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

data class Power (
    val name: String = "",
    val watt: Float = 0.0f,
    val unit: String = ""
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
        Power("A상 유효전력", wAMag, "W"),
        Power("B상 유효전력", wBMag, "W"),
        Power("C상 유효전력", wCMag, "W"),
        Power("총 유효전력", totW, "W"),
        Power("A상 무효전력", varAMag, "Var"),
        Power("B상 무효전력", varBMag, "Var"),
        Power("C상 무효전력", varCMag, "Var"),
        Power("총 무효전력", totVAR, "Var"),
        Power("A상 피상전력", vaAMag, "VA"),
        Power("B상 피상전력", vaBMag, "VA"),
        Power("C상 피상전력", vaCMag, "VA"),
        Power("총 피상전력", totVA, "VA")
    )
    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
        items(power.size) {
            val v = power[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.name,
                    Modifier
                        .weight(0.4f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.watt.toUnitString("%.02f", v.unit)}",
                    Modifier
                        .weight(0.3f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
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


