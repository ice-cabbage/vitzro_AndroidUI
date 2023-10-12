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

data class Status (
    val DI: String = "",
    val unit: Int = 0
)

@Composable
fun DIDO_Screen(viewModel: SharedViewModel) {
    val fir by remember { viewModel.fir }
    val sec by remember { viewModel.sec }
    val thr by remember { viewModel.thr }
    val four by remember { viewModel.four }

    val dido = arrayOf(
        Status("DI", unit = 1),
        Status("DI", unit = 2),
        Status("DI", unit = 3),
        Status("DI", unit = 4),
        Status("DI", unit = 5),
        Status("DI", unit = 6),
        Status("DI", unit = 7),
        Status("DI", unit = 8),
        Status("DI", unit = 9),
        Status("DI", unit = 10),
        Status("DI", unit = 11),
        Status("DI", unit = 12),
        Status("DI", unit = 13),
        Status("DI", unit = 14),
        Status("DI", unit = 15),
        Status("DI", unit = 16),
        Status("DI", unit = 17),
        Status("DI", unit = 18),
        Status("DI", unit = 19),
        Status("DI", unit = 20),
        Status("DI", unit = 21),
        Status("DI", unit = 22),
        Status("DI", unit = 23),
        Status("DI", unit = 24),
        Status("DI", unit = 25),
        Status("DI", unit = 26),
        Status("DI", unit = 27),
        Status("DI", unit = 28),
        Status("DI", unit = 29),
        Status("DI", unit = 30),
        Status("DI", unit = 31),
        Status("DI", unit = 32),
        Status("DI", unit = 33),
        Status("DI", unit = 34),
        Status("DI", unit = 35),
        Status("DI", unit = 36),
        Status("DI", unit = 37),
        Status("DI", unit = 38),
        Status("DI", unit = 39),
        Status("DI", unit = 40)
    )
    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
        items(dido.size) {
            val v = dido[it]
            Row(Modifier.fillMaxWidth()) {

            }
        }
    }
}

@Preview
@Composable
fun DIDO_ScreenPreview() {
    VIPAM3500Theme {
        DIDO_Screen(viewModel())
    }
}