package com.tp.clientandroid_critika.Domaine.entité

class Utilisateur(var id : String, var nom : String, var motPasse : String, var codeAvatar : String,
                  var type : String) {

    override fun toString(): String {
        return "Utilisateur(id='$id', nom='$nom', motPasse='$motPasse', codeAvatar='$codeAvatar', type='$type')"
    }


}