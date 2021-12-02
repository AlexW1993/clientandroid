package com.tp.clientandroid_critika.Domaine.entité

import org.junit.Assert.*
import org.junit.Test

class CommentaireTest {

    @Test
    fun `étant donné un utilisateur, lorsque je fais une commaintaire, j'obtien le resulta id = 1 idJeu = 1 idUtilisateur = 1, date = 2021-11-05, heure = 01 01 et contenue = "Allo"`() {

        //Mise en place
        var u = Utilisateur("1", "root", "root", "aaaa", "utilisateur")
        var cobaye: Commentaire?

        //Exécution
        cobaye = Commentaire("1", "1", "1", "2021-11-05T01:01:01", "Allo", u)

        //Vérification
        assertEquals("1", cobaye.id)
        assertEquals("1", cobaye.jeuVideoId)
        assertEquals("1", cobaye.utilisateurId)
        assertEquals("2021-11-05T01:01:01", cobaye.dateHeure)
        assertEquals("Allo", cobaye.contenue)
        assertEquals("1", cobaye.utilisateur?.id)
        assertEquals("root", cobaye.utilisateur?.nom)
        assertEquals("root", cobaye.utilisateur?.motPasse)
        assertEquals("aaaa", cobaye.utilisateur?.codeAvatar)
        assertEquals("utilisateur", cobaye.utilisateur?.type)
    }

    @Test
    fun `étant donné un utilisateur, lorsque je fais une commaintaire sans ajouter des information sans paramétre, j'obtien le resulta id = "" idJeu = "" idUtilisateur = "", dateHeure = "" contenue = "" et utilisateur = null`() {

        //Mise en place
        var cobaye: Commentaire?

        //Exécution
        cobaye = Commentaire()

        //Vérification

        assertEquals("", cobaye.id)
        assertEquals("", cobaye.jeuVideoId)
        assertEquals("", cobaye.utilisateurId)
        assertEquals("", cobaye.dateHeure)
        assertEquals("", cobaye.contenue)
        assertEquals(null, cobaye.utilisateur)
    }

    @Test
    fun `étant donné un utilisateur, lorsque je fais une modification dans mon commentaire, j'obtien le resulta id = 2 idJeu = 2 idUtilisateur = 2, date = 0001-01-01, heure = 02 02 et contenue = "Bye"`() {

        //Mise en place
        var cobaye = Commentaire("1", "1", "1", "2021-11-05T01:01:01", "Allo", null)

        //Exécution
        cobaye.id = "2"
        cobaye.jeuVideoId = "2"
        cobaye.utilisateurId = "2"
        cobaye.dateHeure = "2021-11-05T01:01:01"
        cobaye.contenue = "Bye"
        cobaye.utilisateur = Utilisateur("1", "root", "root", "aaaa", "utilisateur")

        //Vérification
        assertEquals("2", cobaye.id)
        assertEquals("2", cobaye.jeuVideoId)
        assertEquals("2", cobaye.utilisateurId)
        assertEquals("2021-11-05T01:01:01", cobaye.dateHeure)
        assertEquals("Bye", cobaye.contenue)
        assertEquals("1", cobaye.utilisateur?.id)
        assertEquals("root", cobaye.utilisateur?.nom)
        assertEquals("root", cobaye.utilisateur?.motPasse)
        assertEquals("aaaa", cobaye.utilisateur?.codeAvatar)
        assertEquals("utilisateur", cobaye.utilisateur?.type)
    }

    @Test
    fun `étant donné un utilisateur, lorsque je veux afficher mon commentaire, j'obtien le resulta Commentaire(id='1', idJeu='1', idUtilisateur='1', date='2021-11-05', heure='01 01', contenue='Allo'"`() {

        //Mise en place
        var cobaye = Commentaire("1", "1", "1", "2021-11-05T01:01:01", "Allo", null)
        var resultatAttandu =
            "Commentaire(id='1', jeuVideoId='1', utilisateurId='1', dateHeure=2021-11-05T01:01:01, contenue='Allo', utilisateur=null)"


        //Exécution
        var resultatObservé = cobaye.toString()

        //Vérification
        assertEquals(resultatAttandu, resultatObservé)
    }

}