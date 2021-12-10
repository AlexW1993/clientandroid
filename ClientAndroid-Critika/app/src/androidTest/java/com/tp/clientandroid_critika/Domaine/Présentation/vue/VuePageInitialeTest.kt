package com.tp.clientandroid_critika.Domaine.Présentation.vue



import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import com.tp.clientandroid_critika.R
import com.tp.clientandroid_critika.UI_Activité.MainActivity
import org.junit.Test
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Before
import androidx.test.core.app.ActivityScenario.launch

class VuePageInitialeTest{

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setupTest(){
        scenario = launch(MainActivity::class.java)
        scenario.moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun `testInitialVisuel`() {
        onView(withId(R.id.logo)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.bouton_s_inscrire_initial)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.bouton_Se_connecter)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    @Test
    fun `testInitialBoutonConnexion`() {
        onView(withId(R.id.bouton_Se_connecter)).perform(click())
    }

    @Test
    fun `testInitialBoutonInscription`() {
        onView(withId(R.id.bouton_s_inscrire_initial)).perform(click())
    }

}
