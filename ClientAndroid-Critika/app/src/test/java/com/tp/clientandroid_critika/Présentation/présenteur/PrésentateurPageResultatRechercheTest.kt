package com.tp.clientandroid_critika.Présentation.présenteur
import android.os.Looper.getMainLooper
import com.tp.clientandroid_critika.Domaine.interacteur.SourceDeDonnées
import com.tp.clientandroid_critika.Présentation.vue.VueMenuCompte
import com.tp.clientandroid_critika.Présentation.vue.VuePageRecherche
import com.tp.clientandroid_critika.Présentation.vue.VuePageResultatRecherche
import com.tp.clientandroid_critika.SourceDeDonnées.SourceDeDonnéesAPI
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest= Config.NONE)
class PrésentateurPageResultatRechercheTest {

    @Test
    fun `étant donné un utilisateur, lorsque je recherche tout les jeux se jouant sur une console précise mais qu'il n'y pas de connection avec la source de données, j'obtiens un message d'erreur'`() {
        val mockView = mock(VuePageResultatRecherche::class.java)
        val presentateur = PrésentateurPageResultatRecherche(mockView)
        presentateur.chercherJeuxVideo()
        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()
        verify(mockView).afficherListeJeuxVideo(null)
    }
}