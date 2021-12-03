package com.tp.clientandroid_critika.Domaine.entité

/**
 * Classe JeuVideo
 *
 * Représente une jeu vidéo dans l'application
 */
class JeuVideo(
    var id: String = "",
    var nom: String = "",
    var description: String? = "",
    var plateforme: String? = "",
    var genre: String? = "",
    var modeJeu: String? = "",
    var anneSortie: Int = 1999,
    var listeCommentaires: MutableList<Commentaire>? = null,
    var listeEvaluations: MutableList<Evaluation>? = null
) {

    /**
     * Méthode qui permet e calculer la note moyenne des évaluations pour un jeu
     *
     * @return (Double) la moyenne du jeu
     */
    fun calculerMoyenneEvaluation(): Double {
        var totalEvaluation = 0
        var resultat = 0.0
        if (listeEvaluations?.size != 0) {
            for (liste in listeEvaluations!!) {
                totalEvaluation += liste.note
                println(totalEvaluation)
            }
            resultat = (totalEvaluation / listeEvaluations!!.size).toDouble()
        } else {
            resultat = 0.0
        }
        return resultat
    }

    /**
     * La méthode permet de returner une chaîne de caractères avec tous les attribut de la classe
     * JeuVideo
     *
     * @return (String) la chîne de caractères
     */
    override fun toString(): String {
        return "JeuVideo(id='$id', nom='$nom', description='$description', plateforme='$plateforme', genre='$genre', modeJeu='$modeJeu', anneSortie=$anneSortie, listeCommentaires=$listeCommentaires, listeEvaluations=$listeEvaluations)"
    }


}