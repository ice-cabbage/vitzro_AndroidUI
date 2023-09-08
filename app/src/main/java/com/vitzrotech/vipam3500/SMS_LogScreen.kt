package com.vitzrotech.vipam3500

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme

@Composable
fun SMS_LogScreen(viewModel: SharedViewModel) {

}

@Preview
@Composable
fun SMS_LogScreenPreview() {
    VIPAM3500Theme {
        SMS_LogScreen(viewModel())
    }
}