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

data class LoadRate (
    val name: String = "",
    val per: Float = 0.0f,
    val unit: String = ""
)

@Composable
fun ThermalLoadRateScreen(viewModel: SharedViewModel) {
    val lev by remember { viewModel.lev }
    val ia by remember { viewModel.ia }
    val ib by remember { viewModel.ib }
    val ic by remember { viewModel.ic }

    val theraml = arrayOf(
        LoadRate("열상태", lev, "%"),
        LoadRate("부하율 전류 A상", ia, "%"),
        LoadRate("부하율 전류 B상", ib, "%"),
        LoadRate("부하율 전류 C상", ic, "%")
    )
    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding()) {
        items(theraml.size) {
            val v = theraml[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.name,
                    Modifier
                        .weight(0.3f)
                        .height(40.dp)
                        .border(0.6.dp, MaterialTheme.colorScheme.onBackground),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.per.toUnitString("%.02f", v.unit)}",
                    Modifier
                        .weight(0.2f)
                        .height(40.dp)
                        .border(0.6.dp, MaterialTheme.colorScheme.onBackground),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview
@Composable
fun ThermalLoadRateScreenPreview() {
    VIPAM3500Theme {
        ThermalLoadRateScreen(viewModel())
    }
}