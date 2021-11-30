package com.tp.clientandroid_critika.Domaine.interacteur

import com.tp.clientandroid_critika.Domaine.entité.Utilisateur

class GestionCompte(var _source: SourceDeDonnées?) {

    fun verificationCompte(surnom : String, motPasse : String) : Utilisateur?{
        var u = Utilisateur(nom = surnom, motPasse = motPasse)
        var utilisateur : Utilisateur? = _source?.chercherUtilisateur(u)
        return utilisateur
    }

    fun creationCompte(utilisateur: Utilisateur) : Boolean?{
        return _source?.ajouterUtilisateur(utilisateur)
    }
}