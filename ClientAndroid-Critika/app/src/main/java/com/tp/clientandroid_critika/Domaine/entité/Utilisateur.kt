package com.tp.clientandroid_critika.Domaine.entité

/**
 * Classe Utilisateur
 *
 * représente l'utilisateur de l'application
 */
class Utilisateur(
    var id: String = "",
    var nom: String = "",
    var motPasse: String = "",
    var codeAvatar: String? = "",
    var type: String = ""
) {

    /**
     * La méthode permet de retourner une chaîne de caractères avec tous les attributs de la classe
     * Utilisateur
     *
     * @return (String) la chaîne de caractères
     */
    override fun toString(): String {
        return "Utilisateur(id='$id', nom='$nom', motPasse='$motPasse', codeAvatar='$codeAvatar', type='$type')"
    }
}