package com.tp.clientandroid_critika.Présentation.modèle

import android.os.Build
import androidx.annotation.RequiresApi
import com.tp.clientandroid_critika.Domaine.entité.Commentaire
import com.tp.clientandroid_critika.Domaine.entité.JeuVideo
import com.tp.clientandroid_critika.Domaine.entité.Utilisateur
import com.tp.clientandroid_critika.Domaine.interacteur.*
import java.time.LocalDateTime

class Modèle() {

    var sourceDeDonnées : SourceDeDonnées? = null
    var jeuSelectionné : JeuVideo? = null
    var utilisateur : Utilisateur? = null
    var listeJeux : List<JeuVideo>? = null

    companion object {
        var modèle : Modèle? = null
        fun getInstance() : Modèle{
            if (modèle == null){
                modèle = Modèle()
            }
            return modèle as Modèle
        }
    }

    fun creationUtilisateur(utilisateur: Utilisateur) : Boolean?{
        return CreationCompte(sourceDeDonnées).creationCompte(utilisateur)
    }

    fun verifierUtilisateur(surnom : String, motPasse : String) : Boolean{
        var utilisateur : Utilisateur? = AuthentificationUtilisateur(sourceDeDonnées).verification(surnom,motPasse)
        if (utilisateur != null){
            this.utilisateur = utilisateur
            return true
        } else {
            return false
        }
    }

    fun chercherJeux() : Boolean {
        var liste = GestionJeuxVideo(sourceDeDonnées).chercherTousJeuxVideo()
        if (liste == null) {
            return false
        } else {
            listeJeux = ChercherTop10Jeux().chercherTop10(liste)
            return true
        }
    }

    fun chercherJeuxParConsole(plateforme : String) {
        listeJeux = GestionJeuxVideo(sourceDeDonnées).chercherJuexVideoParConsole(plateforme)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun ajouterCommentaire(contenueCommentaire: String) : Boolean{
        var commentaire = Commentaire("",jeuSelectionné!!.id,utilisateur!!.id,LocalDateTime.now().toString(),contenueCommentaire,utilisateur)
        var confirmationAjouter = GestionCommentaire(sourceDeDonnées).ajouterCommentaire(commentaire)
        if(confirmationAjouter == true){
            listeJeux = GestionJeuxVideo(sourceDeDonnées).chercherTousJeuxVideo()
            for(l in listeJeux!!){
               if(l.id == jeuSelectionné?.id){
                   jeuSelectionné = l
               }
            }
            return true
        } else {
            return false
        }
    }
}