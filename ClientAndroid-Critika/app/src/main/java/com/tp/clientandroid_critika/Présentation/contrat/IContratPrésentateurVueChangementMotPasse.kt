package com.tp.clientandroid_critika.PrĂ©sentation.contrat

interface IContratPrĂ©sentateurVueChangementMotPasse {

    interface IContratPrĂ©sentateurChangementMotPasse {
        fun sauvegarderNouveauMotPasse(motPasse1: String, motPasse2: String)
    }

    interface IContratVueChangementMotPasse {
        fun afficherMenuCompte()
        fun afficherMessage(message: String)
    }
}