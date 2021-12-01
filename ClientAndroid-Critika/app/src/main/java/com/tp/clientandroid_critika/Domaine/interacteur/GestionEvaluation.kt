package com.tp.clientandroid_critika.Domaine.interacteur

import com.tp.clientandroid_critika.Domaine.entité.Evaluation

class GestionEvaluation (var _source: SourceDeDonnées?){

    fun ajouterEvaluation(evaluation: Evaluation) : Boolean?{
        return _source?.ajouterEvaluation(evaluation)
    }

    fun modifierEvaluation(evaluation: Evaluation) : Boolean{
        return
    }

}
