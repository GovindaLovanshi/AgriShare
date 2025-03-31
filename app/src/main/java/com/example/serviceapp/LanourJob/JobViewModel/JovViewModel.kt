package com.example.serviceapp.LanourJob.JobViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.serviceapp.LanourJob.Model.Detail
import com.example.serviceapp.LanourJob.Repository.JobRepositoryImpl
import com.example.serviceapp.LanourJob.Repository.jobRepository
import com.example.serviceapp.LanourJob.data.JobEvent
import com.example.serviceapp.LanourJob.data.JobState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class JovViewModel :ViewModel() {

    val jobRepository : jobRepository = JobRepositoryImpl()
    val _state = MutableStateFlow(JobState())
    val state = _state.asStateFlow()


    fun onEvent(events:JobEvent){

        when(events){
            is JobEvent.SaveJob ->{
                saveJobData(events.jobDet)
            }
        }
    }


    fun saveJobData(jobData:Detail){

        viewModelScope.launch {
            jobRepository.saveJob(jobData)
        }
    }
}