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

data class Confi (
    val sec: String = "",
    val des: Int = 0
)

@Composable
fun DemandConfi_Screen(viewModel: SharedViewModel) {
    val decur by remember { viewModel.decur }
    val desec by remember { viewModel.desec }
    val deact by remember { viewModel.deact }
    val derea by remember { viewModel.derea }
    val demin by remember { viewModel.demin }

    val mandCon = arrayOf(
        Confi("Over Demand Current (A)", decur),
        Confi("Current Demand Set Time (sec)", desec),
        Confi("Over Demand Active Power (W)", deact),
        Confi("Over Demand Reactive Power (VAr)", derea),
        Confi("Power Demand Set Time (min)", demin)
    )

    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(0.6.dp, MaterialTheme.colorScheme.onBackground)) {
        items(mandCon.size) {
            val v = mandCon[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.sec,
                    Modifier
                        .weight(1f)
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
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
@Preview
fun DemandConfi_ScreenPreview() {
    VIPAM3500Theme {
        DemandConfi_Screen(viewModel())
    }
}