package com.vitzrotech.vipam3500

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Reactive_Screen(viewModel: SharedViewModel) {

}

@Composable
@Preview
fun Reactive_ScreenPreview() {
    Reactive_Screen(viewModel())
}