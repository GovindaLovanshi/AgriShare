package com.example.serviceapp.LanourJob.data

import com.example.serviceapp.LanourJob.Model.Detail

data class JobState(
    val isLoading :Boolean = true,
    val jobList : List<Detail> = emptyList()
)
