package com.tp.clientandroid_critika.PrĂ©sentation.contrat

interface IContratPrĂ©sentateurVuePageConnexion {

    interface IPrĂ©sentateurPageConnexion {
        fun verificationUtilisateur(motPasse: String, surnom: String)
    }

    interface IVuePageConnexion {
        fun afficherPageMenuPrincipal()
        fun afficherMessage(message: String)
    }
}