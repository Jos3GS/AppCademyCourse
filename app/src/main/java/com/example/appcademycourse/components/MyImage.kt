package com.example.appcademycourse.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.appcademycourse.R

@Preview
@Composable
fun MyImage(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier.size(200.dp),
            contentScale = ContentScale.Crop
        )

        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(35))
                .border(
                    width = 5.dp,
                    shape = RoundedCornerShape(35),
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color.Red,
                            Color.Cyan,
                            Color.Yellow
                        )
                    )
                ),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview
@Composable
fun MyNetworkImage(modifier: Modifier = Modifier) {
    AsyncImage(
        model = "https://www.concierto.cl/wp-content/uploads/2024/03/dua-lipa-confirma-los-detalles-de-su-proximo-album-radical-optimism-jpg.webp",
        contentDescription = "Image from network",
        modifier = Modifier.size(200.dp),
        onError = {
            Log.i("Image", "Ha ocurrido un error ${it.result}")
        }
    )
}

@Preview
@Composable
fun MyIcon(modifier: Modifier = Modifier) {
    Icon(
        painter = painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = null,
        tint = Color.Red
    )
}