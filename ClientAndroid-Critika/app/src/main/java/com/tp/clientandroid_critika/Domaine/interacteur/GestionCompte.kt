package com.tp.clientandroid_critika.Domaine.interacteur

import com.tp.clientandroid_critika.Domaine.entité.Utilisateur

class GestionCompte(var _source: SourceDeDonnées?) {

    /**
     * La méthode permet de verifier l'existance d'un compte
     *
     * @param (surnom : String,motpasse : String), le surnom et le mot de passe de la compte à verifier
     *
     * @return (Utilisateur) l'utilisateur avec le même surnom et mot de passe
     */
    fun verificationCompte(surnom: String, motPasse: String): Utilisateur? {
        var u = Utilisateur(nom = surnom, motPasse = motPasse)
        var utilisateur: Utilisateur? = _source?.chercherUtilisateur(u)
        return utilisateur
    }

    /**
     * La méthode permet de créer un compte
     *
     * @param (utilisateur : Utilisateur), le utilisateur qui va créer son compte
     *
     * @return (Boolean) true = l'utilisateur à été créer correctement, false = problème pour la création du compte
     */
    fun creationCompte(utilisateur: Utilisateur): Boolean? {
        return _source?.ajouterUtilisateur(utilisateur)
    }

    /**
     * La méthode permet de modifier le surnom de un utilisateur
     *
     * @param (utilisateur: Utilisateur), L'utilisateur avec son surnom modifié
     *
     * @return (Boolean?) true por confirmer que le surnom a été modifié correctement, false si il y a eu un erreur
     */
    fun modifierSurnom(utilisateur: Utilisateur): Boolean? {
        return _source?.modifierSurnom(utilisateur)
    }
}