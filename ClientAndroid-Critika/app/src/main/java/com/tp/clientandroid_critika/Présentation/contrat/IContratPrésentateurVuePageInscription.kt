package com.tp.clientandroid_critika.Présentation.contrat

interface IContratPrésentateurVuePageInscription {

    interface IPrésentateurPageInscription{
        fun verificationInscription(motPasse1 : String, motDePasse2 : String, surNom : String)
    }

    interface IVuePageInscription{
        fun afficherPageConnexion()
        fun afficherMessage(message : String)
    }
}