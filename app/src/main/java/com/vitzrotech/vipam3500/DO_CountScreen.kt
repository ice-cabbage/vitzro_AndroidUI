package com.vitzrotech.vipam3500

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme

@Composable
fun DO_CountScreen(viewModel: SharedViewModel) {

}

@Preview
@Composable
fun DO_CountScreenPreview() {
    VIPAM3500Theme {
        DO_CountScreen(viewModel())
    }
}