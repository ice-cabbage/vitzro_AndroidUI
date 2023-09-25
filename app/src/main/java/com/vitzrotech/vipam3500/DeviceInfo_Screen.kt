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

data class Device (
    val name: String = "",
    val des: String = ""
)

data class Info (
    val info: String = "",
    val descrip: Float = 0.0f
)

@Composable
fun DeviceInfo_Screen(viewModel: SharedViewModel) {
    val Dtype by remember { viewModel.Dtype }
    val DspV by remember { viewModel.DspV }
    val MMIV by remember { viewModel.MMIV }
    val ComV by remember { viewModel.ComV }
    val PLCV by remember { viewModel.PLCV }

    val vicein = arrayOf(
        Info("DSP", DspV),
        Info("MMI", MMIV),
        Info("COM", ComV),
        Info("PLC", PLCV)
    )

    val infoScreen = arrayOf(
        Device("Device Type", Dtype)
    )

    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
        items(vicein.size) {
            val v = vicein[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.info,
                    Modifier
                        .weight(0.4f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.descrip.toUnitString("%.02f", "")}",
                    Modifier
                        .weight(0.3f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
            }
        }
        items(infoScreen.size) {
            val v = infoScreen[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.name,
                    Modifier
                        .weight(0.4f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.des}",
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
fun DeviceInfo_ScreenPreview() {
    VIPAM3500Theme {
        DeviceInfo_Screen(viewModel())
    }
}