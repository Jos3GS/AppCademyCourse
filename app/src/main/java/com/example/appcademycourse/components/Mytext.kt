package com.example.appcademycourse.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview(showSystemUi = true)
@Composable
fun MyText(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "Mechas")
        Text(text = "Mechas Verde", color = Color.Green)
        Text(text = "Mechas grande", fontSize = 22.sp)
        Text(text = "Mechas italic", fontStyle = FontStyle.Italic)
        Text(
            text = "Mechas Pesado",
            fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Italic,
            fontSize = 22.sp
        )
        Text(text = "Mechas espaciado", letterSpacing = 12.sp)
        Text(
            text = "Mechas decorado",
            textDecoration = TextDecoration.LineThrough + TextDecoration.Underline
        )
        Text(
            text = "Mechas Alineado",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

    }
}