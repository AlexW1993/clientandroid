package com.tp.clientandroid_critika.Présentation.contrat

import com.tp.clientandroid_critika.Domaine.entité.JeuVideo

interface IContratPrésentateurVuePageResultatRecherche {

    interface IPrésentateurPageResultatRecherche{
        fun chercherJeuxVideo()
        fun jeuSelectionné(jeuVideo: JeuVideo)

    }

    interface IVuePageResultatRecherche{
        fun afficherListeJeuxVideo(liste: List<JeuVideo?>?)
    }
}