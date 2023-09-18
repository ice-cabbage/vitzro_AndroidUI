package com.vitzrotech.vipam3500

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme

data class Mand (
    val name: String = "",
    val year: Int = 0,
    val mon: Int = 0,
    val day: Int = 0,
    val hour: Int = 0,
    val min: Int = 0,
    val sec: Int = 0,
    val ms: Int = 0,
    val flva: Float = 0.0f,
    val unit: String = "",
    val phase: Float = 0.0f
)

@Composable
fun DemandScreen(viewModel: SharedViewModel) {
    
}

@Preview
@Composable
fun DemandScreenPreview() {
    VIPAM3500Theme {
        DemandScreen(viewModel())
    }
}