package com.vitzrotech.vipam3500

import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
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

@Composable
fun OCGRScreen(viewModel: SharedViewModel) {
    val captions = listOf("1st Inst", "2nd Inst", "1st Time", "2nd Time")
    val stubs = listOf(
        stringResource(R.string.mode),
        stringResource(R.string.curve),
        stringResource(R.string.pickup) + "\n (x GIn)",
        stringResource(R.string.lever),
        stringResource(R.string.delay))
    val relays = listOf (
        listOf(listOf("ON", "OFF"),
            listOf("Definite"),
            0.10f..10.00f,
            0.0f..0.0f,
            0.04f..100.00f),
        listOf(listOf("ON", "OFF"),
            listOf("Definite"),
            0.10f..10.00f,
            0.0f..0.0f,
            0.04f..100.00f),
        listOf(listOf("ON", "OFF"),
            listOf("Definite", "IEC NI", "IEC VI", "IEC EI", "IEC LI", "KEPCO NI", "KEPCO VI"),
            0.02f..2.00f,
            0.05f..10.0f,
            0.10f.. 100.00f),
        listOf(listOf("ON", "OFF"),
            listOf("Definite", "IEC NI", "IEC VI", "IEC EI", "IEC LI", "KEPCO NI", "KEPCO VI"),
            0.02f.. 2.00f,
            0.05f..10.0f,
            0.10f.. 100.00f))
    val states = List(viewModel.ocgrState.size) {
        listOf(viewModel.ocgrState[it].mode,
            viewModel.ocgrState[it].curve,
            "%.02f".format(viewModel.ocgrState[it].pickup),
            "%.02f".format(viewModel.ocgrState[it].lever),
            "%.02f".format(viewModel.ocgrState[it].delay))
    }
    RelayTable(captions, stubs, relays, states) { items ->
        items.forEachIndexed { it, item ->
            viewModel.ocgrState[it] = OCGRState(
                item[0] as Int,
                item[1] as Int,
                (item[2] as String).toFloat(),
                (item[3] as String).toFloat(),
                (item[4] as String).toFloat())
        }
    }
}

@Composable
fun OVGRScreen(viewModel: SharedViewModel) {
    val captions = listOf("1st Time", "2nd Time")
    val stubs = listOf(
        stringResource(R.string.mode),
        stringResource(R.string.curve),
        stringResource(R.string.pickup) + " (x GVn)",
        stringResource(R.string.lever),
        stringResource(R.string.delay))
    val relays = listOf(
        listOf(listOf("ON", "OFF"),
            listOf("Definite", "KEPCO V-NI", "KEPCO V-VI"),
            0.05f.. 0.80f,
            0.05f..10.0f,
            0.10f.. 100.00f),
        listOf(listOf("ON", "OFF"),
            listOf("Definite", "KEPCO V-NI", "KEPCO V-VI"),
            0.05f.. 0.80f,
            0.05f..10.0f,
            0.10f.. 100.00f))
    val states = List(viewModel.ovgrState.size) {
        listOf(viewModel.ovgrState[it].mode,
            viewModel.ovgrState[it].curve,
            "%.02f".format(viewModel.ovgrState[it].pickup),
            "%.02f".format(viewModel.ovgrState[it].lever),
            "%.02f".format(viewModel.ovgrState[it].delay))
    }
    RelayTable(captions, stubs, relays, states) { items ->
        items.forEachIndexed { it, item ->
            viewModel.ovgrState[it] = OVGRState(
                item[0] as Int,
                item[1] as Int,
                (item[2] as String).toFloat(),
                (item[3] as String).toFloat(),
                (item[4] as String).toFloat())
        }
    }
}

