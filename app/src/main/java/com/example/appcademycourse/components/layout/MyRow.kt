package com.example.appcademycourse.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun MyRow(modifier: Modifier = Modifier){
    Row(modifier = modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround){
        Text("Hola", modifier = Modifier.background(Color.Red))
        Text("Hola", modifier = Modifier.background(Color.Blue))
        Text("Hola", modifier = Modifier.background(Color.Green))
        Text("Hola", modifier = Modifier.background(Color.Cyan))
        Text("Hola", modifier = Modifier.background(Color.Yellow))
    }
}