package com.tp.clientandroid_critika.Présentation.vue

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVuePageRecherche
import com.tp.clientandroid_critika.Présentation.présenteur.PrésentateurPageRecherche
import com.tp.clientandroid_critika.R

class VuePageRecherche : Fragment(), IContratPrésentateurVuePageRecherche.IContratVuePageRecherche{

    private var _présentateur : PrésentateurPageRecherche? = null
    private var _nav : NavController? = null
    private var _btnDéconnection : ImageButton? = null
    private var _btnMenuPrincipale : ImageButton? = null
    private var _btnRecherche : ImageButton? = null
    private var _btnCompte : ImageButton? = null
    private var _btnXbox : ImageButton? = null
    private var _btnPlaystation : ImageButton? = null
    private var _btnSwitch : ImageButton? = null
    private var _barreRecherche : EditText? = null
    private var _iconRecherche : ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page_recherche, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _présentateur = PrésentateurPageRecherche(this)
        _nav = Navigation.findNavController(view)
        _btnDéconnection = view.findViewById(R.id.bouton_deconnection)
        _btnMenuPrincipale = view.findViewById(R.id.bouton_menu)
        _btnRecherche = view.findViewById(R.id.bouton_recherche)
        _btnCompte = view.findViewById(R.id.bouton_compte)
        _btnXbox = view.findViewById(R.id.bouton_xbox)
        _btnPlaystation = view.findViewById(R.id.bouton_ps)
        _btnSwitch = view.findViewById(R.id.bouton_switch)
        _barreRecherche = view.findViewById(R.id.saisie_recherche)
        _iconRecherche = view.findViewById(R.id.bouton_saisie_recherche)

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
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VuePageRecherche().apply {
            }
    }
}