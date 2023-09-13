package com.vitzrotech.vipam3500

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme
import java.nio.file.attribute.FileAttribute

data class Factor (
    val name: String = "",
    val fac: Float = 0.0f
)

@Composable
fun K_C_factorScreen(viewModel: SharedViewModel) {
    val ka by remember { viewModel.ka }
    val kb by remember { viewModel.kb }
    val kc by remember { viewModel.kc }
    val eleca by remember { viewModel.eleca }
    val elecb by remember { viewModel.elecb }
    val elecc by remember { viewModel.elecc }
    val vola by remember { viewModel.vola }
    val volb by remember { viewModel.volb }
    val volc by remember { viewModel.volc }

    val fact = arrayOf(
        Factor("A상 : ", ka),
        Factor("B상 : ", kb),
        Factor("C상 : ", kc),
        Factor("전압 A상 : ", eleca),
        Factor("전압 B상 : ", elecb),
        Factor("전압 C상 : ", elecc),
        Factor("전류 A상 : ", vola),
        Factor("전류 B상 : ", volb),
        Factor("전류 C상 : ", volc)
    )
    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(1.dp, Color.Black)) {
        items(fact.size) {
            val v = fact[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.name,
                    Modifier
                        .weight(0.4f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                //Text(
                    //"${v.fac.toUnitString("%.02f", v.fac)}",
                    //Modifier
                        //.weight(0.3f)
                        //.height(40.dp)
                        //.border(0.6.dp, Color.Black),
                    //textAlign = TextAlign.Center
                //)
            }
        }
    }
}

@Preview
@Composable
fun K_C_factorScreenPreview() {
    VIPAM3500Theme {
        K_C_factorScreen(viewModel())
    }
}