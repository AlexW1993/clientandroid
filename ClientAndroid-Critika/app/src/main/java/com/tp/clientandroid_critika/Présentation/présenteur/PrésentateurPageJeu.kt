package com.tp.clientandroid_critika.Présentation.présenteur

import android.os.Build
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.annotation.RequiresApi
import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVuePageJeu
import com.tp.clientandroid_critika.Présentation.modèle.Modèle
import com.tp.clientandroid_critika.Présentation.vue.VuePageJeu

class PrésentateurPageJeu(var _vue : VuePageJeu) : IContratPrésentateurVuePageJeu.IPrésentateurPageJeu{

    private var _modèle : Modèle? = null
    private var _filEsclave : Thread? = null
    private var _handlerRéponse : Handler
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
                } else if (msg.what == _messageErreur){
                    _vue?.afficherMessage("Il y a une problème pour ajouter votre commentaire")
                }
            }
        }
    }

    override fun chercherInformationJeuSelectionné() {
        _vue?.affichageInformationJeuSelecionné(_modèle?.jeuSelectionné)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun ajouterCommenataire(contenueCommentaire: String) {
        if(contenueCommentaire != ""){
            _filEsclave = Thread {
                var msg : Message?
                var confirmation = _modèle?.ajouterCommentaire(contenueCommentaire)
                if(confirmation == true){
                    msg = _handlerRéponse.obtainMessage(_messageConfirmation)
                } else {
                    msg = _handlerRéponse.obtainMessage(_messageErreur)
                }
                _handlerRéponse.sendMessage(msg!!)
            }
            _filEsclave!!.start()
        } else {
            _vue?.afficherMessage("S'il vous plait, si vous voulez ajouter une commentaire, rempliez la boite de commentaire")
        }
    }
}
