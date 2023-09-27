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

data class PowerSys (
    val na: String = "",
    val des: String = ""
)

data class WerSys (
    val nam: String = "",
    val desc: Int = 0
)

data class Sys (
    val name: String = "",
    val descr: Float = 0.0f
)

@Composable
fun PowerSystem_Screen(viewModel: SharedViewModel) {
    val WirA by remember { viewModel.WirA }
    val WirB by remember { viewModel.WirB }
    val Phs by remember { viewModel.Phs }
    val NorFreq by remember { viewModel.NorFreq }
    val PT1 by remember { viewModel.PT1 }
    val PT2 by remember { viewModel.PT2 }
    val AuxPT1 by remember { viewModel.AuxPT1 }
    val AuxPT2 by remember { viewModel.AuxPT2 }
    val GPT1 by remember { viewModel.GPT1 }
    val GPT2 by remember { viewModel.GPT2 }
    val CT1 by remember { viewModel.CT1 }
    val CT2 by remember { viewModel.CT2 }
    val NCT1 by remember { viewModel.NCT1 }
    val NCT2 by remember { viewModel.NCT2 }
    val ZCT1 by remember { viewModel.ZCT1 }
    val ZCT2 by remember { viewModel.ZCT2 }

    val strPow = arrayOf(
        PowerSys("WiringA", WirA),
        PowerSys("Phs Seq", Phs)
    )

    val intPow = arrayOf(
        WerSys("Normal Freq. (Hz)", NorFreq),
        WerSys("PT 1st Value (V)", PT1),
        WerSys("Aux PT 1st Value (V)", AuxPT1),
        WerSys("GPT 1st Value (V)", GPT1),
        WerSys("CT 1st Value (A)", CT1),
        WerSys("CT 2nd Value (A)", CT2),
        WerSys("NCT 1st Value (A)", NCT1),
        WerSys("NCT 2nd Value (A)", NCT2)
    )

    val floPow = arrayOf(
        Sys("PT 2nd Value (V)", PT2),
        Sys("Aux PT 2nd Value (V)", AuxPT2),
        Sys("GPT 2nd Value (V)", GPT2),
        Sys("ZCT 1st Value (A)", ZCT1),
        Sys("ZCT 2nd Value (A)", ZCT2)
    )

    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
        items(strPow.size) {
            val v = strPow[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.na,
                    Modifier
                        .weight(0.6f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(v.des,
                    Modifier
                        .weight(0.5f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center)
            }
        }
        items(intPow.size) {
            val v = intPow[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.nam,
                    Modifier
                        .height(40.dp)
                        .weight(0.6f)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.desc}",
                    Modifier
                        .height(40.dp)
                        .weight(0.6f)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
            }
        }
        items(floPow.size) {
            val v = floPow[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.name,
                    Modifier
                        .height(40.dp)
                        .weight(0.6f)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.descr.toUnitString("%.02f", "")}",
                    Modifier
                        .height(40.dp)
                        .weight(0.6f)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview
@Composable
fun PowerSystem_ScreenPreview() {
    VIPAM3500Theme {
        PowerSystem_Screen(viewModel())
    }
}