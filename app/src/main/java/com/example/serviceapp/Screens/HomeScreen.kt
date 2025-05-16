package com.example.serviceapp.Screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.bottombar.AnimatedBottomBar
import com.example.bottombar.components.BottomBarItem
import com.example.bottombar.model.IndicatorDirection
import com.example.bottombar.model.IndicatorStyle
import com.example.serviceapp.Equipment.Category
import com.example.serviceapp.Equipment.ItemsPopular
import com.example.serviceapp.Equipment.Model.EquipmentModel
import com.example.serviceapp.LanourJob.JobList
import com.example.serviceapp.LanourJob.JobViewModel.jobViewModel
import com.example.serviceapp.LanourJob.Model.JobModel
import com.example.serviceapp.LanourJob.Model.jobdetailsmodel
import com.example.serviceapp.R
import com.example.serviceapp.Utilites.BottomNavItem
import com.example.serviceapp.Utilites.MyBottomBar

import com.example.serviceapp.navigation.Routes


@Composable
fun HomeScreen(navHostController: NavHostController){
    val context = LocalContext.current

    var selectedItem by remember { mutableIntStateOf(0) }
    val shouldShowBottomBar = remember { mutableStateOf(true) }

    val JobViewmodel : jobViewModel = viewModel()
    val formDataList = JobViewmodel.formDataList

    LaunchedEffect(true) {
        JobViewmodel.getFormData()
    }

    val BottomNavItem = listOf(
        BottomNavItem("Home", Icons.Default.Home, unseletedIcon = Icons.Outlined.Home),
        BottomNavItem("Job", Icons.Default.AddCircle, unseletedIcon = Icons.Outlined.AddCircle),
        BottomNavItem("Market", Icons.Default.Menu, unseletedIcon = Icons.Outlined.Menu),
        BottomNavItem("Equipment", Icons.Default.Person, unseletedIcon = Icons.Outlined.Person),
        BottomNavItem("Setting", Icons.Default.Person, unseletedIcon = Icons.Outlined.Settings),
        )


    Scaffold(
        topBar = {
            TopBar(navHostController)
        },

        bottomBar = {


            if (shouldShowBottomBar.value) {

                Surface( modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        bottom = WindowInsets.navigationBars            // this automaticaly adjust the hight of app bottom bar according to system navigation home, back etc
                            .asPaddingValues()
                            .calculateBottomPadding()
                    )
                    // Fixed height for bottom bar
//                    color = Color.Cyan,
                ) {
                    AnimatedBottomBar(


                        selectedItem = selectedItem,
                        itemSize = BottomNavItem.size,


//                        modifier = Modifier.padding(bottom =  WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()),

                        containerColor = Color.Transparent,
                        // indicatorColor = MaterialTheme.colorScheme.primaryContainer,
                        indicatorColor = colorResource(id = R.color.teal_700),
                        contentColor = MaterialTheme.colorScheme.primary,

                        indicatorDirection = IndicatorDirection.BOTTOM,

                        indicatorStyle = IndicatorStyle.FILLED,







                        ) {
                        BottomNavItem.forEachIndexed { index, navigationItem ->
                            BottomBarItem(
                                modifier = Modifier.align(alignment = Alignment.Top),
                                selected = selectedItem == index,
                                onClick = {

                                    selectedItem = index
                                    when (index) {
                                        0 -> navHostController.navigate(Routes.HomeScreen)
                                        1 -> navHostController.navigate(Routes.LabourJobScreen)
                                        2 -> navHostController.navigate(Routes.Market)
                                        3 -> navHostController.navigate(Routes.listequipment)
                                        4 -> navHostController.navigate(Routes.SettingScreen)
                                    }




                                },
                                imageVector = navigationItem.icon,
                                label = navigationItem.name,
                                containerColor = Color.Transparent,
                            )
                        }
                    }

                }


            }
//            MyBottomBar(navHostController , selectedItem = 0, onClick = { index ->
//
//                when(index){
//
//                    0 -> {navHostController.navigate(Routes.HomeScreen)}
//                    1 -> {navHostController.navigate(Routes.LabourJobScreen)}
//                    2 -> {navHostController.navigate(Routes.Market)}
//                    3 -> {navHostController.navigate(Routes.Market)}
//                }
//
//            })
        }
    ) { paddingValues ->
        LazyColumn(
            Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(paddingValues)
                .background(color = colorResource(R.color.lightBlue)),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {


//            item {
//                Search()
//            }

           item {
               Row(
                   Modifier
                       .padding(horizontal = 16.dp)
                       .padding(top = 16.dp)
               ) {
                   Text(
                       text = "Popular Equipment",
                       color = Color.Black,
                       fontSize = 20.sp,
                       fontWeight = FontWeight.SemiBold,
                       modifier = Modifier.weight(1f)
                   )
                   Text(
                       text = "See all",
                       color = Color.Black,
                       fontSize = 16.sp,

                       style = TextStyle(textDecoration = TextDecoration.Underline),
                       modifier = Modifier.clickable {
                           navHostController.navigate(Routes.LabourJobScreen)
                       }
                   )
               }

               LazyRow(
                   modifier = Modifier
                       .fillMaxWidth(),
                   horizontalArrangement = Arrangement.spacedBy(12.dp),
                   contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 8.dp)
               ) {
                   item {
                       ItemsPopular()
                       Spacer(modifier = Modifier.width(10.dp))
                       ItemsPopular()
                       Spacer(modifier = Modifier.width(10.dp))
                       ItemsPopular()
                   }
               }
           }

            item{
                Row(
                    Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 16.dp)
                ) {
                    Text(
                        text = "Latest Jobs",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = "See all",
                        color = Color.Black,
                        fontSize = 16.sp,

                        style = TextStyle(textDecoration = TextDecoration.Underline),
                        modifier = Modifier.clickable {
                            navHostController.navigate(Routes.LabourJobScreen)
                        }
                    )
                }
            }



            items(formDataList) { data->
                List(data, onClick = {
                })

            }

        }
    }

}



