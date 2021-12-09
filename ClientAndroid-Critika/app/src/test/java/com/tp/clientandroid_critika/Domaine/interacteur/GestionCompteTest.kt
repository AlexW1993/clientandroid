package com.tp.clientandroid_critika.Domaine.interacteur

import com.tp.clientandroid_critika.Domaine.entité.Utilisateur
import com.tp.clientandroid_critika.SourceDeDonnées.SourceDeDonnéesBidon
import org.junit.Assert
import org.junit.Test

class GestionCompteTest {

    @Test
    fun `étant donné un utilisateur, lorsque je veux me connecter à application, j'obtien comme resultat une object utilisateur qui a mes information`() {

        //Mise en place
        var cobaye: Utilisateur?
        var sourceDeDonnées = SourceDeDonnéesBidon()

        //Exécution
        cobaye = GestionCompte(sourceDeDonnées).verificationCompte("utilisateruTest", "mdp")

        //Vérification
        Assert.assertNotNull(cobaye)
    }

    @Test
    fun `étant donné un utilisateur, lorsque je veux créer mon compte, j'obtien le resultat true pour confirmer mon inscription`() {

        //Mise en place
        var cobaye: Boolean?
        var sourceDeDonnées = SourceDeDonnéesBidon()
        var u = Utilisateur("", "utilisateurTest", "mdp", "test", "testeur")

        //Exécution
        cobaye = GestionCompte(sourceDeDonnées).creationCompte(u)!!

        //Vérification
        Assert.assertTrue(cobaye)
    }

    @Test
    fun `étant donné un utilisateur, lorsque j'ai fait un changement à mon surnom, j'obtien comme resultat une true pour confirmer que le surnom a été modifié correctement`() {

        //Mise en place
        var cobaye: Boolean?
        var sourceDeDonnées = SourceDeDonnéesBidon()
        var utilisateur = Utilisateur("", "test", "test", "test", "testeur")

        //Exécution
        cobaye = GestionCompte(sourceDeDonnées).modifierSurnom(utilisateur)

        //Vérification
        Assert.assertTrue(cobaye!!)
    }

}