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
import androidx.compose.material3.Button
import androidx.compose.material3.Text

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
                        .padding(8.dp)

                    Button (
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
fun RelayMenuScreenPreview() {
    VIPAM3500Theme {
        RelayMenuScreen(rememberNavController())
    }
}