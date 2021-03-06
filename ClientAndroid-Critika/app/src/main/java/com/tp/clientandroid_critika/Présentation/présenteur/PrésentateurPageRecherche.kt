package com.tp.clientandroid_critika.Présentation.présenteur

import android.os.Handler
import android.os.Looper
import android.os.Message
import com.tp.clientandroid_critika.Domaine.entité.Utilisateur
import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVuePageRecherche
import com.tp.clientandroid_critika.Présentation.modèle.Modèle
import com.tp.clientandroid_critika.Présentation.vue.VuePageRecherche

class PrésentateurPageRecherche(var _vue: VuePageRecherche) :
    IContratPrésentateurVuePageRecherche.IPrésentateurPageRecherche {

    private var _modèle: Modèle? = null
    private var _filEsclave: Thread? = null
    private var _handlerRéponse: Handler
    private var _messageConfirmation = 0
    private var _messageErreur = 1
    private var _messageIntrouvable = 2

    init {
        _modèle = Modèle.getInstance()
        _handlerRéponse = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                _filEsclave = null
                if (msg.what == _messageConfirmation) {
                    _vue.afficherPageResultatRecherche()
                } else if (msg.what == _messageErreur) {
                    _vue?.afficherMessage(
                        "Il y a un problème en ce moment, essayez plus tard"
                    )
                } else if (msg.what == _messageIntrouvable) {
                    _vue?.afficherMessage(
                        "Il n'existe aucun jeu avec le mot cle que vous avez utilisé"
                    )
                }
            }
        }
    }

    /**
     * La méthode permet de chercher les jeux videos pour l'envoyer à la vue ou une message pour
     * qu'il y a eu un problème pour afficher les jeux
     */
    override fun chercherJeuxParConsole(plateforme: String) {
        _filEsclave = Thread {
            var confirmation = _modèle?.chercherJeuxParConsole(plateforme)
            var msg: Message?
            msg = if (confirmation == true) {
                _handlerRéponse.obtainMessage(_messageConfirmation)
            } else {
                _handlerRéponse.obtainMessage(_messageErreur)
            }
            _handlerRéponse.sendMessage(msg!!)
        }
        _filEsclave!!.start()
    }

    /**
     * La méthode permet de chercher les jeux videos pour l'envoyer à la vue ou une message pour
     * dire que il n'y a pas des jeux avec le mot clé que l'utilisateur a écrit
     */
    override fun chercherJeuxParMotCle(motCle: String) {
        _filEsclave = Thread {
            var confirmation = _modèle?.chercherJeuxParMotCle(motCle)
            var msg: Message?
            msg = if (confirmation == true) {
                _handlerRéponse.obtainMessage(_messageConfirmation)
            } else if (confirmation == false) {
                _handlerRéponse.obtainMessage(_messageIntrouvable)
            } else {
                _handlerRéponse.obtainMessage(_messageErreur)
            }

            _handlerRéponse.sendMessage(msg!!)
        }
        _filEsclave!!.start()
    }

}