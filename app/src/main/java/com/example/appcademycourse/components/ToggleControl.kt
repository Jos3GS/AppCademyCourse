package com.example.appcademycourse.components

import android.R.attr.name
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appcademycourse.R

@Preview
@Composable
fun MyToggleControl(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        MySwitch(modifier)
        MyCheckBox(modifier)
        MyGroupCheckBox(modifier)
        MyTriStateCheckBox(modifier)
        MyRadioButton(modifier)
        MyRadioButtonList(modifier)
    }
}

@Composable
fun MyRadioButtonList(modifier:Modifier = Modifier) {
    var selectedName by rememberSaveable { mutableStateOf("") }
    Column(modifier){
        RadioButtonComponent(name = "Jose", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent(name = "Aris", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent(name = "Valeria", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent(name = "Gladys", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent(name = "Toño", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent(name = "Lucia", selectedName = selectedName) { selectedName = it }

    }
}

@Composable
fun RadioButtonComponent(name: String,selectedName: String, onItemSelected: (String) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically){
        RadioButton(
            selected = name == selectedName,
            onClick = {onItemSelected(name)}
        )
        Text(name)
    }
}

@Composable
fun MyRadioButton(modifier:Modifier = Modifier) {
    var state by rememberSaveable { mutableStateOf(true) }
    RadioButton(
        modifier = modifier,
        selected = state,
        onClick = { state = !state},
        enabled = true,
        colors = RadioButtonDefaults.colors(
            selectedColor = Color.Green,
            unselectedColor = Color.Red,
            disabledSelectedColor = Color.DarkGray,
            disabledUnselectedColor = Color.LightGray
        )
    )
}

@Composable
fun MySwitch(modifier: Modifier = Modifier) {
    Switch(
        checked = true,
        onCheckedChange = null,
        modifier = modifier,
        thumbContent = {
            Icon(
                painter = painterResource(
                    id = R.drawable.ic_launcher_foreground
                ), contentDescription = null
            )
        },
        enabled = true,
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.Magenta,
            uncheckedThumbColor = Color.Yellow,
            disabledCheckedThumbColor = Color.DarkGray,
            disabledUncheckedThumbColor = Color.LightGray
        )
    )
}

@Composable
fun MyCheckBox(modifier: Modifier = Modifier) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = true,
            onCheckedChange = null,
            modifier = modifier,
            enabled = false
        )
        Spacer(Modifier.width(12.dp))
        Text("My Checkbox")
    }
}

@Composable
fun MyGroupCheckBox(modifier: Modifier = Modifier) {
    var state by rememberSaveable {
        mutableStateOf(
            listOf(
                CheckBoxState(
                    "Terms",
                    "Aceptar terminos y condiciones"
                ),
                CheckBoxState(
                    "NewsLetter",
                    "Recibir newsletter",
                    checked = true
                ),
                CheckBoxState(
                    "updates",
                    "Recibir actualizaciones"
                )

            )
        )
    }
    Column(modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        state.forEach { myState ->
            MyCheckBoxWithText(checkBoxState = myState) {
                state = state.map {
                    if (it.id == myState.id){
                        myState.copy(checked = !myState.checked)
                    }else{
                        it
                    }
                }
            }
        }
    }
}

@Composable
fun MyCheckBoxWithText(
    checkBoxState: CheckBoxState,
    modifier: Modifier = Modifier,
    onCheckedState: (CheckBoxState) -> Unit
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checkBoxState.checked,
            onCheckedChange = { onCheckedState(checkBoxState) },
            modifier = modifier,
            enabled = false
        )
        Spacer(Modifier.width(12.dp))
        Text(checkBoxState.label)
    }
}

@Composable
fun MyTriStateCheckBox(modifier: Modifier = Modifier) {
    var parentState by rememberSaveable { mutableStateOf(ToggleableState(false)) }
    var child1 by rememberSaveable { mutableStateOf(true) }
    var child2 by rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(child1,child2) {
        parentState = when{
            child1 && child2 -> ToggleableState.On
            !child1 && !child2 -> ToggleableState.Off
            else -> ToggleableState.Indeterminate
        }
    }
    Column(modifier) {
        Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
            TriStateCheckbox(
                state = parentState,
                onClick = {
                    val newState = parentState !=ToggleableState.On
                    child1 = newState
                    child2 = newState
                },
                modifier = modifier,
                enabled = true
            )
            Spacer(Modifier.width(12.dp))
            Text("My Checkbox parent")
        }
        Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = child1,
                onCheckedChange = {child1 = !child1},
                modifier = modifier,
                enabled = true
            )
            Spacer(Modifier.width(12.dp))
            Text("My Checkbox child")
        }
        Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = child2,
                onCheckedChange = { child2= !child2 },
                modifier = modifier,
                enabled = true
            )
            Spacer(Modifier.width(12.dp))
            Text("My Checkbox child")
        }
    }
}