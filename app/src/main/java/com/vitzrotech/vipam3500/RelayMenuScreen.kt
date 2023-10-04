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