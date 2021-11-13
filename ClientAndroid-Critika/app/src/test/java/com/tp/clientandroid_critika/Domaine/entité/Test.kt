package com.tp.clientandroid_critika.Domaine.entité
import com.tp.clientandroid_critika.Domaine.interacteur.SourceDeDonnées
import com.tp.clientandroid_critika.SourceDeDonnées.SourceDeDonnéesAPI
import org.junit.Test


class Test {
    
    @Test
    fun hola(){
        var data : SourceDeDonnées = SourceDeDonnéesAPI("https://localhost:44305/api/Utilisateur")
        var utilisateur : Utilisateur = data.chercherUtilisateur("mario","luigi")

    }
}