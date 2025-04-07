package com.example.serviceapp.MarketPlace

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.serviceapp.R

@Preview
@Composable
fun ItemDetailsScreen(){


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {


        Image(
            painter = painterResource(R.drawable.road),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(290.dp)
                .background(
                    colorResource(R.color.lightGrey),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(16.dp)
        )



        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(
                text = "JCB",
                fontSize = 23.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(end = 16.dp)
            )
//            Text(
//                text = "300 Pr/Day",
//                fontSize = 22.sp
//            )
        }
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            modifier = Modifier.padding(top = 16.dp)
//        ) {
//            Text(
//                text = "Previous Booking",
//                fontWeight = FontWeight.Bold,
//                modifier = Modifier.weight(1f)
//            )
//            Image(
//                painter = painterResource(id = R.drawable.fav_icon),
//                contentDescription = null,
//                modifier = Modifier.padding(end = 8.dp)
//            )
//            Text(text = " Rating", style = MaterialTheme.typography.bodyMedium)
//
//        }


        Spacer(modifier = Modifier.height(12.dp))


        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Spacer(modifier = Modifier.height(12.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {

                Text(
                    text = "Rate",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    maxLines = 1,
                    modifier = Modifier.padding(start = 4.dp)
                )

                Spacer(modifier = Modifier.width(200.dp))

                Text(
                    text = "Quantity",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    maxLines = 1,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(30.dp))


            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.shadow(2.dp, shape = CircleShape).fillMaxWidth()) {
                Image(painter = painterResource(R.drawable.homed),
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp).
                        padding(start = 12.dp)
                        .clip(CircleShape),

                    )

                Spacer(modifier = Modifier.width(15.dp))
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "Seller Name",
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Text(
                            text = "Address",
                            color = Color.Black,
                            fontSize = 12.sp,
                            maxLines = 1,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }

                }
                Row{

                    Image(painter = painterResource(R.drawable.bluecall),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)

                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))


            Text(
                text = "About The Item",
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1
            )

            HorizontalDivider()
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "",
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
            )


            Spacer(modifier = Modifier.height(150.dp))
            HorizontalDivider()
            Button(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
                ,
                onClick = { /* TODO: Implement click action */ },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Color.Blue)
            ) {
                androidx.compose.material3.Text(
                    text = "Buy ", color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
            }


        }
    }
}
//
//@Composable
//fun RatingBar(rating: Double) {
//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = Modifier.padding(top = 16.dp)
//    ) {
//        Text(
//            text = "Select Model",
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier.weight(1f)
//        )
//        Image(
//            painter = painterResource(id = R.drawable.fav_icon),
//            contentDescription = null,
//            modifier = Modifier.padding(end = 8.dp)
//        )
//        Text(text = "$rating Rating", style = MaterialTheme.typography.bodyMedium)
//
//    }
//}