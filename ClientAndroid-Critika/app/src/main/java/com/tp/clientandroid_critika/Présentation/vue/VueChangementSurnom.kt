package com.tp.clientandroid_critika.Présentation.vue

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tp.clientandroid_critika.R
import android.widget.EditText
import android.widget.ImageButton
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.tp.clientandroid_critika.Présentation.présenteur.PrésentateurMenuCompte
import android.widget.Toast
import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVueChangementSurnom
import com.tp.clientandroid_critika.Présentation.présenteur.PrésentateurChangementSurnom

class VueChangementSurnom : Fragment(),
    IContratPrésentateurVueChangementSurnom.IContratVueChangementSurnom
{

    private var _présentateur: PrésentateurChangementSurnom? = null
    private var _nav: NavController? = null
    private var _btnDéconnection: ImageButton? = null
    private var _btnMenuPrincipale: ImageButton? = null
    private var _btnRecherche: ImageButton? = null
    private var _btnCompte: ImageButton? = null
    private var _nouveauSurnom: EditText? = null
    private var _btnSauvegarderSurnom: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_changement_surnom, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _présentateur = PrésentateurChangementSurnom(this)
        _nav = Navigation.findNavController(view)
        _btnDéconnection = view.findViewById(R.id.bouton_deconnection)
        _btnMenuPrincipale = view.findViewById(R.id.bouton_menu)
        _btnRecherche = view.findViewById(R.id.bouton_recherche)
        _btnCompte = view.findViewById(R.id.bouton_compte)
        _nouveauSurnom = view.findViewById(R.id.saisie_nouveau_surnom)
        _btnSauvegarderSurnom = view.findViewById(R.id.bouton_sauvegarde_surnom)
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
        _btnSauvegarderSurnom?.setOnClickListener { view ->

        }
        _présentateur?.sauvegarderNouveauSurnom(_nouveauSurnom!!.text.toString())

    }
        companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VueChangementSurnom().apply {
            }
    }

    /**
     * La méthode permet afficher la vue MenuCompte et un message pour confirmer que l'operation a
     * été realisé correctement
     */
    override fun afficherMenuCompte() {
        Toast.makeText(activity, "Changement effectué correctement", Toast.LENGTH_LONG).show()
        _nav!!.navigate(R.id.vueMenuCompte)
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