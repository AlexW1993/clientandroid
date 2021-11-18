package com.tp.clientandroid_critika.Domaine.interacteur

import com.tp.clientandroid_critika.Domaine.entité.Utilisateur

class AuthentificationUtilisateur(var _source: SourceDeDonnées?) {

    fun verification(surnom : String, motPasse : String) : Utilisateur?{
        var utilisateur : Utilisateur? = _source?.chercherUtilisateur(surnom)
        if(utilisateur?.motPasse == motPasse){
            utilisateur.motPasse = ""
            return utilisateur
        } else{
            return null
        }
    }
}