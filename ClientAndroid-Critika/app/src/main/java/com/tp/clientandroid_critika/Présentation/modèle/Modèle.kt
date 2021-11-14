package com.tp.clientandroid_critika.Présentation.modèle

import com.tp.clientandroid_critika.Domaine.interacteur.SourceDeDonnées

class Modèle(var sorce : SourceDeDonnées) {

    companion object {
        lateinit var modèle : Modèle
        fun getInstance() : Modèle{
            if (modèle == null){
                modèle = Modèle()
            }
            return modèle
        }
    }

    fun setSource(source : SourceDeDonnées) {
        _source = source
    }

}