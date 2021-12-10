package com.tp.clientandroid_critika.Domaine.Présentation.modèle

import com.tp.clientandroid_critika.Domaine.entité.Commentaire
import com.tp.clientandroid_critika.Domaine.entité.Evaluation
import com.tp.clientandroid_critika.Domaine.entité.JeuVideo
import com.tp.clientandroid_critika.Domaine.entité.Utilisateur
import com.tp.clientandroid_critika.Domaine.interacteur.GestionJeuxVideo
import com.tp.clientandroid_critika.Présentation.modèle.Modèle
import com.tp.clientandroid_critika.SourceDeDonnées.SourceDeDonnéesBidon
import org.junit.Assert
import org.junit.Test
import java.time.LocalDateTime

class ModèleTest {

    @Test
    fun `étant donné un utilisateur, lorsque j'ai veux avoir un compte pour avoir accès à appliacation', j'obtien un retour positif (true)`() {

        //Mise en place
        var cobaye: Boolean?
        var sourceDeDonnées = SourceDeDonnéesBidon()
        var u = Utilisateur("", "utilisateurTest", "mdp", "test", "testeur")
        var _modèle = Modèle.getInstance()
        _modèle.sourceDeDonnées = sourceDeDonnées

        //Exécution
        cobaye = _modèle?.creationUtilisateur(u)

        //Vérification
        Assert.assertTrue(cobaye!!)
    }

    @Test
    fun `étant donné un utilisateur, lorsque j'ai me connecte avec les bons identifiants', j'obtien un retour positif (true)`() {

        //Mise en place
        var cobaye: Boolean?
        var _modèle = Modèle.getInstance()
        var sourceDeDonnées = SourceDeDonnéesBidon()
        _modèle.sourceDeDonnées = sourceDeDonnées

        //Exécution
        cobaye = _modèle?.verifierUtilisateur("utilisateurTest", "mdp")

        //Vérification
        Assert.assertTrue(cobaye!!)
    }

    @Test
    fun `étant donné un utilisateur, lorsque je rechercher un jeu par console, j'obtien un retour positif (true)`() {

        //Mise en place
        var cobaye = true
        var _modèle = Modèle.getInstance()
        var listeJeux: List<JeuVideo>? = null
        var sourceDeDonnées = SourceDeDonnéesBidon()
        _modèle.sourceDeDonnées = sourceDeDonnées


        //Exécution
        _modèle?.chercherJeuxParConsole("Test1")
        listeJeux = _modèle.listeJeux
        for (j in listeJeux!!) {
            if (j.plateforme != "Test1") {
                cobaye = false
            }
        }

        //Vérification
        Assert.assertTrue(cobaye!!)
    }

    @Test
    fun `étant donné un utilisateur, lorsque j'ajoute un commentaire, j'obtien un retour positif (true)`() {

        //Mise en place
        var cobaye: Boolean?
        var jeuTest = JeuVideo(
            "aaaa", "test", "un test", "Test1", "Test", "Solo",
            2021, null, null
        )
        var u = Utilisateur("1111", "utilisateurTest", "mdp", "test", "testeur")
        var _modèle = Modèle.getInstance()
        var sourceDeDonnées = SourceDeDonnéesBidon()
        _modèle.sourceDeDonnées = sourceDeDonnées
        _modèle.jeuSelectionné = jeuTest
        _modèle.utilisateur = u

        //Exécution
        cobaye = _modèle?.ajouterCommentaire("Je commente")

        //Vérification
        Assert.assertTrue(cobaye!!)
    }

    @Test
    fun `étant donné un utilisateur, lorsque je veux voir mon évaluation, j'obtien un retour positif (true)`() {

        //Mise en place
        var cobaye: Boolean?
        var jeuTest = JeuVideo(
            "aaaa", "test", "un test", "Test1", "Test", "Solo",
            2021, null, null
        )
        var liste: MutableList<Evaluation> = ArrayList()
        liste.add(Evaluation("111", "aaaa", "", 5))
        jeuTest.listeEvaluations = liste

        var u = Utilisateur("", "utilisateurTest", "mdp", "test", "testeur")
        var _modèle = Modèle.getInstance()
        var sourceDeDonnées = SourceDeDonnéesBidon()
        _modèle.sourceDeDonnées = sourceDeDonnées
        _modèle.jeuSelectionné = jeuTest
        _modèle.utilisateur = u

        //Exécution
        cobaye = _modèle?.chercherEvaluationUtilisateur()

        //Vérification
        Assert.assertTrue(cobaye!!)
    }

