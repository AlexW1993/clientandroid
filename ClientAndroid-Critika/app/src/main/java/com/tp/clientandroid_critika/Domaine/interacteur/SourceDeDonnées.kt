package com.tp.clientandroid_critika.Domaine.interacteur

import com.tp.clientandroid_critika.Domaine.entité.Utilisateur

interface SourceDeDonnées {

    fun chercherUtilisateur(surNom : String, motPasse : String) : Utilisateur?
    fun ajouterUtilisateur(utilisateur : Utilisateur) : Boolean?
}