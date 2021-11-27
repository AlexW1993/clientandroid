package com.tp.clientandroid_critika.Présentation.présenteur

import android.os.Handler
import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVuePageRecherche
import com.tp.clientandroid_critika.Présentation.modèle.Modèle
import com.tp.clientandroid_critika.Présentation.vue.VuePageRecherche

class PrésentateurPageRecherche(var vue : VuePageRecherche) : IContratPrésentateurVuePageRecherche.IContratPrésentateurPageRecherche {

    private var _modèle : Modèle? = null
    private var _filEsclave : Thread? = null
    //private var _handlerRéponse : Handler
    private var _confirmation = 0
    private var _utilisateruExistant = 1

    override fun chercherJeuxParConsole(console: String) {
        TODO("Not yet implemented")
    }
}