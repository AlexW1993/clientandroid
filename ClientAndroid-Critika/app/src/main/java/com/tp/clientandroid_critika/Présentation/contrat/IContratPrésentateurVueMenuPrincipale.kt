package com.tp.clientandroid_critika.Présentation.contrat

import com.tp.clientandroid_critika.Domaine.entité.JeuVideo

interface IContratPrésentateurVueMenuPrincipale {

    interface IPrésentateurMenuPrincipale {
        fun chercherJeuxVideo()
        fun jeuSelectionné(jeuVideo: JeuVideo)
    }

    interface IVueMenuPrincipale {
        fun afficherListeJeuxVideo(liste: List<JeuVideo?>?)
        fun afficherMessage(message: String)
    }
}