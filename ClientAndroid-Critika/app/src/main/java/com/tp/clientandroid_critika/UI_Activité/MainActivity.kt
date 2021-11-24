package com.tp.clientandroid_critika.UI_Activité

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tp.clientandroid_critika.Présentation.modèle.Modèle
import com.tp.clientandroid_critika.R
import com.tp.clientandroid_critika.SourceDeDonnées.SourceDeDonnéesAPI
import com.tp.clientandroid_critika.SourceDeDonnées.SourceDeDonnéesBidon

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var modèle = Modèle.getInstance()
        modèle.creationSourceDeDonnées(SourceDeDonnéesAPI())
        modèle.récuperationContext(this)
        //modèle.creationSourceDeDonnées(SourceDeDonnéesBidon())
        setContentView(R.layout.activity_main)
    }
}