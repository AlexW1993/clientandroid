package com.tp.clientandroid_critika.Présentation.modèle

import com.tp.clientandroid_critika.Domaine.entité.JeuVideo
import com.tp.clientandroid_critika.Domaine.entité.Utilisateur
import com.tp.clientandroid_critika.Domaine.interacteur.AuthentificationUtilisateur
import com.tp.clientandroid_critika.Domaine.interacteur.ChercherMeilleurJeuxVideo
import com.tp.clientandroid_critika.Domaine.interacteur.CreationCompte
import com.tp.clientandroid_critika.Domaine.interacteur.SourceDeDonnées


class Modèle() {

    private var _sourceAPI : SourceDeDonnées? = null
    private var _utilisateur : Utilisateur? = null
    private var _listeMeilleurJeux : List<JeuVideo>? = null

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

    fun chercherMeilleurJeux() : List<JeuVideo>?{

        if(_listeMeilleurJeux == null){
            _listeMeilleurJeux = ChercherMeilleurJeuxVideo(_sourceAPI).chercherMeilleurJeuxVideo()
        }
        return _listeMeilleurJeux
    }
}