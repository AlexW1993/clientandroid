package com.tp.clientandroid_critika.Présentation.présenteur


import android.os.Handler
import android.os.Looper
import android.os.Message
import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVueMenuPrincipale
import com.tp.clientandroid_critika.Présentation.modèle.Modèle

class PrésentateurMenuPrincipale (vue : IContratPrésentateurVueMenuPrincipale.IVueMenuPrincipale) : IContratPrésentateurVueMenuPrincipale.IPrésentateurMenuPrincipale{

    private var _modèle : Modèle? = null
    private var _vue : IContratPrésentateurVueMenuPrincipale.IVueMenuPrincipale? = null
    private var _filEsclave : Thread? = null
    private var _handlerRéponse : Handler
    private var _confirmation = 0
    private var _erreur = 1

    init {
        _vue = vue
        _modèle = Modèle.getInstance()
        _handlerRéponse = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                _filEsclave = null
                if (msg.what == _confirmation) {
                    _vue?.afficherJeuxVideo(_modèle!!.chercherContext(), _modèle!!.getListeTop10())
                } else if (msg.what == _erreur){
                    _vue?.afficherMessage("La liste des jeux n'est pas disponible")
                }
            }
        }
    }

    override fun chercherJeuxVideo() {
        _filEsclave = Thread{
            var msg : Message?
            var confirmation = _modèle?.chercherJeux()
            if(confirmation == true){
                msg = _handlerRéponse.obtainMessage(_confirmation)
            } else {
                msg = _handlerRéponse.obtainMessage(_erreur)
            }
            _handlerRéponse.sendMessage(msg!!)
        }
        _filEsclave!!.start()
    }
}