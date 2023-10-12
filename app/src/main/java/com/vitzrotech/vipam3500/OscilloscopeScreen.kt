package com.vitzrotech.vipam3500

import android.content.res.Configuration
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme
import java.text.DecimalFormat
import kotlin.math.absoluteValue
import kotlin.math.tan

data class OscilloscopeState(
    var svData: Array<Int> = emptyArray(),
    var minV: Float = -200.0f,
    var maxV: Float = 200.0f,
    var minA: Float = -15.0f,
    var maxA: Float = 15.0f,
    var sDiv: Float = 0.005f,
    var n: Int = 144,
    var level: Float = 0.0f,
    var position: Float = 0.0f,
    var p: Int = 0,
    var edge: Int = 1,
    var vaEnable: Boolean = true,
    var vbEnable: Boolean = true,
    var vcEnable: Boolean = true,
    var iaEnable: Boolean = true,
    var ibEnable: Boolean = true,
    var icEnable: Boolean = true,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as OscilloscopeState

        if (!svData.contentEquals(other.svData)) return false
        if (minV != other.minV) return false
        if (maxV != other.maxV) return false
        if (minA != other.minA) return false
        if (maxA != other.maxA) return false
        if (sDiv != other.sDiv) return false
        if (n != other.n) return false
        if (level != other.level) return false
        if (position != other.position) return false
        if (p != other.p) return false
        if (edge != other.edge) return false
        if (vaEnable != other.vaEnable) return false
        if (vbEnable != other.vbEnable) return false
        if (vcEnable != other.vcEnable) return false
        if (iaEnable != other.iaEnable) return false
        if (ibEnable != other.ibEnable) return false
        if (icEnable != other.icEnable) return false

        return true
    }

    override fun hashCode(): Int {
        var result = svData.contentHashCode()
        result = 31 * result + minV.hashCode()
        result = 31 * result + maxV.hashCode()
        result = 31 * result + minA.hashCode()
        result = 31 * result + maxA.hashCode()
        result = 31 * result + sDiv.hashCode()
        result = 31 * result + n
        result = 31 * result + level.hashCode()
        result = 31 * result + position.hashCode()
        result = 31 * result + p
        result = 31 * result + edge
        result = 31 * result + vaEnable.hashCode()
        result = 31 * result + vbEnable.hashCode()
        result = 31 * result + vcEnable.hashCode()
        result = 31 * result + iaEnable.hashCode()
        result = 31 * result + ibEnable.hashCode()
        result = 31 * result + icEnable.hashCode()
        return result
    }
}

sealed class OscilloscopeEvent {
    data class Apply(val value: OscilloscopeState): OscilloscopeEvent()
    data class VaEnableChanged(val value: Boolean): OscilloscopeEvent()
    data class VbEnableChanged(val value: Boolean): OscilloscopeEvent()
    data class VcEnableChanged(val value: Boolean): OscilloscopeEvent()
    data class IaEnableChanged(val value: Boolean): OscilloscopeEvent()
    data class IbEnableChanged(val value: Boolean): OscilloscopeEvent()
    data class IcEnableChanged(val value: Boolean): OscilloscopeEvent()
}

@Composable
fun OscilloscopeScreen(viewModel: SharedViewModel) {
    val state by viewModel.oscilloscopeState.collectAsState()
    if (LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)) {
                OscilloscopeView(state)
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)) {
                OscilloscopeControl(viewModel, state)
            }
        }
    } else {
        Row(modifier = Modifier.fillMaxSize()) {
            Column (modifier = Modifier
                .fillMaxHeight()
                .weight(0.5f)) {
                OscilloscopeView(state)
            }
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(0.5f)) {
                OscilloscopeControl(viewModel, state)
            }
        }
    }
}

