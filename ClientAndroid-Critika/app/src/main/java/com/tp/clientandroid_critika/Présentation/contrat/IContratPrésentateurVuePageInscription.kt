package com.tp.clientandroid_critika.Présentation.contrat

interface IContratPrésentateurVuePageInscription {

    interface IPrésentateurPageInscription{
        fun verificationInscrption(motPasse1 : String, motDePasse2 : String, surNom : String)
    }

    interface IVuePageInscription{
        fun confirmationInscription()
        fun afficherMessage(message : String)
    }
}