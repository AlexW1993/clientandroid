package com.tp.clientandroid_critika.Domaine.Présentation.modèle

import com.tp.clientandroid_critika.Domaine.entité.Evaluation
import com.tp.clientandroid_critika.Domaine.entité.JeuVideo
import com.tp.clientandroid_critika.Domaine.entité.Utilisateur
import com.tp.clientandroid_critika.Domaine.interacteur.GestionJeuxVideo
import com.tp.clientandroid_critika.Présentation.modèle.Modèle
import com.tp.clientandroid_critika.SourceDeDonnées.SourceDeDonnéesBidon
import org.junit.Assert
import org.junit.Test

class ModèleTest {

    @Test
    fun `étant donné un utilisateur, lorsque j'ai veux avoir un compte pour avoir accès à appliacation', j'obtien un retour positif (true)`() {

        //Mise en place
        var cobaye: Boolean?
        var sourceDeDonnées = SourceDeDonnéesBidon()
        var j1 = JeuVideo("", "jeuTest1")
        var j2 = JeuVideo("", "jeuTest2")
        var j3 = JeuVideo("", "jeuTest3")
        var u = Utilisateur("", "utilisateurTest", "mdp", "test", "testeur")
        var listeJeux : List<JeuVideo>? = null
        var evalautionSelectionné : Evaluation? = null
        var _modèle = Modèle()

        //Exécution
        cobaye = _modèle?.creationUtilisateur(u)

        //Vérification
        Assert.assertTrue(cobaye!!)
    }

    @Test
    fun `étant donné un utilisateur, lorsque j'ai me connecte avec les bons identifiants', j'obtien un retour positif (true)`() {

        //Mise en place
        var cobaye: Boolean?
        var _modèle = Modèle()

        //Exécution
        cobaye = _modèle?.verifierUtilisateur("utilisateurTest","mdp")

        //Vérification
        Assert.assertTrue(cobaye!!)
    }

    @Test
    fun `étant donné un utilisateur, lorsque je rechercher un jeu par console, j'obtien un retour positif (true)`() {

        //Mise en place
        var cobaye = true
        var _modèle = Modèle()
        var listeJeux : List<JeuVideo>? = null

        //Exécution
        _modèle?.chercherJeuxParConsole("Atari")
        for(j in listeJeux!!){
            if(j.plateforme == "Atari"){
                cobaye = false
            }
        }

        //Vérification
        Assert.assertTrue(cobaye!!)
    }

    @Test
    fun `étant donné un utilisateur, lorsque j'ajoute un commentaire, j'obtien un retour positif (true)`() {

        //Mise en place
        var cobaye : Boolean?
        var _modèle = Modèle()

        //Exécution
        cobaye = _modèle?.ajouterCommentaire("Je commente")

        //Vérification
        Assert.assertTrue(cobaye!!)
    }

    @Test
    fun `étant donné un utilisateur, lorsque je veux voir mon évaluation, j'obtien un retour positif (true)`() {

        //Mise en place
        var cobaye : Boolean?
        var _modèle = Modèle()

        //Exécution
        cobaye = _modèle?.chercherEvaluationUtilisateur()

        //Vérification
        Assert.assertTrue(cobaye!!)
    }

    @Test
    fun `étant donné un utilisateur, lorsque je veux ajouter mon évaluation, j'obtien un retour positif (true)`() {

        //Mise en place
        var cobaye : Boolean?
        var _modèle = Modèle()

        //Exécution
        cobaye = _modèle?.ajouterEvaluation(4)

        //Vérification
        Assert.assertTrue(cobaye!!)
    }

    @Test
    fun `étant donné un utilisateur, lorsque je veux modifier mon évaluation, j'obtien un retour positif (true)`() {

        //Mise en place
        var cobaye : Boolean?
        var _modèle = Modèle()

        //Exécution
        cobaye = _modèle?.modifierEvaluation(2)

        //Vérification
        Assert.assertTrue(cobaye!!)
    }
}