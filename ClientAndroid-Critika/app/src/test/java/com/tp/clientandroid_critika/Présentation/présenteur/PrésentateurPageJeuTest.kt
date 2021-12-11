package com.tp.clientandroid_critika.Présentation.présenteur

import android.os.Looper.getMainLooper
import com.tp.clientandroid_critika.Présentation.vue.VuePageJeu
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest= Config.NONE)
class PrésentateurPageJeuTest {

    @Test
    fun `étant donné un utilisateur, lorsque je ne saisie rien dans le champs des commentaire et que j'appuie sur envoyer, j'obtien un message d'erreur`() {
        val mockView = mock(VuePageJeu::class.java)
        val presentateur = PrésentateurPageJeu(mockView)
        presentateur.ajouterCommenataire("")
        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()
        verify(mockView).afficherMessage("S'il vous plait, si vous voulez ajouter une commentaire, rempliez la boite de commentaire")
    }
}