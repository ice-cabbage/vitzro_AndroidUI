package com.vitzrotech.vipam3500

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme

data class Interlock(val name: String, val state : Boolean)

@Composable
fun Interlock_StatusScreen(viewModel: SharedViewModel)  {
    val interlock by remember { viewModel.interlock }
    val status = arrayOf(
        Interlock("CB(CB1) ON  BLOCK", interlock.getBit(0)),
        Interlock("CB(CB1) OFF BLOCK", interlock.getBit(1)),
        Interlock("CB2 ON  BLOCK", interlock.getBit(2)),
        Interlock("CB2 OFF BLOCK", interlock.getBit(3)),
        Interlock("DS(DS1) ON  BLOCK", interlock.getBit(4)),
        Interlock("DS(DS1) OFF BLOCK", interlock.getBit(5)),
        Interlock("DS2 ON  BLOCK", interlock.getBit(6)),
        Interlock("DS2 OFF BLOCK", interlock.getBit(7)),
        Interlock("ES(ES1) ON  BLOCK", interlock.getBit(8)),
        Interlock("ES(ES1) OFF BLOCK", interlock.getBit(9)),
        Interlock("ES2 ON  BLOCK", interlock.getBit(10)),
        Interlock("ES2 OFF BLOCK", interlock.getBit(11))
    )
    val columns = if (LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT) 1 else 2
    val rows = (status.size + 1) / columns
    Column(
        Modifier
            .fillMaxWidth()
            .padding(32.dp, 8.dp, 64.dp),
        verticalArrangement = Arrangement.Top,
    ) {
        LazyColumn(Modifier.fillMaxWidth()) {
            items(rows) {
                Row(Modifier.fillMaxWidth()) {
                    for (c in 0 until columns) {
                        val index = rows * c + it
                        if (index < status.size) {
                            val s = status[index]
                            Text(
                                s.name,
                                Modifier
                                    .weight(4f)
                                    .padding(1.dp, 1.dp)
                                    .background(Color.Blue),
                                color = Color.White, textAlign = TextAlign.Center
                            )
                            Text(
                                "\u2B24",
                                Modifier
                                    .weight(2f)
                                    .padding(1.dp, 1.dp),
                                color = if (s.state) Color.Red else Color.Gray,
                                textAlign = TextAlign.Center
                            )
                        } else {
                            Column(Modifier.weight(6f)){}
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun Interlock_StatusScreenPreview() {
    VIPAM3500Theme {
        Interlock_StatusScreen(viewModel())
    }
}