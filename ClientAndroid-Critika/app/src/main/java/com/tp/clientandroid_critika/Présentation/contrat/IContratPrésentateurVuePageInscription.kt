package com.tp.clientandroid_critika.Présentation.contrat

interface IContratPrésentateurVuePageInscription {

    interface IPrésentateurPageInscription{
        fun verificationInscrption(motPasse1 : String, motDePasse2 : String, surNom : String)
    }

    interface IVuePageInscription{
        fun afficherPageInscription()
        fun afficherMessage(message : String)
    }
}