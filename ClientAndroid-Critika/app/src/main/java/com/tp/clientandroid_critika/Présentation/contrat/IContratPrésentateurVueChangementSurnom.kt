package com.tp.clientandroid_critika.Présentation.contrat

interface IContratPrésentateurVueChangementSurnom {

    interface IContratPrésentateurChangementSurnom {
        fun sauvegarderNouveauSurnom(surnom: String)
    }

    interface IContratVueChangementSurnom {
        fun afficherMenuCompte()
        fun afficherMessage(message: String)
    }
}