package com.tp.clientandroid_critika.Présentation.présenteur

import com.tp.clientandroid_critika.Domaine.entité.JeuVideo
import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVuePageResultatRecherche
import com.tp.clientandroid_critika.Présentation.modèle.Modèle
import com.tp.clientandroid_critika.Présentation.vue.VuePageResultatRecherche

class PrésentateurPageResultatRecherche(var _vue: VuePageResultatRecherche) :
    IContratPrésentateurVuePageResultatRecherche.IPrésentateurPageResultatRecherche {

    private var _modèle: Modèle? = null

    init {
        _modèle = Modèle.getInstance()
    }

    /**
     * La méthode permet de chercher les jeux videos de la plateforme selectionné
     */
    override fun chercherJeuxVideo() {
        _vue?.afficherListeJeuxVideo(_modèle?.listeJeux)
    }

    /**
     * La méthode permet d'ajouter un jeu dans le modèle
     *
     * @param (jeuVideo: JeuVideo), le jeu selectionné par l'utilisateur
     */
    override fun jeuSelectionné(jeuVideo: JeuVideo) {
        _modèle?.jeuSelectionné = null
        _modèle?.jeuSelectionné = jeuVideo
    }
}