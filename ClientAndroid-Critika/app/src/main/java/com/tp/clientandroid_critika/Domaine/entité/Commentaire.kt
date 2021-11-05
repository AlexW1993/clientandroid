package com.tp.clientandroid_critika.Domaine.entité

import java.time.LocalDate
import java.time.LocalTime

class Commentaire(var id : String, var idJeu : String, var idUtilisateur : String, var date : LocalDate,
                  var heure : LocalTime, var contenue : String){

    override fun toString(): String {
        return "Commentaire(id='$id', idJeu='$idJeu', idUtilisateur='$idUtilisateur', date='$date', heure='$heure', contenue='$contenue')"
    }
}