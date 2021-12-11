package com.tp.clientandroid_critika.Domaine.Présentation.vue
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import com.tp.clientandroid_critika.R
import com.tp.clientandroid_critika.UI_Activité.MainActivity
import org.junit.Test
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Before
import androidx.test.espresso.action.ViewActions

class VuePageInscriptionTest {
    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setupTest(){
        scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.moveToState(Lifecycle.State.RESUMED)
        onView(withId(R.id.bouton_s_inscrire_initial)).perform(click())
    }

    @Test
    fun `testInscriptionVisuel`() {
        onView(withId(R.id.contenant_avatar)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.bouton_avatar_image)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.bouton_avatar_camera)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.zone_texte_surnom)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.zone_texte_mot_passe_1)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.zone_texte_mot_passe_2)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.bouton_inscription)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    @Test
    fun `testFonctionnalitéInscription`() {
        val surnom = "TestSurnom"
        val motDePasse = "TestMdp"
        onView(withId(R.id.zone_texte_surnom)).perform(ViewActions.typeText(surnom.toString()))
        onView(withId(R.id.zone_texte_surnom)).check(matches(withText("TestSurnom")))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.zone_texte_mot_passe_1)).perform(click())
        onView(withId(R.id.zone_texte_mot_passe_1)).perform(ViewActions.typeText(motDePasse.toString()))
        onView(withId(R.id.zone_texte_mot_passe_1)).check(matches(withText("TestMdp")))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.zone_texte_mot_passe_2)).perform(click())
        onView(withId(R.id.zone_texte_mot_passe_2)).perform(ViewActions.typeText(motDePasse.toString()))
        onView(withId(R.id.zone_texte_mot_passe_2)).check(matches(withText("TestMdp")))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.bouton_inscription)).perform(click())
    }
}
