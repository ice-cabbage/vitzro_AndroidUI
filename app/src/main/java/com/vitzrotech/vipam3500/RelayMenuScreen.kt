package com.vitzrotech.vipam3500

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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

data class RelayItem(
    val buttonName: String = "",
    val dst: String = ""
)

@Composable
fun RelayMenuScreen(navController: NavHostController) {
    val buttonList = arrayListOf(
        RelayItem("Setting_Group", "Setting_Group"),
        RelayItem("OCR", "OCR"),
        RelayItem("OCGR", "OCGR"),
        RelayItem("OVGR", "OVGR"),
        RelayItem("SGR", "SGR"),
        RelayItem("DGR", "DGR"),
        RelayItem("OVR", "OVR"),
        RelayItem("UVR", "UVR"),
        RelayItem("POR", "POR"),
        RelayItem("NSOVR", "NSOVR"),
        RelayItem("DOCR", "DOCR"),
        RelayItem("Reclosing", "Reclosing"),
        RelayItem("Sync", "Sync"),
        RelayItem("NSOCR", "NSOCR"),
        RelayItem("Inrush", "Inrush"),
        RelayItem("UFR1-4", "UFR1-4"),
        RelayItem("OFR1-4", "OFR1-4"),
        RelayItem("UFR5-8", "UFR5-8"),
        RelayItem("OFR5-8", "OFR5-8"),
        RelayItem("UCR", "UCR"),
        RelayItem("THR", "THR"),
        RelayItem("Stall_Locked", "Stall_Locked"),
        RelayItem("NCHR", "NCHR"),
        RelayItem("Active_Power", "Active_Power"),
        RelayItem("Reactive_Power", "Reactive_Power"),
        RelayItem("ROCOF", "ROCOF"),
        RelayItem("SEF", "SEF")
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
fun RelayMenuScreenPreview() {
    VIPAM3500Theme {
        RelayMenuScreen(rememberNavController())
    }
}