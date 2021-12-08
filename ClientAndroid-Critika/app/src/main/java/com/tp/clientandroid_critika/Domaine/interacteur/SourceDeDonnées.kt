package com.tp.clientandroid_critika.Domaine.interacteur

import com.tp.clientandroid_critika.Domaine.entité.Commentaire
import com.tp.clientandroid_critika.Domaine.entité.Evaluation
import com.tp.clientandroid_critika.Domaine.entité.JeuVideo
import com.tp.clientandroid_critika.Domaine.entité.Utilisateur

interface SourceDeDonnées {

    fun chercherUtilisateur(u: Utilisateur): Utilisateur?
    fun ajouterUtilisateur(utilisateur: Utilisateur): Boolean
    fun chercherTousJeux(): List<JeuVideo>?
    fun chercherTousJeuxParPlateforme(plateforme: String): List<JeuVideo>?
    fun ajouterCommentaire(commentaire: Commentaire): Boolean
    fun ajouterEvaluation(evaluation: Evaluation): Boolean
    fun modifierEvaluation(evaluation: Evaluation): Boolean
    fun chercherJeuxParMotCle(motCle: String): List<JeuVideo>?
}