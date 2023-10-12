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
import androidx.navigation.compose.rememberNavController
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.navigation.NavController

data class ButtonTable(
    val name: String = "",
    val onOff: String = ""
)

@Composable
fun VirtualDI_Screen(navController: NavController) {
    val buttonList = arrayListOf(
        ButtonTable("Interlock Relieve 1", "Interlock Relieve 1"),
        ButtonTable("Virtual DI 2", "Virtual DI 2"),
        ButtonTable("Virtual DI 3", "Virtual DI 3"),
        ButtonTable("Virtual DI 4", "Virtual DI 4"),
        ButtonTable("Virtual DI 5", "Virtual DI 5"),
        ButtonTable("Virtual DI 6", "Virtual DI 6"),
        ButtonTable("Virtual DI 7", "Virtual DI 7"),
        ButtonTable("Virtual DI 8", "Virtual DI 8")
    )
    val gridItems = buttonList.chunked(3)

    LazyColumn {
        items(gridItems) {rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                for (item in rowItems) {
                    val modifier = Modifier
                        .height(75.dp)
                        .width(100.dp)
                        .weight(1f)
                        .padding(10.dp)

                    Button(
                        onClick = {
                            navController.navigate(item.onOff) {
                                popUpTo(popUpToId)
                            }
                        },
                        modifier = modifier,
                        shape = androidx.compose.ui.graphics.RectangleShape
                    ) {
                        Text(text = item.name)
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun VirtualDI_ScreenPreview() {
    VIPAM3500Theme {
        VirtualDI_Screen(rememberNavController())
    }
}