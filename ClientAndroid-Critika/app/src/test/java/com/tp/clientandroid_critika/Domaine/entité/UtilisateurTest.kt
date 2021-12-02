package com.tp.clientandroid_critika.Domaine.entité

import org.junit.Assert
import org.junit.Test

class UtilisateurTest {

    @Test
    fun `étant donné une utilisateur, lorsque je crée mon perfil utilisateur en utilisant le constructeur, j'obtien le resulta id = 1 nom =  Will, mot de passe = "1234", codeAvatar = "1" et type = utiisateur`() {

        //Mise en place
        var cobaye: Utilisateur

        //Exécution
        cobaye = Utilisateur("1", "Will", "1234", "1", "utilisateur")

        //Vérification
        Assert.assertEquals("1", cobaye.id)
        Assert.assertEquals("Will", cobaye.nom)
        Assert.assertEquals("1234", cobaye.motPasse)
        Assert.assertEquals("1", cobaye.codeAvatar)
        Assert.assertEquals("utilisateur", cobaye.type)
    }

    @Test
    fun `étant donné une utilisateur, lorsque je crée mon perfil utilisateur en utilisant le constructeur sans parametres, j'obtien le resulta id = "" nom =  "", mot de passe = "", codeAvatar = "" et type = ""`() {

        //Mise en place
        var cobaye: Utilisateur

        //Exécution
        cobaye = Utilisateur()

        //Vérification
        Assert.assertEquals("", cobaye.id)
        Assert.assertEquals("", cobaye.nom)
        Assert.assertEquals("", cobaye.motPasse)
        Assert.assertEquals("", cobaye.codeAvatar)
        Assert.assertEquals("", cobaye.type)
    }

    @Test
    fun `étant donné une utilisateur, lorsque je fais une modification dans mon compte, j'obtien le resulta id = 2 nom =  Alex, mot de passe = "0000", codeAvatar = "2" et type = administrateur`() {

        //Mise en place
        var cobaye = Utilisateur("1", "Will", "1234", "1", "utilisateur")

        //Exécution
        cobaye.id = "2"
        cobaye.nom = "Alex"
        cobaye.motPasse = "0000"
        cobaye.codeAvatar = "2"
        cobaye.type = "administrateur"

        //Vérification
        Assert.assertEquals("2", cobaye.id)
        Assert.assertEquals("Alex", cobaye.nom)
        Assert.assertEquals("0000", cobaye.motPasse)
        Assert.assertEquals("2", cobaye.codeAvatar)
        Assert.assertEquals("administrateur", cobaye.type)
    }

    @Test
    fun `étant donné une utilisateur, lorsque je veux afficher les information de mon profil, j'obtien le resulta "Utilisateur(id='1', nom='Will', motPasse='1234', codeAvatar='1', type='utilisateur')"`() {

        //Mise en place
        var cobaye = Utilisateur("1", "Will", "1234", "1", "utilisateur")
        var resultatAttandu =
            "Utilisateur(id='1', nom='Will', motPasse='1234', codeAvatar='1', type='utilisateur')"


        //Exécution
        var resultatObservé = cobaye.toString()

        //Vérification
        Assert.assertEquals(resultatAttandu, resultatObservé)
    }
}