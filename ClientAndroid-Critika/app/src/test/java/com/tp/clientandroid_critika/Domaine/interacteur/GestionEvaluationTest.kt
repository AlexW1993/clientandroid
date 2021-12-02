package com.tp.clientandroid_critika.Domaine.interacteur

import com.tp.clientandroid_critika.Domaine.entité.Evaluation
import com.tp.clientandroid_critika.SourceDeDonnées.SourceDeDonnéesBidon
import org.junit.Assert
import org.junit.Test

class GestionEvaluationTest {

    @Test
    fun `étant donné un utilisateur, lorsque j'ai fait un évaluation à un jeu vidéo', j'obtien comme resultat une true pour confirmer que l'évalaution a été ajouté correctement`() {

        //Mise en place
        var cobaye: Boolean?
        var sourceDeDonnées = SourceDeDonnéesBidon()
        var evaluation = Evaluation("aaaa", "aaaa", "aaaa", 5)

        //Exécution
        cobaye = GestionEvaluation(sourceDeDonnées).ajouterEvaluation(evaluation)

        //Vérification
        Assert.assertTrue(cobaye!!)
    }

    @Test
    fun `étant donné un utilisateur, lorsque j'ai fait un évaluation à un jeu vidéo que j'avais fait une évaluation avant', j'obtien comme resultat une true pour confirmer que l'évalaution a été modifié correctement`() {

        //Mise en place
        var cobaye: Boolean?
        var sourceDeDonnées = SourceDeDonnéesBidon()
        var evaluation = Evaluation("aaaa", "aaaa", "aaaa", 5)

        //Exécution
        cobaye = GestionEvaluation(sourceDeDonnées).modifierEvaluation(evaluation)

        //Vérification
        Assert.assertTrue(cobaye!!)
    }
}