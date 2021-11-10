package com.tp.clientandroid_critika.Domaine.entité

import java.time.LocalDateTime


class Commentaire(var id : String, var idJeu : String, var idUtilisateur : String, var dateHeure : LocalDateTime, var contenue : String){

    override fun toString(): String {
        return "Commentaire(id='$id', idJeu='$idJeu', idUtilisateur='$idUtilisateur', dateHeure='$dateHeure', contenue='$contenue')"
    }
}