package com.tp.clientandroid_critika.PrĂ©sentation.contrat

interface IContratPrĂ©sentateurVueChangementCommentaire {

    interface IContratPrĂ©sentateurChangementCommentaire {
        fun chercherContenue()
        fun modifierContenueCommentaire(contenue: String)
    }

    interface IContratVueChangementCommentaire {
        fun afficherContenue(contenue: String)
        fun afficherMessage(message: String)
        fun afficherPageJeu()
    }
}