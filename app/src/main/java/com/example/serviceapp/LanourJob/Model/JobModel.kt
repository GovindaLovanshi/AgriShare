package com.example.serviceapp.LanourJob.Model

import java.sql.Date

data class JobModel(
    val image:Int,
    val location:String,
    val description:String,
    val jobName:String,
    val date: String

)


data class Detail(
    var Id: Int = 0,
    var Title: String = "",
    var Call: String = "",
    var Address: String = "",
    var Description: String = "",
    var ImagePath: String = "",
    var date :String = ""
)