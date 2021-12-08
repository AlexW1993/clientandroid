package com.tp.clientandroid_critika.Présentation.présenteur

import android.os.Handler
import android.os.Looper
import android.os.Message
import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVueChangementCommentaire
import com.tp.clientandroid_critika.Présentation.modèle.Modèle
import com.tp.clientandroid_critika.Présentation.vue.VueChangementCommentaire

class PrésentateurChangementCommentaire(var _vue: VueChangementCommentaire) :
    IContratPrésentateurVueChangementCommentaire.IContratPrésentateurChangementCommentaire {

    private var _modèle: Modèle? = null
    private var _filEsclave: Thread? = null
    private var _handlerRéponse: Handler
    private var _messageConfirmation = 0
    private var _messageErreur = 1

    init {
        _modèle = Modèle.getInstance()
        _handlerRéponse = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                _filEsclave = null
                if (msg.what == _messageConfirmation) {
                    _vue?.afficherPageJeu()
                } else if (msg.what == _messageErreur) {
                    _vue?.afficherMessage(
                        "Il y a eu un problème pour faire les modofication à votre commentaire, " +
                                "esseyez plus tard"
                    )
                }
            }
        }
    }

    override fun modifierContenueCommentaire(contenue: String) {
        TODO("Not yet implemented")
    }
}