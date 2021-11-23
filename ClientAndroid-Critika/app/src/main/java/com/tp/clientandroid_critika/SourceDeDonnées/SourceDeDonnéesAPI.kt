package com.tp.clientandroid_critika.SourceDeDonnées
import com.tp.clientandroid_critika.Domaine.entité.Utilisateur
import com.tp.clientandroid_critika.Domaine.interacteur.SourceDeDonnées
import com.tp.clientandroid_critika.SourceDeDonnées.Retrofit.ApiClient
import okhttp3.ResponseBody
import retrofit2.Call

class SourceDeDonnéesAPI : SourceDeDonnées{

    override fun chercherUtilisateur(utilisateur : Utilisateur) : Utilisateur? {
        val retro = ApiClient.SERVICE
        val call : Call<Utilisateur> = retro.PostAuthentificationUtilisateur(utilisateur)
        var res = call.execute()
        var reponse = res.body()
        return reponse
    }

    override fun ajouterUtilisateur(utilisateur: Utilisateur) : Boolean?{
        val retro = ApiClient.SERVICE
        val call : Call<ResponseBody> = retro.PostCreationUtilisateur(utilisateur)
        var res = call.execute()
        var reponse = res.code()
        return reponse == 200
    }



}




