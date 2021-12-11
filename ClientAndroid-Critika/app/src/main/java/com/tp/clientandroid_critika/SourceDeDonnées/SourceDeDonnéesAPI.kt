package com.tp.clientandroid_critika.SourceDeDonnées

import com.tp.clientandroid_critika.Domaine.entité.Commentaire
import com.tp.clientandroid_critika.Domaine.entité.Evaluation
import com.tp.clientandroid_critika.Domaine.entité.JeuVideo
import com.tp.clientandroid_critika.Domaine.entité.Utilisateur
import com.tp.clientandroid_critika.Domaine.interacteur.SourceDeDonnées
import com.tp.clientandroid_critika.SourceDeDonnées.Retrofit.ApiClient
import okhttp3.ResponseBody
import retrofit2.Call

class SourceDeDonnéesAPI : SourceDeDonnées {

    override fun chercherUtilisateur(utilisateur: Utilisateur): Utilisateur? {
        val retro = ApiClient.SERVICE
        val call: Call<Utilisateur> = retro.PostAuthentificationUtilisateur(utilisateur)
        var res = call.execute()
        if (res.code() == 200) {
            return res.body()
        } else {
            return null
        }
    }

    override fun ajouterUtilisateur(utilisateur: Utilisateur): Boolean {
        val retro = ApiClient.SERVICE
        val call: Call<ResponseBody> = retro.PostCreationUtilisateur(utilisateur)
        var res = call.execute()
        var reponse = res.code()
        return reponse == 200
    }

    override fun chercherTousJeux(): List<JeuVideo>? {
        val retro = ApiClient.SERVICE
        val call: Call<List<JeuVideo>> = retro.GetToutJeuVideo()
        var res = call.execute()
        if (res.code() == 200) {
            return res.body()
        } else {
            return null
        }
    }

    override fun chercherTousJeuxParPlateforme(plateforme: String): List<JeuVideo>? {
        val retro = ApiClient.SERVICE
        val call: Call<List<JeuVideo>> = retro.GetJeuVideoParPlateforme(plateforme)
        var res = call.execute()
        if (res.code() == 200) {
            return res.body()
        } else {
            return null
        }

    }

    override fun ajouterCommentaire(commentaire: Commentaire): Boolean {
        val retro = ApiClient.SERVICE
        val call: Call<ResponseBody> = retro.PostAjouterCommentaire(commentaire)
        var res = call.execute()
        var reponse = res.code()
        return reponse == 201
    }

    override fun ajouterEvaluation(evaluation: Evaluation): Boolean {
        val retro = ApiClient.SERVICE
        val call: Call<ResponseBody> = retro.PostAjouterEvaluation(evaluation)
        var res = call.execute()
        var reponse = res.code()
        return reponse == 201
    }

    override fun modifierEvaluation(evaluation: Evaluation): Boolean {
        val retro = ApiClient.SERVICE
        val call: Call<ResponseBody> = retro.PutModifierEvaluation(evaluation)
        var res = call.execute()
        var reponse = res.code()
        return reponse == 204
    }

    override fun chercherJeuxParMotCle(motCle: String): List<JeuVideo>? {
        val retro = ApiClient.SERVICE
        val call: Call<List<JeuVideo>> = retro.GetJeuVideoParMotCle(motCle)
        var res = call.execute()
        if (res.code() == 200) {
            return res.body()
        } else {
            return null
        }
    }

    override fun modifierSurnom(utilisateur: Utilisateur): Boolean {
        val retro = ApiClient.SERVICE
        val call: Call<ResponseBody> = retro.PutModifierSurnom(utilisateur)
        var res = call.execute()
        var reponse = res.code()
        return reponse == 204
    }

    override fun modifierCommentaire(commentaire: Commentaire): Boolean {
        val retro = ApiClient.SERVICE
        val call: Call<ResponseBody> = retro.PutModifierCommentaire(commentaire)
        var res = call.execute()
        var reponse = res.code()
        return reponse == 204
    }

    override fun effacerCommentaire(id: String): Boolean {
        val retro = ApiClient.SERVICE
        val call: Call<ResponseBody> = retro.DeleteCommentaire(id)
        var res = call.execute()
        var reponse = res.code()
        return reponse == 204
    }

    override fun modiferMotPasse(utilisateur: Utilisateur): Boolean {
        val retro = ApiClient.SERVICE
        val call: Call<ResponseBody> = retro.PutModifierMotPasse(utilisateur)
        var res = call.execute()
        var reponse = res.code()
        return reponse == 204
    }
}