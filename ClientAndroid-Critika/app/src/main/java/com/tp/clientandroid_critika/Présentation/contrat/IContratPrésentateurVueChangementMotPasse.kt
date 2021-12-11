package com.tp.clientandroid_critika.Présentation.contrat

interface IContratPrésentateurVueChangementMotPasse {

    interface IContratPrésentateurChangementMotPasse {
        fun sauvegarderNouveauMotPasse(surnom: String)
    }

    interface IContratVueChangementMotPasse {
        fun afficherMenuCompte()
        fun afficherMessage(message: String)
    }
}