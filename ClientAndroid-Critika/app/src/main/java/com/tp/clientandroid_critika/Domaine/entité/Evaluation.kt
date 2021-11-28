package com.tp.clientandroid_critika.Domaine.entité

/**
 * Classe Évaluation
 *
 * Représente une évaluation pour un jeu vidéo
 */
class Evaluation(
    var id : String = "",
    var jeuVideoId : String = "",
    var idUtilisateur : String = "",
    var note : Int = 0){

    override fun toString(): String {
        return "Evaluation(id='$id', idJeu='$jeuVideoId', idUtilisateur='$idUtilisateur', note=$note)"
    }
}