package com.example.appcademycourse.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun MyButtonparent(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Button(
            onClick = { Log.i("Mechas", "Boton pulsado") },
            enabled = true,
            shape = RoundedCornerShape(80),
            border = BorderStroke(2.dp, Color.Red),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Red,
                containerColor = Color.Cyan,
                disabledContentColor = Color.White,
                disabledContainerColor = Color.LightGray
            )

        ) {
            Text("Button")
        }
        OutlinedButton(
            onClick = { },
            enabled = true,
            shape = RoundedCornerShape(80),

            ) {
            Text("Outlined Button")
        }
        TextButton(onClick = {}) {
            Text("Text Button")
        }
        ElevatedButton(onClick = {}) {
            Text("Elevated Button")
        }
        FilledTonalButton(onClick = {} ) {
            Text("Filled Tonal Button")
        }
    }

}

