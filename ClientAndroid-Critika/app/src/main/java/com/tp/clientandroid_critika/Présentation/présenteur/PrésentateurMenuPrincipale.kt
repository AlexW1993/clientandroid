package com.tp.clientandroid_critika.Présentation.présenteur


import android.os.Handler
import android.os.Looper
import android.os.Message
import com.tp.clientandroid_critika.Domaine.entité.JeuVideo
import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVueMenuPrincipale
import com.tp.clientandroid_critika.Présentation.modèle.Modèle

class PrésentateurMenuPrincipale (vue : IContratPrésentateurVueMenuPrincipale.IVueMenuPrincipale) : IContratPrésentateurVueMenuPrincipale.IPrésentateurMenuPrincipale{

    private var _modèle : Modèle? = null
    private var _vue : IContratPrésentateurVueMenuPrincipale.IVueMenuPrincipale? = null
    private var _filEsclave : Thread? = null
    private var _handlerRéponse : Handler
    private var _confirmation = 0

    init {
        _vue = vue
        _modèle = Modèle.getInstance()
        _handlerRéponse = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                _filEsclave = null
                if (msg.what == _confirmation) {
                    _vue?.afficherJeuxVideo()
                }
            }
        }

    }

    override fun chercherJeuxVideo() {
        _filEsclave = Thread{
            var liste = _modèle?.chercherMeilleurJeux()
            var msg : Message? = _handlerRéponse.obtainMessage(_confirmation)
            _handlerRéponse.sendMessage(msg!!)
        }
        _filEsclave!!.start()
    }

}