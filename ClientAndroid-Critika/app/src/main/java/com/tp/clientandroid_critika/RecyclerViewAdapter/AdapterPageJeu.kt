package com.tp.clientandroid_critika.RecyclerViewAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isInvisible
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.tp.clientandroid_critika.Domaine.entité.Commentaire
import com.tp.clientandroid_critika.Présentation.présenteur.PrésentateurPageJeu
import com.tp.clientandroid_critika.R

class AdapterPageJeu(
    var liste: List<Commentaire?>?,
    var idUtilisateur: String,
    var présentatur: PrésentateurPageJeu
) :
    RecyclerView.Adapter<AdapterPageJeu.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val _mInflater = LayoutInflater.from(parent.context)
        return ViewHolder(_mInflater.inflate(R.layout.rangee_commentaire, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        liste?.get(position)?.let { holder.viewHolder(it, idUtilisateur, présentatur) }
    }

    override fun getItemCount(): Int {
        if (liste != null) {
            return liste!!.size
        } else {
            return 0
        }
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var nomUtilisateur: TextView = itemView.findViewById(R.id.nom_utilisateur)
        var contenu: TextView = itemView.findViewById(R.id.commentaire_contenu)
        var dateHeure: TextView = itemView.findViewById(R.id.date_heure_commentaire)
        var avatar: ImageView = itemView.findViewById(R.id.image_avatar)
        var btnChangementCommentaire: ImageButton =
            itemView.findViewById(R.id.bouton_changer_commentaire)
        var btnEffacerCommentaire: ImageButton =
            itemView.findViewById(R.id.bouton_supprimer_commentaire)


        fun viewHolder(
            commentaire: Commentaire,
            idUtilisateur: String,
            présentatur: PrésentateurPageJeu
        ) {
            nomUtilisateur.text = commentaire.utilisateur?.nom
            contenu.text = commentaire.contenue
            dateHeure.text = commentaire.dateHeure
            if (commentaire.utilisateurId == idUtilisateur) {
                btnChangementCommentaire?.setOnClickListener {

                    présentatur?.commentaireSelectionné(commentaire)
                    Navigation.findNavController(view).navigate(R.id.vueChangementCommentaire)
                }
                btnEffacerCommentaire?.setOnClickListener {

                    présentatur?.effacerCommentaire(commentaire.id)
                }

            } else {
                btnChangementCommentaire.setVisibility(View.INVISIBLE)
                btnEffacerCommentaire.setVisibility(View.INVISIBLE)
            }
        }
    }
}
