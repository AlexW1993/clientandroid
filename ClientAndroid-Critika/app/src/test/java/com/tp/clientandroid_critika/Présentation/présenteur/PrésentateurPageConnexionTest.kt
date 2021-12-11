package com.tp.clientandroid_critika.Présentation.présenteur

import android.os.Looper.getMainLooper
import com.tp.clientandroid_critika.Présentation.vue.VuePageConnexion
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest= Config.NONE)
class PrésentateurPageConnexionTest {

    @Test
    fun `étant donné un utilisateur, lorsque je ne saisie pas mon surnom', j'obtien un message d'erreur`() {
        val mockView = mock(VuePageConnexion::class.java)
        val presentateur = PrésentateurPageConnexion(mockView)
        presentateur.verificationUtilisateur("","mdp")
        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()
        verify(mockView).afficherMessage("S'il vous plait, ajoutez un surnom dans la boite de texte")
    }

    @Test
    fun `étant donné un utilisateur, lorsque je ne saisie pas mon mot de passe', j'obtien un message d'erreur`() {
        val mockView = mock(VuePageConnexion::class.java)
        val presentateur = PrésentateurPageConnexion(mockView)
        presentateur.verificationUtilisateur("surnom","")
        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()
        verify(mockView).afficherMessage("S'il vous plait, rempliez la boite de mot des passe")
    }

    @Test
    fun `étant donné un utilisateur, lorsque je saisie le mauvais surnom', j'obtien un message d'erreur`() {
        val mockView = mock(VuePageConnexion::class.java)
        val presentateur = PrésentateurPageConnexion(mockView)
        presentateur.verificationUtilisateur("riit","root")
        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()
        verify(mockView).afficherMessage("Surnom et/ou mot de passe incorrectes")
    }

    @Test
    fun `étant donné un utilisateur, lorsque je saisie le mauvais mot de passe', j'obtien un message d'erreur`() {
        val mockView = mock(VuePageConnexion::class.java)
        val presentateur = PrésentateurPageConnexion(mockView)
        presentateur.verificationUtilisateur("root","riit")
        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()
        verify(mockView).afficherMessage("Surnom et/ou mot de passe incorrectes")
    }

}