@Composable
fun List(JobModel: jobdetailsmodel,
         onClick: () -> Unit){
    val context = LocalContext.current
    Column   (
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 8.dp)
        ,
        verticalArrangement = Arrangement.spacedBy(12.dp),

    ){
        Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(10.dp))
                    .wrapContentHeight()
                    .padding(8.dp)

            ) {

                Image(painter = painterResource(R.drawable.cartoon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(95.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(colorResource(R.color.grey), shape = RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(start = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = JobModel.title,
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(painter = painterResource(R.drawable.location), contentDescription = null)
                        Text(
                            text = JobModel.address,
                            color = Color.Black,
                            fontSize = 12.sp,
                            maxLines = 1,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                    Text(
                        text = "15-05-25",
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1
                    )
                    Text(
                        text = "₹2000",
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1
                    )
                }


            }
        }

    }


@Composable
fun TopBar(navHostController: NavHostController) {
    val horizontalPadding = 16.dp
    val verticalPadding = 16.dp

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        val (bluebox, title1, title2, profile, building, whiteBox) = createRefs()

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(255.dp)
            .background(color = colorResource(R.color.darkGreen))
            .constrainAs(bluebox) {
                top.linkTo(parent.top)
            }
        )

//        Image(painter = painterResource(R.drawable.profile),
//            contentDescription = null,
//            modifier = Modifier.constrainAs(building) {
//                bottom.linkTo(bluebox.bottom)
//            }
//        )
        Image(painter = painterResource(R.drawable.profile),
            contentDescription = null,
            modifier = Modifier
                .padding(horizontal = horizontalPadding, vertical = verticalPadding)
                .constrainAs(profile) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
        )

        Text(
            text = "सुप्रभात! ",
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier
                .constrainAs(title1) {
                    top.linkTo(profile.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Text(
            text = "आज आप क्या कर रहे हैं? \uD83D\uDE0A",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .constrainAs(title2) {
                    top.linkTo(title1.bottom)
                    bottom.linkTo(whiteBox.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        ConstraintLayout(modifier = Modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth()
            .height(110.dp)
            .background(color = Color.White, shape = RoundedCornerShape(10.dp))
            .constrainAs(whiteBox) {
                top.linkTo(bluebox.bottom)
                bottom.linkTo(bluebox.bottom)
            }
            .clip(RoundedCornerShape(10.dp))
        ) {
            val (icon1, icon2, balance, reward, amount, wallet, arrow1, arrow2, arrow3, line1, line2) = createRefs()

            Image(painter = painterResource(R.drawable.mar),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = horizontalPadding, top = verticalPadding)
                    .width(20.dp)
                    .height(20.dp)
                    .constrainAs(icon1) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
            )

            Text(
                text = "Market ",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                style = TextStyle(textDecoration = TextDecoration.Underline),
                modifier = Modifier
                    .padding(start = 8.dp)
                    .constrainAs(wallet) {
                        bottom.linkTo(icon1.bottom)
                        start.linkTo(icon1.end)
                    }
                    .clickable {
                        navHostController.navigate(Routes.Market)
                    }
            )
            Image(painter = painterResource(R.drawable.arrow),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = horizontalPadding)
                    .constrainAs(arrow1) {
                        top.linkTo(wallet.top)
                        bottom.linkTo(wallet.bottom)
                        start.linkTo(wallet.end)
                    }
            )

            Image(painter = painterResource(R.drawable.harvester),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = horizontalPadding, bottom = verticalPadding)
                    .width(20.dp)
                    .height(20.dp)
                    .constrainAs(icon2) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                    }
            )

            Text(
                text = "Equipment",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                style = TextStyle(textDecoration = TextDecoration.Underline),
                modifier = Modifier
                    .padding(start = 8.dp)
                    .constrainAs(reward) {
                        top.linkTo(icon2.top)
                        start.linkTo(icon2.end)
                    }
            )

            Image(painter = painterResource(R.drawable.arrow),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = horizontalPadding)
                    .constrainAs(arrow2) {
                        top.linkTo(reward.top)
                        bottom.linkTo(reward.bottom)
                        start.linkTo(reward.end)
                    }
            )

            Box(modifier = Modifier
                .width(1.dp)
                .fillMaxHeight()
                .padding(vertical = verticalPadding)
                .background(colorResource(R.color.grey))
                .constrainAs(line1) {
                    centerTo(parent)
                }
            )
            Box(Modifier
                .height(1.dp)
                .width(170.dp)
                .padding(horizontal = 16.dp)
                .background(colorResource(R.color.grey))
                .constrainAs(line2) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                }

            )
            Text(
                text = "List of Job",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                style = TextStyle(textDecoration = TextDecoration.Underline),
                color = Color.Black,
                modifier = Modifier
                    .padding(start = horizontalPadding, top = 32.dp)
                    .constrainAs(balance) {
                        top.linkTo(parent.top)
                        start.linkTo(line1.end)
                    }
            )
            Text(
                text = "Switch",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,

                color = Color.Black,
                modifier = Modifier
                    .padding(start = horizontalPadding, top = 8.dp)
                    .constrainAs(amount) {
                        top.linkTo(balance.bottom)
                        start.linkTo(balance.start)
                    }
                    .clickable {
                        navHostController.navigate(Routes.LabourJobScreen)
                    }
            )
            Image(painter = painterResource(R.drawable.arrow),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = horizontalPadding)
                    .constrainAs(arrow3) {

                        bottom.linkTo(amount.bottom)
                        start.linkTo(amount.end)
                    }
            )
        }
    }
}

//@Composable
//@Preview
//fun Search(){
//    var text by rememberSaveable { mutableStateOf("") }
//    androidx.compose.material.TextField(
//        value = text,
//        onValueChange = { text = it },
//        label = {
//            Text(
//                text = "Searching.....",
//                fontSize = 16.sp,
//                color = Color.Black
//            )
//        }, shape = RoundedCornerShape(10.dp),
//        leadingIcon = {
//            Image(
//                painter = painterResource(R.drawable.search_icon),
//                contentDescription = null,
//                modifier = Modifier.size(22.dp)
//            )
//        },
//        colors = androidx.compose.material.TextFieldDefaults.outlinedTextFieldColors(
//            backgroundColor = colorResource(R.color.white),
//            focusedBorderColor = Color.Transparent,
//            unfocusedLabelColor = Color.Transparent,
//            textColor = Color.DarkGray,
//            unfocusedBorderColor = Color.Transparent
//        ),
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//            .height(50.dp)
//            .background(colorResource(R.color.grey), CircleShape)
//    )
//}

data class BottomNavItem(val name: String, val icon: ImageVector, val unseletedIcon: ImageVector)

