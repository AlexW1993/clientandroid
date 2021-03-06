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

class VuePageJeuTest {

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
        val recherche = "apex"
        onView(withId(R.id.saisie_recherche)).perform(click())
        onView(withId(R.id.saisie_recherche)).perform(ViewActions.typeText(recherche.toString()))
        onView(withId(R.id.bouton_saisie_recherche)).perform(click())
        onView(withId(R.id.button_jeu_recherche)).perform(click())
    }

    @Test
    fun `TestAffichageJeuVisuel`() {
        onView(withId(R.id.bouton_retour)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.bouton_deconnection)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.bouton_menu)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.bouton_recherche)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.bouton_compte)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.titre_jeu)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.titre_jeu)).check(matches(withText("Apex Legends")))
        onView(withId(R.id.annee_jeu)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.annee_jeu)).check(matches(withText("2019")))
        onView(withId(R.id.image_jeu)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.moyenne_jeu)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.ratingBar_jeu)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.description_jeu)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.description_jeu)).check(matches(withText("un jeu vidéo de type battle royale développé par Respawn Entertainment et édité par Electronic Arts. Il est publié en accès gratuit le 4 février 2019 sur Microsoft Windows, Nintendo switch, PlayStation 4 et Xbox One. Aussitôt considéré comme un concurrent du très populaire Fortnite Battle Royale, le jeu bat des records de fréquentation dès sa sortie, en réunissant plus de 2,5 millions de joueurs en 24 heures, 10 millions en trois jours puis 25 millions en une semaine après sa commercialisation. Après un mois de commercialisation, le jeu dépasse la barre des 50 millions de joueurs. Le jeu sort sur Nintendo Switch le 9 mars 2021, et sur mobile durant l'année fiscale 2021 dans le but de toucher un plus large public.")))
        onView(withId(R.id.commentaires_jeu)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.saisie_commentaire)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.bouton_envoie_commentaire)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
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
    fun `testBoutonCommentaire`() {
        var commentaire = "Test commentaire"
        onView(withId(R.id.saisie_commentaire)).perform(ViewActions.scrollTo())
        onView(withId(R.id.saisie_commentaire)).perform(click())
        onView(withId(R.id.saisie_commentaire)).perform(ViewActions.typeText(commentaire.toString()))
        onView(withId(R.id.bouton_envoie_commentaire)).perform(click())
        //onView(withId(R.id.saisie_commentaire)).perform(ViewActions.scrollTo())
        //onView(withId(R.id.saisie_commentaire)).perform(click())
        //onView(withId(R.id.bouton_supprimer_commentaire)).perform(click())
    }
}
