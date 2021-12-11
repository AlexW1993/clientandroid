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

    /**
     * La méthode permet effacer l'evaluation que l'utilisateur a fait
     *
     * @param (id: String), l'id de l'evaluation'
     *
     * @return (Boolean) true si l'evaluation a été effacé correctement, false s'il y a eu un problème
     */
    fun effacerEvaluation(id: String): Boolean? {
        return _source?.effacerEvaluation(id)
    }
}
