package com.example.serviceapp.Notification

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.annotation.RequiresApi

class LocalNotification:Application() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()

        val channel = NotificationChannel(BASIC_ID, BASIC_NAME,NotificationManager.IMPORTANCE_DEFAULT)

        val channel2= NotificationChannel(URGENT, URGENT_NAME,NotificationManager.IMPORTANCE_DEFAULT)

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

//        notificationManager.createNotificationChannels(channel)
    }
}