package com.vitzrotech.vipam3500

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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

val measurementTitles = mapOf(
    "voltage/current" to "OCR (50/51)",
    "power" to "OCGR (50G/51G)",
    "energy" to "OVGR (64G)",
    "reverse energy" to "SGR (67G)",
    "di/do status" to "DGR (67N)",
    "ai td" to "OVR (59)",
    "thermal/loadrate" to "UVR (27)",
    "sequence" to "POR (47P)",
    "phase balance" to "NSOVR (47N)",
    "harmonics" to "DOCR (67P)",
    "k-factor/c-factor" to "Reclosing (79)",
    "demand" to "Sync (25)",
    "max/min" to "NSOCR (46)",
    "true rms" to "Inrush (68)",
    "relay status" to "UFR (81U)",
    "interlock status" to "OFR (81O)",
    "plc io memory" to "Active Power (32P)")

@Composable
fun NaviButton(navController: NavController, route: String, modifier: Modifier) {
    Button(onClick = {
        navController.navigate(route) {
            popUpTo(NavRoutes.MainRoute.name)
        }
    }, modifier = modifier.border(1.dp, MaterialTheme.colorScheme.background),
        shape = RectangleShape) {
        Text(measurementTitles[route] ?: "", textAlign = TextAlign.Center)
    }
}

@Composable
fun MeasurementScreen(navController: NavController) {
    val key = measurementTitles.keys.iterator()
    val columns = if (LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT) 3 else 4
    LazyColumn(Modifier.border(2.dp, MaterialTheme.colorScheme.background)) {
        item {
            while(key.hasNext()) {
                Row(modifier = Modifier.height(IntrinsicSize.Min)) {
                    repeat(columns) {
                        if (key.hasNext())
                            NaviButton(navController, key.next(),
                                Modifier
                                    .weight(1.0f)
                                    .fillMaxWidth()
                                    .padding(8.dp))
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
fun MeasurementScreenPreview() {
    VIPAM3500Theme {
        MeasurementScreen(rememberNavController())
    }
}