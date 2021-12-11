package com.tp.clientandroid_critika.Domaine.Présentation.vue

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.tp.clientandroid_critika.R
import com.tp.clientandroid_critika.UI_Activité.MainActivity
import org.junit.Before
import org.junit.Test

class VueChangementMotPasseTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setupTest(){
        scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.moveToState(Lifecycle.State.RESUMED)
        onView(withId(R.id.bouton_Se_connecter)).perform(click())
        val surnom = "root"
        val motDePasse = "root"
        onView(withId(R.id.zone_texte_surnom)).perform(click())
        onView(withId(R.id.zone_texte_surnom)).perform(ViewActions.typeText(surnom.toString()))
        onView(withId(R.id.zone_texte_surnom)).check(matches(withText("root")))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.zone_texte_mot_passe_1)).perform(click())
        onView(withId(R.id.zone_texte_mot_passe_1)).perform(ViewActions.typeText(motDePasse.toString()))
        onView(withId(R.id.zone_texte_mot_passe_1)).check(matches(withText("root")))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.bouton_Se_connecter_Connection)).perform(click())
        onView(withId(R.id.bouton_compte)).perform(click())
        onView(withId(R.id.bouton_modification_mot_passe)).perform(click())
    }

    @Test
    fun `TestAffichageChangementMotPasseVisuel`() {
        onView(withId(R.id.bouton_retour)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.bouton_deconnection)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.bouton_menu)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.bouton_recherche)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.bouton_compte)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.textView5)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.textView5)).check(matches(withText("Changez votre mot de passe")))
        onView(withId(R.id.saisie_changement_mot_passe)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.saisie_changement_mot_passe_2)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.bouton_sauvegarde_mot_passe)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    @Test
    fun `testBoutonDeconnection`() {
        onView(withId(R.id.bouton_deconnection)).perform(click())
    }

    @Test
    fun `testBoutonMenu`() {
        onView(withId(R.id.bouton_menu)).perform(click())
    }

    @Test
    fun `testBoutonRechercher`() {
        onView(withId(R.id.bouton_recherche)).perform(click())
    }

    @Test
    fun `testBoutonCompte`() {
        onView(withId(R.id.bouton_compte)).perform(click())
    }

    @Test
    fun `testBoutonSauvegarder`() {
        var motPasse = "root"
        onView(withId(R.id.saisie_changement_mot_passe)).perform(click())
        onView(withId(R.id.saisie_changement_mot_passe)).perform(ViewActions.typeText(motPasse.toString()))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.saisie_changement_mot_passe_2)).perform(click())
        onView(withId(R.id.saisie_changement_mot_passe_2)).perform(ViewActions.typeText(motPasse.toString()))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.bouton_sauvegarde_mot_passe)).perform(click())
    }
}
