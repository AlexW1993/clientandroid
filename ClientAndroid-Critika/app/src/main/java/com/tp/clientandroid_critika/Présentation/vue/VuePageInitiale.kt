package com.tp.clientandroid_critika.Présentation.vue

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.tp.clientandroid_critika.R

class VuePageInitiale : Fragment() {

    private var btnSeConnecter : ImageButton? = null
    private var btnSInscrire : ImageButton? = null
    private var nav : NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page_initiale, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSInscrire = view.findViewById(R.id.bouton_s_inscrire_initial)
        btnSeConnecter = view.findViewById(R.id.bouton_Se_connecter)
        nav = Navigation.findNavController(view)

        btnSeConnecter?.setOnClickListener{ view ->
            nav!!.navigate(R.id.vuePageConnexion)
        }

        btnSInscrire?.setOnClickListener { view ->
            nav!!.navigate(R.id.vuePageInscription)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VuePageInitiale().apply {
            }
    }
}