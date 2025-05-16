package com.example.serviceapp.Equipment.Model

import android.net.Uri
import java.io.Serializable

data class EquipmentModel(
    var title:String="",
    var description:String="",
    var price:String="",
    var address:String = "",
    var imageUrl: Uri? = null,
    var call: String ="",
    var ownerName:String="",
):Serializable

// title, rent pr hour, uniqueid, description, img, owner name, address to pick,available qunatity,
// phone number

//data class CategoryModel(
//    var Id: Int = 0,
//    var ImagePath: String = "",
//    var Name: String = ""
//)
