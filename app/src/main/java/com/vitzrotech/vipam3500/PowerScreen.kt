package com.vitzrotech.vipam3500

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.layout.fillMaxWidth
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

data class Power (
    val name: String = "",
    val watt: Float = 0.0f
)

@Composable
fun PowerScreen(viewModel: SharedViewModel) {
    val wAMag by remember { viewModel.wAMag }
    val wBMag by remember { viewModel.wBMag }
    val wCMag by remember { viewModel.wCMag }
    val totW by remember { viewModel.totW }
    val varAMag by remember { viewModel.varAMag }
    val varBMag by remember { viewModel.varBMag }
    val varCMag by remember { viewModel.varCMag }
    val totVAR by remember { viewModel.totVAR }
    val vaAMag by remember { viewModel.vaAMag }
    val vaBMag by remember { viewModel.vaBMag }
    val vaCMag by remember { viewModel.vaCMag }
    val totVA by remember { viewModel.totVA }
    val power = arrayOf(
        Power("Active P Phs A", wAMag),
        Power("Active P Phs B", wBMag),
        Power("Active P Phs C", wCMag),
        Power("Active P Phs Total", totW),
        Power("Reactive P Phs A", varAMag),
        Power("Reactive P Phs B", varBMag),
        Power("Reactive P Phs C", varCMag),
        Power("Reactive P Phs Total", totVAR),
        Power("Apparent P Phs A", vaAMag),
        Power("Apparent P Phs B", vaBMag),
        Power("Apparent P Phs C", vaCMag),
        Power("Apparent P Phs Total", totVA),
    )
    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(2.dp, Color.Black)) {
        items(power.size) {
            val v = power[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.name,
                    Modifier
                        .border(1.dp, Color.Black)
                        .weight(0.5f)
                        .padding(10.dp, 10.dp),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.watt.toUnitString("%.02f", "W")}",
                    Modifier
                        .border(1.dp, Color.Black)
                        .weight(0.4f)
                        .padding(10.dp, 10.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview
@Composable
fun PowerScreenPreview() {
    VIPAM3500Theme {
        PowerScreen(viewModel())
    }
}


