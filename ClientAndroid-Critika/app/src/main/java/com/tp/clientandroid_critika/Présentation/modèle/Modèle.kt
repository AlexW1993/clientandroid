package com.tp.clientandroid_critika.Présentation.modèle

import android.os.Build
import androidx.annotation.RequiresApi
import com.tp.clientandroid_critika.Domaine.entité.Commentaire
import com.tp.clientandroid_critika.Domaine.entité.Evaluation
import com.tp.clientandroid_critika.Domaine.entité.JeuVideo
import com.tp.clientandroid_critika.Domaine.entité.Utilisateur
import com.tp.clientandroid_critika.Domaine.interacteur.*
import java.time.LocalDateTime

class Modèle() {

    var sourceDeDonnées: SourceDeDonnées? = null
    var jeuSelectionné: JeuVideo? = null
    var utilisateur: Utilisateur? = null
    var listeJeux: List<JeuVideo>? = null
    var evalautionSelectionné: Evaluation? = null

    companion object {
        var modèle: Modèle? = null
        fun getInstance(): Modèle {
            if (modèle == null) {
                modèle = Modèle()
            }
            return modèle as Modèle
        }
    }

    /**
     * La méthode permet créer un utilisateur
     *
     * @param (utilisateur: Utilisateur), l'utilisateur à créer
     *
     * @return (Boolean) true si l'utilisateur a été créé correctement, false s'il y a eu un problème
     */

    fun creationUtilisateur(utilisateur: Utilisateur): Boolean? {
        return GestionCompte(sourceDeDonnées).creationCompte(utilisateur)
    }

    /**
     * La méthode permet de verifier si l'utilisateur qui essaie de se connecter existe
     *
     * @param (surnom : String, motPasse : String), le surnom et le mot de passe de l'utilisateur qui veut se connecter à son compte
     *
     * @return (Boolean) true si l'utilisateur existe, false s'il yn'existe pas
     */
    fun verifierUtilisateur(surnom: String, motPasse: String): Boolean {
        var utilisateur: Utilisateur? =
            GestionCompte(sourceDeDonnées).verificationCompte(surnom, motPasse)
        if (utilisateur != null) {
            this.utilisateur = utilisateur
            return true
        } else {
            return false
        }
    }

    /**
     * La méthode permet de chercher la liste des tous les jeux
     *
     * @return (Boolean) true si la liste  a été trouvé, false s'il y a eu un problème
     */
    fun chercherJeux(): Boolean {
        var liste = GestionJeuxVideo(sourceDeDonnées).chercherTousJeuxVideo()
        if (liste == null) {
            return false
        } else {
            listeJeux = ChercherTop10Jeux().chercherTop10(liste)
            return true
        }
    }

    /**
     * La méthode permet de chercher la liste des jeux par plateforme
     *
     * @param (plateforme : String), le plateforme des jeux vidéos
     */

    fun chercherJeuxParConsole(plateforme: String): Boolean {
        listeJeux = GestionJeuxVideo(sourceDeDonnées).chercherJeuxVideoParPlateforme(plateforme)
        return listeJeux != null
    }

    /**
     * La méthode permet de ajouter un commentaire
     *
     * @param (contenueCommentaire: String), le contenue du commentaire
     *
     * @return (Boolean) true si le commentaire a été crée correctement, false s'il y a eu un problème
     */

    @RequiresApi(Build.VERSION_CODES.O)
    fun ajouterCommentaire(contenueCommentaire: String): Boolean {
        var commentaire = Commentaire(
            "",
            jeuSelectionné!!.id,
            utilisateur!!.id,
            LocalDateTime.now().toString(),
            contenueCommentaire,
            utilisateur
        )
        var confirmationAjouter =
            GestionCommentaire(sourceDeDonnées).ajouterCommentaire(commentaire)
        if (confirmationAjouter == true) {
            listeJeux = GestionJeuxVideo(sourceDeDonnées).chercherTousJeuxVideo()
            for (l in listeJeux!!) {
                if (l.id == jeuSelectionné?.id) {
                    jeuSelectionné = l
                }
            }
            return true
        } else {
            return false
        }
    }

    /**
     * La méthode permet de chercher l'évaluation que l'utilisateur à fait pour un jeu
     *
     * @return (Boolean) true s'il y a un note de l'utilisateur, false s'il n'a pas fait un note pour le jeu
     */
    fun chercherEvaluationUtilisateur(): Boolean {
        var confirmation = false
        for (l in jeuSelectionné?.listeEvaluations!!) {
            if (l.idUtilisateur == utilisateur?.id) {
                evalautionSelectionné = l
                confirmation = true
            }
        }
        return confirmation
    }

    /**
     * La méthode permet de ajouter une evaluation
     *
     * @param (note : Int), la note
     *
     * @return (Boolean) true si l'evaluation a été crée correctment, false s'il y a eu un problème
     */
    fun ajouterEvaluation(note: Int): Boolean {
        var evaluation = Evaluation("", jeuSelectionné?.id, utilisateur?.id, note)
        var confirmationAjouter = GestionEvaluation(sourceDeDonnées).ajouterEvaluation(evaluation)
        if (confirmationAjouter == true) {
            listeJeux = GestionJeuxVideo(sourceDeDonnées).chercherTousJeuxVideo()
            for (l in listeJeux!!) {
                if (l.id == jeuSelectionné?.id) {
                    jeuSelectionné = l
                }
            }
            return true
        } else {
            return false
        }
    }

    /**
     * La méthode permet de modifier une note que l'utilisateur a inscrit dans une évaluation
     *
     * @param (note : Int), la note
     *
     * @return (Boolean) true si l'evaluation a été modifié correctment, false s'il y a eu un problème
     */
    fun modifierEvaluation(note: Int): Boolean {
        evalautionSelectionné?.note = note

        var confirmationModification = evalautionSelectionné?.let {
            GestionEvaluation(sourceDeDonnées).modifierEvaluation(
                it
            )
        }
        if (confirmationModification == true) {
            listeJeux = GestionJeuxVideo(sourceDeDonnées).chercherTousJeuxVideo()
            for (l in listeJeux!!) {
                if (l.id == jeuSelectionné?.id) {
                    jeuSelectionné = l
                }
            }
            return true
        } else {
            return false
        }
    }

    /**
     * La méthode permet de chercher des jeux vidéos qui ont dans son nom le mot cle que
     * l'utilisateur a écrit
     *
     * @param (motCle: String), le mot cle
     *
     * @return (Boolean) true si il y a une resultat, false s'il n'y a pas des jeux qui utilisent le mot cle
     */
    fun chercherJeuxParMotCle(motCle: String): Boolean? {
        listeJeux = GestionJeuxVideo(sourceDeDonnées).chercherJeuxVideoParMotCle(motCle)
        return if(listeJeux != null){
            listeJeux?.size!! > 0
        } else {
            null
        }

    }

    /**
     * La méthode permet de modifier le surnom d'un utilisateur
     *
     * @param (surnom: String), le surnom
     *
     * @return (Boolean) true si le surnom a été modifié correctment, false s'il y a eu un problème
     */
    fun modiferSurnom(surnom: String): Boolean? {
        utilisateur?.nom = surnom
        var confirmationModification = utilisateur?.let {
            GestionCompte(sourceDeDonnées).modifierSurnom(
                it
            )
        }
        return confirmationModification
    }

}