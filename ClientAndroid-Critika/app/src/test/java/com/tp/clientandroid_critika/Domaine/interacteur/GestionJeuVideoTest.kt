package com.tp.clientandroid_critika.Domaine.interacteur

import com.tp.clientandroid_critika.Domaine.entité.JeuVideo
import com.tp.clientandroid_critika.SourceDeDonnées.SourceDeDonnéesBidon
import org.junit.Assert
import org.junit.Test

class GestionJeuVideoTest {

    @Test
    fun `étant donné un utilisateur, lorsque j'ai veux avoir les jeux videos de la appliacation', j'obtien tout las liste des jeux videos`() {

        //Mise en place
        var cobaye: List<JeuVideo>
        var sourceDeDonnées = SourceDeDonnéesBidon()

        //Exécution
        cobaye = GestionJeuxVideo(sourceDeDonnées).chercherTousJeuxVideo()!!

        //Vérification
        Assert.assertEquals(4, cobaye.size)
    }

    @Test
    fun `étant donné un utilisateur, lorsque j'ai veux avoir les jeux videos d'une plateforme', j'obtien les jeux videos qui sont relié à la plateforme`() {

        //Mise en place
        var cobaye: List<JeuVideo>
        var sourceDeDonnées = SourceDeDonnéesBidon()

        //Exécution
        cobaye = GestionJeuxVideo(sourceDeDonnées).chercherJeuxVideoParPlateforme("Test1")!!

        //Vérification
        Assert.assertEquals(2, cobaye.size)
    }

    @Test
    fun `étant donné un utilisateur, lorsque j'ai veux avoir les jeux videos en utilisant un mot cle, j'obtien les jeux videos qui ont le nom de test3`() {

        //Mise en place
        var cobaye: List<JeuVideo>
        var sourceDeDonnées = SourceDeDonnéesBidon()

        //Exécution
        cobaye = GestionJeuxVideo(sourceDeDonnées).chercherJeuxVideoParMotCle("test3")!!

        //Vérification
        Assert.assertEquals(1, cobaye.size)
    }

}