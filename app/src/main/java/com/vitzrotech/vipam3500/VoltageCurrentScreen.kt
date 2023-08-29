package com.vitzrotech.vipam3500

import android.content.res.Configuration.ORIENTATION_PORTRAIT
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme
import kotlin.math.PI
import kotlin.math.absoluteValue
import kotlin.math.cos
import kotlin.math.sin

data class Phase(val name: String, val mag: Float, val ang: Float)

@OptIn(ExperimentalTextApi::class)
@Composable
fun VoltageCurrentScreen(viewModel: SharedViewModel) {
    val vAMag by remember { viewModel.vAMag }
    val vAAng by remember { viewModel.vAAng }
    val vBMag by remember { viewModel.vBMag }
    val vBAng by remember { viewModel.vBAng }
    val vCMag by remember { viewModel.vCMag }
    val vCAng by remember { viewModel.vCAng }
    val iAMag by remember { viewModel.iAMag }
    val iAAng by remember { viewModel.iAAng }
    val iBMag by remember { viewModel.iBMag }
    val iBAng by remember { viewModel.iBAng }
    val iCMag by remember { viewModel.iCMag }
    val iCAng by remember { viewModel.iCAng }
    val voltage = arrayOf(
        Phase("Va", vAMag, 0.0f),
        Phase("Vb", vBMag, vBAng - vAAng),
        Phase("Vc", vCMag, vCAng - vAAng)
    )
    val current = arrayOf(
        Phase("Ia", iAMag, iAAng - vAAng),
        Phase("Ib", iBMag, iBAng - vAAng),
        Phase("Ic", iCMag, iCAng - vAAng)
    )
    val voltageRange = voltageRange(maxOf(vAMag, vBMag, vCMag))
    val currentRange = currentRange(maxOf(iAMag, iBMag, iCMag))
    if (LocalConfiguration.current.orientation == ORIENTATION_PORTRAIT) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)) {
                VoltageCurrentDiagram(voltage, current, voltageRange, currentRange)
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)) {
                VoltageCurrentTable(voltage, current)
            }
        }
    } else {
        Row(modifier = Modifier.fillMaxSize()) {
            Column (modifier = Modifier
                .fillMaxHeight()
                .weight(0.5f)) {
                VoltageCurrentDiagram(voltage, current, voltageRange, currentRange)
            }
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(0.5f)) {
                VoltageCurrentTable(voltage, current)
            }
        }
    }
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun VoltageCurrentDiagram(voltage: Array<Phase>, current: Array<Phase>, voltageRange: Float, currentRange: Float) {
    val textMeasure = rememberTextMeasurer()
    Canvas(
        modifier = Modifier.fillMaxSize()
    ) {
        val radius = if (size.width > size.height) size.height / 2  - 30 else size.width / 2 - 30
        val cx = size.width / 2
        val cy = size.height / 2
        for (i in 1..4) {
            drawCircle(Color.Black, radius / 4.0f * i, style = Stroke(2.0f))
        }
        for (i in 0 until 360 step 30) {
            rotate(i.toFloat()) {
                drawLine(Color.Black, Offset(cx + radius / 4.0f, cy), Offset(cx + radius, cy))
            }
        }
        voltage.forEach {
            if (it.mag != 0.0f) {
                rotate(-it.ang) {
                    drawPath(arrow(radius * it.mag / voltageRange, cx, cy), Color.Blue)
                }
                val s = textMeasure.measure(AnnotatedString(it.name)).size
                val r = radius * it.mag / voltageRange + 20
                val theta = -it.ang * PI.toFloat() / 180.0f
                drawText(
                    textMeasure, it.name,
                    Offset(cx + r * cos(theta) - s.width / 2, cy + r * sin(theta) - s.height / 2),
                    TextStyle(Color.Blue)
                )
            }
        }
        current.forEach {
            if (it.mag != 0.0f) {
                rotate(-it.ang) {
                    drawPath(arrow(radius * it.mag / currentRange, cx, cy), Color.Red)
                }
                val s = textMeasure.measure(AnnotatedString(it.name)).size
                val r = radius * it.mag / currentRange + 20
                val theta = -it.ang * PI.toFloat() / 180.0f
                drawText(
                    textMeasure, it.name,
                    Offset(cx + r * cos(theta) - s.width / 2, cy + r * sin(theta) - s.height / 2),
                    TextStyle(Color.Red)
                )
            }
        }
        var str = "V range: ${voltageRange.toUnitString("%.02f", "V")}"
        var s = textMeasure.measure(AnnotatedString(str)).size
        drawText(textMeasure, str, Offset(60.0f, size.height - s.height),
            TextStyle(Color.Blue))
        str = "I range: ${currentRange.toUnitString("%.02f", "A")}"
        s = textMeasure.measure(AnnotatedString(str)).size
        drawText(textMeasure, str, Offset(size.width - s.width - 60, size.height - s.height),
            TextStyle(Color.Red)
        )
    }
}

