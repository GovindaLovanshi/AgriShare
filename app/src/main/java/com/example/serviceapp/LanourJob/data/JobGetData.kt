package com.example.serviceapp.LanourJob.data

data class JobGetData(
    var Id: String,
    var Title: String = "",
    var Call: String = "",
    var Address: String = "",
    var Description: String = "",
    var ImagePath: String = "",
    var date :Long
)