@Composable
fun SGRScreen(viewModel: SharedViewModel) {
    val captions = listOf("Time")
    val stubs = listOf(
        stringResource(R.string.mode),
        stringResource(R.string.pickup) + " (x ZIn)",
        stringResource(R.string.delay))
    val relays = listOf (
        listOf(listOf("ON", "OFF"),
            0.6f.. 4.0f,
            0.10f.. 100.00f))
    val states = List(viewModel.sgrState.size) {
        listOf(viewModel.sgrState[it].mode,
            "%.02f".format(viewModel.sgrState[it].pickup),
            "%.02f".format(viewModel.sgrState[it].delay))
    }
    RelayTable(captions, stubs, relays, states) { items ->
        items.forEachIndexed { it, item ->
            viewModel.sgrState[it] = SGRState(
                item[0] as Int,
                (item[1] as String).toFloat(),
                (item[2] as String).toFloat())
        }
    }
}

@Composable
fun DGRScreen(viewModel: SharedViewModel) {
    val captions = listOf("Inst", "Time")
    val stubs = listOf(
        stringResource(R.string.mode),
        stringResource(R.string.pickup) + " (x GIn)",
        stringResource(R.string.lever),
        stringResource(R.string.delay),
        stringResource(R.string.direction),
        stringResource(R.string.memory_mode))
    val relays = listOf (
        listOf(listOf("ON", "OFF"),
            0.10f.. 10.0f,
            0.00f..00.0f,
            0.04f.. 100.00f,
            listOf("Non_Dir",  "Forward", "Reverse"),
            listOf("ON", "OFF")),
        listOf(listOf("ON", "OFF"),
            0.02f.. 2.0f,
            0.05f..10.0f,
            0.10f.. 100.00f,
            listOf("Non_Dir",  "Forward", "Reverse"),
            listOf("ON", "OFF")))
    val states = List(viewModel.dgrState.size) {
        listOf(viewModel.dgrState[it].mode,
            "%.02f".format(viewModel.dgrState[it].pickup),
            "%.02f".format(viewModel.dgrState[it].lever),
            "%.02f".format(viewModel.dgrState[it].delay),
            viewModel.dgrState[it].direction,
            viewModel.dgrState[it].memoryMode)
    }
    RelayTable(captions, stubs, relays, states) {  items ->
        items.forEachIndexed { it, item ->
            viewModel.dgrState[it] = DGRState(
                item[0] as Int,
                (item[1] as String).toFloat(),
                (item[2] as String).toFloat(),
                (item[3] as String).toFloat(),
                item[4] as Int, item[5] as Int)
        }
    }
}

@Composable
fun OVRScreen(viewModel: SharedViewModel) {
    val captions = listOf("1st Time", "2nd Time", "Aux Time")
    val stubs = listOf(
        stringResource(R.string.mode),
        stringResource(R.string.curve),
        stringResource(R.string.pickup) + "\n (x Vn)",
        stringResource(R.string.lever),
        stringResource(R.string.delay))
    val relays = listOf (
        listOf(listOf("ON", "OFF"),
            listOf("Definite", "KEPCO V-NI", "KEPCO V-VI"),
            0.80f.. 1.6f,
            0.05f.. 10.0f,
            0.10f.. 100.00f),
        listOf(listOf("ON", "OFF"),
            listOf("Definite", "KEPCO V-NI", "KEPCO V-VI"),
            0.80f.. 1.6f,
            0.05f.. 10.0f,
            0.10f.. 100.00f),
        listOf(listOf("ON", "OFF"),
            listOf("Definite", "KEPCO V-NI", "KEPCO V-VI"),
            0.80f.. 1.6f,
            0.05f.. 10.0f,
            0.10f.. 100.00f))
    val states = List(viewModel.ovrState.size) {
        listOf(viewModel.ovrState[it].mode,
            viewModel.ovrState[it].curve,
            "%.02f".format(viewModel.ovrState[it].pickup),
            "%.02f".format(viewModel.ovrState[it].lever),
            "%.02f".format(viewModel.ovrState[it].delay))
    }
    RelayTable(captions, stubs, relays, states) { items ->
        items.forEachIndexed { it, item ->
            viewModel.ovrState[it] = OVRState(
                item[0] as Int,
                item[1] as Int,
                (item[2] as String).toFloat(),
                (item[3] as String).toFloat(),
                (item[4] as String).toFloat())
        }
    }
}

