package com.tp.clientandroid_critika.Présentation.présenteur

import android.os.Looper.getMainLooper
import com.tp.clientandroid_critika.Présentation.vue.VueMenuCompte
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest= Config.NONE)
class PrésentateurMenuCompteTest {

    @Test
    fun `étant donné un utilisateur, lorsque je me rend sur le menu compte et qu'il n'y aucun utilisateur de connecté', je n'obtien aucune information sur l'utilisateur`() {
        val mockView = mock(VueMenuCompte::class.java)
        val presentateur = PrésentateurMenuCompte(mockView)
        presentateur.chercherInformationCompte()
        Thread.sleep(100)
        shadowOf(getMainLooper()).idle()
        verify(mockView).afficherInformationCompte(null)
    }

}