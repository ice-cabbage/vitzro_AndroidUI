package com.vitzrotech.vipam3500

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme

@Composable
fun PasswordDialog(password: String, onDismiss: ()-> Unit, onOK: ()-> Unit) {
    var typed by remember { mutableStateOf("") }
    var visible by rememberSaveable { mutableStateOf(false) }
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            modifier = Modifier
                .width(300.dp)
                .wrapContentHeight(),
            shape = RoundedCornerShape(12.dp),
            color = Color.White) {
            Column {
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = typed,
                    onValueChange = {value ->
                        typed = value
                    },
                    label = { Text(text = stringResource(id = R.string.password)) },
                    placeholder = { Text(text = stringResource(id = R.string.type_password)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 4.dp),
                    visualTransformation = if (visible) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                    trailingIcon = {
                        IconButton(onClick = { visible = !visible }) {
                            if (visible)
                                Icon(painterResource(R.drawable.ic_visibility), "Visibility")
                            else
                                Icon(
                                    painterResource(R.drawable.ic_visibility_off),
                                    "Visibility off"
                                )
                        }
                    }
                )
                ElevatedButton(
                    onClick = {
                        if (typed == password) onOK()
                        onDismiss()
                        typed = ""
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 4.dp)) {
                    Text("OK")
                }
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Preview
@Composable
fun PasswordDialogPreview() {
    VIPAM3500Theme {
        PasswordDialog("", onDismiss = {}) {}
    }
}