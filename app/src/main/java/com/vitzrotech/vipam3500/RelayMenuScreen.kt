package com.vitzrotech.vipam3500

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme

val relayTitles = mapOf(
    "ocr" to "OCR (50/51)",
    "ocgr" to "OCGR (50G/51G)",
    "ovgr" to "OVGR (64G)",
    "sgr" to "SGR (67G)",
    "dgr" to "DGR (67N)",
    "ovr" to "OVR (59)",
    "uvr" to "UVR (27)",
    "por" to "POR (47P)",
    "nsovr" to "NSOVR (47N)",
    "docr" to "DOCR (67P)",
    "reclosing" to "Reclosing (79)",
    "sync" to "Sync (25)",
    "nsocr" to "NSOCR (46)",
    "inrush" to "Inrush (68)",
    "ufr" to "UFR (81U)",
    "ofr" to "OFR (81O)",
    "active_power" to "Active Power (32P)",
    "reactive_power" to "Reactive Power (32Q)",
    "rocof" to "ROCOF (81R)")

@Composable
fun NavButton(navController: NavController, route: String, modifier: Modifier) {
    Button(onClick = {
        navController.navigate(route) {
            popUpTo(NavRoutes.MainRoute.name)
        }
    }, modifier = modifier.border(1.dp, MaterialTheme.colorScheme.background),
        shape = RectangleShape) {
        Text(relayTitles[route] ?: "", textAlign = TextAlign.Center)
    }
}

@Composable
fun RelayMenuScreen(navController: NavController) {
    val key = relayTitles.keys.iterator()
    val columns = if (LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT) 3 else 4
    LazyColumn(Modifier.border(2.dp, MaterialTheme.colorScheme.background)) {
        item {
            while(key.hasNext()) {
                Row(modifier = Modifier.height(IntrinsicSize.Min)) {
                    repeat(columns) {
                        if (key.hasNext())
                            NavButton(navController, key.next(),
                                Modifier
                                    .weight(1.0f)
                                    .fillMaxWidth()
                                    .padding(8.dp)
                                    .fillMaxHeight())
                        else
                            Spacer(Modifier.weight(1.0f))
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