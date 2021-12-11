package com.tp.clientandroid_critika.Domaine.interacteur

import com.tp.clientandroid_critika.Domaine.entité.Commentaire
import com.tp.clientandroid_critika.Domaine.entité.Utilisateur
import com.tp.clientandroid_critika.SourceDeDonnées.SourceDeDonnéesBidon
import org.junit.Assert
import org.junit.Test
import java.time.LocalDateTime

class GestionCommentaireTest {

    @Test
    fun `étant donné un utilisateur, lorsque j'ai fait un commentaire et je veux ajouter le commentaire dans son jeu', j'obtien comme resultat une true pour confirmer que le commentaire a été ajouté correctement`() {

        //Mise en place
        var cobaye: Boolean?
        var sourceDeDonnées = SourceDeDonnéesBidon()
        var u = Utilisateur("", "utilisateurTest", "mdp", "test", "testeur")
        var c = Commentaire("", "aaaa", "1111", LocalDateTime.now().toString(), "Bonjour à tous", u)

        //Exécution
        cobaye = GestionCommentaire(sourceDeDonnées).ajouterCommentaire(c)

        //Vérification
        Assert.assertTrue(cobaye!!)

    }

    @Test
    fun `étant donné un utilisateur, lorsque j'ai fait un changement dans un commentaire, j'obtien comme resultat une true pour confirmer que le commentaire a été modifié correctement`() {

        //Mise en place
        var cobaye: Boolean?
        var sourceDeDonnées = SourceDeDonnéesBidon()
        var commentaire =
            Commentaire("aaaa", "aaaa", "aaaa", LocalDateTime.now().toString(), "Test,", null)

        //Exécution
        cobaye = GestionCommentaire(sourceDeDonnées).modifierCommentaire(commentaire)

        //Vérification
        Assert.assertTrue(cobaye!!)
    }

    @Test
    fun `étant donné un utilisateur, lorsque j'ai effacé un commentaire, j'obtien comme resultat une true pour confirmer que le commentaire a été effacé correctement`() {

        //Mise en place
        var cobaye: Boolean?
        var sourceDeDonnées = SourceDeDonnéesBidon()
        var commentaire =
            Commentaire("aaaa", "aaaa", "aaaa", LocalDateTime.now().toString(), "Test,", null)

        //Exécution
        cobaye = GestionCommentaire(sourceDeDonnées).effacerCommentiare(commentaire.id)

        //Vérification
        Assert.assertTrue(cobaye!!)
    }

}