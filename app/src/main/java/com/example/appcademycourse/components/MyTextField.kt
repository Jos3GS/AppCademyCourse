package com.example.appcademycourse.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun MyTextFieldParent(modifier: Modifier = Modifier) {
    var user by rememberSaveable { mutableStateOf("") }
    Column(modifier = modifier) {
        MyTextField(user = user) { user = it }
        MySecondTextField(value = user) { user = it }
        MyAdvanecTextField(value = user) { user = it }
        MyPasswordTextField(value = user) { user = it }
        MyOutlinedTextField(value = user) { user = it }
    }
}

@Composable
fun MyTextField(user: String, onUserChange: (String) -> Unit) {
    Column() {
        TextField(value = user, onValueChange = { onUserChange(it) }, readOnly = user.isEmpty())
    }
}

@Composable
fun MySecondTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = { Text("Developer") }
    )

}

@Composable
fun MyAdvanecTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(value = value, onValueChange = {
        if (it.contains("a")) {
            onValueChange(it.replace("a", ""))
        } else {
            onValueChange(it)
        }

    })
}

@Composable
fun MyPasswordTextField(value: String, onValueChange: (String) -> Unit) {
    var passwordHidden by rememberSaveable { mutableStateOf(false) }
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        singleLine = true,
        label = {Text("Contraseña")},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if(passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            Text(text = if(passwordHidden) "Show" else "Hide", modifier = Modifier.clickable{passwordHidden = !passwordHidden})
        }
        )
}

@Composable
fun MyOutlinedTextField(value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = { Text("Developer") }
    )
}