package com.example.appcademycourse.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun MyComplexLayout(modifier: Modifier = Modifier){
    Column(modifier = modifier.fillMaxSize()){
        Box(modifier = Modifier.weight(1f).fillMaxWidth().background(Color.Red)){}
        Box(modifier = Modifier.weight(1f).fillMaxWidth().background(Color.Green)){}
        Box(modifier = Modifier.weight(1f).fillMaxWidth().background(Color.Cyan)){}
    }
}