@Composable
fun UVRScreen(viewModel: SharedViewModel) {
    val captions = listOf("1st Time", "2nd Time", "Aux Time")
    val stubs = listOf(
        stringResource(R.string.mode),
        stringResource(R.string.pickup) + "\n (x Vn)",
        stringResource(R.string.delay))
    val relays = listOf (
        listOf(listOf("ON", "OFF"),
            0.20f..1.0f,
            0.10f..100.00f),
        listOf(listOf("ON", "OFF"),
            0.20f..1.0f,
            0.10f..100.00f),
        listOf(listOf("ON", "OFF"),
            0.20f..1.0f,
            0.10f..100.00f))
    val states = List(viewModel.uvrState.size) {
        listOf(viewModel.uvrState[it].mode,
            "%.02f".format(viewModel.uvrState[it].pickup),
            "%.02f".format(viewModel.uvrState[it].delay))
    }
    RelayTable(captions, stubs, relays, states) { items ->
        items.forEachIndexed { it, item ->
            viewModel.uvrState[it] = UVRState(
                item[0] as Int,
                (item[1] as String).toFloat(),
                (item[2] as String).toFloat())
        }
    }
}

@Composable
fun PORScreen(viewModel: SharedViewModel) {
    val captions = listOf("Time")
    val stubs = listOf(
        stringResource(R.string.mode),
        stringResource(R.string.pickup) + "(%)",
        stringResource(R.string.delay))
    val relays = listOf(listOf(listOf("ON", "OFF"),
        5.0f..100.0f,
        0.10f..100.00f))
    val states = List(viewModel.porState.size) {
        listOf(viewModel.porState[it].mode,
            "%.02f".format(viewModel.porState[it].pickup),
            "%.02f".format(viewModel.porState[it].delay))
    }
    RelayTable(captions, stubs, relays, states) { items ->
        items.forEachIndexed { it, item ->
            viewModel.porState[it] = PORState(
                item[0] as Int,
                (item[1] as String).toFloat(),
                (item[2] as String).toFloat())
        }
    }
}

@Composable
fun NSOVRScreen(viewModel: SharedViewModel) {
    val captions = listOf("Time")
    val stubs = listOf(
        stringResource(R.string.mode),
        stringResource(R.string.pickup) + "(x Vn)",
        stringResource(R.string.delay))
    val relays = listOf(listOf(listOf("ON", "OFF"),
        0.05f..1.6f,
        0.10f..100.00f))
    val states = List(viewModel.nsovrState.size) {
        listOf(viewModel.nsovrState[it].mode,
            "%.02f".format(viewModel.nsovrState[it].pickup),
            "%.02f".format(viewModel.nsovrState[it].delay))
    }
    RelayTable(captions, stubs, relays, states) { items ->
        items.forEachIndexed { it, item ->
            viewModel.nsovrState[it] = NSOVRState(
                item[0] as Int,
                (item[1] as String).toFloat(),
                (item[2] as String).toFloat())
        }
    }
}

