package com.tp.clientandroid_critika.Domaine.entité

/**
 * Classe Utilisateur
 *
 * représent l'utilisateur de l'application
 */
class Utilisateur(
    var id : String?,
    var nom : String,
    var motPasse : String,
    var codeAvatar : String?,
    var type : String?
    ) {

    /**
     * Constructeur secondaire avec les valuers par defaut
     */
    constructor() : this("","","","","")

    override fun toString(): String {
        return "Utilisateur(id='$id', nom='$nom', motPasse='$motPasse', codeAvatar='$codeAvatar', type='$type')"
    }
}