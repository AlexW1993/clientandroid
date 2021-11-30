package com.tp.clientandroid_critika.Domaine.interacteur

import com.tp.clientandroid_critika.Domaine.entité.Commentaire

class GestionCommentaire(var _source: SourceDeDonnées?) {

    fun ajouterCommentaire(commentaire: Commentaire) : Boolean?{
        return _source?.ajouterCommentaire(commentaire)
    }

}