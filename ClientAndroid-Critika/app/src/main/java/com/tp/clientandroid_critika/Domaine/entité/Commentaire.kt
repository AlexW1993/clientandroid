package com.tp.clientandroid_critika.Domaine.entité

/**
 * Classe Commentaire
 *
 * Représente un commentaire pour un jeu vidéo laissé par un utilisateur
 */
class Commentaire(
    var id: String = "",
    var jeuVideoId: String = "",
    var utilisateurId: String = "",
    var dateHeure: String = "",
    var contenue: String = "",
    var utilisateur: Utilisateur? = null
) {

    /**
     * La méthode permet de retourner une chaîne de caractères avec tous les attributs de la classe
     * Commentaire
     *
     * @return (String) la chîne de caractères
     */
    override fun toString(): String {
        return "Commentaire(id='$id', jeuVideoId='$jeuVideoId', utilisateurId='$utilisateurId', dateHeure=$dateHeure, contenue='$contenue', utilisateur=$utilisateur)"
    }
}