@Composable
fun VoltageCurrentTable(voltage: Array<Phase>, current: Array<Phase>) {
    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(2.dp, Color.Black)) {
        items(voltage.size) {
            val v = voltage[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.name,
                    Modifier
                        .border(1.dp, Color.Black)
                        .weight(0.3f)
                        .padding(8.dp, 4.dp))
                Text("${v.mag.toUnitString("%.02f","V")} \u2220${v.ang.toUnitString("%.02f", "\u00B0")}",
                    Modifier
                        .border(1.dp, Color.Black)
                        .weight(0.7f)
                        .padding(8.dp, 4.dp))
            }
        }
        items(current.size) {
            val i = current[it]
            Row(Modifier.fillMaxWidth()) {
                Text(i.name,
                    Modifier
                        .border(1.dp, Color.Black)
                        .weight(0.3f)
                        .padding(8.dp, 4.dp))
                Text("${i.mag.toUnitString("%.02f","A")} \u2220${i.ang.toUnitString("%.02f", "\u00B0")}",
                    Modifier
                        .border(1.dp, Color.Black)
                        .weight(0.7f)
                        .padding(8.dp, 4.dp))
            }
        }
    }
}

fun arrow(radius: Float, cx: Float, cy: Float): Path {
    return Path().apply {
        moveTo(cx + radius, cy)
        if (radius > 40) {
            lineTo(cx + radius - 40.0f, cy + 10.0f)
            lineTo(cx + radius - 40.0f, cy + 5.0f)
            lineTo(cx, cy + 5.0f)
            lineTo(cx, cy - 5.0f)
            lineTo(cx + radius - 40.0f, cy - 5.0f)
            lineTo(cx + radius - 40.0f, cy - 10.0f)
        } else {
            lineTo(cx, cy + radius / 4)
            lineTo(cx, cy - radius / 4)
        }
        lineTo(cx + radius, cy)
        close()
    }
}

fun voltageRange(value: Float): Float {
    return if (value < 150.0f) 150.0f
    else if (value < 300.0f) 300.0f
    else if (value < 600.0f) 600.0f
    else if (value < 5000.0f) 5000.0f
    else if (value < 8000.0f) 8000.0f
    else if (value < 15000.0f) 15000.0f
    else if (value < 26000.0f) 26000.0f
    else if (value < 40000.0f) 40000.0f
    else if (value < 80000.0f) 80000.0f
    else if (value < 180000.0f) 180000.0f
    else if (value < 400000.0f) 400000.0f
    else 800000.0f
}

fun currentRange(value: Float): Float {
    return if  (value < 1.0f) 1.0f
    else if (value < 3.0f) 3.0f
    else if (value < 5.0f) 5.0f
    else if (value < 10.0f) 10.0f
    else if (value < 30.0f) 30.0f
    else if (value < 50.0f) 50.0f
    else if (value < 100.0f) 100.0f
    else if (value < 300.0f) 300.0f
    else if (value < 500.0f) 500.0f
    else if (value < 1000.0f) 1000.0f
    else if (value < 3000.0f) 3000.0f
    else if (value < 5000.0f) 5000.0f
    else if (value < 10000.0f) 10000.0f
    else if (value < 30000.0f) 30000.0f
    else if (value < 50000.0f) 50000.0f
    else 100000.0f
}

fun Float.toUnitString(format: String, unit: String): String {
    return if (this.absoluteValue < 1000) "${format.format(this)}$unit"
    else if (this.absoluteValue < 1000000.0f) "${format.format(this / 1000.0f)}k$unit"
    else if (this.absoluteValue < 1000000000.0f) "${format.format(this / 1000000.0f)}M$unit"
    else if (this.absoluteValue < 1000000000000.0f) "${format.format(this / 1000000000.0f)}G$unit"
    else "${format.format(this / 1000000000000.0f)}T$unit"
}

@Preview
@Composable
fun VAScreenPreview() {
    VIPAM3500Theme() {
        VoltageCurrentScreen(viewModel())
    }
}