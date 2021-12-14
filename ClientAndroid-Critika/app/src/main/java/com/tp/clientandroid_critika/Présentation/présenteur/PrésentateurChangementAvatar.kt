package com.tp.clientandroid_critika.Présentation.présenteur

import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVueChangementAvatar
import com.tp.clientandroid_critika.Présentation.modèle.Modèle
import com.tp.clientandroid_critika.Présentation.vue.VueChangementAvatar

class PrésentateurChangementAvatar(var _vue:VueChangementAvatar) : IContratPrésentateurVueChangementAvatar.IContratPrésentateurChangementAvatar{

    private var _modèle : Modèle? = null

    init {
        _modèle = Modèle.getInstance()
    }

    override fun chercherImageAvatar() {
        _modèle?.utilisateur?.codeAvatar?.let { _vue?.récupérerImageAvatar(it) }
    }

}