package com.tp.clientandroid_critika.Présentation.présenteur

import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVueChangementSurnom
import com.tp.clientandroid_critika.Présentation.vue.VueChangementSurnom
import android.os.Handler
import android.os.Looper
import android.os.Message
import com.tp.clientandroid_critika.Présentation.modèle.Modèle

class PrésentateurChangementSurnom(var _vue: VueChangementSurnom) :
    IContratPrésentateurVueChangementSurnom.IContratPrésentateurChangementSurnom {
    private var _modèle: Modèle? = null
    private var _filEsclave: Thread? = null
    private var _handlerRéponse: Handler
    private var _messageConfirmation = 0
    private var _messageUtilisateruExistant = 1

    init{_modèle = Modèle.getInstance()
        _handlerRéponse = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                _filEsclave = null
                if (msg.what == _messageConfirmation) {
                    _vue?.afficherMenuCompte()
                } else if (msg.what == _messageUtilisateruExistant) {
                    _vue?.afficherMessage(
                        "Le surnom que vous avez choisi est dèja utiliser, S'il vous plait " +
                                "ecrivez vous une autre surnom"
                    )
                }
            }
        }
    }
    override fun sauvegarderNouveauSurnom(surnom: String) {
        if(surnom != ""){
            _filEsclave = Thread {

            }
            _filEsclave!!.start()
        }
    }

}
