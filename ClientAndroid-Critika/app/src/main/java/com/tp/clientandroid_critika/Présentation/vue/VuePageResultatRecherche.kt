package com.tp.clientandroid_critika.Présentation.vue

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tp.clientandroid_critika.Domaine.entité.JeuVideo
import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVuePageResultatRecherche
import com.tp.clientandroid_critika.Présentation.présenteur.PrésentateurPageResultatRecherche
import com.tp.clientandroid_critika.R
import com.tp.clientandroid_critika.RecyclerViewAdapter.AdapterPageResultatRecherche

class VuePageResultatRecherche : Fragment(), IContratPrésentateurVuePageResultatRecherche.IVuePageResultatRecherche {

    private var _présentateur : PrésentateurPageResultatRecherche? = null
    private var _nav : NavController? = null
    private var _btnDéconnection : ImageButton? = null
    private var _btnMenuPrincipale : ImageButton? = null
    private var _btnRecherche : ImageButton? = null
    private var _btnCompte : ImageButton? = null
    private var _adapter : AdapterPageResultatRecherche? = null
    private var _listeJeux : RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page_resultat_recherche, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _présentateur = PrésentateurPageResultatRecherche(this)
        _nav = Navigation.findNavController(view)
        _btnDéconnection = view.findViewById(R.id.bouton_deconnection)
        _btnMenuPrincipale = view.findViewById(R.id.bouton_menu)
        _btnRecherche = view.findViewById(R.id.bouton_recherche)
        _btnCompte = view.findViewById(R.id.bouton_compte)
        _listeJeux = view.findViewById(R.id.recycler_view_resultat_recherche)

        _btnDéconnection?.setOnClickListener {
                view -> _nav!!.navigate(R.id.vuePageInitiale)
        }
        _btnMenuPrincipale?.setOnClickListener {
                view -> _nav!!.navigate(R.id.vueMenuPrincipale)
        }
        _btnRecherche?.setOnClickListener {
                view -> _nav!!.navigate(R.id.vuePageRecherche)
        }
        _btnCompte?.setOnClickListener {
                view -> _nav!!.navigate(R.id.vueMenuCompte)
        }
        _présentateur!!.chercherJeuxVideo()
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VuePageResultatRecherche().apply {
            }
    }

    override fun afficherListeJeuxVideo(liste: List<JeuVideo?>?) {
        _listeJeux?.layoutManager = LinearLayoutManager(parentFragment?.context)
        _adapter = _présentateur?.let { AdapterPageResultatRecherche(liste, it) }
        _listeJeux?.adapter = _adapter
    }
}