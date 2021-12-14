package com.tp.clientandroid_critika.Présentation.vue

import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.tp.clientandroid_critika.Présentation.contrat.IContratPrésentateurVueChangementAvatar
import com.tp.clientandroid_critika.Présentation.présenteur.PrésentateurChangementAvatar
import com.tp.clientandroid_critika.Présentation.présenteur.PrésentateurChangementMotPasse
import com.tp.clientandroid_critika.R

class VueChangementAvatar : Fragment(), IContratPrésentateurVueChangementAvatar.IContratVueChangementAvatar {

    private var _nav: NavController? = null
    private var _présentateur : PrésentateurChangementAvatar? =null
    private var _btnSauvegarder: ImageButton? = null
    private var _btnAvatarImage: ImageButton? = null
    private var _btnAvatarCamera: ImageButton? = null
    private var _imageAvatar: ImageView? = null
    private val PERMISSION_CODE = 1000
    private val IMAGE_CAPTURE_CODE = 1001
    var image_uri: Uri? = null
    private val _galleryActivityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            val imageUri = data!!.data

            _imageAvatar?.setImageURI(imageUri)
        } else {
            Toast.makeText(context, "Cancelled...", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_changement_avatar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _nav = Navigation.findNavController(view)
        _présentateur = PrésentateurChangementAvatar(this)
        _btnSauvegarder = view.findViewById(R.id.bouton_sauvegarder)
        _imageAvatar = view.findViewById(R.id.avatar_changement)
        _btnAvatarImage = view.findViewById(R.id.bouton_image)
        _btnAvatarCamera = view.findViewById(R.id.bouton_photo)
        _présentateur?.chercherImageAvatar()
        _btnSauvegarder?.setOnClickListener { view ->
            _nav!!.navigate(R.id.vueMenuCompte)
        }
        _btnAvatarCamera?.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (context?.let { it1 ->
                        ContextCompat.checkSelfPermission(
                            it1,
                            Manifest.permission.CAMERA
                        )
                    }
                    == PackageManager.PERMISSION_DENIED ||
                    context?.let { it1 ->
                        ContextCompat.checkSelfPermission(
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
        _btnAvatarImage?.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            _galleryActivityResultLauncher.launch(intent)
        }

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VueChangementAvatar().apply {
            }
    }

    /**
     * La méthode permet l'ouverture de la camera et de garder en l'image capturer
     *
     */
    fun OpenCamera() {
        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE, "New Photo")
        values.put(MediaStore.Images.Media.DESCRIPTION, "From the Camera")
        image_uri = context?.getContentResolver()
            ?.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, image_uri)
        startActivityForResult(cameraIntent, IMAGE_CAPTURE_CODE)
    }

    /**
     * La méthode permet de gérer les permissions
     *
     */
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

    /**
     * La méthode permet a l'image prise en photo d'être afficher
     *
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            _imageAvatar?.setImageURI(image_uri)
        }
    }

    override fun récupérerImageAvatar(codeAvatar : String) {
        if(codeAvatar != "default.png" && codeAvatar != "" && codeAvatar != null) {
            var nomImage = codeAvatar?.lowercase()?.replace(' ', '_')
                ?.replace('-', '_')?.replace(".png", "")?.replace(".jpg", "")
            var drawableId: Int = view?.context?.getResources()!!
                .getIdentifier(nomImage, "drawable", view!!.context.packageName)
            _imageAvatar?.setImageResource(drawableId)
        }
    }

}