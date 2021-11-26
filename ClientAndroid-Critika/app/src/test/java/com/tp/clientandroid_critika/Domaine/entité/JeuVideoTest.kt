package com.tp.clientandroid_critika.Domaine.entité
import org.junit.Assert
import org.junit.Test
import java.time.LocalDateTime

class JeuVideoTest {

    @Test
    fun `étant donné une utilisateur, lorsque je crée un jeu en utilisant le constructeur, j'obtien ses information aussi l'id de un commentaire et d'une evalauiton`(){

        //Mise en place
        var id = "1"
        var nom = "Mario Kart"
        var descriptio = "Mario avec des voitures"
        var plateforme = "Nintendo Switch"
        var genre = "Kart"
        var modeJeu = "1 - 4 player"
        var anneSortie = 2021
        var listeCommentaire : MutableList<Commentaire> = ArrayList()
        listeCommentaire.add(Commentaire("1","1","1", LocalDateTime.of(1,1,1,2,2,2),"Mario",null))
        var listeEvaluation : MutableList<Evaluation> = ArrayList()
        listeEvaluation.add(Evaluation("1","1","1",5))

        //Exécution
        var listeCommentaire2 : MutableList<Commentaire> = ArrayList()
        listeCommentaire2.add(Commentaire("1","1","1", LocalDateTime.of(1,1,1,2,2,2),"Mario",null))
        var listeEvaluation2 : MutableList<Evaluation> = ArrayList()
        listeEvaluation2.add(Evaluation("1","1","1",5))
        var cobaye = JeuVideo("1","Mario Kart", "Mario avec des voitures", "Nintendo Switch",
            "Kart", "1 - 4 player", 2021,listeCommentaire2,listeEvaluation2)

        //Vérification
        Assert.assertEquals(id, cobaye.id)
        Assert.assertEquals(nom, cobaye.nom)
        Assert.assertEquals(descriptio, cobaye.description)
        Assert.assertEquals(plateforme, cobaye.plateforme)
        Assert.assertEquals(genre, cobaye.genre)
        Assert.assertEquals(modeJeu, cobaye.modeJeu)
        Assert.assertEquals(anneSortie, cobaye.anneSortie)
        Assert.assertEquals(listeCommentaire[0].id, cobaye.listeCommentaires?.get(0)?.id)
        Assert.assertEquals(listeEvaluation[0].id, cobaye.listeEvaluations?.get(0)?.id)
    }

    @Test
    fun `étant donné une utilisateur, lorsque je fais une modification dans les information d'un jeu, j'obtien le resulta id = 2 nom =  Alex, mot de passe = "0000", codeAvatar = "2", type = administrateur et droit à ecrire = true`(){

        //Mise en place
        var listeCommentaire : MutableList<Commentaire> = ArrayList()
        listeCommentaire.add(Commentaire("1","1","1", LocalDateTime.of(1,1,1,2,2,2),"Mario",null))
        var listeEvaluation : MutableList<Evaluation> = ArrayList()
        listeEvaluation.add(Evaluation("1","1","1",5))
        var cobaye = JeuVideo("1","Mario Kart", "Mario avec des voitures", "Nintendo Switch",
            "Kart", "1 - 4 player", 2021,listeCommentaire,listeEvaluation)


        //Exécution
        cobaye.id = "2"
        cobaye.nom = "God of war"
        cobaye.description = "un bon jeu"
        cobaye.plateforme = "Playstation 4"
        cobaye.genre = "Aventure"
        cobaye.modeJeu = "Solo"
        cobaye.anneSortie = 2020
        cobaye.listeCommentaires?.get(0)?.id = "2"
        cobaye.listeEvaluations?.get(0)?.id = "2"


        //Vérification
        Assert.assertEquals("2", cobaye.id)
        Assert.assertEquals("God of war", cobaye.nom)
        Assert.assertEquals("un bon jeu", cobaye.description)
        Assert.assertEquals("Playstation 4", cobaye.plateforme)
        Assert.assertEquals("Aventure", cobaye.genre)
        Assert.assertEquals("Solo", cobaye.modeJeu)
        Assert.assertEquals(2020, cobaye.anneSortie)
        Assert.assertEquals("2", cobaye.listeCommentaires?.get(0)?.id)
        Assert.assertEquals("2", cobaye.listeEvaluations?.get(0)?.id)
    }

    @Test
    fun `étant donné une utilisateur, lorsque je veux afficher les information de un jeu, j'obtien le resulta et pas un null"`(){

        //Mise en place
        var listeCommentaire : MutableList<Commentaire> = ArrayList()
        listeCommentaire.add(Commentaire("1","1","1", LocalDateTime.of(1,1,1,2,2,2),"Mario",null))
        var listeEvaluation : MutableList<Evaluation> = ArrayList()
        listeEvaluation.add(Evaluation("1","1","1",5))
        var cobaye = JeuVideo("1","Mario Kart", "Mario avec des voitures", "Nintendo Switch",
            "Kart", "1 - 4 player", 2021,listeCommentaire,listeEvaluation)

        //Exécution
        var resultatObservé = cobaye.toString()

        //Vérification
        Assert.assertNotNull(resultatObservé)

    }

    @Test
    fun `étant donné une utilisateur, lorsque je veux afficher la moyenne d'evaluation d'un jeu video, j'obtien le resulta et pas un null"`(){

        //Mise en place
        var listeCommentaire : MutableList<Commentaire> = ArrayList()
        listeCommentaire.add(Commentaire("1","1","1", LocalDateTime.of(1,1,1,2,2,2),"Mario",null))
        var listeEvaluation : MutableList<Evaluation> = ArrayList()
        listeEvaluation.add(Evaluation("1","1","1",5))
        listeEvaluation.add(Evaluation("2","1","2",3))
        var cobaye = JeuVideo("1","Mario Kart", "Mario avec des voitures", "Nintendo Switch",
            "Kart", "1 - 4 player", 2021,listeCommentaire,listeEvaluation)

        //Exécution
        var resultatAttandu = 4.0
        var resultatObservé = cobaye.calculerMoyenneEvaluation()

        //Vérification
        Assert.assertEquals(resultatAttandu, resultatObservé,0.0)
    }
}