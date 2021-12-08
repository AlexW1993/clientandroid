package com.tp.clientandroid_critika.SourceDeDonnées

import com.tp.clientandroid_critika.Domaine.entité.Commentaire
import com.tp.clientandroid_critika.Domaine.entité.Evaluation
import com.tp.clientandroid_critika.Domaine.entité.JeuVideo
import com.tp.clientandroid_critika.Domaine.entité.Utilisateur
import com.tp.clientandroid_critika.Domaine.interacteur.SourceDeDonnées

class SourceDeDonnéesBidon : SourceDeDonnées {

    override fun chercherUtilisateur(u: Utilisateur): Utilisateur? {
        return u
    }

    override fun ajouterUtilisateur(utilisateur: Utilisateur): Boolean {
        return true
    }

    override fun chercherTousJeux(): List<JeuVideo>? {
        var listeJeux: MutableList<JeuVideo> = ArrayList()
        var listeEvaluation1: MutableList<Evaluation> = ArrayList()
        var listeEvaluation2: MutableList<Evaluation> = ArrayList()
        listeEvaluation1?.add(Evaluation("aaa", "aaa", "aaa", 5))
        listeEvaluation2?.add(Evaluation("bbb", "bbb", "bbb", 3))
        var jeuVideo = JeuVideo(
            "aaaa", "test", "un test", "Test1", "Test", "Solo",
            2021, null, listeEvaluation1
        )
        listeJeux?.add(jeuVideo)
        jeuVideo = JeuVideo(
            "bbbb", "test", "un test", "Test2", "Test", "Solo",
            2021, null, null
        )
        listeJeux?.add(jeuVideo)
        jeuVideo = JeuVideo(
            "cccc", "test", "un test", "Test1", "Test", "Solo",
            2021, null, listeEvaluation2
        )
        listeJeux?.add(jeuVideo)
        jeuVideo = JeuVideo(
            "dddd", "test", "un test", "Test2", "Test", "Solo",
            2021, null, null
        )
        listeJeux?.add(jeuVideo)
        return listeJeux
    }

    override fun chercherTousJeuxParPlateforme(plateforme: String): List<JeuVideo>? {
        var listeJeux: MutableList<JeuVideo> = ArrayList()
        var listeEvaluation1: MutableList<Evaluation> = ArrayList()
        var listeEvaluation2: MutableList<Evaluation> = ArrayList()
        listeEvaluation1?.add(Evaluation("aaa", "aaa", "aaa", 5))
        listeEvaluation2?.add(Evaluation("bbb", "bbb", "bbb", 3))
        var jeuVideo = JeuVideo(
            "aaaa", "test", "un test", "Test1", "Test", "Solo",
            2021, null, listeEvaluation1
        )
        listeJeux?.add(jeuVideo)
        jeuVideo = JeuVideo(
            "bbbb", "test", "un test", "Test2", "Test", "Solo",
            2021, null, null
        )
        listeJeux?.add(jeuVideo)
        jeuVideo = JeuVideo(
            "cccc", "test", "un test", "Test1", "Test", "Solo",
            2021, null, listeEvaluation2
        )
        listeJeux?.add(jeuVideo)
        jeuVideo = JeuVideo(
            "dddd", "test", "un test", "Test2", "Test", "Solo",
            2021, null, null
        )
        var listePlateforme: MutableList<JeuVideo> = ArrayList()
        listeJeux?.add(jeuVideo)
        for (l in listeJeux) {
            if (plateforme == l.plateforme) {
                listePlateforme.add(l)
            }
        }
        return listePlateforme
    }

    override fun ajouterCommentaire(commentaire: Commentaire): Boolean {
        return true
    }

    override fun ajouterEvaluation(evaluation: Evaluation): Boolean {
        return true
    }

    override fun modifierEvaluation(evaluation: Evaluation): Boolean {
        return true
    }

    override fun chercherJeuxParMotCle(motCle: String): List<JeuVideo>? {
        TODO("Not yet implemented")
    }


}