package com.example.serviceapp.Models

import java.io.Serializable

data class EquipmentModel(
    var title:String="",
    var description:String="",
    var picUrl:ArrayList<String> =ArrayList(),
    var size:ArrayList<String> =ArrayList(),
    var price:Double=0.0,
    var rating:Double=0.0,
    var numberIn:Int=0,
    var showRecommended:Boolean=false,
    var categoryId:String="",
    var sellerName:String="",
    var sellerPic:String="",
    var sellerTell:Int=0
):Serializable

// title, rent pr hour, uniqueid, description, img, owner name, address to pick,available qunatity,
// phone number
