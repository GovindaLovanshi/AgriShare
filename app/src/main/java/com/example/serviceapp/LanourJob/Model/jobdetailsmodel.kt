package com.example.serviceapp.LanourJob.Model

import android.net.Uri
import java.io.Serializable

data class jobdetailsmodel(
    var id: String = "",
    var title: String = "",
    var call: String = "",
    var address: String = "",
    var age: String = "",
    var Salary: String = "",
    var description: String = "",
    var imageUrl: String? = null,
    var date: String = ""
) : Serializable
