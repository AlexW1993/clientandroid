package com.tp.clientandroid_critika.Présentation.présenteur

import android.os.Looper.getMainLooper
import com.tp.clientandroid_critika.Présentation.vue.VueChangementCommentaire
import com.tp.clientandroid_critika.Présentation.vue.VueChangementMotPasse
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest= Config.NONE)
class PrésentateurChangementMotPasseTest {

    @Test
    fun `étant donné un utilisateur, lorsque je veux modifier mon mot de passe et que je ne saisie rien, j'obtiens un message d'erreur'`() {
        val mockView = mock(VueChangementMotPasse::class.java)
        val presentateur = PrésentateurChangementMotPasse(mockView)
        presentateur.sauvegarderNouveauMotPasse("","")
        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()
        verify(mockView).afficherMessage("S'il vous plait, remplissez les deux boites des mot des passes")
    }

    @Test
    fun `étant donné un utilisateur, lorsque je veux modifier mon mot de passe et que je n'es rien écrit dans la 1ere boite, j'obtiens un message d'erreur'`() {
        val mockView = mock(VueChangementMotPasse::class.java)
        val presentateur = PrésentateurChangementMotPasse(mockView)
        presentateur.sauvegarderNouveauMotPasse("","mdp")
        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()
        verify(mockView).afficherMessage("S'il vous plait, remplissez les deux boites des mot des passes")
    }

    @Test
    fun `étant donné un utilisateur, lorsque je veux modifier mon mot de passe et que je n'es rien écrit dans la 2eme boite', j'obtiens un message d'erreur'`() {
        val mockView = mock(VueChangementMotPasse::class.java)
        val presentateur = PrésentateurChangementMotPasse(mockView)
        presentateur.sauvegarderNouveauMotPasse("mdp","")
        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()
        verify(mockView).afficherMessage("S'il vous plait, remplissez les deux boites des mot des passes")
    }

    @Test
    fun `étant donné un utilisateur, lorsque je veux modifier mon mot de passe et que je n'écris pas le même', j'obtiens un message d'erreur'`() {
        val mockView = mock(VueChangementMotPasse::class.java)
        val presentateur = PrésentateurChangementMotPasse(mockView)
        presentateur.sauvegarderNouveauMotPasse("mdp","mdd")
        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()
        verify(mockView).afficherMessage("Les mots passés ne sont pas identiques")
    }

}