@Composable
fun OscilloscopeView(state: OscilloscopeState) {
    val colors = Array(6) {Color.hsv(60.0f * it, 1.0f, 1.0f)}
    Canvas(Modifier.fillMaxSize()) {
        drawRect(Color.Black, Offset(0.0f, 0.0f), size)
        for (i in 0..8) {
            drawLine(
                Color.White,
                Offset(0.0f, size.height * i / 8),
                Offset(size.width, size.height * i / 8),
                if (i == 4) 3.0f else 2.0f
            )
            drawLine(
                Color.White,
                Offset(size.width * i / 8, 0.0f),
                Offset(size.width * i/ 8, size.height),
                if (i == 4) 3.0f else 2.0f
            )
        }
        for (i in 0 until 8) {
            drawLine(
                Color.White,
                Offset(size.width / 2 - size.width / 32, size.height * i / 8 + size.height / 16),
                Offset(size.width / 2 + size.width / 32, size.height * i / 8 + size.height / 16),
                2.0f
            )
            drawLine(
                Color.White,
                Offset(size.width * i / 8 + size.width / 16, size.height / 2 - size.height / 32),
                Offset(size.width * i / 8 + size.width  / 16, size.height / 2 + size.height / 32),
                2.0f
            )
        }
        var startVa = Offset(0.0f, 0.0f)
        var startVb = Offset(0.0f, 0.0f)
        var startVc = Offset(0.0f, 0.0f)
        var startIa = Offset(0.0f, 0.0f)
        var startIb = Offset(0.0f, 0.0f)
        var startIc = Offset(0.0f, 0.0f)
        val maxV = (state.maxV * 100).toInt()
        val minV = (state.minV * 100).toInt()
        val maxA = (state.maxA * 1000).toInt()
        val minA = (state.minA * 1000).toInt()
        for (i in 0 until state.svData.size step 6) {
            val x = size.width * i / 6 / state.n
            val endVa = Offset(x, size.height / (maxV - minV) * (maxV - state.svData[i]))
            val endVb = Offset(x, size.height / (maxV - minV) * (maxV - state.svData[i + 1]))
            val endVc = Offset(x, size.height / (maxV - minV) * (maxV - state.svData[i + 2]))
            val endIa = Offset(x, size.height / (maxA - minA) * (maxA - state.svData[i + 3]))
            val endIb = Offset(x, size.height / (maxA - minA) * (maxA - state.svData[i + 4]))
            val endIc = Offset(x, size.height / (maxA - minA) * (maxA - state.svData[i + 5]))
            if (i != 0) {
                if (state.vaEnable) drawLine(colors[0], startVa, endVa, 5.0f)
                if (state.vbEnable) drawLine(colors[1], startVb, endVb, 5.0f)
                if (state.vcEnable) drawLine(colors[2], startVc, endVc, 5.0f)
                if (state.iaEnable) drawLine(colors[3], startIa, endIa, 5.0f)
                if (state.ibEnable) drawLine(colors[4], startIb, endIb, 5.0f)
                if (state.icEnable) drawLine(colors[5], startIc, endIc, 5.0f)
            }
            startVa = endVa
            startVb = endVb
            startVc = endVc
            startIa = endIa
            startIb = endIb
            startIc = endIc
        }
    }
}

