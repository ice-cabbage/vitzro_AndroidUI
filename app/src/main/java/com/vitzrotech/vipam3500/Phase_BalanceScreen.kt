package com.vitzrotech.vipam3500

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme

data class Balance (
    val name: String = "",
    val pst: Float = 0.0f,
)

@Composable
fun Phase_BalanceScreen(viewModel: SharedViewModel) {
    val balance = arrayOf()

    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(2.dp, Color.Black)) {
        items(balance.size) {
            val v = balance[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.name,
                    Modifier
                        .border(1.dp, Color.Black)
                        .weight(0.5f)
                        .padding(10.dp),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.watt.toUnitString("%.02f", "%")}",
                    Modifier
                        .border(1.dp, Color.Black)
                        .weight(0.4f)
                        .padding(10.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview
@Composable
fun Phase_BalanceScreenPreview() {
    VIPAM3500Theme {
        Phase_BalanceScreen(viewModel())
    }
}