package com.tp.clientandroid_critika.Présentation.vue

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tp.clientandroid_critika.Domaine.entité.JeuVideo
import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVueMenuPrincipale
import com.tp.clientandroid_critika.Présentation.présenteur.PrésentateurMenuPrincipale
import com.tp.clientandroid_critika.R
import com.tp.clientandroid_critika.RecyclerViewAdapter.AdapterMenuPrincipal

class VueMenuPrincipale : Fragment(), IContratPrésentateurVueMenuPrincipale.IVueMenuPrincipale {

    private var _présentateur: PrésentateurMenuPrincipale? = null
    private var _nav: NavController? = null
    private var _btnDéconnection: ImageButton? = null
    private var _btnMenuPrincipale: ImageButton? = null
    private var _btnRecherche: ImageButton? = null
    private var _btnCompte: ImageButton? = null
    private var _adapter: AdapterMenuPrincipal? = null
    private var _listeJeux: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_principale, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _présentateur = PrésentateurMenuPrincipale(this)
        _nav = Navigation.findNavController(view)
        _btnDéconnection = view.findViewById(R.id.bouton_deconnection)
        _btnMenuPrincipale = view.findViewById(R.id.bouton_menu)
        _btnRecherche = view.findViewById(R.id.bouton_recherche)
        _btnCompte = view.findViewById(R.id.bouton_compte)
        _listeJeux = view.findViewById(R.id.recycler_view_menu)

        _btnDéconnection?.setOnClickListener { view ->
            _nav!!.navigate(R.id.vuePageInitiale)
        }
        _btnMenuPrincipale?.setOnClickListener { view ->
            _nav!!.navigate(R.id.vueMenuPrincipale)
        }
        _btnRecherche?.setOnClickListener { view ->
            _nav!!.navigate(R.id.vuePageRecherche)
        }
        _btnCompte?.setOnClickListener { view ->
            _nav!!.navigate(R.id.vueMenuCompte)
        }
        _présentateur!!.chercherJeuxVideo()
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VueMenuPrincipale().apply {
            }
    }

    /**
     * La méthode permet afficher une liste de jeux vidéos
     *
     * @param (liste: List<JeuVideo?>?), la liste de jeux vidéos
     */
    override fun afficherListeJeuxVideo(liste: List<JeuVideo?>?) {
        _listeJeux?.layoutManager = LinearLayoutManager(parentFragment?.context)
        _adapter = _présentateur?.let { AdapterMenuPrincipal(liste, it) }
        _listeJeux?.adapter = _adapter
    }

    /**
     * La méthode permet afficher une message
     *
     * @param (message: String), le message
     */
    override fun afficherMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }
}