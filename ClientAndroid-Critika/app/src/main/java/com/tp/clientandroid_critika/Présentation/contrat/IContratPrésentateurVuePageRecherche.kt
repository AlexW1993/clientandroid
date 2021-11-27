package com.tp.clientandroid_critika.Présentation.contrat

interface IContratPrésentateurVuePageRecherche {

    interface IPrésentateurPageRecherche{
        fun chercherJeuxParConsole(console : String)
    }

    interface IVuePageRecherche{
        fun afficherPageResultatRecherche()
    }
}