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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme

data class MenuItemList(
    val buttonName: String = "",
    val dst: String = ""
)

@Composable
fun LogScreen(navController: NavHostController) {
    val buttonList = arrayListOf(
        MenuItemList("COS_Log", "COS_Log"),
        MenuItemList("SOE_Log", "SOE_Log"),
        MenuItemList("Demand_Log", "Demand_Log"),
        MenuItemList("Fault_List", "Fault_List"),
        MenuItemList("PQ_Log", "PQ_Log"),
        MenuItemList("DO_Count", "DO_Count"),
        MenuItemList("CB_OperationCount", "CB_Operation_Count"),
        MenuItemList("SMS_Log", "SMS_Log"),
        MenuItemList("Operation_Time", "Operation_Time")
    )
    Column {
        for (r in 0 until 3) {
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
                                .height(95.dp)
                                .weight(1f)
                                .padding(9.dp, 9.dp),
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
fun LogScreenPreview() {
    VIPAM3500Theme {
        LogScreen(rememberNavController())
    }
}