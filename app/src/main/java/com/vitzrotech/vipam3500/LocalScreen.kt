package com.vitzrotech.vipam3500

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme

@Composable
fun LocalScreen(password: String, onDismiss: () -> Unit, onOK: () -> Unit) {
    var typed by remember { mutableStateOf("") }
    var visible by remember { mutableStateOf(false) }
    Dialog(onDismissRequest = onDismiss) {
        Surface (

        )
    }
}

@Composable
@Preview
fun LocalScreenPreview() {
    VIPAM3500Theme {
        LocalScreen("", onDismiss = {}) {}
    }
}