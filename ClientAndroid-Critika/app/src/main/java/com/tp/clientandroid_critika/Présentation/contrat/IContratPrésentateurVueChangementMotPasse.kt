package com.tp.clientandroid_critika.Présentation.contrat

interface IContratPrésentateurVueChangementMotPasse {

    interface IContratPrésentateurChangementMotPasse {
        fun sauvegarderNouveauMotPasse(motPasse1: String, motPasse2: String)
    }

    interface IContratVueChangementMotPasse {
        fun afficherMenuCompte()
        fun afficherMessage(message: String)
    }
}