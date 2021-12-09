package com.tp.clientandroid_critika.Présentation.contrat

interface IContratPrésentateurVuePageConnexion {

    interface IPrésentateurPageConnexion {
        fun verificationUtilisateur(motPasse: String, surnom: String)
    }

    interface IVuePageConnexion {
        fun afficherPageMenuPrincipal()
        fun afficherMessage(message: String)
    }
}