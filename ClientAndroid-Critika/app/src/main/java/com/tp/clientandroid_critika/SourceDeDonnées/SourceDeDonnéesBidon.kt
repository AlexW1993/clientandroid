package com.tp.clientandroid_critika.SourceDeDonnées

import com.tp.clientandroid_critika.Domaine.entité.Utilisateur
import com.tp.clientandroid_critika.Domaine.interacteur.SourceDeDonnées

class SourceDeDonnéesBidon : SourceDeDonnées{
    override fun chercherUtilisateur(u: Utilisateur): Utilisateur? {
        return u
    }

    override fun ajouterUtilisateur(utilisateur: Utilisateur): Boolean? {
       return true
    }
}