package com.example.appcademycourse.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.RangeSliderState
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SliderState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun MySlider(modifier: Modifier = Modifier) {
    var MyValue by rememberSaveable { mutableStateOf(0.45f) }
    Column(modifier = modifier) {
        Slider(
            value = MyValue,
            onValueChange = { MyValue = it },
            colors = SliderDefaults.colors(
                thumbColor = Color.Red,
                activeTrackColor = Color.Green,
                inactiveTrackColor = Color.Blue,
                activeTickColor = Color.Yellow,
                inactiveTickColor = Color.Magenta,
                disabledThumbColor = Color.Cyan,
                disabledActiveTrackColor = Color.DarkGray,
                disabledInactiveTrackColor = Color.LightGray,
                disabledActiveTickColor = Color.Black,
                disabledInactiveTickColor = Color.White
            ))
        Text(text = MyValue.toString())
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MySliderAdvanced(modifier: Modifier = Modifier) {
    var msg by rememberSaveable { mutableStateOf("Oh No") }
val state = rememberSaveable { SliderState(
    value = 5f,
    valueRange = 0f..10f,
    steps = 9,
    onValueChangeFinished = {msg = "Happy Happy"}
) }
    Column(modifier = modifier) {
        Slider(state = state)
        Text(text = msg)

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MyRangeSlider(modifier: Modifier = Modifier) {
    val state = rememberSaveable { RangeSliderState(
        activeRangeStart = 3f,
        activeRangeEnd = 6f,
        valueRange = 0f..10f,
        steps = 9,
        onValueChangeFinished = {}
    ) }
    Column(modifier = modifier){
        RangeSlider(state = state)
    }
}