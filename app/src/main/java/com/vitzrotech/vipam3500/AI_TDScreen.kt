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

data class Input (
    val name: String = "",
    val ma: Float = 0.0f,
    val temp: String = ""
)

@Composable
fun AI_TDScreen(viewModel: SharedViewModel) {
    val ma1 by remember { viewModel.ma1 }
    val ma2 by remember { viewModel.ma2 }
    val ma3 by remember { viewModel.ma3 }
    val ma4 by remember { viewModel.ma4 }

    val analog = arrayOf(
        Input("AI 1", ma1, "-"),
        Input("AI 2", ma2, "-"),
        Input("AI 3", ma3, "-"),
        Input("AI 4", ma4, "-")
    )

    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(1.dp, Color.Black)) {
        items(analog.size) {
            val v = analog[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.name,
                    Modifier
                        .weight(0.4f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.ma.toUnitString("%.02f", "")}",
                    Modifier
                        .weight(0.3f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(v.temp,
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
fun AI_TDScreenPreview() {
    VIPAM3500Theme {
        AI_TDScreen(viewModel())
    }
}