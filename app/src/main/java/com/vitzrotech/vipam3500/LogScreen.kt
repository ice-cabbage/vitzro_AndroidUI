package com.vitzrotech.vipam3500

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.navigation.NavController

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
                        shape = RectangleShape
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
fun LogScreenPreview() {
    VIPAM3500Theme {
        LogScreen(rememberNavController())
    }
}