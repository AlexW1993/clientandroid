package com.tp.clientandroid_critika.Présentation.vue

import android.Manifest
import android.app.Activity
import android.content.ContentUris
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE
import android.provider.MediaStore
import android.provider.SyncStateContract.Helpers.insert
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVuePageInscription
import com.tp.clientandroid_critika.Présentation.présenteur.PrésentateurPageInscription
import com.tp.clientandroid_critika.R

class VuePageInscription : Fragment(), IContratPrésentateurVuePageInscription.IVuePageInscription {

    private var _présenateur: PrésentateurPageInscription? = null
    private var _btnInscription: ImageButton? = null
    private var _btnAvatatImage: ImageButton? = null
    private var _btnAvatarCamera: ImageButton? = null
    private var _btnRetour: ImageButton? = null
    private var _surnom: EditText? = null
    private var _motPasse1: EditText? = null
    private var _motPasse2: EditText? = null
    private var _imageAvatar: ImageView? = null
    private var _nav: NavController? = null
    private val PERMISSION_CODE = 1000
    private val IMAGE_CAPTURE_CODE = 1001
    var image_uri: Uri? = null


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
        _btnRetour = view.findViewById(R.id.bouton_logo_retour_inscription)
        _surnom = view.findViewById(R.id.zone_texte_surnom)
        _motPasse1 = view.findViewById(R.id.zone_texte_mot_passe_1)
        _motPasse2 = view.findViewById(R.id.zone_texte_mot_passe_2)
        _imageAvatar = view.findViewById(R.id.avatar)
        _nav = Navigation.findNavController(view)
        _btnInscription?.setOnClickListener { view ->
            _présenateur!!.verificationInscription(
                _motPasse1!!.text.toString(),
                _motPasse2!!.text.toString(),
                _surnom!!.text.toString()
            )
        }
        _btnRetour?.setOnClickListener { view ->
            _nav!!.navigate(R.id.vuePageInitiale)
        }
        _btnAvatarCamera?.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (context?.let { it1 -> checkSelfPermission(it1, Manifest.permission.CAMERA) }
                    == PackageManager.PERMISSION_DENIED ||
                    context?.let { it1 ->
                        checkSelfPermission(
                            it1,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                        )
                    }
                    == PackageManager.PERMISSION_DENIED) {
                    val permission = arrayOf(
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    )
                    requestPermissions(permission, PERMISSION_CODE)
                } else {
                    OpenCamera()
                }

            } else {
                OpenCamera()
            }
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VuePageInscription().apply {
            }
    }

    /**
     * La méthode permet afficher une message pour confirmer la cration du compte et afficher la vue
     * PageConnexion
     */
    override fun afficherPageConnexion() {
        Toast.makeText(activity, "Votre compte à été créé correctement", Toast.LENGTH_LONG).show()
        _nav!!.navigate(R.id.vuePageConnexion)
    }

    /**
     * La méthode permet afficher une message
     *
     * @param (message: String), le message
     */
    override fun afficherMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

    fun OpenCamera() {
        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE, "New Picture")
        values.put(MediaStore.Images.Media.DESCRIPTION, "From the Camera")
        image_uri = context?.getContentResolver()?.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, image_uri)
        startActivityForResult(cameraIntent, IMAGE_CAPTURE_CODE)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSION_CODE -> {
                if (grantResults.size > 0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED
                ) {
                } else {
                    Toast.makeText(context, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            _imageAvatar?.setImageURI(image_uri)
        }
    }

}