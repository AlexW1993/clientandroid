package com.tp.clientandroid_critika.Présentation.vue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVueChangementCommentaire
import com.tp.clientandroid_critika.Présentation.présenteur.PrésentateurChangementCommentaire
import com.tp.clientandroid_critika.R
import com.tp.clientandroid_critika.RecyclerViewAdapter.AdapterMenuPrincipal

class VueChangementCommentaire : Fragment(),
    IContratPrésentateurVueChangementCommentaire.IContratVueChangementCommentaire {

    private var _présentateur: PrésentateurChangementCommentaire? = null
    private var _nav: NavController? = null
    private var _btnDéconnection: ImageButton? = null
    private var _btnMenuPrincipale: ImageButton? = null
    private var _btnRecherche: ImageButton? = null
    private var _btnCompte: ImageButton? = null
    private var _contenue: EditText? = null
    private var _btnModifier: ImageButton? = null
    private var _btnAnnulation: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_changement_commentaire, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _présentateur = PrésentateurChangementCommentaire(this)
        _nav = Navigation.findNavController(view)
        _btnDéconnection = view.findViewById(R.id.bouton_deconnection)
        _btnMenuPrincipale = view.findViewById(R.id.bouton_menu)
        _btnRecherche = view.findViewById(R.id.bouton_recherche)
        _btnCompte = view.findViewById(R.id.bouton_compte)
        _contenue = view.findViewById(R.id.saisie_changement_commentaire)
        _btnModifier = view.findViewById(R.id.bouton_changement_commentaire)
        _btnAnnulation = view.findViewById(R.id.bouton_supprimer_commentaire2)

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
        _présentateur!!.chercherContenue()
        _btnModifier?.setOnClickListener { view ->
            _présentateur?.modifierContenueCommentaire(_contenue!!.text.toString())
        }
        _btnAnnulation?.setOnClickListener { view ->
            _nav!!.navigate(R.id.vuePageJeu)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VueMenuPrincipale().apply {
            }
    }

    override fun afficherContenue(contenue: String) {
        TODO("Not yet implemented")
    }

    override fun afficherMessage(message: String) {
        TODO("Not yet implemented")
    }

    override fun afficherPageJeu() {
        TODO("Not yet implemented")
    }
}