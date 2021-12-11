package com.tp.clientandroid_critika.Présentation.présenteur

import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVueChangementMotPasse
import com.tp.clientandroid_critika.Présentation.vue.VueChangementMotPasse

class PrésentateurChangementMotPasse(var _vue : VueChangementMotPasse) : IContratPrésentateurVueChangementMotPasse.IContratPrésentateurChangementMotPasse {

    override fun sauvegarderNouveauMotPasse(motPasse1: String, motPasse2: String) {
        TODO("Not yet implemented")
    }
}