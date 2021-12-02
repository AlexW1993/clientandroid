package com.tp.clientandroid_critika.Domaine.interacteur

import com.tp.clientandroid_critika.Domaine.entité.Utilisateur
import com.tp.clientandroid_critika.SourceDeDonnées.SourceDeDonnéesBidon
import org.junit.Assert
import org.junit.Test

class GestionCompteTest {

    @Test
    fun `étant donné un utilisateur, lorsque je veux me connecter à application, j'obtien comme resultat une object utilisateur qui a mes information`() {

        //Mise en place
        var utilisateur: Utilisateur?
        var sourceDeDonnées = SourceDeDonnéesBidon()
        var cobaye = Utilisateur("111", "utilisateurTest", "mdp", "test", "testeur")

        //Exécution
        utilisateur = GestionCompte(sourceDeDonnées).verificationCompte("utilisateruTest", "mdp")

        //Vérification
        Assert.assertNotNull(utilisateur)
    }

    @Test
    fun `étant donné un utilisateur, lorsque je veux créer mon compte, j'obtien le resultat true pour confirmer mon inscription`() {

        //Mise en place
        var confirmation: Boolean?
        var sourceDeDonnées = SourceDeDonnéesBidon()
        var cobaye = Utilisateur("", "utilisateurTest", "mdp", "", "t")

        //Exécution
        confirmation = GestionCompte(sourceDeDonnées).creationCompte(cobaye)!!

        //Vérification
        Assert.assertTrue(confirmation)
    }
}