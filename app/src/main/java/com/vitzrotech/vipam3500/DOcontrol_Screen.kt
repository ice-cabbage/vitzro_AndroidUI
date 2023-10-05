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

data class ButtonMenu(
    val name: String = "",
    val des: String = ""
)

@Composable
fun DOcontrol_Screen(navController: NavHostController) {
    val doButton = arrayListOf(
        ButtonMenu("CB1 ON", "CB1_ON"),
        ButtonMenu("CB1 OFF", "CB1_OFF"),
        ButtonMenu("CB2 ON", "CB2_ON"),
        ButtonMenu("CB2 OFF", "CB2_OFF"),
        ButtonMenu("DS1 ON", "DS1_ON"),
        ButtonMenu("DS1 OFF", "DS1_OFF"),
        ButtonMenu("DS2 ON", "DS2_ON"),
        ButtonMenu("DS2 OFF", "DS2_OFF"),
        ButtonMenu("ES1 ON", "ES1_ON"),
        ButtonMenu("ES1 OFF", "ES1_OFF"),
        ButtonMenu("ES2 ON", "ES2_ON"),
        ButtonMenu("ES2 OFF", "ES2_ON"),
        ButtonMenu("43PDA A BUS SEL", "A_SEL"),
        ButtonMenu("43PDA B BUS SEL", "B_SEL"),
        ButtonMenu("43PDA OFF", "OFF_SEL"),
        ButtonMenu("-", "NULL"),
        ButtonMenu("43PDA AUTO SEL", "AUTO_SEL"),
        ButtonMenu("43PDA MAN SEL", "MAN_SEL")
    )

    val gridItems = doButton.chunked(4)

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
                            navController.navigate(item.des) {
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
fun DOcontrol_ScreenPreview() {
    VIPAM3500Theme {
        DOcontrol_Screen(rememberNavController())
    }
}