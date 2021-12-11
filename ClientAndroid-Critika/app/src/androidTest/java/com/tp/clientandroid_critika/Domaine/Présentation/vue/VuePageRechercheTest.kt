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

class VuePageRechercheTest {

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
        onView(withId(R.id.bouton_recherche)).perform(click())
    }

    @Test
    fun `TestAffichageRechercherVisuel`() {
        onView(withId(R.id.bouton_retour)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.bouton_deconnection)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.bouton_menu)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.bouton_recherche)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.bouton_compte)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.saisie_recherche)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.bouton_saisie_recherche)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.bouton_switch)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.bouton_ps)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.bouton_xbox)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
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
    fun `testSaisirRecherche`() {
        val recherche = "mario"
        onView(withId(R.id.saisie_recherche)).perform(click())
        onView(withId(R.id.saisie_recherche)).perform(ViewActions.typeText(recherche.toString()))
        onView(withId(R.id.saisie_recherche)).check(matches(withText("mario")))
    }

    @Test
    fun `testBoutonRecherche`() {
        val recherche = "mario"
        onView(withId(R.id.saisie_recherche)).perform(click())
        onView(withId(R.id.saisie_recherche)).perform(ViewActions.typeText(recherche.toString()))
        onView(withId(R.id.bouton_saisie_recherche)).perform(click())
    }
}
