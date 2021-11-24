package com.tp.clientandroid_critika.Domaine.interacteurs

import com.tp.clientandroid_critika.Domaine.entité.JeuVideo
import com.tp.clientandroid_critika.Domaine.entité.Utilisateur
import com.tp.clientandroid_critika.Domaine.interacteur.InteracteurRécupererJeuDétails
import com.tp.clientandroid_critika.Domaine.interacteur.SourceDeDonnées
import org.junit.Assert
import org.junit.Test
import java.lang.Exception

class TestRécuperationJeuDétails {
    @Test
    fun `étant donné un id d'un jeu vidéo, lorsque je cherche un jeu par id, jobtiens objet JeuVideo qui corresponde a ce id`(){
        val source: SourceDeDonnées = object : SourceDeDonnées{
            override fun chercherUtilisateur(u: Utilisateur): Utilisateur? {
                TODO("Not yet implemented")
            }

            override fun ajouterUtilisateur(utilisateur: Utilisateur): Boolean? {
                TODO("Not yet implemented")
            }

            override fun récupererJeuDétails(id: String): JeuVideo? {
                val jeu =  JeuVideo()
                jeu.id = "3"

                return jeu
            }
        }

        val interacteur = InteracteurRécupererJeuDétails(source)
        try {
            val jeuVideo = interacteur.obtenirDetailsJeuVideo("1")
            Assert.assertNotNull(jeuVideo)
            Assert.assertEquals("1",jeuVideo!!.id)
        } catch (e: Exception) {
            Assert.fail(e.message)
        }

    }
}