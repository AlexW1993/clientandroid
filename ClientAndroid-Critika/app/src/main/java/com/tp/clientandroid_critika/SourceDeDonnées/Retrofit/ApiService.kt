package com.tp.clientandroid_critika.SourceDeDonnées.Retrofit

import com.tp.clientandroid_critika.Domaine.entité.Commentaire
import com.tp.clientandroid_critika.Domaine.entité.Evaluation
import com.tp.clientandroid_critika.Domaine.entité.JeuVideo
import com.tp.clientandroid_critika.Domaine.entité.Utilisateur
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @POST("Utilisateur/Authentification")
    fun PostAuthentificationUtilisateur(@Body utilisateur: Utilisateur): Call<Utilisateur>

    @POST("Utilisateur")
    fun PostCreationUtilisateur(@Body utilisateur: Utilisateur): Call<ResponseBody>

    @GET("JeuVideo")
    fun GetToutJeuVideo(): Call<List<JeuVideo>>

    @GET("JeuVideo/recherchePlateforme/{plateforme}")
    fun GetJeuVideoParPlateforme(@Path("plateforme") plateforme: String): Call<List<JeuVideo>>

    @POST("Commentaire")
    fun PostAjouterCommentaire(@Body commentaire: Commentaire): Call<ResponseBody>

    @POST("Evaluation")
    fun PostAjouterEvaluation(@Body evaluation: Evaluation): Call<ResponseBody>

    @PUT("Evaluation")
    fun PutModifierEvaluation(@Body evaluation: Evaluation): Call<ResponseBody>

    @GET("JeuVideo/rechercheParMotCle/{motCle}")
    fun GetJeuVideoParMotCle(@Path("motCle") motCle: String): Call<List<JeuVideo>>

    @PUT("Utilisateur/ModifierNom")
    fun PutModifierSurnom(@Body utilisateur: Utilisateur): Call<ResponseBody>

    @PUT("Commentaire")
    fun PutModifierCommentaire(@Body commentaire: Commentaire): Call<ResponseBody>

    @DELETE("Commentaire/{id}")
    fun DeleteCommentaire(@Path("id") id: String): Call<ResponseBody>

    @PUT("Utilisateur/ModifierMotPasse")
    fun PutModifierMotPasse(@Body utilisateur: Utilisateur): Call<ResponseBody>

    @DELETE("Evaluation/{id}")
    fun DeleteEvaluation(@Path("id") id: String): Call<ResponseBody>
}