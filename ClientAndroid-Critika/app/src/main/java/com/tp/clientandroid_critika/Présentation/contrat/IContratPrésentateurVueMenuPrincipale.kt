package com.tp.clientandroid_critika.Présentation.contrat

import android.content.Context
import com.tp.clientandroid_critika.Domaine.entité.JeuVideo

interface IContratPrésentateurVueMenuPrincipale {

    interface IPrésentateurMenuPrincipale{
        fun chercherJeuxVideo()
    }

    interface IVueMenuPrincipale{
        fun afficherJeuxVideo(ctx: Context?, liste: List<JeuVideo?>?)
        fun afficherMessage(message : String)
    }
}