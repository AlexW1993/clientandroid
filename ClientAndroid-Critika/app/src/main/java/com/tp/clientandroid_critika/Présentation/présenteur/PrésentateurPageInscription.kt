package com.tp.clientandroid_critika.Présentation.présenteur

import android.os.Handler
import android.os.Looper
import android.os.Message
import com.tp.clientandroid_critika.Domaine.entité.Utilisateur
import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVuePageInscription
import com.tp.clientandroid_critika.Présentation.modèle.Modèle

class PrésentateurPageInscription (vue : IContratPrésentateurVuePageInscription.IVuePageInscription) : IContratPrésentateurVuePageInscription.IPrésentateurPageInscription {
    private var _modèle : Modèle? = null
    private var _vue : IContratPrésentateurVuePageInscription.IVuePageInscription? = null
    private var _filEsclave : Thread? = null
    private var _handlerRéponse : Handler
    private var _confirmation = 0
    private var _utilisateruExistant = 1
    init {
        _vue = vue
        _modèle = Modèle.getInstance()
        _vue = vue
        _handlerRéponse = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                _filEsclave = null
                if (msg.what == _confirmation) {
                    _vue?.confirmationInscription()
                } else if(msg.what == _utilisateruExistant){
                    _vue?.afficherMessage("Le surnom que vous avez choisi est dèja utiliser, S'il vous plait " +
                            "ecrivez vous une autre surnom")
                }
            }
        }
    }

    override fun verificationInscrption(motPasse1: String, motPasse2: String, surNom: String) {
        if( surNom != ""){
            if(motPasse1 != "" && motPasse2 != "" ){
                if(motPasse1 == motPasse2){
                    _filEsclave = Thread {
                        var msg: Message?
                        var utilisateur = Utilisateur(null,surNom,motPasse1,null,null)
                        var confirmation  = _modèle?.creationUtilisateur(utilisateur)
                        msg = if(confirmation == true){
                            _handlerRéponse.obtainMessage(_confirmation)
                        } else {
                            _handlerRéponse.obtainMessage(_utilisateruExistant)
                        }
                        _handlerRéponse.sendMessage(msg!!)
                        }
                        _filEsclave!!.start()
                } else {
                    _vue?.afficherMessage("Les mots de passés ne sont pas identiques")
                }
            } else {
                _vue?.afficherMessage("S'il vous plait, rempliez les deux boites des mot des passes")
            }
        } else {
            _vue?.afficherMessage("S'il vous plait, ajoutez un surnom dans la boite de texte")
        }
    }
}