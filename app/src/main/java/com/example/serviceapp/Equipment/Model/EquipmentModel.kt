package com.example.serviceapp.Equipment.Model

import java.io.Serializable

data class EquipmentModel(
    var title:String="",
    var description:String="",
    var price:Double=0.0,
    var name:String = "",
    var numberIn:Int=0,
    var ownerName:String="",
    var sellerPic:String="",
    var quantity:Int=0,
    var phoneNumber:String = ""
):Serializable

// title, rent pr hour, uniqueid, description, img, owner name, address to pick,available qunatity,
// phone number

data class CategoryModel(
    var Id: Int = 0,
    var ImagePath: String = "",
    var Name: String = ""
)
