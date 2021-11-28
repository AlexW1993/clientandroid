package com.tp.clientandroid_critika.Présentation.présenteur

import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVuePageJeu
import com.tp.clientandroid_critika.Présentation.modèle.Modèle
import com.tp.clientandroid_critika.Présentation.vue.VuePageJeu

class PrésentateurPageJeu(var _vue : VuePageJeu) : IContratPrésentateurVuePageJeu.IPrésentateurPageJeu{

    private var _modèle : Modèle? = null

    init {
        _modèle = Modèle.getInstance()
    }

    override fun chercherInformationJeuSelectionné() {
        _vue?.affichageInformationJeuSelecionné(_modèle?.jeuSelectionné)
    }
}
