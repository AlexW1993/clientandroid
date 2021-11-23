package com.tp.clientandroid_critika.Domaine.interacteur

import com.tp.clientandroid_critika.Domaine.entité.JeuVideo

class ChercherMeilleurJeuxVideo(var _source : SourceDeDonnées?) {

    fun chercherMeilleurJeuxVideo() : List<JeuVideo>?{
        return _source?.chercherToutJeux()
    }
}