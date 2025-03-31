package com.example.serviceapp.Notification

import android.Manifest.permission.POST_NOTIFICATIONS
import android.app.Notification
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.example.serviceapp.R

fun BasicNotification(context:Context) {

    val notification = NotificationCompat.Builder(context, URGENT).setSmallIcon(android.R.drawable.bottom_bar)
        .build()

    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){

        if(ContextCompat.checkSelfPermission(
            context,POST_NOTIFICATIONS
        ) == PackageManager.PERMISSION_GRANTED){
            NotificationManagerCompat.from(context).notify(1,notification)
        }
    }else{
        NotificationManagerCompat.from(context).notify(1,notification)
    }
}

fun groupNotification(context:Context){

    val chatGroup = NotificationCompat.Builder(context, BASIC_ID)
        .setSmallIcon(R.drawable.fav_icon)
        .setContentTitle("Chat")
        .setContentText("new ")
        .setGroup("Chat").setGroupSummary(true).build()


    val firstNotification = NotificationCompat.Builder(context, BASIC_ID)
        .setSmallIcon(R.drawable.fav_icon)
        .setContentTitle("Chat")
        .setContentText("new ")
        .setGroup("Chat").setGroupSummary(true).build()

    val secondNotification =  NotificationCompat.Builder(context, BASIC_ID)
        .setSmallIcon(R.drawable.fav_icon)
        .setContentTitle("Chat")
        .setContentText("new ")
        .setGroup("Chat").setGroupSummary(true).build()


    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {

        if (ContextCompat.checkSelfPermission(
                context, POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            NotificationManagerCompat.from(context).apply {

                notify(1,chatGroup)
                notify(1,firstNotification)
                notify(1,secondNotification  )
            }
        }else{
            NotificationManagerCompat.from(context).apply {

                notify(1,chatGroup)
                notify(1,firstNotification)
                notify(1,secondNotification  )
            }
        }
    }
}

fun actionNoti(context:Context){

    val intent = Intent(context,JobReceiver::class.java)


    val pendingIntent =  PendingIntent.getBroadcast(context,2,intent,PendingIntent.FLAG_IMMUTABLE)

    val notification = NotificationCompat.Builder(context, BASIC_ID)
        .setSmallIcon(R.drawable.fav_icon)
        .setContentTitle("Chat")
        .addAction(android.R.drawable.btn_star,"Start",null).build()


    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){

        if(ContextCompat.checkSelfPermission(
                context,POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED){
            NotificationManagerCompat.from(context).notify(1,notification)
        }
    }else{
        NotificationManagerCompat.from(context).notify(1,notification)
    }

}

class JobReceiver:BroadcastReceiver(){
    override fun onReceive(p0: Context?, p1: Intent?) {
        Toast.makeText( p0,"start",Toast.LENGTH_SHORT).show()
    }

}