package com.tp.clientandroid_critika.RecyclerViewAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tp.clientandroid_critika.Domaine.entité.JeuVideo
import com.tp.clientandroid_critika.R

class AdapterMenuPrincipal(var liste: List<JeuVideo?>?) : RecyclerView.Adapter<AdapterMenuPrincipal.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val _mInflater = LayoutInflater.from(parent.context)
        return ViewHolder(_mInflater.inflate(R.layout.rangee_jeu_menu,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        liste?.get(position)?.let { holder.viewHolder(it,position) }
    }

    override fun getItemCount(): Int = liste!!.size


    class ViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        var palmares : TextView = itemView.findViewById(R.id.palmares_jeu)
        var image : ImageView = itemView.findViewById(R.id.image_jeu_menu)
        var description : TextView = itemView.findViewById(R.id.description_jeu_menu)
        var moyenne : TextView = itemView.findViewById(R.id.moyenne_jeu_menu)
        fun viewHolder(jeuVideo : JeuVideo, position: Int){
            description.text = jeuVideo.description
            palmares.text = (position + 1).toString()
        }

    }
}
