package com.tp.clientandroid_critika.Domaine.entité
import org.junit.Assert
import org.junit.Test

class UtilisateurTest {

    @Test
    fun `étant donné une utilisateur, lorsque je crée mon perfil utilisateur en utilisant le constructeur, j'obtien le resulta id = 1 nom =  Will, mot de passe = "1234", codeAvatar = "1", type = utiisateur et droit à ecrire = false`(){

        //Mise en place
        var id = "1"
        var nom = "Will"
        var motPasse = "1234"
        var codeAvatar = "1"
        var type = "utilisateur"
        var droitEcrire = false


        //Exécution
        var cobaye = Utilisateur("1","Will","1234", "1", "utilisateur", false)

        //Vérification
        Assert.assertEquals(id, cobaye.id)
        Assert.assertEquals(nom, cobaye.nom)
        Assert.assertEquals(motPasse, cobaye.motPasse)
        Assert.assertEquals(codeAvatar, cobaye.codeAvatar)
        Assert.assertEquals(type, cobaye.type)
        Assert.assertEquals(droitEcrire, cobaye.droitEcrire)
    }

    @Test
    fun `étant donné une utilisateur, lorsque je fais une modification dans mon compte, j'obtien le resulta id = 2 nom =  Alex, mot de passe = "0000", codeAvatar = "2", type = administrateur et droit à ecrire = true`(){

        //Mise en place
        var cobaye = Utilisateur("1","Will","1234", "1", "utilisateur", false)


        //Exécution
        cobaye.id = "2"
        cobaye.nom = "Alex"
        cobaye.motPasse = "0000"
        cobaye.codeAvatar = "2"
        cobaye.type = "administrateur"
        cobaye.droitEcrire = true

        //Vérification
        Assert.assertEquals("2", cobaye.id)
        Assert.assertEquals("Alex", cobaye.nom)
        Assert.assertEquals("0000", cobaye.motPasse)
        Assert.assertEquals("2", cobaye.codeAvatar)
        Assert.assertEquals("administrateur", cobaye.type)
        Assert.assertEquals(true, cobaye.droitEcrire)
    }

    @Test
    fun `étant donné une utilisateur, lorsque je veux afficher les information de mon profil, j'obtien le resulta "Utilisateur(id='1', nom='Will', motPasse='1234', codeAvatar='1', type='utilisateur', droitEcrire=false)"`(){

        //Mise en place
        var cobaye = Utilisateur("1","Will","1234", "1", "utilisateur", false)
        var resultatAttandu = "Utilisateur(id='1', nom='Will', motPasse='1234', codeAvatar='1', type='utilisateur', droitEcrire=false)"


        //Exécution
        var resultatObservé = cobaye.toString()

        //Vérification
        Assert.assertEquals(resultatAttandu, resultatObservé)

    }
}