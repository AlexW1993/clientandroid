package com.tp.clientandroid_critika.Domaine.entité

class Commentaire(var id : String, var jeuVideoId : String, var utilisateurId : String, var dateHeure : String,
                  var contenue : String, var utilisateur : Utilisateur?){

    override fun toString(): String {
        return "Commentaire(id='$id', jeuVideoId='$jeuVideoId', utilisateurId='$utilisateurId', dateHeure=$dateHeure, contenue='$contenue', utilisateur=$utilisateur)"
    }
}