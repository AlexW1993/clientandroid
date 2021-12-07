package com.tp.clientandroid_critika.RecyclerViewAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.tp.clientandroid_critika.Domaine.entité.JeuVideo
import com.tp.clientandroid_critika.Présentation.présenteur.PrésentateurMenuPrincipale
import com.tp.clientandroid_critika.R

class AdapterMenuPrincipal(
    var liste: List<JeuVideo?>?,
    var présentateur: PrésentateurMenuPrincipale
) : RecyclerView.Adapter<AdapterMenuPrincipal.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val _mInflater = LayoutInflater.from(parent.context)
        return ViewHolder(_mInflater.inflate(R.layout.rangee_jeu_menu, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        liste?.get(position)?.let { holder.viewHolder(it, position, présentateur) }
    }

    override fun getItemCount(): Int {
        if (liste != null) {
            return liste!!.size
        } else {
            return 0
        }
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var palmares: TextView = itemView.findViewById(R.id.palmares_jeu)
        var image: ImageView = itemView.findViewById(R.id.image_jeu_menu)
        var nom: TextView = itemView.findViewById(R.id.nom_jeu_menu)
        var moyenne: TextView = itemView.findViewById(R.id.moyenne_jeu_menu)
        var button: Button = itemView.findViewById(R.id.button_jeu_menu)
        fun viewHolder(
            jeuVideo: JeuVideo,
            position: Int,
            présentateur: PrésentateurMenuPrincipale
        ) {
            nom.text = jeuVideo.nom
            palmares.text = (position + 1).toString()
            moyenne.text = jeuVideo.calculerMoyenneEvaluation().toString()
            button.setOnClickListener {
                présentateur.jeuSelectionné(jeuVideo)
                Navigation.findNavController(view).navigate(R.id.vuePageJeu)
            }
        }
    }
}
