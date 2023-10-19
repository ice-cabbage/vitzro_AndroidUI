package com.vitzrotech.vipam3500

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.text.style.TextAlign
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme

data class TCS (
    val name: String = "",
    val sec: String = ""
)

data class TRS (
    val mode: String = "",
    val des: Int = 0
)

@Composable
fun TCS_TRS_Screen(viewModel: SharedViewModel) {
    val onOffMode by remember { viewModel.onOffMode }
    val TcsChkTime by remember { viewModel.TcsChkTime }
    val TrsChkTime by remember { viewModel.TrsChkTime }

    val control = arrayOf(
        TCS("Mode", onOffMode)
    )

    val second = arrayOf(
        TRS("TCS Chk Time (sec)", TcsChkTime),
        TRS("TRS Chk Time (sec)", TrsChkTime)
    )

    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(0.6.dp, MaterialTheme.colorScheme.onBackground)) {
        items(control.size) {
            val v = control[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.name,
                    Modifier
                        .weight(0.4f)
                        .height(40.dp)
                        .border(0.6.dp, MaterialTheme.colorScheme.onBackground),
                    textAlign = TextAlign.Center
                )
                Text(
                    v.sec,
                    Modifier
                        .weight(0.5f)
                        .height(40.dp)
                        .border(0.6.dp, MaterialTheme.colorScheme.onBackground),
                    textAlign = TextAlign.Center
                )
            }
        }
        items(second.size) {
            val v = second[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.mode,
                    Modifier
                        .weight(0.4f)
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
    }
}

@Composable
@Preview
fun TCS_TRS_ScreenPreview() {
    VIPAM3500Theme {
        TCS_TRS_Screen(viewModel())
    }
}