package com.tp.clientandroid_critika.Présentation.vue

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tp.clientandroid_critika.Domaine.entité.JeuVideo
import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVuePageJeu
import com.tp.clientandroid_critika.Présentation.présenteur.PrésentateurPageJeu
import com.tp.clientandroid_critika.R
import com.tp.clientandroid_critika.RecyclerViewAdapter.AdapterPageJeu

class VuePageJeu : Fragment(), IContratPrésentateurVuePageJeu.IVuePageJeu {

    private var _présentateur : PrésentateurPageJeu? = null
    private var _nav : NavController? = null
    private var _adapter : AdapterPageJeu? = null
    private var _btnDéconnection : ImageButton? = null
    private var _btnMenuPrincipale : ImageButton? = null
    private var _btnRecherche : ImageButton? = null
    private var _btnCompte : ImageButton? = null
    private var _titreJeu : TextView? = null
    private var _anneeJeu : TextView? = null
    private var _moyenneJeu : TextView? = null
    private var _imageJeu : ImageView? = null
    private var _descriptionJeu : TextView? = null
    private var _listeCommentaires : RecyclerView? = null
    private var _commentaire : EditText? = null
    private var _btnEnvoyer : ImageButton? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page_jeu, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _présentateur = PrésentateurPageJeu(this)
        _nav = Navigation.findNavController(view)
        _btnDéconnection = view.findViewById(R.id.bouton_deconnection)
        _btnMenuPrincipale = view.findViewById(R.id.bouton_menu)
        _btnRecherche = view.findViewById(R.id.bouton_recherche)
        _btnCompte = view.findViewById(R.id.bouton_compte)
        _titreJeu = view.findViewById(R.id.titre_jeu)
        _anneeJeu = view.findViewById(R.id.annee_jeu)
        _moyenneJeu = view.findViewById(R.id.moyenne_jeu)
        _imageJeu = view.findViewById(R.id.image_jeu)
        _descriptionJeu = view.findViewById(R.id.description_jeu)
        _listeCommentaires = view.findViewById(R.id.commentaires_jeu)
        _commentaire = view.findViewById(R.id.saisie_commentaire)
        _btnEnvoyer = view.findViewById(R.id.bouton_envoie_commentaire)
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
        _présentateur?.chercherInformationJeuSelectionné()
        _btnEnvoyer?.setOnClickListener{
            _présentateur?.ajouterCommenataire(_commentaire!!.text.toString())
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VuePageJeu().apply {
            }
    }

    override fun affichageInformationJeuSelecionné(jeu: JeuVideo?) {
        _titreJeu?.text = jeu?.nom
        _anneeJeu?.text = jeu?.anneSortie.toString()
        _moyenneJeu?.text = jeu?.calculerMoyenneEvaluation().toString()
        _imageJeu = null
        _descriptionJeu?.text = jeu?.description
        _listeCommentaires?.layoutManager = LinearLayoutManager(parentFragment?.context)
        _adapter = AdapterPageJeu(jeu?.listeCommentaires)
        _listeCommentaires?.adapter = _adapter
    }

    override fun afficherMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

    override fun afficherPageJeu() {
        Toast.makeText(activity, "Commentaire ajouté correctement", Toast.LENGTH_LONG).show()
        _nav!!.navigate(R.id.vuePageJeu)
    }
}