package com.tp.clientandroid_critika.Domaine.entité

import org.junit.Assert.*
import org.junit.Test
import java.time.LocalDateTime

class CommentaireTest {

    @Test
    fun `étant donné un utilisateur, lorsque je fais une commaintaire, j'obtien le resulta id = 1 idJeu = 1 idUtilisateur = 1, date = 2021-11-05, heure = 01 01 et contenue = "Allo"`(){

        //Mise en place
        var id = "1"
        var idJeu = "1"
        var idUtilisateur = "1"
        var dateHeure = LocalDateTime.of(1,1,1,2,2,2)
        var contenue = "Allo"


        //Exécution
        var cobaye = Commentaire("1","1","1", LocalDateTime.of(1,1,1,2,2,2), "Allo", null)

        //Vérification

        assertEquals( id, cobaye.id )
        assertEquals( idJeu, cobaye.jeuVideoId )
        assertEquals( idUtilisateur, cobaye.utilisateurId )
        assertEquals( dateHeure, cobaye.dateHeure )
        assertEquals( contenue, cobaye.contenue )
    }

    @Test
    fun `étant donné un utilisateur, lorsque je fais une modification dans mon commentaire, j'obtien le resulta id = 2 idJeu = 2 idUtilisateur = 2, date = 0001-01-01, heure = 02 02 et contenue = "Bye"`(){

        //Mise en place
        var cobaye = Commentaire("1","1","1", LocalDateTime.now(),"Allo", null)


        //Exécution
        cobaye.id = "2"
        cobaye.jeuVideoId = "2"
        cobaye.utilisateurId = "2"
        cobaye.dateHeure = LocalDateTime.of(1,1,1,2,2)
        cobaye.contenue = "Bye"

        //Vérification
        assertEquals( "2", cobaye.id )
        assertEquals( "2", cobaye.jeuVideoId )
        assertEquals( "2", cobaye.utilisateurId )
        assertEquals( LocalDateTime.of(1,1,1,2,2), cobaye.dateHeure )
        assertEquals( "Bye", cobaye.contenue )
    }

    @Test
    fun `étant donné un utilisateur, lorsque je veux afficher mon commentaire, j'obtien le resulta Commentaire(id='1', idJeu='1', idUtilisateur='1', date='2021-11-05', heure='01 01', contenue='Allo'"`(){

        //Mise en place
        var cobaye = Commentaire("1","1","1", LocalDateTime.of(2021,11,5,1,1,1), "Allo", null)
        var resultatAttandu = "Commentaire(id='1', jeuVideoId='1', utilisateurId='1', dateHeure=2021-11-05T01:01:01, contenue='Allo', utilisateur=null)"


        //Exécution
        var resultatObservé = cobaye.toString()

        //Vérification
        assertEquals( resultatAttandu, resultatObservé )
    }

}