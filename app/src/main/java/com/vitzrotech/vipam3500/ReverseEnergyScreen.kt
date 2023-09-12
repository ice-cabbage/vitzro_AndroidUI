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

data class Reverse (
    val name: String = "",
    val wattHour: Float = 0.0f,
    val unit: String = ""
)

@Composable
fun ReverseEnergyScreen(viewModel: SharedViewModel) {
    val rWhA by remember { viewModel.rWhA }
    val rWhB by remember { viewModel.rWhB }
    val rWhC by remember { viewModel.rWhC }
    val rWh by remember { viewModel.rWh }
    val rVarhA by remember { viewModel.rVarhA }
    val rVarhB by remember { viewModel.rVarhB }
    val rVarhC by remember { viewModel.rVarhC }
    val rVarh by remember { viewModel.rVarh }
    val rLgVarhA by remember { viewModel.rLgVarhA }
    val rLgVarhB by remember { viewModel.rLgVarhB }
    val rLgVarhC by remember { viewModel.rLgVarhC }
    val rLgVarh by remember { viewModel.rLgVarh }
    val rVahA by remember { viewModel.rVahA }
    val rVahB by remember { viewModel.rVahB }
    val rVahC by remember { viewModel.rVahC }
    val rVah by remember { viewModel.rVah }

    val reverse = arrayOf(
        Reverse("A상 유효", rWhA, "Wh"),
        Reverse("B상 유효", rWhB, "Wh"),
        Reverse("C상 유효", rWhC, "Wh"),
        Reverse("총 유효", rWh, "Wh"),
        Reverse("A상 무효진상", rVarhA, "Varh"),
        Reverse("B상 무효진상", rVarhB, "Varh"),
        Reverse("C상 무효진상", rVarhC, "Varh"),
        Reverse("총 무효진상", rVarh, "Varh"),
        Reverse("A상 무효지상", rLgVarhA, "Varh"),
        Reverse("B상 무효지상", rLgVarhB, "Varh"),
        Reverse("C상 무효지상", rLgVarhC, "Varh"),
        Reverse("총 무효지상", rLgVarh, "VAh"),
        Reverse("A상 피상", rVahA, "VAh"),
        Reverse("B상 피상", rVahB, "VAh"),
        Reverse("C상 피상", rVahC, "VAh"),
        Reverse("총 피상", rVah, "VAh")
    )
    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
        items(reverse.size) {
            val v = reverse[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.name,
                    Modifier
                        .weight(0.4f)
                        .padding(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.wattHour.toUnitString("%.02f", v.unit)}",
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
fun ReverseEnergyScreenPreview() {
    VIPAM3500Theme {
        ReverseEnergyScreen(viewModel())
    }
}