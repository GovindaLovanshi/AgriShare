package com.example.serviceapp.LanourJob.Repository

import com.example.serviceapp.LanourJob.Model.Detail
import com.example.serviceapp.navigation.Routes

interface jobRepository {

    suspend fun saveJob(job:Detail)
    suspend fun getJob():List<Detail>

}