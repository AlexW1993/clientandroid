package com.tp.clientandroid_critika.Domaine.interacteur

import com.tp.clientandroid_critika.Domaine.entité.Utilisateur

class CreationCompte (var _source : SourceDeDonnées) {

    fun creationCompte(utilisateur: Utilisateur) : Boolean{
        var confirmation : Boolean? = _source.ajouterUtilisateur(utilisateur)
        if(confirmation == null){
            return false
        } else {
            return confirmation
        }
    }
}