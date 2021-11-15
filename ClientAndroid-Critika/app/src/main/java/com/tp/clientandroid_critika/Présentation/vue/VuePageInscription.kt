package com.tp.clientandroid_critika.Présentation.vue

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVuePageInscription
import com.tp.clientandroid_critika.Présentation.présenteur.PrésentateurPageInscription
import com.tp.clientandroid_critika.R

class VuePageInscription : Fragment(), IContratPrésentateurVuePageInscription.IVuePageInscription {

    private var _présenateur : PrésentateurPageInscription? = null
    private var _btnInscription : ImageButton? = null
    private var _btnAvatatImage : ImageButton? = null
    private var _btnAvatarCamera : ImageButton? = null
    private var _surNom : EditText? = null
    private var _motPasse1 : EditText? = null
    private var _motPasse2 : EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page_inscription, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _présenateur = PrésentateurPageInscription(this)
        _btnInscription = view.findViewById(R.id.bouton_inscription)
        _btnAvatatImage = view.findViewById(R.id.bouton_avatar_image)
        _btnAvatarCamera = view.findViewById(R.id.bouton_avatar_camera)
        _surNom = view.findViewById(R.id.zone_texte_surnom)
        _motPasse1 = view.findViewById(R.id.zone_texte_mot_passe_1)
        _motPasse2 = view.findViewById(R.id.zone_texte_mot_passe_2)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VuePageInscription().apply {
            }
    }
}