    @Test
    fun `étant donné un utilisateur, lorsque je veux ajouter mon évaluation, j'obtien un retour positif (true)`() {

        //Mise en place
        var cobaye: Boolean?
        var _modèle = Modèle.getInstance()
        var sourceDeDonnées = SourceDeDonnéesBidon()
        _modèle.sourceDeDonnées = sourceDeDonnées

        //Exécution
        cobaye = _modèle?.ajouterEvaluation(4)

        //Vérification
        Assert.assertTrue(cobaye!!)
    }

    @Test
    fun `étant donné un utilisateur, lorsque je veux modifier mon évaluation, j'obtien un retour positif (true)`() {

        //Mise en place
        var cobaye: Boolean?
        var _modèle = Modèle.getInstance()
        var sourceDeDonnées = SourceDeDonnéesBidon()
        var evaluation = Evaluation("aaa", "aaa", "aaa", 5)
        _modèle.sourceDeDonnées = sourceDeDonnées
        _modèle.evalautionSelectionné = evaluation

        //Exécution
        cobaye = _modèle?.modifierEvaluation(2)

        //Vérification
        Assert.assertTrue(cobaye!!)
    }

    @Test
    fun `étant donné un utilisateur, lorsque je rechercher un jeu un mot cle, j'obtien un retour positif (true)`() {

        //Mise en place
        var cobaye = true
        var _modèle = Modèle.getInstance()
        var listeJeux: List<JeuVideo>? = null
        var sourceDeDonnées = SourceDeDonnéesBidon()
        _modèle.sourceDeDonnées = sourceDeDonnées


        //Exécution
        _modèle?.chercherJeuxParMotCle("test1")
        listeJeux = _modèle.listeJeux
        for (j in listeJeux!!) {
            if (j.nom != "test1") {
                cobaye = false
            }
        }

        //Vérification
        Assert.assertTrue(cobaye!!)
    }

    @Test
    fun `étant donné un utilisateur, lorsque je veux modifier mon surnom, j'obtien un retour positif (true)`() {

        //Mise en place
        var cobaye: Boolean?
        var _modèle = Modèle.getInstance()
        var sourceDeDonnées = SourceDeDonnéesBidon()
        var utilisateur = Utilisateur("", "test", "test", "test", "testeur")
        _modèle.sourceDeDonnées = sourceDeDonnées
        _modèle.utilisateur = utilisateur

        //Exécution
        cobaye = _modèle?.modiferSurnom("test2")

        //Vérification
        Assert.assertTrue(cobaye!!)
    }

    @Test
    fun `étant donné un utilisateur, lorsque je veux modifier un commentaire, j'obtien un retour positif (true)`() {

        //Mise en place
        var cobaye: Boolean?
        var _modèle = Modèle.getInstance()
        var sourceDeDonnées = SourceDeDonnéesBidon()
        var utilisateur = Utilisateur("", "test", "test", "test", "testeur")
        var commentaire = Commentaire(
            "aaaa", "aaaa", "aaaa",
            LocalDateTime.now().toString(), "Test,", utilisateur
        )
        _modèle.sourceDeDonnées = sourceDeDonnées
        _modèle.commentaireSelectionné = commentaire

        //Exécution
        cobaye = _modèle?.modiferCommentaire("Test2")

        //Vérification
        Assert.assertTrue(cobaye!!)
    }

    @Test
    fun `étant donné un utilisateur, lorsque je veux effacer un commentaire, j'obtien un retour positif (true)`() {

        //Mise en place
        var cobaye: Boolean?
        var _modèle = Modèle.getInstance()
        var sourceDeDonnées = SourceDeDonnéesBidon()
        _modèle.sourceDeDonnées = sourceDeDonnées

        //Exécution
        cobaye = _modèle?.effacerCommentaire("aaaaaa")

        //Vérification
        Assert.assertTrue(cobaye!!)
    }

}