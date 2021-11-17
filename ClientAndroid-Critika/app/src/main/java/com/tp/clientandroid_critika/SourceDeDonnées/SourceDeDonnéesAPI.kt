package com.tp.clientandroid_critika.SourceDeDonnées
import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.*
import com.google.gson.Gson
import com.tp.clientandroid_critika.Domaine.entité.Utilisateur
import com.tp.clientandroid_critika.Domaine.interacteur.SourceDeDonnées
import org.json.JSONObject
import java.util.concurrent.ExecutionException

class SourceDeDonnéesAPI (var ctx : Context) : SourceDeDonnées{

    var gson : Gson = Gson()

    override fun chercherUtilisateur(surNom : String, motPasse : String) : Utilisateur? {
        var queue : RequestQueue = Volley.newRequestQueue(ctx)
        var future : RequestFuture<String> = RequestFuture.newFuture()
        var url = "https://localhost:44305/api/Utilisateur/$surNom"
        var request = StringRequest(Request.Method.GET, url,future,future)
        queue.add(request)
        try {
            var reponse = future.get()
            var utilisateurs : Utilisateur? = gson.fromJson(reponse, Utilisateur::class.java)
            return utilisateurs
        }catch (e : InterruptedException){
            e.printStackTrace()
        } catch (e : ExecutionException){
            e.printStackTrace()
        }
        return null
    }

    override fun ajouterUtilisateur(utilisateur: Utilisateur) : Boolean?{
        var queue : RequestQueue = Volley.newRequestQueue(ctx)
        var json : String = gson.toJson(utilisateur)
        var future : RequestFuture<JSONObject> = RequestFuture.newFuture()
        var url = "https://localhost:44305/api/Utilisateur"
        var request = JsonObjectRequest(Request.Method.POST, url, json,future,future)
        queue.add(request)
        try {
            var reponse = future.get()
            var confirmation : Boolean = gson.fromJson(reponse, Boolean::class.java)
            return confirmation
        }catch (e : InterruptedException){
            e.printStackTrace()
        } catch (e : ExecutionException){
            e.printStackTrace()
        }
        return true
    }



}



