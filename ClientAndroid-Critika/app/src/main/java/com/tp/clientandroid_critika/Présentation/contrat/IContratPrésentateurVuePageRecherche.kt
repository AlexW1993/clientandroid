package com.tp.clientandroid_critika.PrĂ©sentation.contrat

interface IContratPrĂ©sentateurVuePageRecherche {

    interface IPrĂ©sentateurPageRecherche {
        fun chercherJeuxParConsole(console: String)
        fun chercherJeuxParMotCle(motCle: String)
    }

    interface IVuePageRecherche {
        fun afficherPageResultatRecherche()
        fun afficherMessage(message: String)
    }
}