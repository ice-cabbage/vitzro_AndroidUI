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

data class Super (
    val name: String = "",
    val sv25: String = "",
    val sv50: String = "",
    val sv15: String = ""
)

data class Vision (
    val delay: String = "",
    val sv2: Float = 0.0f,
    val sv5: Float = 0.0f,
    val sv1: Float = 0.0f
)

@Composable
fun Supervision_Screen(viewModel: SharedViewModel) {
    val sv25M by remember { viewModel.sv25M }
    val sv25P by remember { viewModel.sv25P }
    val sv25D by remember { viewModel.sv25D }

    val sv50M by remember { viewModel.sv50M }
    val sv50P by remember { viewModel.sv50P }
    val sv50D by remember { viewModel.sv50D }

    val sv150M by remember { viewModel.sv150M }
    val sv150P by remember { viewModel.sv150P }
    val sv150D by remember { viewModel.sv150D }

    val mode = arrayOf(
        Super("Mode", "SV 2.5V", "SV 5.0V", "SV 15.0V")
    )

    val pickUp = arrayOf(
        Vision("Pick Up (V)", sv25P, sv50P, sv150P)
    )

    val delaySec = arrayOf(
        Vision("Delay (sec)", sv25D, sv50D, sv150D)
    )

    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(0.6.dp, Color.Black)) {
        items(mode.size) {
            val v = mode[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.name,
                    Modifier
                        .weight(0.2f)
                        .height(40.dp)
                        .border(1.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(v.sv25,
                    Modifier
                        .weight(0.1f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(v.sv50,
                    Modifier
                        .weight(0.1f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(v.sv15,
                    Modifier
                        .weight(0.1f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
            }
        }
        items(pickUp.size) {
            val v = pickUp[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.delay,
                    Modifier
                        .weight(0.2f)
                        .height(40.dp)
                        .border(1.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.sv2.toUnitString("%.02f", "")}",
                    Modifier
                        .weight(0.1f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.sv5.toUnitString("%.02f", "")}",
                    Modifier
                        .weight(0.1f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.sv1.toUnitString("%.02f", "")}",
                    Modifier
                        .weight(0.1f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
            }
        }
        items(delaySec.size) {
            val v = delaySec[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.delay,
                    Modifier
                        .weight(0.2f)
                        .height(40.dp)
                        .border(1.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.sv2.toUnitString("%.02f", "")}",
                    Modifier
                        .weight(0.1f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.sv5.toUnitString("%.02f", "")}",
                    Modifier
                        .weight(0.1f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.sv1.toUnitString("%.02f", "")}",
                    Modifier
                        .weight(0.1f)
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
fun Supervision_ScreenPreview() {
    VIPAM3500Theme {
        Supervision_Screen(viewModel())
    }
}