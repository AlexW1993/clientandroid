package com.tp.clientandroid_critika.PrĂ©sentation.contrat

interface IContratPrĂ©sentateurVuePageInscription {

    interface IPrĂ©sentateurPageInscription {
        fun verificationInscription(motPasse1: String, motDePasse2: String, surNom: String)
    }

    interface IVuePageInscription {
        fun afficherPageConnexion()
        fun afficherMessage(message: String)
    }
}