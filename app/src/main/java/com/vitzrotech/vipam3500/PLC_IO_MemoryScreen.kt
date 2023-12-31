package com.vitzrotech.vipam3500

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme

@Composable
fun PLC_IO_MemoryScreen(viewModel: SharedViewModel) {

}

@Preview
@Composable
fun PLC_IO_MemoryScreenPreview() {
    VIPAM3500Theme {
        PLC_IO_MemoryScreen(viewModel())
    }
}