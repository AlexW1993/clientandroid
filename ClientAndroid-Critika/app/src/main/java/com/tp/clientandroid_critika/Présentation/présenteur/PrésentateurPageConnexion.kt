package com.tp.clientandroid_critika.Présentation.présenteur

import android.os.Handler
import android.os.Looper
import android.os.Message
import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVuePageConnexion
import com.tp.clientandroid_critika.Présentation.modèle.Modèle
import com.tp.clientandroid_critika.Présentation.vue.VuePageConnexion

class PrésentateurPageConnexion(var _vue: VuePageConnexion) :
    IContratPrésentateurVuePageConnexion.IPrésentateurPageConnexion {

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
                    _vue?.afficherPageMenuPrincipal()
                } else if (msg.what == _messageErreur) {
                    _vue?.afficherMessage("Surnom et/ou mot de passe incorrectes")
                }
            }
        }
    }

    /**
     * La méthode vérifier si l'utitilisateur qui essaie de se connecter, existe. S'il y a une
     * erreur, une message sera envoyer
     *
     * @param ((surnom : String, motPasse : String), le surnom et le mot de passe de l'utilisateur
     */
    override fun verificationUtilisateur(surnom: String, motPasse: String) {
        if (surnom != "") {
            if (motPasse != "") {
                _filEsclave = Thread {
                    var msg: Message?
                    val confirmation = _modèle?.verifierUtilisateur(surnom, motPasse)
                    if (confirmation == true) {
                        msg = _handlerRéponse.obtainMessage(_messageConfirmation)
                    } else {
                        msg = _handlerRéponse.obtainMessage(_messageErreur)
                    }
                    _handlerRéponse.sendMessage(msg!!)
                }
                _filEsclave!!.start()
            } else {
                _vue?.afficherMessage("S'il vous plait, rempliez la boite de mot des passe")
            }
        } else {
            _vue?.afficherMessage("S'il vous plait, ajoutez un surnom dans la boite de texte")
        }
    }
}