package com.tp.clientandroid_critika.Présentation.vue

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tp.clientandroid_critika.R
import android.widget.ImageButton
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.tp.clientandroid_critika.Domaine.entité.Utilisateur
import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVueMenuCompte
import android.widget.ImageView
import android.widget.TextView
import com.tp.clientandroid_critika.Présentation.présenteur.PrésentateurMenuCompte

class VueMenuCompte : Fragment(), IContratPrésentateurVueMenuCompte.IContratVueMenuCompte {

    private var _présentateur: PrésentateurMenuCompte? = null
    private var _nav: NavController? = null
    private var _btnDéconnection: ImageButton? = null
    private var _btnMenuPrincipale: ImageButton? = null
    private var _btnRecherche: ImageButton? = null
    private var _btnCompte: ImageButton? = null
    private var _surnom: TextView? = null
    private var _motPasse: TextView? = null
    private var _avatar: ImageView? = null
    private var _btnModifierAvatar: ImageButton? = null
    private var _btnModifierSurnom: ImageButton? = null
    private var _btnModifierMotPasse: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_compte, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _présentateur = PrésentateurMenuCompte(this)
        _nav = Navigation.findNavController(view)
        _btnDéconnection = view.findViewById(R.id.bouton_deconnection)
        _btnMenuPrincipale = view.findViewById(R.id.bouton_menu)
        _btnRecherche = view.findViewById(R.id.bouton_recherche)
        _btnCompte = view.findViewById(R.id.bouton_compte)
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
        _btnModifierAvatar = view.findViewById(R.id.bouton_modification_avatar)
        _avatar = view.findViewById(R.id.avatar_changement)
        _btnModifierSurnom = view.findViewById(R.id.bouton_modification_surnom)
        _surnom = view.findViewById(R.id.surnom)
        _motPasse = view.findViewById(R.id.mot_passe)
        _btnModifierMotPasse = view.findViewById(R.id.bouton_modification_mot_passe)
        _btnModifierAvatar?.setOnClickListener { view ->
            _nav!!.navigate(R.id.vueChangementAvatar)
        }
        _btnModifierSurnom?.setOnClickListener { view ->
            _nav!!.navigate(R.id.vueChangementSurnom)
        }
        _btnModifierMotPasse?.setOnClickListener { view ->
            _nav!!.navigate(R.id.vueChangementMotPasse)
        }
        _présentateur!!.chercherInformationCompte()

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VueMenuCompte().apply {
            }
    }

    /**
     * La méthode affiche les infomration de l'utilisateur
     *
     * @param (utilisateur: Utilisateur?), le utilisateur
     */
    override fun afficherInformationCompte(utilisateur: Utilisateur?) {
        _surnom?.text = utilisateur?.nom
        _motPasse?.text = utilisateur?.motPasse

    }
}