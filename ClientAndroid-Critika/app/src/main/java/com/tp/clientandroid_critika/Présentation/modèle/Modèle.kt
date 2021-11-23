package com.tp.clientandroid_critika.Présentation.modèle

import com.tp.clientandroid_critika.Domaine.entité.Utilisateur
import com.tp.clientandroid_critika.Domaine.interacteur.AuthentificationUtilisateur
import com.tp.clientandroid_critika.Domaine.interacteur.CreationCompte
import com.tp.clientandroid_critika.Domaine.interacteur.SourceDeDonnées


class Modèle() {

    private var _sourceAPI : SourceDeDonnées? = null
    private var _utilisateur : Utilisateur? = null

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
}