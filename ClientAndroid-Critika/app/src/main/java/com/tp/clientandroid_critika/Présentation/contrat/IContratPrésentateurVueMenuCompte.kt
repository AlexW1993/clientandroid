package com.tp.clientandroid_critika.Présentation.contrat

import com.tp.clientandroid_critika.Domaine.entité.Utilisateur

interface IContratPrésentateurVueMenuCompte {

    interface IContratPrésentateurMenuCompte {
        fun chercherInformationCompte()
    }

    interface IContratVueMenuCompte {
        fun afficherInformationCompte(utilisateur: Utilisateur?)
    }
}
