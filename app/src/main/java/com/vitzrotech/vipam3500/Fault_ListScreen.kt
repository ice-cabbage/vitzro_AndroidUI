package com.vitzrotech.vipam3500

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme

@Composable
fun Fault_ListScreen(viewModel: SharedViewModel) {

}

@Preview
@Composable
fun Fault_ListScreenPreview() {
    VIPAM3500Theme {
        Fault_ListScreen(viewModel())
    }
}