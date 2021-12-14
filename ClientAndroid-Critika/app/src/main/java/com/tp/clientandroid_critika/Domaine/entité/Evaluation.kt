package com.tp.clientandroid_critika.Domaine.entité

/**
 * Classe Evaluation
 *
 * Représente une évaluation pour un jeu vidéo
 */
class Evaluation(
    var id: String = "",
    var jeuVideoId: String? = "",
    var idUtilisateur: String? = "",
    var note: Int = 0
) {

    /**
     * La méthode permet de retourner une chaîne de caractères avec tous les attributs de la classe
     * Evaluation
     *
     * @return (String) la chîne de caractères
     */
    override fun toString(): String {
        return "Evaluation(id='$id', idJeu='$jeuVideoId', idUtilisateur='$idUtilisateur', note=$note)"
    }
}