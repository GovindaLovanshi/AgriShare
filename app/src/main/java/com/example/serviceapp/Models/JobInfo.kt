package com.example.serviceapp.Models

import java.io.Serializable

data class JobInfo(
    var title:String="",
    var description:String="",
    var jobpostnumber:Int=0,


): Serializable
