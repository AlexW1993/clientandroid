package com.tp.clientandroid_critika.Présentation.présenteur

import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVuePageRecherche
import com.tp.clientandroid_critika.Présentation.modèle.Modèle
import com.tp.clientandroid_critika.Présentation.vue.VuePageRecherche

class PrésentateurPageRecherche(var vue : VuePageRecherche) : IContratPrésentateurVuePageRecherche.IContratPrésentateurPageRecherche {

    private var _modèle : Modèle? = null
    private var _filEsclave : Thread? = null

    override fun chercherJeuxParConsole(plateforme: String) {
        _filEsclave = Thread {
            _modèle?.chercherJeuxParConsole(plateforme)
        }
        _filEsclave!!.start()
        vue.afficherPageResultatRecherche()
    }
}