package com.tp.clientandroid_critika.Domaine.entité

import com.google.gson.annotations.SerializedName

class Utilisateur(@SerializedName("id")var id : String?,
                  @SerializedName("nom")var nom : String,
                  @SerializedName("motPasse")var motPasse : String,
                  @SerializedName("codeAvatar")var codeAvatar : String?,
                  @SerializedName("type")var type : String?) {

    override fun toString(): String {
        return "Utilisateur(id='$id', nom='$nom', motPasse='$motPasse', codeAvatar='$codeAvatar', type='$type')"
    }


}