@Composable
fun DOCRScreen(viewModel: SharedViewModel) {
    val captions = listOf("Inst", "Time")
    val stubs = listOf(
        stringResource(R.string.mode),
        stringResource(R.string.curve),
        stringResource(R.string.pickup) + " (x In)",
        stringResource(R.string.lever),
        stringResource(R.string.delay),
        stringResource(R.string.direction),
        stringResource(R.string.memory_mode))
    val relays = listOf (
        listOf(listOf("ON", "OFF"),
            listOf("Definite"),
            0.10f..32.0f,
            0.00f..00.0f,
            0.04f..100.00f,
            listOf("Non_Dir",  "Forward", "Reverse"),
            listOf("ON", "OFF")),
        listOf(listOf("ON", "OFF"),
            listOf("Definite", "IEC NI", "IEC VI", "IEC EI", "IEC LI", "KEPCO NI", "KEPCO VI"),
            0.02f..10.0f,
            0.05f..10.0f,
            0.10f..100.00f,
            listOf("Non_Dir",  "Forward", "Reverse"),
            listOf("ON", "OFF")))
    val states = List(viewModel.docrState.size) {
        listOf(viewModel.docrState[it].mode,
            viewModel.docrState[it].curve,
            "%.02f".format(viewModel.docrState[it].pickup),
            "%.02f".format(viewModel.docrState[it].lever),
            "%.02f".format(viewModel.docrState[it].delay),
            viewModel.docrState[it].direction,
            viewModel.docrState[it].memoryMode)
    }
    RelayTable(captions, stubs, relays, states) { items ->
        items.forEachIndexed { it, item ->
            viewModel.docrState[it] = DOCRState(
                item[0] as Int,
                item[1] as Int,
                (item[2] as String).toFloat(),
                (item[3] as String).toFloat(),
                (item[4] as String).toFloat(),
                item[5] as Int,
                item[6] as Int)
        }
    }
}

@Composable
fun ReclosingScreen(viewModel: SharedViewModel) {
    val captions = listOf("Auto Reclosing")
    val stubs = listOf(
        stringResource(R.string.mode),
        stringResource(R.string.number),
        stringResource(R.string.first_rcd_time),
        stringResource(R.string.second_rcd_time),
        stringResource(R.string.third_rcd_time),
        stringResource(R.string.fourth_rcd_time))
    val relays = listOf (
        listOf(listOf("ON", "OFF"),
            listOf("0", "1", "2", "3", "4"),
            0.2f..180.0f,
            0.2f..180.0f,
            0.2f..180.0f,
            0.2f..180.0f))
    val states = List(viewModel.reclosingState.size) {
        listOf(viewModel.reclosingState[it].mode,
            viewModel.reclosingState[it].number,
            "%.02f".format(viewModel.reclosingState[it].first),
            "%.02f".format(viewModel.reclosingState[it].second),
            "%.02f".format(viewModel.reclosingState[it].third),
            "%.02f".format(viewModel.reclosingState[it].fourth))
    }
    RelayTable(captions, stubs, relays, states) { items ->
        items.forEachIndexed { it, item ->
            viewModel.reclosingState[it] = ReclosingRelayState(
                item[0] as Int,
                item[1] as Int,
                (item[2] as String).toFloat(),
                (item[3] as String).toFloat(),
                (item[4] as String).toFloat(),
                (item[5] as String).toFloat())
        }
    }
}

@Composable
fun SyncScreen(viewModel: SharedViewModel) {
    val captions = listOf("Time")
    val stubs = listOf(
        stringResource(R.string.mode),
        stringResource(R.string.diff_vol),
        stringResource(R.string.diff_freq),
        stringResource(R.string.diff_phs_ang),
        stringResource(R.string.live_dead_mode),
        stringResource(R.string.dead_line_value),
        stringResource(R.string.live_line_value),
        stringResource(R.string.dead_bus_value),
        stringResource(R.string.live_bus_value))
    val relays = listOf (
        listOf(listOf("ON", "OFF"),
            3.00f..10.00f,
            0.10f..0.50f,
            5.00f..20.00f,
            listOf("DL-DB", "LL-DB", "DL-LB", "DL-DB | LL-DB", "DL-DB | DL-LB", "LL-DB | DL-LB", "DL-DB | LL-DB | DL-LB"),
            0.10f..0.80f,
            0.80f..1.60f,
            0.10f..0.80f,
            0.80f..1.60f))
    val states = List(viewModel.syncState.size) {
        listOf(viewModel.syncState[it].mode,
            "%.02f".format(viewModel.syncState[it].diffVol),
            "%.02f".format(viewModel.syncState[it].diffFreq),
            "%.02f".format(viewModel.syncState[it].diffPhsAng),
            viewModel.syncState[it].liveDeadMode,
            "%.02f".format(viewModel.syncState[it].deadLineValue),
            "%.02f".format(viewModel.syncState[it].liveLineValue),
            "%.02f".format(viewModel.syncState[it].deadBusValue),
            "%.02f".format(viewModel.syncState[it].liveBusValue))
    }
    RelayTable(captions, stubs, relays, states) { items ->
        items.forEachIndexed { it, item ->
            viewModel.syncState[it] = SyncRelayState(
                item[0] as Int,
                (item[1] as String).toFloat(),
                (item[2] as String).toFloat(),
                (item[3] as String).toFloat(),
                item[4] as Int,
                (item[5] as String).toFloat(),
                (item[6] as String).toFloat(),
                (item[7] as String).toFloat(),
                (item[8] as String).toFloat())
        }
    }
}

