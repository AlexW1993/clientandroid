package com.tp.clientandroid_critika.Domaine.Présentation.vue


import androidx.test.core.app.ActivityScenario
import com.tp.clientandroid_critika.Présentation.vue.VuePageInitiale
import com.tp.clientandroid_critika.R
import com.tp.clientandroid_critika.UI_Activité.MainActivity
import org.junit.Assert
import org.junit.Test

class VuePageInitialeTest {
    @Test
    fun `étant`() {
        val scenario: ActivityScenario<MainActivity> = ActivityScenario.launch<MainActivity>(
            MainActivity::class.java
        )
        scenario.onActivity(ActivityScenario.ActivityAction<MainActivity> {
                activité: MainActivity ->
            val vueinitial = activité.supportFragmentManager.findFragmentById(R.id.frameLayout_initial)
            Assert.assertNotNull(vueinitial)
            Assert.assertTrue(vueinitial is VuePageInitiale)
        })
        //Mise en place

        //Exécution

        //Vérification
    }
}