package com.tp.clientandroid_critika.Domaine.interacteur

import com.tp.clientandroid_critika.Domaine.entité.JeuVideo

class GestionJeuxVideo(var _source: SourceDeDonnées?) {

    /**
     * La méthode permet de chercher une liste de jeux vidéos
     *
     * @return (List<JeuVideo>?) La liste de jeux vidéos
     */
    fun chercherTousJeuxVideo(): List<JeuVideo>? {
        return _source?.chercherTousJeux()
    }

    /**
     * La méthode permet de chercher une liste de jeux vidéos d'un plateforme
     *
     * @param (plateforme : String), La plateforme des jeux de la liste
     *
     * @return (List<JeuVideo>?) La liste de jeux vidéos par plateforme
     */
    fun chercherJuexVideoParPlateforme(plateforme: String): List<JeuVideo>? {
        return _source?.chercherTousJeuxParPlateforme(plateforme)
    }
}