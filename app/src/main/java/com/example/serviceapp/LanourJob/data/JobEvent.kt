package com.example.serviceapp.LanourJob.data

import com.example.serviceapp.LanourJob.Model.Detail

sealed class JobEvent{


   data class SaveJob(val jobDet:Detail) : JobEvent()
}