package com.tp.clientandroid_critika.Domaine.entité

/**
 * Classe Utilisateur
 *
 * représent l'utilisateur de l'application
 */
class Utilisateur(
    var id: String = "",
    var nom: String = "",
    var motPasse: String = "",
    var codeAvatar: String? = "",
    var type: String = ""
) {

    /**
     * La méthode permet de returner une chaîne de caractères avec tous les attribut de la classe
     * Utilisateur
     *
     * @return (String) la chîne de caractères
     */
    override fun toString(): String {
        return "Utilisateur(id='$id', nom='$nom', motPasse='$motPasse', codeAvatar='$codeAvatar', type='$type')"
    }
}