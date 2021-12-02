package com.tp.clientandroid_critika.Domaine.interacteur

import com.tp.clientandroid_critika.Domaine.entité.Evaluation
import com.tp.clientandroid_critika.Domaine.entité.JeuVideo
import org.junit.Assert
import org.junit.Test

class ChercherTop10JeuxTest {

    @Test
    fun `étant donné un application, lorsque il vas chercher la liste de meilleur notes des jeux vidéos', j'obtien comme resultat 2 jeux qui ont des notes`() {

        //Mise en place
        var listeJeux: MutableList<JeuVideo> = ArrayList()
        var listeEvaluation1: MutableList<Evaluation> = ArrayList()
        var listeEvaluation2: MutableList<Evaluation> = ArrayList()
        var jeuVideo: JeuVideo
        listeEvaluation1?.add(Evaluation("aaa", "aaa", "aaa", 5))
        listeEvaluation2?.add(Evaluation("bbb", "bbb", "bbb", 3))
        jeuVideo = JeuVideo(
            "aaaa", "test", "un test", "Test", "Test", "Solo",
            2021, null, listeEvaluation1
        )
        listeJeux?.add(jeuVideo)
        jeuVideo = JeuVideo(
            "bbbb", "test", "un test", "Test", "Test", "Solo",
            2021, null, null
        )
        listeJeux?.add(jeuVideo)
        jeuVideo = JeuVideo(
            "cccc", "test", "un test", "Test", "Test", "Solo",
            2021, null, listeEvaluation2
        )
        listeJeux?.add(jeuVideo)
        jeuVideo = JeuVideo(
            "dddd", "test", "un test", "Test", "Test", "Solo",
            2021, null, null
        )
        listeJeux?.add(jeuVideo)

        //Exécution
        var cobaye = ChercherTop10Jeux().chercherTop10(listeJeux)

        //Vérification
        Assert.assertEquals(2, cobaye.size)
    }
}