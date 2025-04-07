package com.example.serviceapp.Equipment

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import coil.compose.AsyncImage
import com.example.serviceapp.R


@Preview
@Composable
fun Category(){

    Row(
        Modifier
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp)
    ) {
        Text(
            text = "Popular Stores",
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "See all",
            color = Color.Black,
            fontSize = 16.sp,

            style = TextStyle(textDecoration = TextDecoration.Underline)
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
            ItemsPopular()
            ItemsPopular()
        }
    }


}

@Composable
fun ItemsPopular() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .wrapContentSize()
            .background(Color.White, shape = RoundedCornerShape(10.dp))
            .padding(8.dp)

    ) {
        Image(
            painterResource(id = R.drawable.road),
            contentDescription = null,
            modifier = Modifier
                .size(135.dp, 90.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(colorResource(R.color.grey), shape = RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop
        )
        Text(
            text="JCB",
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(top=8.dp)
        )
        Row(
            Modifier.padding(top=8.dp)
        ){
            Image(painter = painterResource(R.drawable.location),contentDescription = null)
            Text(
                text="Indore",
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(start =8.dp)
            )
        }
    }
}