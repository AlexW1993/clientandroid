package com.tp.clientandroid_critika.Domaine.entité

import java.time.LocalDateTime

/**
 * Classe Commentaire
 *
 * Représente un commentaire pour un jeu vidéo laissé par un utilisateur
 */
class Commentaire(
    var id : String,
    var jeuVideoId : String,
    var utilisateurId : String,
    var dateHeure : LocalDateTime?,
    var contenue : String,
    var utilisateur : Utilisateur?
    ){

    /**
     * Constructeur secondaire pour la classe commentaire avec les valeurs par defaut
     */
    constructor() : this("","","",null,"",null)
    
    override fun toString(): String {
        return "Commentaire(id='$id', jeuVideoId='$jeuVideoId', utilisateurId='$utilisateurId', dateHeure=$dateHeure, contenue='$contenue', utilisateur=$utilisateur)"
    }
}