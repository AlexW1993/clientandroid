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

    /**
     * La méthode permet modifier un commentaire de l'utilisateur
     *
     * @param (commentaire : Commentaire), le commentaire a ajouté
     *
     * @return (Boolean) true si le commentaire a été modifié correctment, false s'il y a eu un problème
     */
    fun modifierCommentaire(commentaire: Commentaire): Boolean? {
        return _source?.modifierCommentaire(commentaire)
    }

    /**
     * La méthode permet effacer un commentaire de l'utilisateur
     *
     * @param (id: String), l'id du commentaire'
     *
     * @return (Boolean) true si le commentaire a été effacé correctment, false s'il y a eu un problème
     */
    fun effacerCommentiare(id: String): Boolean? {
        return _source?.effacerCommentaire(id)
    }

}