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
import com.tp.clientandroid_critika.Présentation.présenteur.PrésentateurPageResultatRecherche
import com.tp.clientandroid_critika.R

class AdapterPageResultatRecherche(var liste: List<JeuVideo?>?, var présentateur : PrésentateurPageResultatRecherche) : RecyclerView.Adapter<AdapterPageResultatRecherche.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val _mInflater = LayoutInflater.from(parent.context)
        return ViewHolder(_mInflater.inflate(R.layout.rangee_jeu_recherche, parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        liste?.get(position)?.let { holder.viewHolder(it,présentateur) }
    }

    override fun getItemCount(): Int = liste!!.size

    class ViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        var image : ImageView = itemView.findViewById(R.id.image_jeu_recherche)
        var nom : TextView = itemView.findViewById(R.id.nom_jeu_recherche)
        var button : Button = itemView.findViewById(R.id.button_jeu_recherche)
        fun viewHolder(jeuVideo : JeuVideo,présentateur: PrésentateurPageResultatRecherche){
            nom.text = jeuVideo.nom
            button.setOnClickListener{
                présentateur.jeuSelectionné(jeuVideo)
                Navigation.findNavController(view).navigate(R.id.vuePageJeu)
            }
        }
    }

}