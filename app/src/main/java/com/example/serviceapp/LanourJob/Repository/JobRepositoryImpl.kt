package com.example.serviceapp.LanourJob.Repository

import com.example.serviceapp.LanourJob.Mapper.JobgetData
import com.example.serviceapp.LanourJob.Model.Detail
import com.example.serviceapp.LanourJob.data.JobGetData
import com.example.serviceapp.navigation.Routes
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class JobRepositoryImpl:jobRepository {


    val firebase = FirebaseDatabase.getInstance()
    val jobRef = firebase.getReference("jobData")

    override suspend fun saveJob(job: Detail) {
       val JobGetData = job.JobgetData()

        try {

            jobRef.child(JobGetData.Id).setValue(job.JobgetData()).await()

        }catch (e :Exception){

        }
    }

    override suspend fun getJob(): List<Detail >{

        TODO("Not yet implemented")
    }
}