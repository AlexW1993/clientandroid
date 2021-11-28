package com.tp.clientandroid_critika.Présentation.contrat

import com.tp.clientandroid_critika.Domaine.entité.JeuVideo

interface IContratPrésentateurVuePageJeu {

    interface IPrésentateurPageJeu{
        fun chercherInformationJeuSelectionné()
    }

    interface IVuePageJeu{
        fun affichageInformationJeuSelecionné(jeu : JeuVideo?)
    }
}
