package com.vitzrotech.vipam3500

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme

data class MenuList(
    val buttonName: String = "",
    val dst: String = ""
)

@Composable
fun SystemScreen(navController: NavHostController) {
    val buttonList = arrayListOf(
        MenuList("device_info", "device_info"),
        MenuList("power_system", "power_system"),
        MenuList("addition_faculty", "addition_faculty"),
        MenuList("motor_status_info", "motor_status_info"),
        MenuList("DO_control", "DO_control"),
        MenuList("breaker_failure", "breaker_failure"),
        MenuList("TCS&TRS", "TCS&TRS"),
        MenuList("coldLoad_pickUp", "coldLock_pickUp"),
        MenuList("power_Supervision", "power_Supervision"),
        MenuList("communication", "communication"),
        MenuList("VT_Failure", "VT_Failure"),
        MenuList("virtual_DI", "virtual_DI"),
        MenuList("PQ_Configuration", "PQ_Configuration"),
        MenuList("demand_Configuration", "demand_Configuration"),
        MenuList("system_Dignosis", "system_Dignosis"),
        MenuList("function", "function"),
        MenuList("AI_Config", "AI_Config")
    )
    Column {
        for (r in 0 until 6) {
            Row {
                for (c in 0 until 3) {
                    val index = r * 3 + c
                    if (index < buttonList.size) {
                        Button(
                            onClick = {
                                navController.navigate(buttonList[index].dst) {
                                    popUpTo(popUpToId)
                                }
                            },
                            modifier = Modifier
                                .height(75.dp)
                                .weight(1f)
                                .padding(8.dp, 8.dp),
                            shape = RectangleShape
                        ) {
                            Text(text = buttonList[index].buttonName)
                        }
                    } else {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun SystemScreenPreview() {
    VIPAM3500Theme {
        SystemScreen(rememberNavController())
    }
}