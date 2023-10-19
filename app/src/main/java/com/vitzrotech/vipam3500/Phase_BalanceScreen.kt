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

data class Balance (
    val name: String = "",
    val pst: Float = 0.0f,
    val unit: String = ""
)

@Composable
fun Phase_BalanceScreen(viewModel: SharedViewModel) {
    val lmbVa by remember { viewModel.lmbVa }
    val lmbVb by remember { viewModel.lmbVb }
    val lmbVc by remember { viewModel.lmbVc }
    val lmbVab by remember { viewModel.lmbVab }
    val lmbVbc by remember { viewModel.lmbVbc }
    val lmbVca by remember { viewModel.lmbVca }
    val lmbNgv by remember { viewModel.lmbNgv }
    val lmbZroV by remember { viewModel.lmbZroV }
    val lmbla by remember { viewModel.lmbla }
    val lmblb by remember { viewModel.lmblb }
    val lmblc by remember { viewModel.lmblc }
    val lmbNgA by remember { viewModel.lmbNgA }
    val lmbZroA by remember { viewModel.lmbZroA }

    val phase = arrayOf(
        Balance("불평형전압 A상", lmbVa, "%"),
        Balance("불평형전압 B상", lmbVb, "%"),
        Balance("불평형전압 C상", lmbVc, "%"),
        Balance("불평형선간전압", lmbVab, "%"),
        Balance("불평형선간전압", lmbVbc, "%"),
        Balance("불평형선간전압", lmbVca, "%"),
        Balance("불평형역상전압", lmbNgv, "%"),
        Balance("불평형영상전압", lmbZroV, "%"),
        Balance("불평형전류 A상", lmbla, "%"),
        Balance("불평형전류 B상", lmblb, "%"),
        Balance("불평형전류 C상", lmblc, "%"),
        Balance("불평형역상전류", lmbNgA, "%"),
        Balance("불평형영상전류", lmbZroA, "%")
    )
    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
        items(phase.size) {
            val v = phase[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.name,
                    Modifier
                        .weight(0.4f)
                        .height(40.dp)
                        .border(0.6.dp, MaterialTheme.colorScheme.onBackground),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.pst.toUnitString("%.02f", v.unit)}",
                    Modifier
                        .weight(0.3f)
                        .height(40.dp)
                        .border(0.6.dp, MaterialTheme.colorScheme.onBackground),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 200, heightDp = 100)
@Composable
fun Phase_BalanceScreenPreview() {
    VIPAM3500Theme {
        Phase_BalanceScreen(viewModel())
    }
}