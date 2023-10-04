package com.vitzrotech.vipam3500

import androidx.compose.foundation.border
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel

data class OCRState(
    var mode: Int,
    var curve: Int,
    var pickup: Float,
    var lever: Float,
    var delay: Float
)

data class OCGRState(
    var mode: Int,
    var curve: Int,
    var pickup: Float,
    var lever: Float,
    var delay: Float
)

data class OVGRState(
    var mode: Int,
    var curve: Int,
    var pickup: Float,
    var lever: Float,
    var delay: Float
)

data class SGRState(
    var mode: Int,
    var pickup: Float,
    var delay: Float
)

data class DGRState(
    var mode: Int,
    var pickup: Float,
    var lever: Float,
    var delay: Float,
    var direction: Int,
    var memoryMode: Int
)

data class OVRState(
    var mode: Int,
    var curve: Int,
    var pickup: Float,
    var lever: Float,
    var delay: Float
)

data class UVRState(
    var mode: Int,
    var pickup: Float,
    var delay: Float
)

data class PORState(
    var mode: Int,
    var pickup: Float,
    var delay: Float
)

data class NSOVRState(
    var mode: Int,
    var pickup: Float,
    var delay: Float
)

data class DOCRState(
    var mode: Int,
    var curve: Int,
    var pickup: Float,
    var lever: Float,
    var delay: Float,
    var direction: Int = 0,
    var memoryMode: Int = 0
)

data class ReclosingRelayState(
    var mode: Int,
    var number: Int,
    var first: Float,
    var second: Float,
    var third: Float,
    var fourth: Float
)

data class SyncRelayState(
    var mode: Int,
    var diffVol: Float,
    var diffFreq: Float,
    var diffPhsAng: Float,
    var liveDeadMode: Int,
    var deadLineValue: Float,
    var liveLineValue: Float,
    var deadBusValue: Float,
    var liveBusValue: Float
)

data class NSOCRState(
    var mode: Int,
    var pickup: Float,
    var delay: Float
)

data class InrushRelayState(
    var mode: Int,
    var channel: Int,
    var pickup: Float,
    var delay: Float
)

data class UFRState(
    var mode: Int,
    var pickup: Float,
    var blkVol: Float,
    var delay: Float,
    var blkDelay: Float
)

data class OFRState(
    var mode: Int,
    var pickup: Float,
    var blkVol: Float,
    var delay: Float,
    var blkDelay: Float
)

data class ActivePowerRelayState(
    var mode: Int,
    var source: Int = 0,
    var pickup: Float,
    var delay: Float,
    var blkCur: Float,
    var blkVol: Float
)

data class ReactivePowerRelayState(
    var mode: Int,
    var pickup: Float,
    var delay: Float,
    var blkCur: Float,
    var blkVol: Float
)

data class ROCOFState(
    var mode: Int,
    var pickup: Float,
    var blkVol: Float,
    var delay: Float
)

@Composable
fun RelayMenuScreen(viewModel: SharedViewModel) {
    val captions = listOf("1st Inst", "2nd Inst", "1st Time", "2nd Time")
    val stubs = listOf(
        stringResource(R.string.mode),
        stringResource(R.string.curve),
        stringResource(R.string.pickup) + "\n (x In)",
        stringResource(R.string.lever),
        stringResource(R.string.delay))
    val relays = listOf(
        listOf(listOf("ON", "OFF"),
            listOf("Definite"),
            0.10f..32.00f,
            0.0f..0.0f,
            0.01f..100.00f),
        listOf(listOf("ON", "OFF"),
            listOf("Definite"),
            0.10f..32.00f,
            0.0f..0.0f,
            0.01f..100.00f),
        listOf(listOf("ON", "OFF"),
            listOf("Definite", "IEC NI", "IEC VI", "IEC EI", "IEC LI", "KEPCO NI", "KEPCO VI"),
            0.02f..10.00f,
            0.05f..10.0f,
            0.10f..100.00f),
        listOf(listOf("ON", "OFF"),
            listOf("Definite", "IEC NI", "IEC VI", "IEC EI", "IEC LI", "KEPCO NI", "KEPCO VI"),
            0.02f..10.00f,
            0.05f..10.0f,
            0.10f..100.00f))
    val states = List(viewModel.ocrState.size) {
        listOf(viewModel.ocrState[it].mode,
            viewModel.ocrState[it].curve,
            "%.02f".format(viewModel.ocrState[it].pickup),
            "%.02f".format(viewModel.ocrState[it].lever),
            "%.02f".format(viewModel.ocrState[it].delay))
    }
    RelayTable(captions, stubs, relays, states) { items ->
        items.forEachIndexed { it, item ->
            viewModel.ocrState[it] = OCRState(
                item[0] as Int,
                item[1] as Int,
                (item[2] as String).toFloat(),
                (item[3] as String).toFloat(),
                (item[4] as String).toFloat())
        }
    }
}

@Preview
@Composable
fun RelayMenuScreenPreview() {
    VIPAM3500Theme {
        RelayMenuScreen(viewModel())
    }
}

@Composable
fun RelayTable(captions: List<String>, stubs: List<String>, relays: List<List<Any>>, states: List<List<Any>>,
               onApply: (List<List<Any>>) -> Unit) {
    val items = remember { List(states.size) { List(states[it].size) {i -> states[it][i]}.toMutableStateList() }}
    val cancelEnabled = states != items
    val applyEnabled = cancelEnabled && isRelayInRange(items, relays)
    LazyColumn(
        Modifier
            .fillMaxWidth()
            .border(2.dp, MaterialTheme.colorScheme.background)) {
        item {
            //RelayTableTextRow("", captions)
        }
    }
}

fun isRelayInRange(items: List<List<Any?>>, relays: List<List<Any>>): Boolean {
    items.forEachIndexed { it, item ->
        item.forEachIndexed { i, v ->
            when (relays[it][i]) {
                is IntRange -> {
                    val range = relays[it][i] as IntRange
                    if ((v !is String) || (v.toIntOrNull() == null) || (v.toInt() !in range))
                        return false
                }
                is ClosedFloatingPointRange<*> -> {
                    @Suppress("UNCHECKED_CAST")
                    val range = relays[it][i] as ClosedFloatingPointRange<Float>
                    if ((v !is String) || (v.toFloatOrNull() == null) || (v.toFloat() !in range))
                        return false
                }
            }
        }
    }
    return true
}