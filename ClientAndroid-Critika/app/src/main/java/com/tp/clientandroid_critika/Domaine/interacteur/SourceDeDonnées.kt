package com.tp.clientandroid_critika.Domaine.interacteur

import com.tp.clientandroid_critika.Domaine.entité.Utilisateur

interface SourceDeDonnées {

    fun chercherUtilisateurs() : Array<Utilisateur?>?;
    fun ajouterUtilisateur() ;
}