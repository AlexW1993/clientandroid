package com.tp.clientandroid_critika.Présentation.modèle

import android.content.Context
import com.tp.clientandroid_critika.Domaine.entité.JeuVideo
import com.tp.clientandroid_critika.Domaine.entité.Utilisateur
import com.tp.clientandroid_critika.Domaine.interacteur.*


class Modèle() {

    private var _sourceAPI : SourceDeDonnées? = null
    private var _utilisateur : Utilisateur? = null
    private var _listeTop10 : List<JeuVideo>? = null
    private var _ctx : Context? = null

    companion object {
        var modèle : Modèle? = null
        fun getInstance() : Modèle{
            if (modèle == null){
                modèle = Modèle()
            }
            return modèle as Modèle
        }
    }

    fun creationSourceDeDonnées(source : SourceDeDonnées) {
        _sourceAPI  = source
    }

    fun récuperationContext(ctx : Context){
        _ctx = ctx
    }

    fun chercherContext() : Context?{
        return  _ctx
    }

    fun creationUtilisateur(utilisateur: Utilisateur) : Boolean?{
        return CreationCompte(_sourceAPI).creationCompte(utilisateur)
    }

    fun verifierUtilisateur(surnom : String, motPasse : String) : Boolean{
        var utilisateur : Utilisateur? = AuthentificationUtilisateur(_sourceAPI).verification(surnom,motPasse)
        if (utilisateur != null){
            _utilisateur = utilisateur
            return true
        } else {
            return false
        }
    }

    fun chercherJeux() : Boolean {
        var liste = ChercherJeuxVideo(_sourceAPI).chercherMeilleurJeuxVideo()
        if (liste == null) {
            return false
        } else {
            ChercherTop10Jeux().chercherTop10(liste)
            return true
        }
    }

    fun getListeTop10() : List<JeuVideo?>? {
        return _listeTop10
    }

}