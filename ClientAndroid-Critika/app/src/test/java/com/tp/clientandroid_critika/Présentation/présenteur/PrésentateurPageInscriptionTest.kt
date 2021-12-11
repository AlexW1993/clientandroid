package com.tp.clientandroid_critika.Présentation.présenteur

import android.os.Looper.getMainLooper
import com.tp.clientandroid_critika.Présentation.vue.VuePageConnexion
import com.tp.clientandroid_critika.Présentation.vue.VuePageInscription
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf

@RunWith(RobolectricTestRunner::class)
class PrésentateurPageInscriptionTest {

    @Test
    fun `étant donné un utilisateur, lorsque je m'inscris et que je ne saisie pas mon surnom', j'obtien un message d'erreur`() {
        val mockView = mock(VuePageInscription::class.java)
        val presentateur = PrésentateurPageInscription(mockView)
        presentateur.verificationInscription("mdp","mdp","")
        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()
        verify(mockView).afficherMessage("S'il vous plait, ajoutez un surnom dans la boite de texte")
    }

    @Test
    fun `étant donné un utilisateur, lorsque je m'inscrit et que je ne saisie pas un mot de passe', j'obtien un message d'erreur`() {
        val mockView = mock(VuePageInscription::class.java)
        val presentateur = PrésentateurPageInscription(mockView)
        presentateur.verificationInscription("","mdp","surnom")
        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()
        verify(mockView).afficherMessage("S'il vous plait, rempliez les deux boites des mot des passes")
    }

    @Test
    fun `étant donné un utilisateur, lorsque je m'inscrit et que je ne saisie pas les mêmes mots de passe', j'obtien un message d'erreur`() {
        val mockView = mock(VuePageInscription::class.java)
        val presentateur = PrésentateurPageInscription(mockView)
        presentateur.verificationInscription("mdp","mdd","surnom")
        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()
        verify(mockView).afficherMessage("Les mots de passés ne sont pas identiques")
    }

    @Test
    fun `étant donné un utilisateur, lorsque je m'inscrit et que je saisie un surnom déja utilisé, j'obtien un message d'erreur`() {
        val mockView = mock(VuePageInscription::class.java)
        val presentateur = PrésentateurPageInscription(mockView)
        presentateur.verificationInscription("mdp","mdp","root")
        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()
        verify(mockView).afficherMessage("Le surnom que vous avez choisi est dèja utiliser, S'il vous plait ecrivez vous une autre surnom")
    }

    //@Test
    //fun `étant donné un utilisateur, lorsque je m'inscrit et que je saisie tput correctement, je me retrouve sur la page de connexion`() {
        //val mockView = mock(VuePageInscription::class.java)
        //val presentateur = PrésentateurPageInscription(mockView)
        //presentateur.verificationInscription("mdp","mdp","test")
        //Thread.sleep(100)
        //shadowOf(getMainLooper()).idle()
        //verify(mockView)?.afficherPageConnexion()
    //}
}