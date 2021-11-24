package com.tp.clientandroid_critika.Présentation.modèle

import android.content.Context
import com.tp.clientandroid_critika.Domaine.entité.JeuVideo
import com.tp.clientandroid_critika.Domaine.entité.Utilisateur
import com.tp.clientandroid_critika.Domaine.interacteur.AuthentificationUtilisateur
import com.tp.clientandroid_critika.Domaine.interacteur.ChercherMeilleurJeuxVideo
import com.tp.clientandroid_critika.Domaine.interacteur.CreationCompte
import com.tp.clientandroid_critika.Domaine.interacteur.SourceDeDonnées


class Modèle() {

    private var _sourceAPI : SourceDeDonnées? = null
    private var _utilisateur : Utilisateur? = null
    private var _listeJeux : List<JeuVideo>? = null
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

        if (_listeJeux == null) {
            var liste = ChercherMeilleurJeuxVideo(_sourceAPI).chercherMeilleurJeuxVideo()
            if (liste == null) {
                return false
            } else {
                _listeJeux = liste
                return true
            }
        }
        return true
    }

    fun getListeJeuxVideo() : List<JeuVideo?>? {
        return _listeJeux
    }

}