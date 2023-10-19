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

val systemTitles = mapOf(
    "device Info" to "Device Info",
    "power System" to "Power System",
    "addition Faculty" to "Addition Faculty",
    "motor StatusInfo" to "Motor Status Info",
    "DO Control" to "DO Control",
    "breaker Failure" to "Breaker Failure",
    "TCS&TRS" to "TCS & TRS",
    "coldLoad pickUp" to "Cold Load Pick up",
    "power Supervision" to "Power Supervision",
    "communication" to "Communication",
    "VT Failure" to "VT Failure",
    "virtual DI" to "Virtual DI",
    "PQ Configuration" to "PQ Configuration",
    "demand Configuration" to "Demand Configuration",
    "system Dignosis" to "System Dignosis")

@Composable
fun NavigationButton(navController: NavController, route: String, modifier: Modifier) {
    Button(onClick = {
        navController.navigate(route) {
            popUpTo(NavRoutes.MainRoute.name)
        }
    }, modifier = modifier.border(1.dp, MaterialTheme.colorScheme.background),
        shape = RectangleShape) {
        Text(systemTitles[route] ?: "", textAlign = TextAlign.Center)
    }
}

@Composable
fun SystemScreen(navController: NavController) {
    val key = systemTitles.keys.iterator()
    val columns = if (LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT) 3 else 4
    LazyColumn(Modifier.border(2.dp, MaterialTheme.colorScheme.background)) {
        item {
            while(key.hasNext()) {
                Row(modifier = Modifier.height(IntrinsicSize.Min)) {
                    repeat(columns) {
                        if (key.hasNext())
                            NavigationButton(navController, key.next(),
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
fun SystemScreenPreview() {
    VIPAM3500Theme {
        SystemScreen(rememberNavController())
    }
}