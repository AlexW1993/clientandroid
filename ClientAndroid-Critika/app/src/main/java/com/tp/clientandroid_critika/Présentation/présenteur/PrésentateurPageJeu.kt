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
    private var _messageErreur = 1

    init {
        _modèle = Modèle.getInstance()
        _handlerRéponse = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                _filEsclave = null
                if (msg.what == _messageConfirmation) {
                    _vue?.afficherPageJeu()
                } else if (msg.what == _messageErreur) {
                    _vue?.afficherMessage("Il y a une problème pour réaliser l'operation")
                }
            }
        }
    }

    /**
     * La méthode cherche les informations du jeu selectionné
     */
    override fun chercherInformationJeuSelectionné() {
        if (_modèle?.jeuSelectionné?.listeCommentaires?.size != 0) {
            _modèle?.jeuSelectionné?.listeCommentaires?.sortBy { it.dateHeure }
            var listeCommentaire: MutableList<Commentaire>? = arrayListOf()
            listeCommentaire =
                _modèle?.jeuSelectionné?.listeCommentaires?.reversed() as MutableList<Commentaire>?
            _modèle?.jeuSelectionné?.listeCommentaires = listeCommentaire
        }
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
                    msg = _handlerRéponse.obtainMessage(_messageErreur)
                }
                _handlerRéponse.sendMessage(msg!!)
            }
            _filEsclave!!.start()
        } else {
            _vue?.afficherMessage("S'il vous plait, si vous voulez ajouter une commentaire, remplissez la boite de commentaire")
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
                    msg = _handlerRéponse.obtainMessage(_messageErreur)
                }
                _handlerRéponse.sendMessage(msg!!)
            } else {
                var msg: Message?
                var confirmation = _modèle?.modifierEvaluation(note)
                if (confirmation == true) {
                    msg = _handlerRéponse.obtainMessage(_messageConfirmation)
                } else {
                    msg = _handlerRéponse.obtainMessage(_messageErreur)
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

    /**
     * La méthode permet effacer un commentaire de l'utilisateur.
     *
     * @param (id: String), l'id du commentaire
     */
    override fun effacerCommentaire(id: String) {
        _filEsclave = Thread {
            var msg: Message?
            var confirmation = _modèle?.effacerCommentaire(id)
            if (confirmation == true) {
                msg = _handlerRéponse.obtainMessage(_messageConfirmation)
            } else {
                msg = _handlerRéponse.obtainMessage(_messageErreur)
            }
            _handlerRéponse.sendMessage(msg!!)
        }
        _filEsclave!!.start()
    }

    /**
     * La méthode permet effacer l'evaluation de l'utilisateur sur un jeu.
     *
     * @param (id: String), l'id de l'evaluation
     */
    override fun effacerEvaluation() {
        _filEsclave = Thread {
            var msg: Message?
            var confirmation = _modèle?.effacerEvaluation()
            if (confirmation == true) {
                msg = _handlerRéponse.obtainMessage(_messageConfirmation)
            } else {
                msg = _handlerRéponse.obtainMessage(_messageErreur)
            }
            _handlerRéponse.sendMessage(msg!!)
        }
        _filEsclave!!.start()
    }
}