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

data class Max (
    val name: String = "",
    val year: Int = 0,
    val mon: Int = 0,
    val day: Int = 0,
    val hour: Int = 0,
    val minute: Int = 0,
    val sec: Int = 0,
    val ms: Int = 0,
    val flva: Float = 0.0f,
    val unit: String = "",
    val phase: Float = 0.0f
)

@Composable
fun MaxminScreen(viewModel: SharedViewModel) {
    //val time = "$year-$month"
    val maxCur by remember { viewModel.maxCur }
    val maxCurPh by remember { viewModel.maxCurPh }
    val maxCurY by remember { viewModel.maxCurY }
    val maxCurMon by remember { viewModel.maxCurMon }
    val maxCurD by remember { viewModel.maxCurD }
    val maxCurH by remember { viewModel.maxCurH }
    val maxCurMin by remember { viewModel.maxCurMin }
    val maxCurS by remember { viewModel.maxCurS }
    val maxCurms by remember { viewModel.maxCurms }

    val minCur by remember { viewModel.minCur }
    val minCurPh by remember { viewModel.minCurPh }
    val minCurY by remember { viewModel.minCurY }
    val minCurMon by remember { viewModel.minCurMon }
    val minCurD by remember { viewModel.minCurD }
    val minCurH by remember { viewModel.minCurH }
    val minCurMin by remember { viewModel.minCurMin }
    val minCurS by remember { viewModel.minCurS }
    val minCurms by remember { viewModel.minCurms }

    val maxVol by remember { viewModel.maxVol }
    val maxVolPh by remember { viewModel.maxVolPh }
    val maxVolY by remember { viewModel.maxVolY }
    val maxVolMon by remember { viewModel.maxVolMon }
    val maxVolD by remember { viewModel.maxVolD }
    val maxVolH by remember { viewModel.maxVolH }
    val maxVolMin by remember { viewModel.maxVolMin }
    val maxVolS by remember { viewModel.maxVolS }
    val maxVolms by remember { viewModel.maxVolms }

    val minVol by remember { viewModel.minVol }
    val minVolPh by remember { viewModel.minVolPh }
    val minVolY by remember { viewModel.minVolY }
    val minVolMon by remember { viewModel.minVolMon }
    val minVolD by remember { viewModel.minVolD }
    val minVolH by remember { viewModel.minVolH }
    val minVolMin by remember { viewModel.minVolMin }
    val minVolS by remember { viewModel.minVolS }
    val minVolms by remember { viewModel.minVolms }

    val maxFreq by remember { viewModel.maxFreq }
    val maxFreqPh by remember { viewModel.maxFreqPh }
    val maxFreqY by remember { viewModel.maxFreqY }
    val maxFreqMon by remember { viewModel.maxFreqMon }
    val maxFreqD by remember { viewModel.maxFreqD }
    val maxFreqH by remember { viewModel.maxFreqH }
    val maxFreqMin by remember { viewModel.maxFreqMin }
    val maxFreqS by remember { viewModel.maxFreqS }
    val maxFreqms by remember { viewModel.maxFreqms }

    val minFreq by remember { viewModel.minFreq }
    val minFreqPh by remember { viewModel.minFreqPh }
    val minFreqY by remember { viewModel.minFreqY }
    val minFreqMon by remember { viewModel.minFreqMon }
    val minFreqD by remember { viewModel.minFreqD }
    val minFreqH by remember { viewModel.minFreqH }
    val minFreqMin by remember { viewModel.minFreqMin }
    val minFreqS by remember { viewModel.minFreqS }
    val minFreqms by remember { viewModel.minFreqms }

    val maxWatt by remember { viewModel.maxWatt }
    val maxWattPh by remember { viewModel.maxWattPh }
    val maxWattY by remember { viewModel.maxWattY }
    val maxWattMon by remember { viewModel.maxWattMon }
    val maxWattD by remember { viewModel.maxWattD }
    val maxWattH by remember { viewModel.maxWattH }
    val maxWattMin by remember { viewModel.maxWattMin }
    val maxWattS by remember { viewModel.maxWattS }
    val maxWattms by remember { viewModel.maxWattms }

    val minWatt by remember { viewModel.minWatt }
    val minWattPh by remember { viewModel.minWattPh }
    val minWattY by remember { viewModel.minWattY }
    val minWattMon by remember { viewModel.minWattMon }
    val minWattD by remember { viewModel.minWattD }
    val minWattH by remember { viewModel.minWattH }
    val minWattMin by remember { viewModel.minWattMin }
    val minWattS by remember { viewModel.minWattS }
    val minWattms by remember { viewModel.minWattms }

    val maxVar by remember { viewModel.maxVar }
    val maxVarPh by remember { viewModel.maxVarPh }
    val maxVarY by remember { viewModel.maxVarY }
    val maxVarMon by remember { viewModel.maxVarMon }
    val maxVarD by remember { viewModel.maxVarD }
    val maxVarH by remember { viewModel.maxVarH }
    val maxVarMin by remember { viewModel.maxVarMin }
    val maxVarS by remember { viewModel.maxVarS }
    val maxVarms by remember { viewModel.maxVarms }

    val minVar by remember { viewModel.minVar }
    val minVarPh by remember { viewModel.minVarPh }
    val minVarY by remember { viewModel.minVarY }
    val minVarMon by remember { viewModel.minVarMon }
    val minVarD by remember { viewModel.minVarD }
    val minVarH by remember { viewModel.minVarH }
    val minVarMin by remember { viewModel.minVarMin }
    val minVarS by remember { viewModel.minVarS }
    val minVarms by remember { viewModel.minVarms }

    val min = arrayOf (
        Max("Max Current", maxCurY, maxCurMon, maxCurD, maxCurH, maxCurMin, maxCurS, maxCurms, maxCur, "A", maxCurPh),
        Max("Min Current", minCurY, minCurMon, minCurD, minCurH, minCurMin, minCurS, minCurms, minCur, "A", minCurPh),
        Max("Max Voltage", maxVolY, maxVolMon, maxVolD, maxVolH, maxVolMin, maxVolS, maxVolms, maxVol, "V", maxVolPh),
        Max("Min Voltage", minVolY, minVolMon, minVolD, minVolH, minVolMin, minVolS, minVolms, minVol, "V", minVolPh),
        Max("Max Freq", maxFreqY, maxFreqMon, maxFreqD, maxFreqH, maxFreqMin, maxFreqS, maxFreqms, maxFreq, "Hz", maxFreqPh),
        Max("Min Freq", minFreqY, minFreqMon, minFreqD, minFreqH, minFreqMin, minFreqS, minFreqms, minFreq, "Hz", minFreqPh),
        Max("Max Watt", maxWattY, maxWattMon, maxWattD, maxWattH, maxWattMin, maxWattS, maxWattms, maxWatt, "W", maxWattPh),
        Max("Min Watt", minWattY, minWattMon, minWattD, minWattH, minWattMin, minWattS, minWattms, minWatt, "W", minWattPh),
        Max("Max Var", maxVarY, maxVarMon, maxVarD, maxVarH, maxVarMin, maxVarS, maxVarms, maxVar, "Var", maxVarPh),
        Max("Min Var", minVarY, minVarMon, minVarD, minVarH, minVarMin, minVarS, minVarms, minVar, "Var", minVarPh)
    )
    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
        items(min.size) {
            val v = min[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.name,
                    Modifier
                        .weight(0.4f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.year},${v.mon},${v.day},${v.hour},${v.minute},${v.sec},${v.ms}",
                    Modifier
                        .weight(0.4f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.flva.toUnitString("%.02f", v.unit)}",
                    Modifier
                        .weight(0.3f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.phase.toUnitString("%.02f", "")}",
                    Modifier
                        .weight(0.2f)
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
fun MaxminScreenPreview() {
    VIPAM3500Theme {
        MaxminScreen(viewModel())
    }
}