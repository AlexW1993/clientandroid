package com.tp.clientandroid_critika.Présentation.vue

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVueMenuPrincipale
import com.tp.clientandroid_critika.Présentation.présenteur.PrésentateurMenuPrincipale
import com.tp.clientandroid_critika.R

class VueMenuPrincipale : Fragment(), IContratPrésentateurVueMenuPrincipale.IVueMenuPrincipale {

    private var _présentateur : PrésentateurMenuPrincipale? = null
    private var _nav : NavController? = null
    private var _btnDéconnection : ImageButton? = null
    private var _btnLogo : ImageButton? = null
    private var _btnMenuPrincipale : ImageButton? = null
    private var _btnRecherche : ImageButton? = null
    private var _btnCompte : ImageButton? = null

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
        _btnLogo = view.findViewById(R.id.bouton_retour)
        _btnMenuPrincipale = view.findViewById(R.id.bouton_menu)
        _btnRecherche = view.findViewById(R.id.bouton_recherche)
        _btnCompte = view.findViewById(R.id.bouton_compte)

        _btnDéconnection?.setOnClickListener {
                view -> _nav!!.navigate(R.id.vuePageInitiale)
        }
        _btnLogo?.setOnClickListener {
                view -> _nav!!.navigate(R.id.vueMenuPrincipale)
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
            VueMenuPrincipale().apply {
            }
    }

    override fun afficherJeuxVideo() {
        TODO("Not yet implemented")
    }
}