package com.tp.clientandroid_critika.Domaine.entité

class JeuVideo(
    var id : String = "",
    var nom : String = "",
    var description : String? = "",
    var plateforme : String? = "",
    var genre : String? = "",
    var modeJeu : String? = "",
    var anneSortie : Int? = 0,
    var listeCommentaires : MutableList<Commentaire>? = null,
    var listeEvaluations : MutableList<Evaluation>? = null){

    /**
     * Méthode calculer la moyenne
     *
     * Permet de calculer la note moyenne des évaluations pour un jeu
     */
    fun calculerMoyenneEvaluation(): Double{
        var totalEvaluation = 0
        var resultat = 0.0
        for (liste in listeEvaluations!!){
            totalEvaluation += liste.note
            println(totalEvaluation)
        }
        resultat = (totalEvaluation / listeEvaluations!!.size).toDouble()
        return resultat
    }

    override fun toString(): String {
        return "JeuVideo(id='$id', nom='$nom', description='$description', plateforme='$plateforme', genre='$genre', modeJeu='$modeJeu', anneSortie=$anneSortie, listeCommentaires=$listeCommentaires, listeEvaluations=$listeEvaluations)"
    }


}