package com.tp.clientandroid_critika.Présentation.contrat

interface IContratPrésentateurVueChangementCommentaire {

    interface IContratPrésentateurChangementCommentaire {
        fun chercherContenue()
        fun modifierContenueCommentaire(contenue: String)
    }

    interface IContratVueChangementCommentaire {
        fun afficherContenue(contenue: String)
        fun afficherMessage(message: String)
        fun afficherPageJeu()
    }
}