package com.tp.clientandroid_critika.Présentation.présenteur

import com.tp.clientandroid_critika.Domaine.entité.Utilisateur
import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVuePageInscription
import com.tp.clientandroid_critika.Présentation.modèle.Modèle

class PrésentateurPageInscription (vue : IContratPrésentateurVuePageInscription.IVuePageInscription) : IContratPrésentateurVuePageInscription.IPrésentateurPageInscription {
    private var _modèle : Modèle? = null
    private var _vue : IContratPrésentateurVuePageInscription.IVuePageInscription? = null
    private var filEsclave : Thread? = null
    init {
        _vue = vue
        _modèle = Modèle.getInstance()
        _vue = vue
    }

    override fun verificationInscrption(motPasse1: String, motPasse2: String, surNom: String) {
        var confirmation : Boolean? = null
        if( surNom != ""){
            if(motPasse1 != "" && motPasse2 != "" ){
                if(motPasse1 == motPasse2){
                    //filEsclave = Thread {
                        var utilisateur = Utilisateur(null,surNom,motPasse1,null,null)
                        confirmation  = _modèle?.creationUtilisateur(utilisateur)
                        if(confirmation == true){
                            _vue?.confirmationInscription()
                        } else if (confirmation == false) {
                            _vue?.afficherMessage("Le surnom que vous avez choisi est dèja utiliser, S'il vous plait " +
                                    "ecrivez vous une autre surnom")
                        } else if (confirmation == null){
                            _vue?.afficherMessage("Désolé, nous avons des problèmes de connexion")
                        }
                    //}
                   // filEsclave!!.start()
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