package com.vitzrotech.vipam3500

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.text.style.TextAlign
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme

data class Cold (
    val name: String = "",
    val mod: String = ""
)

data class Load (
    val time: String = "",
    val sec: Float = 0.0f
)

@Composable
fun ColdLoad_Screen(viewModel: SharedViewModel) {
    val coldMode by remember { viewModel.coldMode }
    val cbOpenTime by remember { viewModel.cbOpenTime }
    val activeTime by remember { viewModel.activeTime }
    val stopTime by remember { viewModel.stopTime }

    val pickup = arrayOf(
        Cold("Mode", coldMode)
    )

    val coldload = arrayOf(
        Load("CB Open Time (sec)", cbOpenTime),
        Load("Active Time (sec)", activeTime),
        Load("Stop Time (sec)", stopTime)
    )

    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(0.6.dp, Color.Black)) {
        items(pickup.size) {
            val v = pickup[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.name,
                    Modifier
                        .weight(0.4f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(
                    v.mod,
                    Modifier
                        .weight(0.5f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
            }
        }
        items(coldload.size) {
            val v = coldload[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.time,
                    Modifier
                        .weight(0.4f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.sec.toUnitString("%.02f", "")}",
                    Modifier
                        .weight(0.5f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
@Preview
fun ColdLoad_ScreenPreview() {
    VIPAM3500Theme {
        ColdLoad_Screen(viewModel())
    }
}