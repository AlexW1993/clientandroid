package com.tp.clientandroid_critika.Domaine.interacteur

import com.tp.clientandroid_critika.Domaine.entité.Utilisateur

interface SourceDeDonnées {

    fun chercherUtilisateur(u : Utilisateur) : Utilisateur?
    fun ajouterUtilisateur(utilisateur : Utilisateur) : Boolean?
}