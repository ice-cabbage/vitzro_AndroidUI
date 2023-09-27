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
        MenuItem("전압/전류", "voltage_current"),
        MenuItem("전력", "power"),
        MenuItem("전력량", "energy"),
        MenuItem("역방향 전력량", "reverse_Energy"),
        MenuItem("DI/DO 상태", "DI/DO_Status"),
        MenuItem("아날로그TD 입력", "AI_TD"),
        MenuItem("열상태/부하율", "Thermal/LoadRate"),
        MenuItem("시퀀스", "sequence"),
        MenuItem("상 균형", "phase_Balance"),
        MenuItem("고조파", "harmonics"),
        MenuItem("k-팩터/c-팩터", "k-factor/c-factor"),
        MenuItem("디맨드", "demand"),
        MenuItem("최대/최소값", "max/min"),
        MenuItem("true 실효값", "true_RMS"),
        MenuItem("계전 상태", "relay_Status"),
        MenuItem("인터락 상태정보", "interlock_Status"),
        MenuItem("PLC_IO_메모리", "PLC_IO_Memory"),
        MenuItem("oscilloscope", "oscilloscope")
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
