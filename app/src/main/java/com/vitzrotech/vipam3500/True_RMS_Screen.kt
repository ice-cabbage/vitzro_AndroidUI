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

data class RMS (
    val name: String = "",
    val vaux: Float = 0.0f,
    val unit: String = ""
)

@Composable
fun True_RMS_Screen(viewModel: SharedViewModel) {
    val rmsVa by remember { viewModel.rmsVa }
    val rmsVb by remember { viewModel.rmsVb }
    val rmsVc by remember { viewModel.rmsVc }
    val rmsVn by remember { viewModel.rmsVn }
    val rmsIa by remember { viewModel.rmsIa }
    val rmsIb by remember { viewModel.rmsIb }
    val rmsIc by remember { viewModel.rmsIc }
    val rmsIn by remember { viewModel.rmsIn }
    val rms by remember { viewModel.rms }

    val rmstrue = arrayOf(
        RMS("전압 A상 : ", rmsVa, "V"),
        RMS("전압 B상 : ", rmsVb, "V"),
        RMS("전압 C상 : ", rmsVc, "V"),
        RMS("전압 N상 : ", rmsVn, "V"),
        RMS("전류 A상 : ", rmsIa, "A"),
        RMS("전류 B상 : ", rmsIb, "A"),
        RMS("전류 C상 : ", rmsIc, "A"),
        RMS("전류 N상 : ", rmsIn, "A"),
        RMS("상위 전압 : ", rms, "V")
    )
    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
        items(rmstrue.size) {
            val v = rmstrue[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.name,
                    Modifier
                        .weight(0.4f)
                        .height(40.dp)
                        .border(0.6.dp, MaterialTheme.colorScheme.onBackground),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.vaux.toUnitString("%.02f", v.unit)}",
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
fun True_RMS_ScreenPreview() {
    VIPAM3500Theme {
        True_RMS_Screen(viewModel())
    }
}