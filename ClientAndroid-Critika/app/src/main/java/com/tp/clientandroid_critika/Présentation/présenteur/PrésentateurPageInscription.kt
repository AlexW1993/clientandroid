package com.tp.clientandroid_critika.Présentation.présenteur

import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVuePageInscription
import com.tp.clientandroid_critika.Présentation.modèle.Modèle

class PrésentateurPageInscription (vue : IContratPrésentateurVuePageInscription.IVuePageInscription) : IContratPrésentateurVuePageInscription.IPrésentateurPageInscription {
    private var _modèle : Modèle? = null
    private var _vue : IContratPrésentateurVuePageInscription.IVuePageInscription? = null
    init {
        _vue = vue
        _modèle = Modèle.getInstance()
    }

}