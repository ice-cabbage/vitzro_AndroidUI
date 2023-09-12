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

data class AI(
    val ai: String = "",
    val value: UInt = 0x0u,
    val temp: String = ""
)

@Composable
fun AI_TDScreen(viewModel: SharedViewModel) {
    val diStatus2 by remember { viewModel.diStatus2 }
    val diStatus1 by remember { viewModel.diStatus1 }
    val doStatus2 by remember { viewModel.doStatus2 }
    val doStatus1 by remember { viewModel.doStatus1 }

    val status = arrayOf(
        AI("AI 1", diStatus2, "-"),
        AI("AI 2", diStatus1, "-"),
        AI("AI 3", doStatus2, "-"),
        AI("AI 4", doStatus1, "-")
    )
    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
        items(status.size) {
            val v = status[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.ai,
                    Modifier
                        .weight(0.4f)
                        .padding(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.value.toUnitString("%.02f", v.temp)}",
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
fun AI_TDScreenPreview() {
    VIPAM3500Theme {
        AI_TDScreen(viewModel())
    }
}