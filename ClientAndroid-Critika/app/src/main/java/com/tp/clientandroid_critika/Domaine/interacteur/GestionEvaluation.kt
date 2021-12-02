package com.tp.clientandroid_critika.Domaine.interacteur

import com.tp.clientandroid_critika.Domaine.entité.Evaluation

class GestionEvaluation(var _source: SourceDeDonnées?) {

    /**
     * La méthode permet de ajouter un note d'un utilisateur à un jeu
     *
     * @param (evaluation: Evaluation), L'évalaution a ajouté
     *
     * @return (Boolean?) true por confirmer que l'évalaution a été ajouté correctement, false si il y a eu un erreur
     */
    fun ajouterEvaluation(evaluation: Evaluation): Boolean? {
        return _source?.ajouterEvaluation(evaluation)
    }

    /**
     * La méthode permet de modifier un note que l'utilisateur a fait à un jeu
     *
     * @param (evaluation: Evaluation), L'évalaution a modifié
     *
     * @return (Boolean?) true por confirmer que l'évalaution a été modifié correctement, false si il y a eu un erreur
     */
    fun modifierEvaluation(evaluation: Evaluation): Boolean? {
        return _source?.modifierEvaluation(evaluation)
    }

}