@Composable
fun SiInput(label: Int, text: String, onValueChange: (String)->Unit, suffix: String, modifier: Modifier) {
    TextField(
        value = text,
        onValueChange = onValueChange,
        modifier = modifier,
        label = { Text(stringResource(label)) },
        isError = text.toSiFloatOrNull() == null,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        visualTransformation = if (text.isEmpty() || text.toSiFloatOrNull() == null)
            VisualTransformation.None
        else
            SuffixTransformation(suffix)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComboBox(level: Int, text:String, list: List<String>, onClick: (String)->Unit, modifier: Modifier) {
    var expanded by remember { mutableStateOf(false) }
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier
    ) {
        TextField(
            readOnly = true,
            value = text,
            onValueChange = {},
            modifier = Modifier.menuAnchor(),
            label = { Text(stringResource(level)) },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            list.forEach {
                DropdownMenuItem(
                    text = {Text(it)},
                    onClick = {
                        onClick(it)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun OscilloscopeControl(viewModel: SharedViewModel, state: OscilloscopeState) {
    var minVText by remember { mutableStateOf(state.minV.toString()) }
    var maxVText by remember { mutableStateOf(state.maxV.toString()) }
    var minAText by remember { mutableStateOf(state.minA.toString()) }
    var maxAText by remember { mutableStateOf(state.maxA.toString()) }
    var sDivText by remember { mutableStateOf(DecimalFormat("#.###").format(state.sDiv)) }
    var levelText by remember { mutableStateOf(state.level.toString()) }
    var positionText by remember { mutableStateOf(state.position.toString()) }
    val edgeList = listOf("Both", "Up", "Down")
    var edgeText by remember { mutableStateOf(edgeList[state.edge]) }
    var vaEnable by remember { mutableStateOf(state.vaEnable)}
    var vbEnable by remember { mutableStateOf(state.vbEnable)}
    var vcEnable by remember { mutableStateOf(state.vcEnable)}
    var iaEnable by remember { mutableStateOf(state.iaEnable)}
    var ibEnable by remember { mutableStateOf(state.ibEnable)}
    var icEnable by remember { mutableStateOf(state.icEnable)}
    val colors = Array(6) {Color.hsv(60.0f * it, 1.0f, 0.78f)}
    val parallelogramShape = ParallelogramShape(45.0f)

    LazyColumn(
        Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
    ) {
        item {
            Row {
                SiInput(R.string.min_v, minVText, {minVText = it}, "V", Modifier.weight(1.0f))
                SiInput(R.string.max_v, maxVText, {maxVText = it}, "V", Modifier.weight(1.0f))
                SiInput(R.string.min_a, minAText, {minAText = it}, "A", Modifier.weight(1.0f))
                SiInput(R.string.max_a, maxAText, {maxAText = it}, "A", Modifier.weight(1.0f))
            }
        }
        item {
            Row {
                SiInput(R.string.s_div, sDivText, {sDivText = it}, "", Modifier.weight(1.0f))
                SiInput(R.string.level, levelText, {levelText = it}, "V", Modifier.weight(0.9f))
                SiInput(R.string.position, positionText, {positionText = it}, "s", Modifier.weight(0.9f))
                ComboBox(R.string.edge, edgeText, edgeList, {edgeText = it}, Modifier.weight(1.2f))
            }
        }
        item {
            Button(
                onClick = {
                    val oscilloscopeState = OscilloscopeState()
                    oscilloscopeState.minV = minVText.toSiFloatOrNull() ?: state.minV
                    oscilloscopeState.maxV = maxVText.toSiFloatOrNull() ?: state.maxV
                    oscilloscopeState.minA = minAText.toSiFloatOrNull() ?: state.minA
                    oscilloscopeState.maxA = maxAText.toSiFloatOrNull() ?: state.maxA
                    oscilloscopeState.sDiv = sDivText.toSiFloatOrNull() ?: state.sDiv
                    oscilloscopeState.n = (3600 * oscilloscopeState.sDiv * 8).toInt()
                    oscilloscopeState.level = levelText.toSiFloatOrNull() ?: state.level
                    oscilloscopeState.position = positionText.toSiFloatOrNull() ?: state.position
                    oscilloscopeState.p = (oscilloscopeState.position * 3600).toInt()
                    oscilloscopeState.edge = edgeList.indexOf(edgeText)
                    oscilloscopeState.vaEnable  = state.vaEnable
                    oscilloscopeState.vbEnable  = state.vbEnable
                    oscilloscopeState.vcEnable  = state.vcEnable
                    oscilloscopeState.iaEnable  = state.iaEnable
                    oscilloscopeState.ibEnable  = state.ibEnable
                    oscilloscopeState.icEnable  = state.icEnable
                    viewModel.onOscilloscopeEvent(OscilloscopeEvent.Apply(oscilloscopeState))
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RectangleShape,
                enabled = !minVText.isEqualOrNull(state.minV) ||
                        !maxVText.isEqualOrNull(state.maxV) ||
                        !minAText.isEqualOrNull(state.minA) ||
                        !maxAText.isEqualOrNull(state.maxA) ||
                        !sDivText.isEqualOrNull(state.sDiv) ||
                        levelText.isEqualOrNull(state.level) ||
                        !positionText.isEqualOrNull(state.position) ||
                        edgeList.indexOf(edgeText) != state.edge
            ) {
                Text(stringResource(R.string.apply))
            }
        }
        item {
            Row {
                Button(onClick = {
                    vaEnable = !vaEnable
                    viewModel.onOscilloscopeEvent(OscilloscopeEvent.VaEnableChanged(vaEnable))
                },
                    Modifier.weight(1.0f),
                    shape = parallelogramShape,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (vaEnable) colors[0] else Color.Gray)) {
                    Text(stringResource(R.string.va))
                }
                Button(onClick = {
                    vbEnable = !vbEnable
                    viewModel.onOscilloscopeEvent(OscilloscopeEvent.VbEnableChanged(vbEnable))
                },
                    Modifier.weight(1.0f),
                    shape = parallelogramShape,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (vbEnable) colors[1] else Color.Gray)) {
                    Text(stringResource(R.string.vb))
                }
                Button(onClick = {
                    vcEnable = !vcEnable
                    viewModel.onOscilloscopeEvent(OscilloscopeEvent.VcEnableChanged(vcEnable))
                },
                    Modifier.weight(1.0f),
                    shape = parallelogramShape,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (vcEnable) colors[2] else Color.Gray)) {
                    Text(stringResource(R.string.vc))
                }
                Button(onClick = {
                    iaEnable = !iaEnable
                    viewModel.onOscilloscopeEvent(OscilloscopeEvent.IaEnableChanged(iaEnable))
                },
                    Modifier.weight(1.0f),
                    shape = parallelogramShape,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (iaEnable) colors[3] else Color.Gray)) {
                    Text(stringResource(R.string.ia))
                }
                Button(onClick = {
                    ibEnable = !ibEnable
                    viewModel.onOscilloscopeEvent(OscilloscopeEvent.IbEnableChanged(ibEnable))
                },
                    Modifier.weight(1.0f),
                    shape = parallelogramShape,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (ibEnable) colors[4] else Color.Gray)) {
                    Text(stringResource(R.string.ib))
                }
                Button(onClick = {
                    icEnable = !icEnable
                    viewModel.onOscilloscopeEvent(OscilloscopeEvent.IcEnableChanged(icEnable))
                },
                    Modifier.weight(1.0f),
                    shape = parallelogramShape,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (icEnable) colors[5] else Color.Gray)) {
                    Text(stringResource(R.string.ic))
                }
            }
        }
    }
}

class ParallelogramShape(private val angle: Float): Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density,
    ) = Outline.Generic(
        Path().apply {
            val width = size.width - size.height / tan(angle)
            moveTo(size.width - width, 0f)
            lineTo(size.width, 0f)
            lineTo(width, size.height)
            lineTo(0f, size.height)
            lineTo(size.width - width, 0f)
        }
    )
}

