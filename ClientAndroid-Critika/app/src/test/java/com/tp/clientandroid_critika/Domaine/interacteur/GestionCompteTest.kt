package com.tp.clientandroid_critika.Domaine.interacteur

import com.tp.clientandroid_critika.Domaine.entité.Utilisateur
import com.tp.clientandroid_critika.SourceDeDonnées.SourceDeDonnéesBidon
import org.junit.Assert
import org.junit.Test

class GestionCompteTest {

    @Test
    fun `étant donné un utilisateur, lorsque je veux utiliser me connecter à application, j'obtien le resultat connection=true`(){

        //Mise en place
        var connection : Boolean? = null
        var sourceDeDonnées = SourceDeDonnéesBidon()
        var cobaye = Utilisateur("111","utilisateurTest","mdp","test","testeur")


        //Exécution
        connection = GestionCompte(sourceDeDonnées).creationCompte(cobaye)!!

        //Vérification

        Assert.assertTrue(connection)
    }
}