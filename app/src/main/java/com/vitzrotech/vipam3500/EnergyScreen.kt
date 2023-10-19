package com.vitzrotech.vipam3500

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme

data class Energy (
    val name: String = "",
    val wattHour: Float = 0.0f,
    val unit: String = ""
)

@Composable
fun EnergyScreen(viewModel: SharedViewModel) {
    val whA by remember { viewModel.whA }
    val whB by remember { viewModel.whB }
    val whC by remember { viewModel.whC }
    val wh by remember { viewModel.wh }
    val varhA by remember { viewModel.varhA }
    val varhB by remember { viewModel.varhB }
    val varhC by remember { viewModel.varhC }
    val varh by remember { viewModel.varh }
    val lgVarhA by remember { viewModel.lgVarhA }
    val lgVarhB by remember { viewModel.lgVarhB }
    val lgVarhC by remember { viewModel.lgVarhC }
    val lgVarh by remember { viewModel.lgVarh }
    val vahA by remember { viewModel.vahA }
    val vahB by remember { viewModel.vahB }
    val vahC by remember { viewModel.vahC }
    val vah by remember { viewModel.vah }

    val energy = arrayOf(
        Energy("A상 유효", whA, "wh"),
        Energy("B상 유효", whB, "wh"),
        Energy("C상 유효", whC, "wh"),
        Energy("총 유효", wh, "wh"),
        Energy("A상 무효진상", varhA, "Varh") ,
        Energy("B상 무효진상", varhB, "Varh"),
        Energy("C상 무효진상", varhC, "Varh"),
        Energy("총 무효진상", varh, "Varh"),
        Energy("A상 무효지상", lgVarhA, "Varh") ,
        Energy("B상 무효지상", lgVarhB, "Varh"),
        Energy("C상 무효지상", lgVarhC, "Varh"),
        Energy("총 무효지상", lgVarh, "Varh"),
        Energy("A상 피상", vahA, "Vah") ,
        Energy("B상 피상", vahB, "Vah"),
        Energy("C상 피상", vahC, "Vah"),
        Energy("총 피상", vah, "Vah")
    )
    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
        items(energy.size) {
            val v = energy[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.name,
                    Modifier
                        .weight(0.4f)
                        .height(40.dp)
                        .border(0.6.dp, MaterialTheme.colorScheme.onBackground),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.wattHour.toUnitString("%.02f", v.unit)}",
                    Modifier
                        .weight(0.3f)
                        .height(40.dp)
                        .border(0.6.dp, MaterialTheme.colorScheme.onBackground),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview
@Composable
fun EnergyScreenPreview() {
    VIPAM3500Theme {
        EnergyScreen(viewModel())
    }
}


