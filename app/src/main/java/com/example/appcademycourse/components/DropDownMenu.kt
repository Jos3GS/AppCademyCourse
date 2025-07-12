package com.example.appcademycourse.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.example.appcademycourse.R
import kotlin.math.exp


@Preview(showBackground = true)
@Composable
fun MyDropDownMenu(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Box(modifier = modifier) {
        Button(onClick = { expanded = true }) {
            Text(text = "Ver Opciones")
        }
        DropdownMenu(
            modifier = Modifier,
            expanded = expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset(16.dp, 16.dp),
            properties = PopupProperties(
                focusable = true,
                dismissOnClickOutside = false,
                dismissOnBackPress = false
            )
        ) {
            DropdownMenuItem(text = { Text(text = "Opcion 1") }, onClick = { expanded = false })
            DropdownMenuItem(text = { Text(text = "Opcion 2") }, onClick = { expanded = false })
            DropdownMenuItem(text = { Text(text = "Opcion 3") }, onClick = { expanded = false })
            DropdownMenuItem(text = { Text(text = "Opcion 4") }, onClick = { expanded = false })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyDropDownMenuItem(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        DropdownMenuItem(
            text = {
                Text("Ejemplo 1")
            },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = ""
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = ""
                )
            },
            enabled = true,
            contentPadding = PaddingValues(16.dp),
            onClick = {}
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MyExposedDropDownMenu(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    var selection by rememberSaveable { mutableStateOf("") }
    ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = !expanded }) {
        TextField(
            value = selection,
            onValueChange = {},
            readOnly = true,
            label = { Text(text = "Idioma") },
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(),
            trailingIcon = {ExposedDropdownMenuDefaults.TrailingIcon(expanded)}
        )
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            DropdownMenuItem(text = { Text(text = "Opcion 1") }, onClick = {
                expanded = false
                selection = "Opcion 1"
            })
            DropdownMenuItem(text = { Text(text = "Opcion 2") }, onClick = {
                expanded = false
                selection = "Opcion 2"
            })
            DropdownMenuItem(text = { Text(text = "Opcion 3") }, onClick = {
                expanded = false
                selection = "Opcion 3"
            })
            DropdownMenuItem(text = { Text(text = "Opcion 4") }, onClick = {
                expanded = false
                selection = "Opcion 4"
            })
        }
    }
}