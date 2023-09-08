package com.vitzrotech.vipam3500

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color

data class MenuItem(
    val buttonName : String = "",
    val dst : String = ""
)

@Composable
fun MeasurementScreen(navController: NavHostController) {
    val buttonList = arrayListOf(
        MenuItem("voltage_current", "voltage_current"),
        MenuItem("power", "power"),
        MenuItem("energy", "energy"),
        MenuItem("reverse_Energy", "reverse_Energy"),
        MenuItem("DI/DO_Status", "DI/DO_Status"),
        MenuItem("AI_TD", "AI_TD"),
        MenuItem("Thermal/LoadRate", "Thermal/LoadRate"),
        MenuItem("sequence", "sequence"),
        MenuItem("phase_Balance", "phase_Balance"),
        MenuItem("harmonics", "harmonics"),
        MenuItem("k-factor/c-factor", "k-factor/c-factor"),
        MenuItem("demand", "demand"),
        MenuItem("max/min", "max/min"),
        MenuItem("true_RMS", "true_RMS"),
        MenuItem("relay_Status", "relay_Status"),
        MenuItem("interlock_Status", "interlock_Status"),
        MenuItem("PLC_IO_Memory", "PLC_IO_Memory")
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
                        .padding(8.dp, 8.dp)

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
                    Spacer(modifier = Modifier.weight(2f))
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
