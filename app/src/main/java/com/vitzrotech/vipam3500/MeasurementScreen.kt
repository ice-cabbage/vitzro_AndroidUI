package com.vitzrotech.vipam3500

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text

data class MenuItem(
    val buttonName : String = "",
    val dst : String = ""
)

@Composable
fun MeasurementScreen(navController: NavHostController) {
    val buttonList = arrayListOf(
        MenuItem("Voltage current", "voltage_current"),
        MenuItem("Power", "power"),
        MenuItem("Energy", "energy"),
        MenuItem("Reverse Energy", "reverse_Energy"),
        MenuItem("DI/DO Status", "DI/DO_Status"),
        MenuItem("AI TD", "AI_TD"),
        MenuItem("Thermal/LoadRate", "Thermal/LoadRate"),
        MenuItem("Sequence", "sequence"),
        MenuItem("Phase Balance", "phase_Balance"),
        MenuItem("Harmonics", "harmonics"),
        MenuItem("K-factor/C-factor", "k-factor/c-factor"),
        MenuItem("Demand", "demand"),
        MenuItem("Max/Min", "max/min"),
        MenuItem("True RMS", "true_RMS"),
        MenuItem("Relay Status", "relay_Status"),
        MenuItem("Interlock Status", "interlock_Status"),
        MenuItem("PLC IO Memory", "PLC_IO_Memory"),
        MenuItem("Oscilloscope", "oscilloscope")
    )
    val gridItems = buttonList.chunked(3)

    LazyColumn {
        items(gridItems) { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                for (item in rowItems) {
                    val modifier = Modifier
                        .height(75.dp)
                        .width(100.dp)
                        .weight(1f)
                        .padding(10.dp, 10.dp)

                    Button(
                        onClick = {
                            navController.navigate(item.dst) {
                                popUpTo(popUpToId)
                            }
                        },
                        modifier = modifier,
                        shape = androidx.compose.ui.graphics.RectangleShape
                    ) {
                        Text(text = item.buttonName)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun MeasurementScreenPreview() {
    VIPAM3500Theme {
        MeasurementScreen(rememberNavController())
    }
}
