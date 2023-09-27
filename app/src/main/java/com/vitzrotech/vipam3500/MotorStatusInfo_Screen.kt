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

data class Motor(
    val name: String = "",
    val des: String = ""
)

data class StatusInfo(
    val nam: String = "",
    val desc: Float = 0.0f
)

@Composable
fun MotorStatusInfo_Screen(viewModel: SharedViewModel) {
    val mod by remember { viewModel.mod }
    val fullCur by remember { viewModel.fullCur }
    val lockCur by remember { viewModel.lockCur }
    val lockTime by remember { viewModel.lockTime }
    val safeTime by remember { viewModel.safeTime }

    val mode = arrayOf(
        Motor("Mode", mod)
    )

    val etc = arrayOf(
        StatusInfo("Full Load Cur (x In)", fullCur),
        StatusInfo("LockRotor Cur (x In)", lockCur),
        StatusInfo("OI Lockout Time (sec)", lockTime),
        StatusInfo("Safe Stall Time (sec)", safeTime)
    )

    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
        items(mode.size) {
            val v = mode[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.name,
                    Modifier
                        .weight(0.6f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(
                    v.des,
                    Modifier
                        .weight(0.5f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center)
            }
        }
        items(etc.size) {
            val v = etc[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.nam,
                    Modifier
                        .weight(0.6f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.desc.toUnitString("%.02f", "")}",
                    Modifier
                        .weight(0.5f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center)
            }
        }
    }
}

@Composable
@Preview
fun MotorStatusInfo_ScreenPreview() {
    VIPAM3500Theme {
        MotorStatusInfo_Screen(viewModel())
    }
}