fun Float.toSiString(format: String): String {
    return if (this.absoluteValue < 1000) format.format(this)
    else if (this.absoluteValue < 1000000.0f) "${format.format(this / 1000.0f)}k"
    else if (this.absoluteValue < 1000000000.0f) "${format.format(this / 1000000.0f)}M"
    else if (this.absoluteValue < 1000000000000.0f) "${format.format(this / 1000000000.0f)}G"
    else "${format.format(this / 1000000000000.0f)}T"
}

fun String.toSiFloat(): Float {
    return this.toSiFloatOrNull() ?: 0.0f
}

fun String.toSiFloatOrNull(): Float? {
    var str = this
    var m  =  1.0f
    if (str.endsWith("m")) {
        str = str.dropLast(1)
        m = 0.001f
    } else if (str.endsWith("k")) {
        str = str.dropLast(1)
        m = 1000.0f
    } else if (str.endsWith("M")) {
        str = str.dropLast(1)
        m = 1000000.0f
    } else if (str.endsWith("G")) {
        str = str.dropLast(1)
        m = 1000000000.0f
    } else if (str.endsWith("T")) {
        str = str.dropLast(1)
        m = 1000000000000.0f
    }
    val f = str.toFloatOrNull()
    return if (str.isEmpty() || f  == null) null else f * m
}

fun String.isEqualOrNull(value: Float): Boolean {
    val v = this.toSiFloatOrNull()
    return v == null || v == value
}

class SuffixTransformation(private val suffix: String) : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val result = text + AnnotatedString(suffix)
        val numberOffsetTranslator = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                return offset
            }
            override fun transformedToOriginal(offset: Int): Int {
                if (text.isEmpty()) return 0
                if (offset >=  text.length) return text.length
                return offset
            }
        }
        return TransformedText(result, numberOffsetTranslator)
    }
}

@Preview
@Composable
fun OscilloscopeScreenPreview() {
    VIPAM3500Theme() {
        OscilloscopeScreen(viewModel = viewModel())
    }
}