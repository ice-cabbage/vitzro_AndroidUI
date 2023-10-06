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

data class Pq (
    val mode: String = "",
    val sag: String = "",
    val swell: String = "",
    val interruption: String = ""
)

data class Config (
    val pickUp: String = "",
    val persag: Int = 0,
    val perswell: Int = 0,
    val perinter: Int = 0
)

@Composable
fun PQconfi_Screen(viewModel: SharedViewModel) {
    val sagM by remember { viewModel.sagM }
    val sagP by remember { viewModel.sagP }
    val swellM by remember { viewModel.swellM }
    val interM by remember { viewModel.interM }
    val swellP by remember { viewModel.swellP }
    val interP by remember { viewModel.interP }

    val con = arrayOf(
        Pq("", "SAG", "SWELL", "INTERRUPTION")
    )

    val fig = arrayOf(
        Pq("Mode", sagM, swellM, interM)
    )

    val pick = arrayOf(
        Config("Pick Up (%)", sagP, swellP, interP)
    )

    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(0.6.dp, Color.Black)) {
        items(con.size) {
            val v = con[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.mode,
                    Modifier
                        .weight(0.2f)
                        .height(40.dp)
                        .border(1.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(v.sag,
                    Modifier
                        .weight(0.1f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(v.swell,
                    Modifier
                        .weight(0.1f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(v.interruption,
                    Modifier
                        .weight(0.1f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
            }
        }
        items(fig.size) {
            val v = fig[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.mode,
                    Modifier
                        .weight(0.2f)
                        .height(40.dp)
                        .border(1.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(v.sag,
                    Modifier
                        .weight(0.1f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(v.swell,
                    Modifier
                        .weight(0.1f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(v.interruption,
                    Modifier
                        .weight(0.1f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
            }
        }
        items(pick.size) {
            val v = pick[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.pickUp,
                    Modifier
                        .weight(0.2f)
                        .height(40.dp)
                        .border(1.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.persag.toInt()}",
                    Modifier
                        .weight(0.1f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.perswell.toInt()}",
                    Modifier
                        .weight(0.1f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.perinter.toInt()}",
                    Modifier
                        .weight(0.1f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
@Preview
fun PQconfi_ScreenPreview() {
    VIPAM3500Theme {
        PQconfi_Screen(viewModel())
    }
}