package com.vitzrotech.vipam3500

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme

@Composable
fun NCHR_Screen(viewModel: SharedViewModel) {

}

@Composable
@Preview
fun NCHR_ScreenPreview() {
    VIPAM3500Theme {
        NCHR_Screen(viewModel())
    }
}