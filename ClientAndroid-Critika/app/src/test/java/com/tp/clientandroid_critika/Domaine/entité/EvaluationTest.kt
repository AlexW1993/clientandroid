package com.tp.clientandroid_critika.Domaine.entité
import org.junit.Assert.*
import org.junit.Test

class EvaluationTest {

    @Test
    fun `étant donné un utilisateur, lorsque je fais une évaluation en utilisant le constructeur, j'obtien le resulta id = 1234 idJeu = 4321 idUtilisateur = 1111 et note = 5`(){

        //Mise en place
        var id = "1234"
        var idJeu = "4321"
        var idUtilisateur = "1111"
        var note = 5


        //Exécution
        var cobaye = Evaluation("1234","4321","1111",5)

        //Vérification
        assertEquals( id, cobaye.id )
        assertEquals( idJeu, cobaye.jeuVideoId )
        assertEquals( idUtilisateur, cobaye.idUtilisateur )
        assertEquals( note, cobaye.note )
    }

    @Test
    fun `étant donné un utilisateur, lorsque je fais une modification dans mon évalaution, j'obtien le resulta id = 321 idJeu = 1234 idUtilisateur = 2222 et note = 1`(){

        //Mise en place
        var cobaye = Evaluation("1234","4321","1111",5)


        //Exécution
        cobaye.id = "4321"
        cobaye.jeuVideoId = "1234"
        cobaye.idUtilisateur = "2222"
        cobaye.note = 1

        //Vérification
        assertEquals( "4321", cobaye.id )
        assertEquals( "1234", cobaye.jeuVideoId )
        assertEquals( "2222", cobaye.idUtilisateur )
        assertEquals( 1, cobaye.note )
    }

    @Test
    fun `étant donné un utilisateur, lorsque je veux afficher ma évalauiton, j'obtien le resulta "Evaluation(id='1', idJeu='1', idUtilisateur='1', note=1)"`(){

        //Mise en place
        var cobaye = Evaluation("1","1","1",1)
        var resultatAttandu = "Evaluation(id='1', idJeu='1', idUtilisateur='1', note=1)"


        //Exécution
        var resultatObservé = cobaye.toString()

        //Vérification
        assertEquals( resultatAttandu, resultatObservé )

    }

}