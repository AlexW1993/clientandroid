package com.tp.clientandroid_critika.Présentation.modèle

import android.content.Context
import com.tp.clientandroid_critika.Domaine.entité.JeuVideo
import com.tp.clientandroid_critika.Domaine.entité.Utilisateur
import com.tp.clientandroid_critika.Domaine.interacteur.*

class Modèle() {

    var sourceDeDonnées : SourceDeDonnées? = null
    private var _utilisateur : Utilisateur? = null
    private var _listeJeux : List<JeuVideo>? = null
    var ctx : Context? = null
    var jeuSelectionné : JeuVideo? = null

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
            _utilisateur = utilisateur
            return true
        } else {
            return false
        }
    }

    fun chercherJeux() : Boolean {
        var liste = ChercherJeuxVideo(sourceDeDonnées).chercherMeilleurJeuxVideo()
        if (liste == null) {
            return false
        } else {
            _listeJeux = ChercherTop10Jeux().chercherTop10(liste)
            return true
        }
    }

    fun getListeTop10() : List<JeuVideo?>? {
        return _listeJeux
    }
}