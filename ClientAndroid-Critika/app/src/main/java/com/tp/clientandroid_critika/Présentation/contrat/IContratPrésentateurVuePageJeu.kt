package com.tp.clientandroid_critika.Présentation.contrat

import com.tp.clientandroid_critika.Domaine.entité.JeuVideo

interface IContratPrésentateurVuePageJeu {

    interface IPrésentateurPageJeu{
        fun chercherInformationJeuSelectionné()
        fun ajouterCommenataire(contenueCommentaire : String)
        fun ajouterEvaluation(note : Int)
    }

    interface IVuePageJeu{
        fun affichageInformationJeuSelecionné(jeu : JeuVideo?)
        fun afficherMessage(message : String)
        fun afficherPageJeu()
    }
}
