package com.tp.clientandroid_critika.SourceDeDonnées
import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.RequestFuture
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.tp.clientandroid_critika.Domaine.entité.Utilisateur
import com.tp.clientandroid_critika.Domaine.interacteur.SourceDeDonnées
import java.net.URL
import java.util.concurrent.ExecutionException

class SourceDeDonnéesAPI (var url : URL, var ctx : Context) : SourceDeDonnées{

    var gson : Gson = Gson()

    override fun chercherUtilisateurs() : Array<Utilisateur?>? {
        var queue : RequestQueue = Volley.newRequestQueue(ctx)
        var future : RequestFuture<String> = RequestFuture.newFuture()
        var request = StringRequest(Request.Method.GET, url.toString(),future,future)
        queue.add(request)
        try {
            var reponse = future.get()
            var utilisateurs : Array<Utilisateur?> = gson.fromJson(reponse, Array<Utilisateur?>::class.java)
            return utilisateurs
        }catch (e : InterruptedException){
            e.printStackTrace()
        } catch (e : ExecutionException){
            e.printStackTrace()
        }
        return null
    }

}