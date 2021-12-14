package com.tp.clientandroid_critika.Présentation.présenteur

import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVueMenuCompte
import com.tp.clientandroid_critika.Présentation.modèle.Modèle
import com.tp.clientandroid_critika.Présentation.vue.VueMenuCompte

class PrésentateurMenuCompte(var _vue: VueMenuCompte) :
    IContratPrésentateurVueMenuCompte.IContratPrésentateurMenuCompte {

    private var _modèle: Modèle? = null

    init {
        _modèle = Modèle.getInstance()
    }

    /**
     * La méthode cherche l'utilisateur avec ses informations
     */
    override fun chercherInformationCompte() {
        _vue?.afficherInformationCompte(_modèle?.utilisateur)
    }
}