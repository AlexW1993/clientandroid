package com.tp.clientandroid_critika.Présentation.modèle
import android.content.Context
import com.tp.clientandroid_critika.Domaine.entité.Utilisateur
import com.tp.clientandroid_critika.Domaine.interacteur.CreationCompte
import com.tp.clientandroid_critika.Domaine.interacteur.SourceDeDonnées


class Modèle() {

    private var sourceAPI : SourceDeDonnées? = null

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
        sourceAPI  = source
    }

    fun creationUtilisateur(utilisateur: Utilisateur) : Boolean?{
        return CreationCompte(sourceAPI).creationCompte(utilisateur)
    }

}