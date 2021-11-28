package com.tp.clientandroid_critika.SourceDeDonnées

import com.tp.clientandroid_critika.Domaine.entité.JeuVideo
import com.tp.clientandroid_critika.Domaine.entité.Utilisateur
import com.tp.clientandroid_critika.Domaine.interacteur.SourceDeDonnées

abstract class SourceDeDonnéesBidon : SourceDeDonnées{
    override fun chercherUtilisateur(u: Utilisateur): Utilisateur? {
        return u
    }

    override fun ajouterUtilisateur(utilisateur: Utilisateur): Boolean? {
       return true
    }

    override fun chercherTousJeux(): List<JeuVideo>? {
        TODO("Not yet implemented")
    }

    override fun chercherTousJeuxParPlateforme(plateforme: String): List<JeuVideo>? {
        TODO("Not yet implemented")
    }
}