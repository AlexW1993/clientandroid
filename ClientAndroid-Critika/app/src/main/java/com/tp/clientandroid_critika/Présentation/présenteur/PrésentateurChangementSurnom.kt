package com.tp.clientandroid_critika.Présentation.présenteur

import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVueChangementSurnom
import com.tp.clientandroid_critika.Présentation.vue.VueChangementSurnom

class PrésentateurChangementSurnom(var _vue: VueChangementSurnom) :
    IContratPrésentateurVueChangementSurnom.IContratPrésentateurChangementSurnom {
    override fun sauvegarderNouveauSurnom(surnom: String) {
        TODO("Not yet implemented")
    }
}