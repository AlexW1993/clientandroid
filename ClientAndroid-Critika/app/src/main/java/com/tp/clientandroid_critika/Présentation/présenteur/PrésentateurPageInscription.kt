package com.tp.clientandroid_critika.Présentation.présenteur

import android.os.Handler
import android.os.Looper
import android.os.Message
import com.tp.clientandroid_critika.Domaine.entité.Utilisateur
import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVuePageInscription
import com.tp.clientandroid_critika.Présentation.modèle.Modèle
import com.tp.clientandroid_critika.Présentation.vue.VuePageInscription

class PrésentateurPageInscription(var _vue: VuePageInscription) :
    IContratPrésentateurVuePageInscription.IPrésentateurPageInscription {
    private var _modèle: Modèle? = null
    private var _filEsclave: Thread? = null
    private var _handlerRéponse: Handler
    private var _messageConfirmation = 0
    private var _messageUtilisateruExistant = 1

    init {
        _modèle = Modèle.getInstance()
        _handlerRéponse = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                _filEsclave = null
                if (msg.what == _messageConfirmation) {
                    _vue?.afficherPageConnexion()
                } else if (msg.what == _messageUtilisateruExistant) {
                    _vue?.afficherMessage(
                        "Le surnom que vous avez choisi est dèja utiliser, S'il vous plait " +
                                "ecrivez vous une autre surnom"
                    )
                }
            }
        }
    }

    /**
     * La méthode vérifie si l'utitilisateur a rempli correctement les champs pour son inscription et l'envoye.
     * S'il y a un problème, il va envoyer un message à la vue
     *
     * @param (motPasse1: String, motPasse2: String, surNom: String), deux fois le mot de passe pour
     * verifier qui sont pareil et son surnom
     */
    override fun verificationInscription(motPasse1: String, motPasse2: String, surNom: String) {
        if (surNom != "") {
            if (motPasse1 != "" && motPasse2 != "") {
                if (motPasse1 == motPasse2) {
                    _filEsclave = Thread {
                        var msg: Message?
                        var utilisateur = Utilisateur(nom = surNom, motPasse = motPasse1)
                        var confirmation = _modèle?.creationUtilisateur(utilisateur)
                        msg = if (confirmation == true) {
                            _handlerRéponse.obtainMessage(_messageConfirmation)
                        } else {
                            _handlerRéponse.obtainMessage(_messageUtilisateruExistant)
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