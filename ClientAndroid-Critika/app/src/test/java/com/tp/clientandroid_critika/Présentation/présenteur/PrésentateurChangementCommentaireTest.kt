package com.tp.clientandroid_critika.Présentation.présenteur

import android.os.Looper.getMainLooper
import com.tp.clientandroid_critika.Présentation.vue.VueChangementCommentaire
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest= Config.NONE)
class PrésentateurChangementCommentaireTest {

    @Test
    fun `étant donné un utilisateur, lorsque je veux modifier un de mes commentaire et que je ne saisie rien, j'obtiens un message d'erreur'`() {
        val mockView = mock(VueChangementCommentaire::class.java)
        val presentateur = PrésentateurChangementCommentaire(mockView)
        presentateur.modifierContenueCommentaire("")
        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()
        verify(mockView).afficherMessage("Le contenue ne doit pas être vide")
    }

    @Test
    fun `étant donné un utilisateur, lorsque je veux modifier un de mes commentaire et que laconnection ne se fait pas, j'obtiens un message d'erreur'`() {
        val mockView = mock(VueChangementCommentaire::class.java)
        val presentateur = PrésentateurChangementCommentaire(mockView)
        presentateur.modifierContenueCommentaire("blabla")
        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()
        verify(mockView).afficherMessage("Il y a eu un problème pour faire les modification à votre commentaire, essayez plus tard")
    }

}