package com.tp.clientandroid_critika.Présentation.présenteur

import android.os.Handler
import android.os.Looper
import android.os.Message
import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVueChangementMotPasse
import com.tp.clientandroid_critika.Présentation.modèle.Modèle
import com.tp.clientandroid_critika.Présentation.vue.VueChangementMotPasse

class PrésentateurChangementMotPasse(var _vue: VueChangementMotPasse) :
    IContratPrésentateurVueChangementMotPasse.IContratPrésentateurChangementMotPasse {

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
                    _vue?.afficherMenuCompte()
                } else if (msg.what == _messageErreur) {
                    _vue?.afficherMessage(
                        "Il y a eu une problème pour realiser la modification"
                    )
                }
            }
        }
    }

    /**
     * La méthode permet le changement le mot de passe d'un utilisateur, il va verfier si les boites
     * sont vides ou si l'utilisateur utilise le même mot de passe dans les boites
     *
     * @param (motPasse1: String, motPasse2: String), deux mots de passes qui devent être identiques
     */
    override fun sauvegarderNouveauMotPasse(motPasse1: String, motPasse2: String) {
        if (motPasse1 != "" && motPasse2 != "") {
            if (motPasse1 != _modèle?.utilisateur?.motPasse) {
                if (motPasse2 != _modèle?.utilisateur?.motPasse) {
                    if (motPasse1 == motPasse2) {
                        _filEsclave = Thread {
                            var msg: Message?
                            val confirmation = _modèle?.modiferMotPasse(motPasse1)
                            if (confirmation == true) {
                                msg = _handlerRéponse.obtainMessage(_messageConfirmation)
                            } else {
                                msg = _handlerRéponse.obtainMessage(_messageErreur)
                            }
                            _handlerRéponse.sendMessage(msg!!)
                        }
                        _filEsclave!!.start()
                    } else {
                        _vue?.afficherMessage("Les mots passés ne sont pas identiques")
                    }
                } else {
                    _vue?.afficherMessage("Vous utilisez le même mot de passe dans la deuxième boite")
                }
            } else {
                _vue?.afficherMessage("Vous utilisez le même mot de passe dans la prèmière boite")
            }
        } else {
            _vue?.afficherMessage("S'il vous plait, remplissez les deux boites des mot des passes")
        }
    }
}
