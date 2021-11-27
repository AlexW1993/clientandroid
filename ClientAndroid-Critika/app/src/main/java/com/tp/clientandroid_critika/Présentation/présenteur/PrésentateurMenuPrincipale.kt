package com.tp.clientandroid_critika.Présentation.présenteur

import android.os.Handler
import android.os.Looper
import android.os.Message
import com.tp.clientandroid_critika.Domaine.entité.JeuVideo
import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVueMenuPrincipale
import com.tp.clientandroid_critika.Présentation.modèle.Modèle
import com.tp.clientandroid_critika.Présentation.vue.VueMenuPrincipale

class PrésentateurMenuPrincipale (var _vue : VueMenuPrincipale) : IContratPrésentateurVueMenuPrincipale.IPrésentateurMenuPrincipale{

    private var _modèle : Modèle? = null
    private var _filEsclave : Thread? = null
    private var _handlerRéponse : Handler
    private var _confirmation = 0
    private var _erreur = 1

    init {
        _modèle = Modèle.getInstance()
        _handlerRéponse = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                _filEsclave = null
                if (msg.what == _confirmation) {
                    _vue?.afficherJeuxVideo(_modèle?._listeJeux)
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

    override fun jeuSelectionné(jeuVideo: JeuVideo) {
        _modèle?.jeuSelectionné = null
        _modèle?.jeuSelectionné = jeuVideo
    }
}