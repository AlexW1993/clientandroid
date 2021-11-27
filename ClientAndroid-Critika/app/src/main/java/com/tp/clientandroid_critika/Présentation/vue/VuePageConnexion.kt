package com.tp.clientandroid_critika.Présentation.vue

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVuePageConnexion
import com.tp.clientandroid_critika.Présentation.présenteur.PrésentateurPageConnexion
import com.tp.clientandroid_critika.R

class VuePageConnexion : Fragment(), IContratPrésentateurVuePageConnexion.IVuePageConnexion {

    private var _présenateur : PrésentateurPageConnexion? = null
    private var _surnom : EditText? = null
    private var _motPasse : EditText? = null
    private var _btnSeConnecter : ImageButton? = null
    private var _nav : NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page_connexion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _présenateur = PrésentateurPageConnexion(this)
        _surnom = view.findViewById(R.id.zone_texte_surnom)
        _motPasse = view.findViewById(R.id.zone_texte_mot_passe_1)
        _btnSeConnecter = view.findViewById(R.id.bouton_Se_connecter_Connection)
        _nav = Navigation.findNavController(view)
        _btnSeConnecter?.setOnClickListener { view ->
            _présenateur!!.verificationUtilisateur(_surnom!!.text.toString(), _motPasse!!.text.toString())
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VuePageConnexion().apply {
            }
    }

    override fun afficherPageMenuPrincipal() {
        _nav!!.navigate(R.id.vueMenuPrincipale)
    }

    override fun afficherMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }
}