package com.vitzrotech.vipam3500

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme

data class Breaker (
    val name: String = "",
    val des: String = ""
)

data class aker (
    val na: String = "",
    val descr: Float = 0.0f
)

@Composable
fun Breaker_Screen(viewModel: SharedViewModel) {
    
}

@Composable
@Preview
fun Breaker_ScreenPreview() {
    VIPAM3500Theme {
        Breaker_Screen(viewModel())
    }
}