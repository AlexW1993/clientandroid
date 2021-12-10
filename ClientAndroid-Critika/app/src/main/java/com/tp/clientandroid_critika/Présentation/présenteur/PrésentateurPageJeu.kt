package com.tp.clientandroid_critika.Présentation.présenteur

import android.os.Build
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.annotation.RequiresApi
import com.tp.clientandroid_critika.Domaine.entité.Commentaire
import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVuePageJeu
import com.tp.clientandroid_critika.Présentation.modèle.Modèle
import com.tp.clientandroid_critika.Présentation.vue.VuePageJeu

class PrésentateurPageJeu(var _vue: VuePageJeu) :
    IContratPrésentateurVuePageJeu.IPrésentateurPageJeu {

    private var _modèle: Modèle? = null
    private var _filEsclave: Thread? = null
    private var _handlerRéponse: Handler
    private var _messageConfirmation = 0
    private var _messageErreurCommentaire = 1
    private var _messageErreurEvaluation = 2

    init {
        _modèle = Modèle.getInstance()
        _handlerRéponse = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                _filEsclave = null
                if (msg.what == _messageConfirmation) {
                    _vue?.afficherPageJeu()
                } else if (msg.what == _messageErreurCommentaire) {
                    _vue?.afficherMessage("Il y a une problème pour votre commentaire")
                } else if (msg.what == _messageErreurEvaluation) {
                    _vue?.afficherMessage("Il y a une problème pour votre evaluation")
                }
            }
        }
    }

    /**
     * La méthode cherche les informations du jeu selectionné
     */
    override fun chercherInformationJeuSelectionné() {
        _modèle?.utilisateur?.id?.let {
            _vue?.affichageInformationJeuSelecionné(
                _modèle?.jeuSelectionné,
                it
            )
        }
    }

    /**
     * La méthode permet ajouter le commentaire que l'utilisateur vient de créer. si le contenue
     * est vide, il va envoyer une message
     *
     * @param (contenueCommentaire: String), le contenue du commentaire
     */
    @RequiresApi(Build.VERSION_CODES.O)
    override fun ajouterCommenataire(contenueCommentaire: String) {
        if (contenueCommentaire != "") {
            _filEsclave = Thread {
                var msg: Message?
                var confirmation = _modèle?.ajouterCommentaire(contenueCommentaire)
                if (confirmation == true) {
                    msg = _handlerRéponse.obtainMessage(_messageConfirmation)
                } else {
                    msg = _handlerRéponse.obtainMessage(_messageErreurCommentaire)
                }
                _handlerRéponse.sendMessage(msg!!)
            }
            _filEsclave!!.start()
        } else {
            _vue?.afficherMessage("S'il vous plait, si vous voulez ajouter une commentaire, rempliez la boite de commentaire")
        }
    }

    /**
     * La méthode permet ajouter une note que l'utilisateur vient de créer. si le jeu a une note que
     * l'utilisateur a fait, la note va être modifier
     *
     * @param (note: Int), la note que l'utilisateur a fait
     */
    override fun ajouterEvaluation(note: Int) {
        _filEsclave = Thread {
            var confirmation = _modèle?.chercherEvaluationUtilisateur()
            if (confirmation == false) {
                var msg: Message?
                var confirmation = _modèle?.ajouterEvaluation(note)
                if (confirmation == true) {
                    msg = _handlerRéponse.obtainMessage(_messageConfirmation)
                } else {
                    msg = _handlerRéponse.obtainMessage(_messageErreurEvaluation)
                }
                _handlerRéponse.sendMessage(msg!!)
            } else {
                var msg: Message?
                var confirmation = _modèle?.modifierEvaluation(note)
                if (confirmation == true) {
                    msg = _handlerRéponse.obtainMessage(_messageConfirmation)
                } else {
                    msg = _handlerRéponse.obtainMessage(_messageErreurEvaluation)
                }
                _handlerRéponse.sendMessage(msg!!)
            }
        }
        _filEsclave!!.start()
    }

    /**
     * La méthode permet d'ajouter un commentaire dans le modèle
     *
     * @param (commentaire: Commentaire), le commentaire selectionné par l'utilisateur
     */
    override fun commentaireSelectionné(commentaire: Commentaire) {
        _modèle?.commentaireSelectionné = null
        _modèle?.commentaireSelectionné = commentaire
    }
}