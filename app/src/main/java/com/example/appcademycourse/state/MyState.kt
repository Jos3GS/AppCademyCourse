package com.example.appcademycourse.state

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier

@Composable
fun MyState() {
    var number by rememberSaveable { mutableStateOf(0) }
    Text("Pulsame: ${number}", modifier = Modifier.clickable { number += 1 })
}