@Composable
fun NSOCRScreen(viewModel: SharedViewModel) {
    val captions = listOf("Time")
    val stubs = listOf(
        stringResource(R.string.mode),
        stringResource(R.string.pickup) + " (x In)",
        stringResource(R.string.delay))
    val relays = listOf (
        listOf(listOf("ON", "OFF"),
            0.20f..10.00f,
            0.10f..100.00f))
    val states = List(viewModel.nsocrState.size) {
        listOf(viewModel.nsocrState[it].mode,
            "%.02f".format(viewModel.nsocrState[it].pickup),
            "%.02f".format(viewModel.nsocrState[it].delay))
    }
    RelayTable(captions, stubs, relays, states) { items ->
        items.forEachIndexed { it, item ->
            viewModel.nsocrState[it] = NSOCRState(
                item[0] as Int,
                (item[1] as String).toFloat(),
                (item[2] as String).toFloat())
        }
    }
}

@Composable
fun InrushScreen(viewModel: SharedViewModel) {
    val captions = listOf("2nd Time", "1st Time")
    val stubs  = listOf(
        stringResource(R.string.mode),
        stringResource(R.string.channel),
        stringResource(R.string.pickup) + "(%)",
        stringResource(R.string.delay))
    val relays = listOf (
        listOf(listOf("ON", "OFF"),
            2..31,
            0.10f..100.00f,
            0.10f..100.00f),
        listOf(listOf("ON", "OFF"),
            2..31,
            0.10f..100.00f,
            0.10f..100.00f))
    val states = List(viewModel.inrushState.size) {
        listOf(viewModel.inrushState[it].mode,
            "%d".format(viewModel.inrushState[it].channel),
            "%.02f".format(viewModel.inrushState[it].pickup),
            "%.02f".format(viewModel.inrushState[it].delay))
    }
    RelayTable(captions, stubs, relays, states) { items ->
        items.forEachIndexed { it, item ->
            viewModel.inrushState[it] = InrushRelayState(
                item[0] as Int,
                (item[1] as String).toInt(),
                (item[2] as String).toFloat(),
                (item[3] as String).toFloat())
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
fun RelayTable(captions: List<String>, stubs: List<String>, relays: List<List<Any>>, states: List<List<Any?>>,
               onApply: (List<List<Any>>) -> Unit) {
    val items = remember { List(states.size) { List(states[it].size) {i -> states[it][i]}.toMutableStateList() }}
    val cancelEnabled = states != items
    val applyEnabled = cancelEnabled && isRelayInRange(items, relays)
    LazyColumn(
        Modifier
            .fillMaxWidth()
            .border(2.dp, MaterialTheme.colorScheme.background)) {
        item {
            RelayTableTextRow("", captions)
            relays[0].forEachIndexed { i, relay ->
                @Suppress("UNCHECKED_CAST")
                when(relay) {
                    is List<*> -> {
                        RelayTableComboBoxRow(stubs[i], List(items.size) {items[it][i] as Int},
                            List(relays.size) { relays[it][i] as List<String>}) { it, v -> items[it][i] = v }
                    }
                    is ClosedFloatingPointRange<*> -> {
                        RelayTableFloatTextFieldRow(stubs[i], List(items.size) {items[it][i] as String},
                            List(relays.size) { relays[it][i] as ClosedFloatingPointRange<Float> }) { it, v -> items[it][i] = v }
                    }
                    is IntRange -> {
                        RelayTableIntTextFieldRow(stubs[i], List(items.size) {items[it][i] as String},
                            List(relays.size) { relays[it][i] as IntRange }) { it, v -> items[it][i] = v }
                    }
                }
            }
            RelayTableButtonRow(states.size, cancelEnabled, applyEnabled, onApply = {
                @Suppress("UNCHECKED_CAST")
                onApply(items as List<List<Any>>)}) {
                states.forEachIndexed { it, state ->
                    state.forEachIndexed { i, item ->
                        items[it][i] = item
                    }
                }
            }
        }
    }
}


@Composable
fun RelayTableTextRow(label: String, items: List<String>) {
    Row(Modifier.height(IntrinsicSize.Min)) {
        RelayTableText(label, Modifier.weight(1.0f))
        items.forEach { RelayTableText(it, Modifier.weight(1.0f)) }
    }
}

@Composable
fun RelayTableComboBoxRow(label: String, items: List<Int>, lists: List<List<String>>, onClick: (Int, Int) -> Unit) {
    Row(Modifier.height(IntrinsicSize.Min)) {
        RelayTableText(label, Modifier.weight(1.0f))
        items.forEachIndexed { i, item ->
            RelayTableComboBox(
                lists[i][item],
                lists[i],
                { onClick(i, lists[i].indexOf(it)) },
                Modifier.weight(1.0f))
        }
    }
}

@Composable
fun RelayTableFloatTextFieldRow(label: String, items: List<String>, ranges: List<ClosedFloatingPointRange<Float>>, onValueChange: (Int, String) -> Unit) {
    Row(Modifier.height(IntrinsicSize.Min)) {
        RelayTableText(label, Modifier.weight(1.0f))
        items.forEachIndexed { i, item ->
            RelayTableTextField(item, ranges[i], Modifier.weight(1.0f)) { onValueChange(i, it) }
        }
    }
}

@Composable
fun RelayTableIntTextFieldRow(label: String, items: List<String>, ranges: List<IntRange>, onValueChange: (Int, String) -> Unit) {
    Row(Modifier.height(IntrinsicSize.Min)) {
        RelayTableText(label, Modifier.weight(1.0f))
        items.forEachIndexed { i, item ->
            RelayTableTextField(item, ranges[i], Modifier.weight(1.0f)) { onValueChange(i, it) }
        }
    }
}

@Composable
fun RelayTableButtonRow(size: Int, cancelEnabled: Boolean, applyEnabled: Boolean, onApply: () -> Unit, onCancel: ()->Unit) {
    Row(Modifier.height(IntrinsicSize.Min)) {
        Spacer (Modifier.weight(1.0f))
        Button(onClick = onCancel, modifier = Modifier
            .border(1.dp, MaterialTheme.colorScheme.background)
            .fillMaxHeight()
            .weight(size.toFloat() / 2), shape = RectangleShape, enabled = cancelEnabled) { Text(stringResource(R.string.cancel)) }
        Button(onClick = onApply, modifier = Modifier
            .border(1.dp, MaterialTheme.colorScheme.background)
            .fillMaxHeight()
            .weight(size.toFloat() / 2), shape = RectangleShape, enabled = applyEnabled) { Text(stringResource(R.string.apply)) }
    }
}

@Composable
fun RelayTableText(text: String, modifier: Modifier) {
    Text(text,
        modifier
            .border(1.dp, MaterialTheme.colorScheme.background)
            .padding(8.dp, 4.dp)
            .fillMaxHeight()
            .wrapContentHeight(), textAlign = TextAlign.Center, color = MaterialTheme.colorScheme.onBackground)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RelayTableComboBox(text:String, list: List<String>, onClick: (String)->Unit, modifier: Modifier) {
    var expanded by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { if (list.size > 1) expanded = !expanded },
        modifier = modifier
            .border(1.dp, MaterialTheme.colorScheme.background)
            .fillMaxHeight()
    ) {
        BasicTextField(
            value = text,
            modifier = modifier
                .menuAnchor()
                .fillMaxWidth()
                .fillMaxHeight(),
            onValueChange = {},
            interactionSource = interactionSource,
            readOnly = true,
            textStyle = LocalTextStyle.current.copy(color = MaterialTheme.colorScheme.onBackground),
            decorationBox = @Composable { innerTextField ->
                TextFieldDefaults.DecorationBox(
                    value = text,
                    visualTransformation = VisualTransformation.None,
                    innerTextField = innerTextField,
                    singleLine = true,
                    enabled = true,
                    interactionSource = interactionSource,
                    contentPadding = PaddingValues(8.dp, 4.dp)) })
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            list.forEach {
                DropdownMenuItem(
                    text = {Text(it)},
                    onClick = {
                        onClick(it)
                        expanded = false })
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RelayTableTextField(text: String, range: ClosedFloatingPointRange<Float>, modifier: Modifier, onValueChange: (String)->Unit) {
    val interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
    BasicTextField(
        value = if (range.start != range.endInclusive) text else "-",
        modifier = modifier
            .border(1.dp, MaterialTheme.colorScheme.background)
            .fillMaxHeight(),
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        interactionSource = interactionSource,
        singleLine = true,
        enabled = true,
        readOnly = range.start == range.endInclusive,
        textStyle = LocalTextStyle.current.copy(textAlign = if (range.start != range.endInclusive)
            LocalTextStyle.current.textAlign else TextAlign.Center, color = MaterialTheme.colorScheme.onBackground),
        decorationBox = @Composable { innerTextField ->
            TextFieldDefaults.DecorationBox(
                value = text,
                visualTransformation = VisualTransformation.None,
                innerTextField = innerTextField,
                label = (@Composable{ Text("${"%.02f".format(range.start)}~${"%.02f".format(range.endInclusive)}", fontSize = 9.sp) })
                    .takeIf {range.start != range.endInclusive},
                singleLine = true,
                enabled = true,
                isError = text.toFloatOrNull() == null || text.toFloat() !in range,
                interactionSource = interactionSource,
                contentPadding = PaddingValues(8.dp, 4.dp))
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RelayTableTextField(text: String, range: IntRange, modifier: Modifier, onValueChange: (String)->Unit) {
    val interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
    BasicTextField(
        value = if (range.first != range.last) text else "-",
        modifier = modifier
            .border(1.dp, MaterialTheme.colorScheme.background)
            .fillMaxHeight(),
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        interactionSource = interactionSource,
        singleLine = true,
        enabled = true,
        readOnly = range.first == range.last,
        textStyle = LocalTextStyle.current.copy(textAlign = if (range.first != range.last)
            LocalTextStyle.current.textAlign else TextAlign.Center, color = MaterialTheme.colorScheme.onBackground),
        decorationBox = @Composable { innerTextField ->
            TextFieldDefaults.DecorationBox(
                value = text,
                visualTransformation = VisualTransformation.None,
                innerTextField = innerTextField,
                label = (@Composable{ Text("${"%d".format(range.first)}~${"%d".format(range.last)}", fontSize = 9.sp) })
                    .takeIf{range.first != range.last},
                singleLine = true,
                enabled = true,
                isError = text.toIntOrNull() == null || text.toInt() !in range,
                interactionSource = interactionSource,
                contentPadding = PaddingValues(8.dp, 4.dp))
        }
    )
}

fun isRelayInRange(items: List<List<Any?>>, relays: List<List<Any>>): Boolean {
    items.forEachIndexed { it, item ->
        item.forEachIndexed {i, v ->
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