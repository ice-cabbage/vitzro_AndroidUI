package com.vitzrotech.vipam3500

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme

@Composable
fun DIDO_StatusScreen(viewModel: SharedViewModel) {

}

@Preview
@Composable
fun DIDO_StatusScreenPreview() {
    VIPAM3500Theme {
        DIDO_StatusScreen(viewModel())
    }
}