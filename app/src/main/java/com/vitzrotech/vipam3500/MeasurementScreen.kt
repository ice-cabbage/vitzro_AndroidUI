package com.vitzrotech.vipam3500

import android.view.Menu
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme

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
    Column {
        for (r in 0 until 6) {
            Row {
                for (c in 0 until 3) {
                    val index = r * 3 + c
                    if (index < buttonList.size) {
                        androidx.compose.material3.Button(
                            onClick = {
                                navController.navigate(buttonList[index].dst) {
                                    popUpTo(popUpToId)
                                }
                            },
                            modifier = androidx.compose.ui.Modifier
                                .height(75.dp)
                                .weight(1f)
                                .padding(8.dp, 8.dp),
                            shape = androidx.compose.ui.graphics.RectangleShape
                        ) {
                            androidx.compose.material3.Text(text = buttonList[index].buttonName)
                        }
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
