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
        MenuList("기기 정보", "device_info"),
        MenuList("기기 결선정보", "power_system"),
        MenuList("추가 정보", "addition_faculty"),
        MenuList("모터상태 정보", "motor_status_info"),
        MenuList("DO 제어", "DO_control"),
        MenuList("차단실패 설정", "breaker_failure"),
        MenuList("TCS & TRS 설정", "TCS&TRS"),
        MenuList("돌입전류 억제", "coldLock_pickUp"),
        MenuList("내부전원 감시설정", "power_Supervision"),
        MenuList("통신", "communication"),
        MenuList("VT 감시", "VT_Failure"),
        MenuList("가상 DI", "virtual_DI"),
        MenuList("PQ 설정", "PQ_Configuration"),
        MenuList("수요 설정", "demand_Configuration"),
        MenuList("시스템 진단정보", "system_Dignosis"),
        MenuList("부가기능", "function"),
        MenuList("AI(TD) 설정", "AI_Config")
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
fun SystemScreenPreview() {
    VIPAM3500Theme {
        SystemScreen(rememberNavController())
    }
}