package com.tp.clientandroid_critika.Présentation.présenteur

import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVuePageConnexion
import com.tp.clientandroid_critika.Présentation.modèle.Modèle

class PrésentateurPageConnexion(vue : IContratPrésentateurVuePageConnexion.IVuePageConnexion) : IContratPrésentateurVuePageConnexion.IPrésentateurPageConnexion {

    private var _modèle : Modèle? = null
    private var _vue : IContratPrésentateurVuePageConnexion.IVuePageConnexion? = null
    private var filEsclave : Thread? = null
    init {
        _vue = vue
        _modèle = Modèle.getInstance()
        _vue = vue
    }

    override fun verificationUtilisateur(surnom : String, motPasse : String) {
        var confirmation : Boolean? = null
        if(surnom != ""){
            if(motPasse != ""){
                filEsclave = Thread {
                    confirmation = _modèle?.verifierUtilisateur(surnom, motPasse)
                }
                filEsclave!!.start()
                when (confirmation) {
                    true -> {
                        _vue?.confirmationUtilisateur()
                    }
                    null -> {
                        _vue?.afficherMessage("Votre information est invalide")
                    }
                }
            } else {
                _vue?.afficherMessage("S'il vous plait, rempliez la boite des mot des passe")
            }
        } else {
            _vue?.afficherMessage("S'il vous plait, ajoutez un surnom dans la boite de texte")
        }
    }
}