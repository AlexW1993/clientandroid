package com.tp.clientandroid_critika.Domaine.entité

class Evaluation (var id : String, var jeuVideoId : String, var idUtilisateur : String, var note : Int) {

    override fun toString(): String {
        return "Evaluation(id='$id', idJeu='$jeuVideoId', idUtilisateur='$idUtilisateur', note=$note)"
    }
}