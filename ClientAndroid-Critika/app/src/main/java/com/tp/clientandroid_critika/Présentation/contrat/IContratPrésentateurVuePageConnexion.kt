package com.tp.clientandroid_critika.Présentation.contrat

interface IContratPrésentateurVuePageConnexion {

    interface IPrésentateurPageConnexion{
        fun verificationUtilisateur(motPasse : String, surnom : String)
    }

    interface IVuePageConnexion{
        fun confirmationUtilisateur()
        fun afficherMessage(message : String)
    }
}