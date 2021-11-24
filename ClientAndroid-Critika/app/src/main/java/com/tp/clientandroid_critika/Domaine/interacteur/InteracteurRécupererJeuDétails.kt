package com.tp.clientandroid_critika.Domaine.interacteur

import com.tp.clientandroid_critika.Domaine.entité.JeuVideo

class InteracteurRécupererJeuDétails(var source: SourceDeDonnées) {
    var jeuVideo : JeuVideo? = null

    fun obtenirDetailsJeuVideo(idJeuVideo : String ) : JeuVideo?{
        jeuVideo = source.récupererJeuDétails(idJeuVideo)
        return jeuVideo
    }
}