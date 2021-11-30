package com.tp.clientandroid_critika.Domaine.interacteur

import com.tp.clientandroid_critika.Domaine.entité.JeuVideo

class GestionJeuxVideo(var _source : SourceDeDonnées?) {

    fun chercherTousJeuxVideo() : List<JeuVideo>?{
        return _source?.chercherTousJeux()
    }

    fun chercherJuexVideoParConsole(plateforme : String) : List<JeuVideo>?{
        return _source?.chercherTousJeuxParPlateforme(plateforme)
    }
}