package com.tp.clientandroid_critika.Domaine.entité

class JeuVideo(var id : String, var nom : String, var description : String?, var plateforme : String?,
               var genre : String?, var modeJeu : String?, var anneSortie : Int?,
               var listeCommentaires : List<Commentaire>?, var listeEvaluations : List<Evaluation>?){

    fun calculerMoyenneEvaluation(): Double{
        var totalEvaluation = 0
        var resultat = 0.0
        for (liste in listeEvaluations!!){
            totalEvaluation += liste.note
        }
        resultat = (totalEvaluation / listeEvaluations!!.size).toDouble()
        return resultat
    }

    override fun toString(): String {
        return "JeuVideo(id='$id', nom='$nom', descfiption='$description', plateforme='$plateforme'," +
                " genre='$genre', modeJeu='$modeJeu', anneSortie=$anneSortie, listeCommentiare=$listeCommentaires, " +
                "listeEvaluation=$listeEvaluations)"
    }


}