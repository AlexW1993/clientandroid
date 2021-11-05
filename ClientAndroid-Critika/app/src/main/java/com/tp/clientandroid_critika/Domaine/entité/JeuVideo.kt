package com.tp.clientandroid_critika.Domaine.entité

class JeuVideo(var id : String, var nom : String, var description : String?, var plateforme : String?,
               var genre : String?, var modeJeu : String?, var anneSortie : Int?,
               var listeCommentaire : List<Commentaire>?, var listeEvaluation : List<Evaluation>?){

    fun calculerMoyenneEvaluation(): Double{
        var totalEvaluation = 0
        var resultat = 0.0
        for (liste in listeEvaluation!!){
            totalEvaluation += liste.note
        }
        resultat = (totalEvaluation / listeEvaluation!!.size).toDouble()
        return resultat
    }

    override fun toString(): String {
        return "JeuVideo(id='$id', nom='$nom', descfiption='$description', plateforme='$plateforme'," +
                " genre='$genre', modeJeu='$modeJeu', anneSortie=$anneSortie, listeCommentiare=$listeCommentaire, " +
                "listeEvaluation=$listeEvaluation)"
    }


}