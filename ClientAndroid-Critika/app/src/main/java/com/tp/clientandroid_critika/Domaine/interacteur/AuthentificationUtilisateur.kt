package com.tp.clientandroid_critika.Domaine.interacteur

import com.tp.clientandroid_critika.Domaine.entité.Utilisateur

class AuthentificationUtilisateur(var _source: SourceDeDonnées?) {

    fun verification(surnom : String, motPasse : String) : Utilisateur?{
        var u = Utilisateur(null,surnom,motPasse,null,null)
        var utilisateur : Utilisateur? = _source?.chercherUtilisateur(u)
        return utilisateur
    }
}