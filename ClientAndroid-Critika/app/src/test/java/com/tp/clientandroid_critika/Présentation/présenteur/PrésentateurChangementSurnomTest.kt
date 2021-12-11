package com.tp.clientandroid_critika.Présentation.présenteur

import android.os.Looper.getMainLooper
import com.tp.clientandroid_critika.Présentation.vue.VueChangementSurnom
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest= Config.NONE)
class PrésentateurChangementSurnomTest {

    @Test
    fun `étant donné un utilisateur, lorsque je veux modifier mon surnom et que je ne saisie rien, j'obtiens un message d'erreur'`() {
        val mockView = mock(VueChangementSurnom::class.java)
        val presentateur = PrésentateurChangementSurnom(mockView)
        presentateur.sauvegarderNouveauSurnom("")
        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()
        verify(mockView).afficherMessage("Vous devez remplir la boite pour modifier votre surnom")
    }

    @Test
    fun `étant donné un utilisateur, lorsque je veux modifier mon surnom et que je saisie un surnom déja utilisé, j'obtiens un message d'erreur'`() {
        val mockView = mock(VueChangementSurnom::class.java)
        val presentateur = PrésentateurChangementSurnom(mockView)
        presentateur.sauvegarderNouveauSurnom("root")
        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()
        verify(mockView).afficherMessage("Le surnom que vous avez choisi est dèja utiliser, S'il vous plait ecrivez vous une autre surnom")
    }
}