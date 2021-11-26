package com.tp.clientandroid_critika.SourceDeDonnées.Retrofit

import com.tp.clientandroid_critika.Domaine.entité.JeuVideo
import com.tp.clientandroid_critika.Domaine.entité.Utilisateur
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("Utilisateur/Authentification")
    fun PostAuthentificationUtilisateur(@Body utilisateur : Utilisateur) : Call<Utilisateur>

    @POST("Utilisateur")
    fun PostCreationUtilisateur(@Body utilisateur: Utilisateur) : Call<ResponseBody>

    @GET("JeuVideo")
    fun GetToutJeuVideo() : Call<List<JeuVideo>>
}