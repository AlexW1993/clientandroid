package com.tp.clientandroid_critika.PrĂ©sentation.contrat

interface IContratPrĂ©sentateurVueChangementSurnom {

    interface IContratPrĂ©sentateurChangementSurnom {
        fun sauvegarderNouveauSurnom(surnom: String)
    }

    interface IContratVueChangementSurnom {
        fun afficherMenuCompte()
        fun afficherMessage(message: String)
    }
}