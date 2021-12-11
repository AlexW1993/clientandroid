package com.tp.clientandroid_critika.Présentation.présenteur

import android.os.Looper.getMainLooper
import com.tp.clientandroid_critika.Présentation.vue.VueMenuPrincipale
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest= Config.NONE)
class PrésentateurMenuPrincipalTest {

    @Test
    fun `étant donné un utilisateur, lorsque je me rend sur le menu principale et que la liste de jeu video est video, j'obtien un message d'avertissement`() {
        val mockView = mock(VueMenuPrincipale::class.java)
        val presentateur = PrésentateurMenuPrincipale(mockView)
        presentateur.chercherJeuxVideo()
        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()
        verify(mockView).afficherMessage("La liste des jeux n'est pas disponible")
    }

}