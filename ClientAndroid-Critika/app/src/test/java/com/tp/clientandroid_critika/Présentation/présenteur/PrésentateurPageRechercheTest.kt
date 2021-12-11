package com.tp.clientandroid_critika.Présentation.présenteur

import android.os.Looper.getMainLooper
import com.tp.clientandroid_critika.Présentation.vue.VuePageRecherche
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest= Config.NONE)
class PrésentateurPageRechercheTest {

    @Test
    fun `étant donné un utilisateur, lorsque je recherche tout les jeux se jouant sur une console précise mais qu'il n'y pas de connection avec la source de données, j'obtiens un message d'erreur'`() {
        val mockView = mock(VuePageRecherche::class.java)
        val presentateur = PrésentateurPageRecherche(mockView)
        presentateur.chercherJeuxParConsole("Nintendo Swotch")
        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()
        verify(mockView).afficherMessage("Il y a un problème dans cette moment, essayez plus tard");
    }

    //@Test
    //fun `étant donné un utilisateur, lorsque je recherche tout les jeux se jouant sur la Nintendo Switch, je me retrouve sur la page des résultat de recherche`() {
        //val mockView = mock(VuePageRecherche::class.java)
        //val presentateur = PrésentateurPageRecherche(mockView)
        //presentateur.chercherJeuxParConsole("Nintendo Switch")
        //Thread.sleep(100)
        //shadowOf(getMainLooper()).idle()
        //verify(mockView).afficherPageResultatRecherche()
    //}

    @Test
    fun `étant donné un utilisateur, lorsque je recherche un jeu ayant le mot clé "apex" mais qu'il n'y pas de connection avec la source de données, j'obtiens un message d'erreur'`() {
        val mockView = mock(VuePageRecherche::class.java)
        val presentateur = PrésentateurPageRecherche(mockView)
        presentateur.chercherJeuxParMotCle("apex")
        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()
        verify(mockView).afficherMessage("Il y a un problème dans cette moment, essayez plus tard")
    }

}