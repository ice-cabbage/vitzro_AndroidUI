package com.vitzrotech.vipam3500

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme


data class DIDO (
    val value: Float = 0.0f
)

@Composable
fun DIDO_StatusScreen(viewModel: SharedViewModel) {
    val diStatus2 by remember { viewModel.diStatus2 }
    val diStatus1 by remember { viewModel.diStatus1 }
    val doStatus2 by remember { viewModel.doStatus2 }
    val doStatus1 by remember { viewModel.doStatus1 }
}

@Preview
@Composable
fun DIDO_StatusScreenPreview() {
    VIPAM3500Theme {
        DIDO_StatusScreen(viewModel())
    }
}