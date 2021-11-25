package com.tp.clientandroid_critika.Domaine.interacteur

import com.tp.clientandroid_critika.Domaine.entité.JeuVideo

class ChercherTop10Jeux{

    fun chercherTop10(liste : List<JeuVideo>?) : List<JeuVideo>{
        var listeMeilleursNotes : List<JeuVideo>? = null
        var listeMoyenne : MutableList<Moyenne> = ArrayList()
        if (liste != null) {
            for (l in liste){
                if(l.listeEvaluations?.size != 0){
                    var moyenne = Moyenne(l.id,l.calculerMoyenneEvaluation())
                    listeMoyenne.add(moyenne)
                }
            }
        }
        listeMoyenne?.sortBy { it.moyenne}
        var listeInverse = listeMoyenne.reversed()
        var listeMoyenneOrdre : MutableList<JeuVideo> = ArrayList()

        for (m in listeInverse) {
            if (liste != null) {
                for(j in liste){
                    if(j.id == m.idJeu){
                        listeMoyenneOrdre.add(j)
                    }
                }
            }
        }

        var listeTop10 : MutableList<JeuVideo> = ArrayList()
        for(i in 0 until 10){
            listeTop10.add(listeMoyenneOrdre[i])
        }

        listeMeilleursNotes = listeTop10
        return listeMeilleursNotes
    }

    class Moyenne(var idJeu : String, var moyenne : Double){

    }
}


