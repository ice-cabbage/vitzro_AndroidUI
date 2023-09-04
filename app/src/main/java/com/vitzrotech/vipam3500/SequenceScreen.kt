package com.vitzrotech.vipam3500

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme

@Composable
fun SequenceScreen(viewModel: SharedViewModel) {

}

@Preview
@Composable
fun SequenceScreenPreview() {
    VIPAM3500Theme {
        SequenceScreen(viewModel())
    }
}