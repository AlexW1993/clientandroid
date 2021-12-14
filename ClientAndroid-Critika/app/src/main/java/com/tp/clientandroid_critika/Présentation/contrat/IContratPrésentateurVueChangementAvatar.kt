package com.tp.clientandroid_critika.Présentation.contrat

interface IContratPrésentateurVueChangementAvatar {

    interface IContratPrésentateurChangementAvatar{
        fun chercherImageAvatar()
    }
    interface IContratVueChangementAvatar{
        fun récupérerImageAvatar(codeAvatar: String)
    }
}