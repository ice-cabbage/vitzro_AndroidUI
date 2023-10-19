package com.vitzrotech.vipam3500

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme

data class Breaker (
    val name: String = "",
    val des: String = ""
)

data class Aker (
    val na: String = "",
    val descr: Float = 0.0f
)

@Composable
fun Breaker_Screen(viewModel: SharedViewModel) {
    val mo by remember { viewModel.mo }
    val failure by remember { viewModel.failure }
    val delaySec by remember { viewModel.delaySec }
    val detect by remember { viewModel.detect }

    val fail = arrayOf(
        Breaker("Mode", mo),
        Breaker("Failure Mode", failure)
    )

    val ure = arrayOf(
        Aker("Delay Time (sec)", delaySec),
        Aker("Detection Current (x In)", detect)
    )

    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(0.6.dp, MaterialTheme.colorScheme.onBackground)) {
        items(fail.size) {
            val v = fail[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.name,
                    Modifier
                        .weight(0.4f)
                        .height(40.dp)
                        .border(0.6.dp, MaterialTheme.colorScheme.onBackground),
                    textAlign = TextAlign.Center
                )
                Text(
                    v.des,
                    Modifier
                        .weight(0.5f)
                        .height(40.dp)
                        .border(0.6.dp, MaterialTheme.colorScheme.onBackground),
                    textAlign = TextAlign.Center
                )
            }
        }
        items(ure.size) {
            val v = ure[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.na,
                    Modifier
                        .weight(0.4f)
                        .height(40.dp)
                        .border(0.6.dp, MaterialTheme.colorScheme.onBackground),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.descr.toUnitString("%.02f", "")}",
                    Modifier
                        .weight(0.5f)
                        .height(40.dp)
                        .border(0.6.dp, MaterialTheme.colorScheme.onBackground),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
@Preview
fun Breaker_ScreenPreview() {
    VIPAM3500Theme {
        Breaker_Screen(viewModel())
    }
}