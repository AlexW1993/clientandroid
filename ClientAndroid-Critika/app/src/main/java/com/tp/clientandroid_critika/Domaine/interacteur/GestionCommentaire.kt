package com.tp.clientandroid_critika.Domaine.interacteur

import com.tp.clientandroid_critika.Domaine.entité.Commentaire

class GestionCommentaire(var _source: SourceDeDonnées?) {

    /**
     * La méthode permet ajouter un commentaire dans le jeu selectionné
     *
     * @param (commentaire : Commentaire), le commentaire a ajouté
     *
     * @return (Boolean) true si le commentaire a été ajouter correctment, false s'il y a eu un problème
     */
    fun ajouterCommentaire(commentaire: Commentaire): Boolean? {
        return _source?.ajouterCommentaire(commentaire)
    }

    fun modifierCommentaire(commentaire: Commentaire): Boolean? {
        return _source?.modifierCommentaire(commentaire)
    }
}