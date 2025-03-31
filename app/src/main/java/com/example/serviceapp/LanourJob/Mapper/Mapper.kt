package com.example.serviceapp.LanourJob.Mapper

import com.example.serviceapp.LanourJob.Model.Detail
import com.example.serviceapp.LanourJob.data.JobGetData
import java.util.UUID

fun Detail.JobgetData() : JobGetData {

    return JobGetData(
        Call = Call,
        Address = Address,
        date = System.currentTimeMillis(),
        Id =  UUID.randomUUID().toString(),
        Title = Title,
        Description = Description,
        ImagePath = ImagePath
    )
}