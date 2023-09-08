package com.vitzrotech.vipam3500

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme

@Composable
fun Operation_TimeScreen(viewModel: SharedViewModel) {

}

@Preview
@Composable
fun Operation_TimeScreenPreview() {
    VIPAM3500Theme {
        Operation_TimeScreen(viewModel())
    }
}