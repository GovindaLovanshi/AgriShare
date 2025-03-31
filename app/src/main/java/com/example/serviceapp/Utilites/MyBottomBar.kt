package com.example.serviceapp.Utilites

import android.content.Intent
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick
import androidx.navigation.NavHostController
import com.example.serviceapp.MainActivity
import com.example.serviceapp.R


@Composable

fun MyBottomBar(
    navHostController: NavHostController,
    onClick: (index:Int) ->Unit,
    selectedItem: Int,
) {

    val items = listOf(

        NavigationItem("Home",R.drawable.home),
        NavigationItem("Job",R.drawable.job),
        NavigationItem("Search",R.drawable.fav_icon),
        NavigationItem("Profile",R.drawable.profile),
    )



//    NavigationBar (containerColor = Color.White,modifier = Modifier.height(80.dp)){
//
//        items.forEachIndexed{index, item ->
//
//            NavigationBarItem(
//                selected = selectedItem == index,
//                onClick = {onClick(index)},
//                label = {
//                    if(index == selectedItem){
//
//                        Text(text = item.name, color = Color.Black)
//                    }else{
//                        Text(text = item.name, color = Color.White)
//                    }
//                },
//                icon = {
//                    Icon(
//                        painter = if (
//                            index == selectedItem
//                        ) {
//                            painterResource(item.selectedItem)
//                        } else {
//                            painterResource(item.selectedItem)
//                        }, contentDescription = null,
//                        tint = if (index == selectedItem) {
//                            Color.Black
//
//                        } else {
//                            Color.White
//                        },
//                        modifier = Modifier.size(4.dp)
//                    )
//
//                    Spacer(modifier = Modifier.height(4.dp))
//
//
//                }
//                , colors = NavigationBarItemDefaults.colors(indicatorColor = colorResource(id = R.color.teal_700)))
//        }
//    }

}


data class NavigationItem(
    val name:String,
    @DrawableRes val selectedItem:Int
)


data class BottomNavItem(val name: String, val icon: ImageVector, val unseletedIcon: ImageVector)

