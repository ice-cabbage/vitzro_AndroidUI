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

data class Addition (
    val name: String = "",
    val  des: Int = 0
)

data class Infor (
    val nam: String = "",
    val strna: String = ""
)

data class Mation (
    val na: String = "",
    val flo: Float = 0.0f
)

@Composable
fun AdditionInfo_Screen(viewModel: SharedViewModel) {
    val UVvol by remember { viewModel.UVvol }
    val UCcur by remember { viewModel.UCcur }
    val NVvol by remember { viewModel.NVvol }
    val NCcur by remember { viewModel.NCcur }
    val POvol by remember { viewModel.POvol }
    val TDcur by remember { viewModel.TDcur }
    val DMtime by remember { viewModel.DMtime }
    val VTfail by remember { viewModel.VTfail }
    val sup by remember { viewModel.sup }
    val wave by remember { viewModel.wave }
    val trend by remember { viewModel.trend }

    val floadd = arrayOf(
        Mation("UV Block Vol (x Vn)", UVvol),
        Mation("UC Block Cur (x In)", UCcur),
        Mation("NV Block Vol (x Vn)", NVvol),
        Mation("NC Block Cur (x In)", NCcur),
        Mation("PO Block Vol (x Vn)", POvol),
        Mation("Tdd Cur Load", TDcur)
    )

    val intadd = arrayOf(
        Addition("DI Debounce Time", DMtime)
    )

    val stradd = arrayOf(
        Infor("VT Fail Block Mode", VTfail),
        Infor("CT/PT Supervision Mode", sup),
        Infor("Wave Trigger Mode", wave),
        Infor("RMS Trend Mode", trend)
    )

    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
        items(floadd.size) {
            val v = floadd[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.na,
                    Modifier
                        .weight(0.6f)
                        .height(40.dp)
                        .border(0.6.dp, MaterialTheme.colorScheme.onBackground),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.flo.toUnitString("%.02f", "")}",
                    Modifier
                        .weight(0.5f)
                        .height(40.dp)
                        .border(0.6.dp, MaterialTheme.colorScheme.onBackground),
                    textAlign = TextAlign.Center)
            }
        }
        items(intadd.size) {
            val v = intadd[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.name,
                    Modifier
                        .weight(0.6f)
                        .height(40.dp)
                        .border(0.6.dp, MaterialTheme.colorScheme.onBackground),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.des.toInt()}",
                    Modifier
                        .weight(0.5f)
                        .height(40.dp)
                        .border(0.6.dp, MaterialTheme.colorScheme.onBackground),
                    textAlign = TextAlign.Center)
            }
        }
        items(stradd.size) {
            val v = stradd[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.nam,
                    Modifier
                        .weight(0.6f)
                        .height(40.dp)
                        .border(0.6.dp, MaterialTheme.colorScheme.onBackground),
                    textAlign = TextAlign.Center
                )
                Text(v.strna,
                    Modifier
                        .weight(0.5f)
                        .height(40.dp)
                        .border(0.6.dp, MaterialTheme.colorScheme.onBackground),
                    textAlign = TextAlign.Center)
            }
        }
    }
}

@Composable
@Preview
fun AdditionInfo_ScreenPreview() {
    VIPAM3500Theme {
        AdditionInfo_Screen(viewModel())
    }
}