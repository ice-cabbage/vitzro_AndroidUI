package com.vitzrotech.vipam3500

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme

@Composable
fun CompanyScreen(viewModel: SharedViewModel) {

}

@Composable
@Preview
fun CompanyScreenPreview() {
    VIPAM3500Theme {
        CompanyScreen(viewModel())
    }
}