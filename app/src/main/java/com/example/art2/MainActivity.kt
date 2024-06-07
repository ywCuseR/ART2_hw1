package com.example.art2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeLayout() // 在setContent中调用MyComposeLayout()函数以显示UI
        }
    }
}

@Composable
fun MyComposeLayout() {
    var imageIndex by remember { mutableIntStateOf(0) }
    var textsIndex by remember { mutableIntStateOf(0) }

    val images = listOf(R.drawable._1, R.drawable._2, R.drawable._3,
        R.drawable._4, R.drawable._5, R.drawable._6,
        R.drawable._7, R.drawable._8, R.drawable._9, R.drawable._10)
    val texts = listOf(
        "Taipei 101", "Eluanbi Park", "Alishan Forest Railways", "Yehliu Geopark",
        "Sun Moon Lake", "Liberty Square (CKS Memorial Hall)",
        "Fishing Boat",  "windmill", "Jiufen Old Street",
        "hot air balloon")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(id = images[imageIndex]),
            contentDescription = null,
            modifier = Modifier.size(250.dp)
        )
        BasicText(
            text = texts[textsIndex],
            modifier = Modifier.padding(top = 8.dp)
        )

        // 按钮列
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 32.dp)
        ) {
            Button(
                onClick = {
                    imageIndex = (imageIndex + 1) % images.size
                    textsIndex = (textsIndex + 1) % texts.size },
                modifier = Modifier.padding(end = 90.dp)
            ) {
                BasicText(text = "NEXT")
            }

            Button(
                onClick = {
                    imageIndex = if (imageIndex == 0) images.size - 1 else imageIndex - 1
                    textsIndex = if (textsIndex == 0) texts.size - 1 else textsIndex - 1 },
                modifier = Modifier.padding(start = 80.dp)
            ) {
                BasicText(text = "PREVIOUS")
            }
        }
    }
}