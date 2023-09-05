package com.vitzrotech.vipam3500

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme

@Composable
fun K_C_factorScreen(viewModel: SharedViewModel) {

}

@Preview
@Composable
fun K_C_factorScreenPreview() {
    VIPAM3500Theme {
        K_C_factorScreen(viewModel())
    }
}