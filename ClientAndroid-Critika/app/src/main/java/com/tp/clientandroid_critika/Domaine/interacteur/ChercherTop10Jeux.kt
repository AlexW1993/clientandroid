package com.tp.clientandroid_critika.Domaine.interacteur

import com.tp.clientandroid_critika.Domaine.entité.JeuVideo

class ChercherTop10Jeux {

    /**
     * La méthode permet de chercher les 10 meilleurs jeux en utilisant la liste des evaluations de chaque
     * jeu pour savoir sa moyenne
     *
     * @param (liste : List<JeuVideo>?), la liste de jeux videos
     *
     * @return (List<JeuVideo>) Les 10 meilleurs jeux videos avec les meilleurs moyennes
     */
    fun chercherTop10(liste: List<JeuVideo>?): List<JeuVideo> {
        var listeMeilleursNotes: List<JeuVideo>?
        var listeMoyenne: MutableList<Moyenne> = ArrayList()
        var listeTop10: MutableList<JeuVideo> = ArrayList()
        if (liste != null) {
            for (l in liste) {
                if (l.listeEvaluations?.size != 0) {
                    var moyenne = Moyenne(l.id, l.calculerMoyenneEvaluation())
                    listeMoyenne.add(moyenne)
                }
            }
        }
        listeMoyenne?.sortBy { it.moyenne }
        var listeInverse = listeMoyenne.reversed()
        var listeMoyenneOrdre: MutableList<JeuVideo> = ArrayList()
        for (m in listeInverse) {
            if (liste != null) {
                for (j in liste) {
                    if (j.id == m.idJeu) {
                        listeMoyenneOrdre.add(j)
                    }
                }
            }
        }
        if (listeMoyenneOrdre.size > 10) {
            for (i in 0 until 10) {
                listeTop10.add(listeMoyenneOrdre[i])
            }
        } else {
            for (i in 0 until listeMoyenneOrdre.size) {
                listeTop10.add(listeMoyenneOrdre[i])
            }
        }
        listeMeilleursNotes = listeTop10
        return listeMeilleursNotes
    }

    /**
     * Classe privée Moyenne
     *
     * Représente un jeu avec sa moyenne
     */
    private class Moyenne(var idJeu: String, var moyenne: Double)
}


