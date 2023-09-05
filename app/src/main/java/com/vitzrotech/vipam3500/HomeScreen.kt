package com.vitzrotech.vipam3500

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.Log
import android.util.Size
import android.view.View
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme
import java.beans.PropertyChangeEvent
import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import java.io.InputStream
import java.lang.Float.min
import java.nio.ByteBuffer
import java.nio.ByteOrder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            MIMICView(context).apply {
            }
        },
        update = {
        }
    )
}

@Preview
@Composable
fun HomeScreenPreview() {
    VIPAM3500Theme {
        HomeScreen()
    }
}

class TopicMap<K, V> : HashMap<K, V>() {
    private val ps = PropertyChangeSupport(this)

    fun addMapListener(pcl: PropertyChangeListener?) {
        ps.addPropertyChangeListener(pcl)
    }

    fun removeMapListener(pcl: PropertyChangeListener) {
        ps.removePropertyChangeListener(pcl)
    }

    override fun put(key: K, value: V): V? {
        Log.d("topics", "key = $key, value = $value")
        val ret = super.put(key, value)
        ps.firePropertyChange("map", ret, value)
        return ret
    }
}

var topics = TopicMap<String, Any>()

class MIMICView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : View(context, attrs, defStyle), PropertyChangeListener {
    private var diStatus: Int = 0
    private var mimicData = MIMICData()
    private var lines = mutableListOf<LineData>()
    private var symbols = mutableListOf<SymbolData>()
    private var texts = mutableListOf<TextData>()
    private var zoom = 1.0f
    private var x = 0
    private var y = 0

    init {
        val input = context.assets.open("cfgMiMiC.bin")
        input.skip(28)
        mimicData.rowCount = 26
        mimicData.colCount = 38
        mimicData.cellSize = Size(16, 16)
        for (row in 0 until mimicData.rowCount) {
            for (col in 0 until mimicData.colCount) {
                val line = LineAttr()
                line.index = readInt(input)
                if (line.index >= 0 && line.index < lineFileNames.size) {
                    val lineData = LineData()
                    lineData.x = col * mimicData.cellSize.width
                    lineData.y = row * mimicData.cellSize.height
                    lineData.lineAttr = line
                    val name = lineFileNames[line.index]
                    val stream = context.assets.open(name)
                    lineData.bitmap = replaceColor(BitmapFactory.decodeStream(stream))
                    lines.add(lineData)
                }
            }
        }
        for (row in 0 until mimicData.rowCount) {
            for (col in 0 until mimicData.colCount) {
                val symbol = SymbolAttr()
                symbol.index = readInt(input)
                symbol.onOff = readInt(input)
                symbol.state = readInt(input)
                symbol.category = readInt(input)
                symbol.dataPoint = readInt(input)
                if(symbol.index >= 0 && symbol.index < symbolFileNames.size) {
                    val symbolData = SymbolData()
                    symbolData.x = col * mimicData.cellSize.width
                    symbolData.y = row * mimicData.cellSize.height
                    symbolData.symbolAttr = symbol
                    val names = symbolFileNames[symbol.index]
                    names.forEach { name ->
                        val stream = context.assets.open(name)
                        val bitmap = replaceColor(BitmapFactory.decodeStream(stream))
                        symbolData.bitmaps.add(bitmap)
                    }
                    symbols.add(symbolData)
                }
            }
        }
        for (row in 0 until mimicData.rowCount) {
            for (col in 0 until mimicData.colCount) {
                val text = TextAttr()
                text.exist = readInt(input)
                text.enableMap = readInt(input)
                text.category = readInt(input)
                text.dataPoint = readInt(input)
                text.dataType = readInt(input)
                text.stringFormat = readString(input, 128)
                text.fuu = readInt(input)
                text.stringFuu = readString(input, 32)
                text.transparent = readInt(input)
                text.fontName = readString(input, 128)
                text.fontType = readInt(input)
                text.fontSize = readInt(input)
                text.fontBold = readInt(input)
                text.fontColor = readInt(input)
                if(text.exist != 0)
                {
                    val textData = TextData()
                    textData.x = col * mimicData.cellSize.width
                    textData.y = row * mimicData.cellSize.height
                    textData.textAttr = text
                    texts.add(textData)
                }
            }
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        topics.addMapListener(this)
        Log.d("MIMIC Screen", "attached")
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        topics.removeMapListener(this)
        Log.d("MIMIC Screen", "detached")
    }

    override fun propertyChange(evt: PropertyChangeEvent?) {
        Log.d("MIMIC Screen", "changed")
        invalidate();
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        val mimicWidth = (mimicData.colCount * mimicData.cellSize.width)
        val mimicHeight = (mimicData.rowCount * mimicData.cellSize.height)
        val zoomX = width.toFloat() / mimicWidth.toFloat()
        val zoomY = height.toFloat() / mimicHeight.toFloat()
        zoom = min(zoomX, zoomY)
        x = if (zoomX > zoomY) (w - (mimicWidth * zoom).toInt()) / 2 else  0
        y = if (zoomY > zoomX) (h - (mimicHeight * zoom).toInt()) / 2 else  0
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        lines.forEach { line ->
            line.bitmap?.let { bitmap ->
                canvas?.drawBitmap(bitmap, Rect(0, 0, bitmap.width, bitmap.height),
                    RectF(x + line.x * zoom, y + line.y * zoom,
                        x + (line.x + bitmap.width) * zoom,
                        y + (line.y + bitmap.height) * zoom), paint)
            }
        }
        symbols.forEach { symbol ->
            symbol.mode = symbolMode(symbol.symbolAttr)
            if (symbol.mode >= 0 && symbol.mode < symbol.bitmaps.size) {
                val bitmap = symbol.bitmaps[symbol.mode]
                canvas?.drawBitmap(bitmap, Rect(0, 0, bitmap.width, bitmap.height),
                    RectF(x + symbol.x * zoom, y + symbol.y * zoom,
                        x + (symbol.x + bitmap.width) * zoom,
                        y + (symbol.y + bitmap.height) * zoom), paint)
            }
        }
        texts.forEach {
            paint.textSize = it.textAttr.fontSize * zoom
            if (it.textAttr.fontBold != 0)
                paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            else
                paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
            paint.color = 0xff000000.toInt() or it.textAttr.fontColor
            val textValue = convertText(it.textAttr)
            canvas?.drawText(textValue, x + it.x * zoom, y + it.y * zoom, paint)
        }
    }

    private fun replaceColor(src: Bitmap): Bitmap {
        val pixels = IntArray(src.width * src.height)
        src.getPixels(pixels, 0, src.width, 0, 0, src.width, src.height)
        pixels.indices.forEach {
            if (pixels[it] == 0xffff00ff.toInt()) pixels[it] = 0
        }
        return Bitmap.createBitmap(pixels, src.width, src.height, Bitmap.Config.ARGB_8888)
    }

    private fun readInt(input: InputStream): Int {
        val bytes = ByteArray(4)
        input.read(bytes, 0, 4)
        return ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).int
    }

    private fun readString(input: InputStream, size: Int): String {
        val bytes = ByteArray(size)
        input.read(bytes, 0, size)
        val n = bytes.indexOf(0)
        if (n == 0)
            return ""
        else if (n < 0)
            return String(bytes)
        else
            return String(bytes.copyOf(n))
    }

    private fun convertUnitValue(value: Float, unit: String): UnitValue {
        val unitValue = UnitValue()
        if ((value >= 1000.0f && value  < 1000000.0f) || (value <= -1000.0f && value  > -1000000.0f)) {
            unitValue.value = value / 1000.0f
            unitValue.unit = "k$unit"
        } else if( (value >= 1000000.0f && value  < 1000000000.0f) ||
            (value <= -1000000.0f && value  > -1000000000.0f) ) {
            unitValue.value = value / 1000000.0f
            unitValue.unit = "M$unit"
        } else if ((value >= 1000000000.0f) || (value <= -1000000000.0f)) {
            unitValue.value = value /1000000000.0f
            unitValue.unit = "G$unit"
        } else {
            unitValue.value = value
            unitValue.unit = unit
        }
        return unitValue
    }

    private fun convertAzimuthValue(value: Float): Float {
        if (value < 0)
            return 360 + value
        return value
    }

    private fun convertText(attr: TextAttr): String
    {
        val load = attr.stringFormat
        if (attr.enableMap != 0)
        {
            var unit = ""
            if (attr.fuu != 0)
                unit =  attr.stringFuu
            val convert = "$load "
            Log.d("MIMICScreen", "dataPoint = ${attr.dataPoint}")
            val variable = data(attr.dataPoint)
            val unitValue = convertUnitValue(variable, unit)
            val render = convert.format(unitValue.value)
            Log.d("convertText", "render = $render")
            if (attr.dataPoint == 58 || attr.dataPoint == 59) {
                if ((topics["MI/MMXU/TotPF/mag"] as? Float ?: 0.0f)  > 0)
                    return "$render Lag"
                else
                    return "$render Lead"
            } else {
                return "$render ${unitValue.unit}"
            }
        }
        return load
    }

    private fun symbolMode(symbol: SymbolAttr): Int {
        return if ((symbol.index >= 0) && (symbol.index <= 7)) {
            val status1 = (0x1 shl (symbol.dataPoint and 0xffff) and diStatus) != 0
            val status2 = (0x1 shl (symbol.dataPoint shr 16) and diStatus) != 0
            if (!status1 && status2) 0 else if (status1 && !status2) 1 else 2
        } else if (((symbol.index >= 8) && (symbol.index <= 10)) ||
            ((symbol.index >= 47) && (symbol.index <= 58))) {
            if ((symbol.dataPoint and 0xffff) <= 31) {
                0x1 shl (symbol.dataPoint and 0xffff) and diStatus
            } else  {
                val status = when(symbol.dataPoint.toUInt()) {
                    0xFFFF4F20u -> topics["system/symStu/op_Stored/bit/TOCA1"] as? Boolean?: false
                    0xFFFF4F21u -> topics["system/symStu/op_Stored/bit/TOCB1"] as? Boolean?: false
                    0xFFFF4F22u -> topics["system/symStu/op_Stored/bit/TOCC1"] as? Boolean?: false
                    0xFFFF4F23u -> topics["system/symStu/op_Stored/bit/TOCA2"] as? Boolean?: false
                    0xFFFF4F24u -> topics["system/symStu/op_Stored/bit/TOCB2"] as? Boolean?: false
                    0xFFFF4F25u -> topics["system/symStu/op_Stored/bit/TOCC2"] as? Boolean?: false
                    0xFFFF4F26u -> topics["system/symStu/op_Stored/bit/TOCN1"] as? Boolean?: false
                    0xFFFF4F27u -> topics["system/symStu/op_Stored/bit/TOCN2"] as? Boolean?: false
                    0xFFFF4F28u -> topics["system/symStu/op_Stored/bit/IOCA1"] as? Boolean?: false
                    0xFFFF4F29u -> topics["system/symStu/op_Stored/bit/IOCB1"] as? Boolean?: false
                    0xFFFF4F2Au -> topics["system/symStu/op_Stored/bit/IOCC1"] as? Boolean?: false
                    0xFFFF4F2Bu -> topics["system/symStu/op_Stored/bit/IOCA2"] as? Boolean ?: false
                    0xFFFF4F2Cu -> topics["system/symStu/op_Stored/bit/IOCB2"] as? Boolean ?: false
                    0xFFFF4F2Du -> topics["system/symStu/op_Stored/bit/IOCC2"] as? Boolean ?: false
                    0xFFFF4F2Eu -> topics["system/symStu/op_Stored/bit/IOCN1"] as? Boolean ?: false
                    0xFFFF4F2Fu -> topics["system/symStu/op_Stored/bit/IOCN2"] as? Boolean ?: false
                    0xFFFF4F30u -> topics["system/symStu/op_Stored/bit/TVVSA"] as? Boolean ?: false
                    0xFFFF4F31u -> topics["system/symStu/op_Stored/bit/TVVSB"] as? Boolean ?: false
                    0xFFFF4F32u -> topics["system/symStu/op_Stored/bit/TVVSC"] as? Boolean ?: false
                    0xFFFF4F33u -> topics["system/symStu/op_Stored/bit/RecSignal"] as? Boolean ?: false
                    0xFFFF4F34u -> topics["system/symStu/op_Stored/bit/TOVN1"] as? Boolean ?: false
                    0xFFFF4F35u -> topics["system/symStu/op_Stored/bit/TOVN2"] as? Boolean ?: false
                    0xFFFF4F37u -> topics["system/symStu/op_Stored/bit/TOVA1"] as? Boolean ?: false
                    0xFFFF4F38u -> topics["system/symStu/op_Stored/bit/TOVB1"] as? Boolean ?: false
                    0xFFFF4F39u -> topics["system/symStu/op_Stored/bit/TOVC1"] as? Boolean ?: false
                    0xFFFF4F3Au -> topics["system/symStu/op_Stored/bit/TOVA2"] as? Boolean ?: false
                    0xFFFF4F3Bu -> topics["system/symStu/op_Stored/bit/TOVB2"] as? Boolean ?: false
                    0xFFFF4F3Cu -> topics["system/symStu/op_Stored/bit/TOVC2"] as? Boolean ?: false
                    0xFFFF4F3Du -> topics["system/symStu/op_Stored/bit/TUVA1"] as? Boolean ?: false
                    0xFFFF4F3Eu -> topics["system/symStu/op_Stored/bit/TUVB1"] as? Boolean ?: false
                    0xFFFF4F3Fu -> topics["system/symStu/op_Stored/bit/TUVC1"] as? Boolean ?: false
                    0xFFFF4F40u -> topics["system/symStu/op_Stored/bit/TUVA2"] as? Boolean ?: false
                    0xFFFF4F41u -> topics["system/symStu/op_Stored/bit/TUVB2"] as? Boolean ?: false
                    0xFFFF4F42u -> topics["system/symStu/op_Stored/bit/TUVC2"] as? Boolean ?: false
                    0xFFFF4F48u -> topics["system/symStu/op_Stored/bit/TOVA21"] as? Boolean ?: false
                    0xFFFF4F49u -> topics["system/symStu/op_Stored/bit/TOVB21"] as? Boolean ?: false
                    0xFFFF4F4Au -> topics["system/symStu/op_Stored/bit/TOVC21"] as? Boolean ?: false
                    0xFFFF4F4Bu -> topics["system/symStu/op_Stored/bit/TOVA22"] as? Boolean ?: false
                    0xFFFF4F4Cu -> topics["system/symStu/op_Stored/bit/TOVB22"] as? Boolean ?: false
                    0xFFFF4F4Du -> topics["system/symStu/op_Stored/bit/TOVC22"] as? Boolean ?: false
                    0xFFFF4F50u -> topics["system/symStu/op_Stored/bit/TUVA21"] as? Boolean ?: false
                    0xFFFF4F51u -> topics["system/symStu/op_Stored/bit/TUVB21"] as? Boolean ?: false
                    0xFFFF4F52u -> topics["system/symStu/op_Stored/bit/TUVC21"] as? Boolean ?: false
                    0xFFFF4F53u -> topics["system/symStu/op_Stored/bit/TUVA22"] as? Boolean ?: false
                    0xFFFF4F54u -> topics["system/symStu/op_Stored/bit/TUVB22"] as? Boolean ?: false
                    0xFFFF4F55u -> topics["system/symStu/op_Stored/bit/TUVC22"] as? Boolean ?: false
                    0xFFFF5020u -> topics["system/symStu/str/bit/TOCA1"] as? Boolean?: false
                    0xFFFF5021u -> topics["system/symStu/str/bit/TOCB1"] as? Boolean ?: false
                    0xFFFF5022u -> topics["system/symStu/str/bit/TOCC1"] as? Boolean ?: false
                    0xFFFF5023u -> topics["system/symStu/str/bit/TOCA2"] as? Boolean ?: false
                    0xFFFF5024u -> topics["system/symStu/str/bit/TOCB2"] as? Boolean ?: false
                    0xFFFF5025u -> topics["system/symStu/str/bit/TOCC2"] as? Boolean ?: false
                    0xFFFF5026u -> topics["system/symStu/str/bit/TOCN1"] as? Boolean ?: false
                    0xFFFF5027u -> topics["system/symStu/str/bit/TOCN2"] as? Boolean ?: false
                    0xFFFF5028u -> topics["system/symStu/str/bit/IOCA1"] as? Boolean ?: false
                    0xFFFF5029u -> topics["system/symStu/str/bit/IOCB1"] as? Boolean ?: false
                    0xFFFF502Au -> topics["system/symStu/str/bit/IOCC1"] as? Boolean ?: false
                    0xFFFF502Bu -> topics["system/symStu/str/bit/IOCA2"] as? Boolean ?: false
                    0xFFFF502Cu -> topics["system/symStu/str/bit/IOCB2"] as? Boolean ?: false
                    0xFFFF502Du -> topics["system/symStu/str/bit/IOCC2"] as? Boolean ?: false
                    0xFFFF502Eu -> topics["system/symStu/str/bit/IOCN1"] as? Boolean ?: false
                    0xFFFF502Fu -> topics["system/symStu/str/bit/IOCN2"] as? Boolean ?: false
                    0xFFFF5030u -> topics["system/symStu/str/bit/TVVSA"] as? Boolean ?: false
                    0xFFFF5031u -> topics["system/symStu/str/bit/TVVSB"] as? Boolean ?: false
                    0xFFFF5032u -> topics["system/symStu/str/bit/TVVSC"] as? Boolean ?: false
                    0xFFFF5033u -> topics["system/symStu/str/bit/RecSignal"] as? Boolean ?: false
                    0xFFFF5034u -> topics["system/symStu/str/bit/TOVN1"] as? Boolean ?: false
                    0xFFFF5035u -> topics["system/symStu/str/bit/TOVA2"] as? Boolean ?: false
                    0xFFFF5038u -> topics["system/symStu/str/bit/TOVA1"] as? Boolean ?: false
                    0xFFFF5039u -> topics["system/symStu/str/bit/TOVB1"] as? Boolean ?: false
                    0xFFFF503Au -> topics["system/symStu/str/bit/TOVC1"] as? Boolean ?: false
                    0xFFFF503Bu -> topics["system/symStu/str/bit/TOVA2"] as? Boolean ?: false
                    0xFFFF503Cu -> topics["system/symStu/str/bit/TOVB2"] as? Boolean ?: false
                    0xFFFF503Du -> topics["system/symStu/str/bit/TOVC2"] as? Boolean ?: false
                    0xFFFF5040u -> topics["system/symStu/str/bit/TUVA1"] as? Boolean ?: false
                    0xFFFF5041u -> topics["system/symStu/str/bit/TUVB1"] as? Boolean ?: false
                    0xFFFF5042u -> topics["system/symStu/str/bit/TUVC1"] as? Boolean ?: false
                    0xFFFF5043u -> topics["system/symStu/str/bit/TUVA2"] as? Boolean ?: false
                    0xFFFF5044u -> topics["system/symStu/str/bit/TUVB2"] as? Boolean ?: false
                    0xFFFF5045u -> topics["system/symStu/str/bit/TUVC2"] as? Boolean ?: false
                    0xFFFF5048u -> topics["system/symStu/str/bit/TOVA21"] as? Boolean ?: false
                    0xFFFF5049u -> topics["system/symStu/str/bit/TOVB21"] as? Boolean ?: false
                    0xFFFF504Au -> topics["system/symStu/str/bit/TOVC21"] as? Boolean ?: false
                    0xFFFF504Bu -> topics["system/symStu/str/bit/TOVA22"] as? Boolean ?: false
                    0xFFFF504Cu -> topics["system/symStu/str/bit/TOVB22"] as? Boolean ?: false
                    0xFFFF504Du -> topics["system/symStu/str/bit/TOVC22"] as? Boolean ?: false
                    0xFFFF5050u -> topics["system/symStu/str/bit/TUVA21"] as? Boolean ?: false
                    0xFFFF5051u -> topics["system/symStu/str/bit/TUVB21"] as? Boolean ?: false
                    0xFFFF5052u -> topics["system/symStu/str/bit/TUVC21"] as? Boolean ?: false
                    0xFFFF5053u -> topics["system/symStu/str/bit/TUVA22"] as? Boolean ?: false
                    0xFFFF5054u -> topics["system/symStu/str/bit/TUVB22"] as? Boolean ?: false
                    0xFFFF5055u -> topics["system/symStu/str/bit/TUVC22"] as? Boolean ?: false
                    0xFFFF5220u -> (topics["system/symStu/op_Stored/bit/TOCA1"] as? Boolean ?: false) or (topics["system/symStu/op_Stored/bit/TOCB1"] as? Boolean ?: false) or (topics["system/symStu/op_Stored/bit/TOCC1"] as? Boolean ?: false)
                    0xFFFF5221u-> (topics["system/symStu/op_Stored/bit/TOCA2"] as? Boolean ?: false) or (topics["system/symStu/op_Stored/bit/TOCB2"] as? Boolean ?: false) or (topics["system/symStu/op_Stored/bit/TOCC2"] as? Boolean ?: false)
                    0xFFFF5222u -> topics["system/symStu/op_Stored/bit/TOCN1"] as? Boolean ?: false
                    0xFFFF5223u -> topics["system/symStu/op_Stored/bit/TOCN2"] as? Boolean ?: false
                    0xFFFF5224u -> (topics["system/symStu/op_Stored/bit/IOCA1"] as? Boolean ?: false) or (topics["system/symStu/op_Stored/bit/IOCB1"] as? Boolean ?: false) or (topics["system/symStu/op_Stored/bit/IOCC1"] as? Boolean ?: false)
                    0xFFFF5225u -> (topics["system/symStu/op_Stored/bit/IOCA2"] as? Boolean ?: false) or (topics["system/symStu/op_Stored/bit/IOCB2"] as? Boolean ?: false) or (topics["system/symStu/op_Stored/bit/IOCC2"] as? Boolean ?: false)
                    0xFFFF5226u -> topics["system/symStu/op_Stored/bit/IOCN1"] as? Boolean ?: false
                    0xFFFF5227u -> topics["system/symStu/op_Stored/bit/IOCN2"] as? Boolean ?: false
                    0xFFFF5228u -> (topics["system/symStu/op_Stored/bit/TVVSA"] as? Boolean ?: false) or (topics["system/symStu/op_Stored/bit/TVVSB"] as? Boolean ?: false) or (topics["system/symStu/op_Stored/bit/TVVSC"] as? Boolean ?: false)
                    0xFFFF5229u -> topics["system/symStu/op_Stored/bit/RecSignal"] as? Boolean ?: false
                    0xFFFF522Au -> topics["system/symStu/op_Stored/bit/TOCN1"] as? Boolean ?: false
                    0xFFFF522Bu -> topics["system/symStu/op_Stored/bit/TOCN2"] as? Boolean ?: false
                    0xFFFF522Du -> (topics["system/symStu/op_Stored/bit/TOVA1"] as? Boolean ?: false) or (topics["system/symStu/op_Stored/bit/TOVB1"] as? Boolean ?: false) or (topics["system/symStu/op_Stored/bit/TOVC1"] as? Boolean ?: false)
                    0xFFFF522Eu -> (topics["system/symStu/op_Stored/bit/TOVA2"] as? Boolean ?: false) or (topics["system/symStu/op_Stored/bit/TOVB2"] as? Boolean ?: false) or (topics["system/symStu/op_Stored/bit/TOVC2"] as? Boolean ?: false)
                    0xFFFF522Fu -> (topics["system/symStu/op_Stored/bit/TUVA1"] as? Boolean ?: false) or (topics["system/symStu/op_Stored/bit/TUVB1"] as? Boolean ?: false) or (topics["system/symStu/op_Stored/bit/TUVC1"] as? Boolean ?: false)
                    0xFFFF5230u -> (topics["system/symStu/op_Stored/bit/TUVA2"] as? Boolean ?: false) or (topics["system/symStu/op_Stored/bit/TUVB2"] as? Boolean ?: false) or (topics["system/symStu/op_Stored/bit/TUVC2"] as? Boolean ?: false)
                    0xFFFF5231u -> (topics["system/symStu/op_Stored/bit/TOVA21"] as? Boolean ?: false) or (topics["system/symStu/op_Stored/bit/TOVB21"] as? Boolean ?: false) or (topics["system/symStu/op_Stored/bit/TOVC21"] as? Boolean ?: false)
                    0xFFFF5232u -> (topics["system/symStu/op_Stored/bit/TOVA22"] as? Boolean ?: false) or (topics["system/symStu/op_Stored/bit/TOVB22"] as? Boolean ?: false) or (topics["system/symStu/op_Stored/bit/TOVC22"] as? Boolean ?: false)
                    0xFFFF5233u -> (topics["system/symStu/op_Stored/bit/TUVA21"] as? Boolean ?: false) or (topics["system/symStu/op_Stored/bit/TUVB21"] as? Boolean ?: false) or (topics["system/symStu/op_Stored/bit/TUVC21"] as? Boolean ?: false)
                    0xFFFF5234u -> (topics["system/symStu/op_Stored/bit/TUVA22"] as? Boolean ?: false) or (topics["system/symStu/op_Stored/bit/TUVB22"] as? Boolean ?: false) or (topics["system/symStu/op_Stored/bit/TUVC22"] as? Boolean ?: false)
                    else -> false
                }
                if (status) {
                    1
                } else {
                    0
                }
            }
        } else {
            0
        }
    }

    private fun data(index: Int):  Float {
        return when(index) {
            0, 1 -> topics[""] as? Float ?: 0.0f
            2, 3 -> convertAzimuthValue((topics["MI/MMXU/PhV/res/val/ang"] as? Float ?: 0.0f) - (topics["MI/MMXU/PhV/phsA/val/ang"] as? Float ?: 0.0f))
            4, 5 -> topics["MI/MMXU/PhV/phsA/val/mag"] as? Float ?: 0.0f
            6, 7 -> 0.0f
            8, 9 -> topics["MI/MMXU/PhV/phsB/val/mag"] as? Float ?: 0.0f
            10, 11 -> convertAzimuthValue((topics["MI/MMXU/PhV/phsB/val/ang"] as? Float ?: 0.0f) - (topics["MI/MMXU/PhV/phsA/val/ang"] as? Float ?: 0.0f))
            12, 13 -> topics["MI/MMXU/PhV/phsC/val/mag"] as? Float ?: 0.0f
            14, 15 -> convertAzimuthValue((topics["MI/MMXU/PhV/phsC/val/ang"] as? Float ?: 0.0f) - (topics["MI/MMXU/PhV/phsA/val/ang"] as? Float ?: 0.0f))
            16, 17 -> topics["MI/MMXU/PhV/neut/val/mag"] as? Float ?: 0.0f
            18, 19 -> convertAzimuthValue((topics["MI/MMXU/PhV/neut/val/ang"] as? Float ?: 0.0f) - (topics["MI/MMXU/PhV/phsA/val/ang"] as? Float ?: 0.0f))
            20, 21 -> topics["MI/MMXU/PPV/phsAB/val/mag"] as? Float ?: 0.0f
            22, 23 -> convertAzimuthValue((topics["MI/MMXU/PPV/phsAB/val/ang"] as? Float ?: 0.0f) - (topics["MI/MMXU/PhV/phsA/val/ang"] as? Float ?: 0.0f))
            24, 25 -> topics["MI/MMXU/PPV/phsBC/val/mag"] as? Float ?: 0.0f
            26, 27 -> convertAzimuthValue((topics["MI/MMXU/PPV/phsBC/val/ang"] as? Float ?: 0.0f) - (topics["MI/MMXU/PhV/phsA/val/ang"] as? Float ?: 0.0f))
            28, 29 -> topics["MI/MMXU/PPV/phsCA/val/mag"] as? Float ?: 0.0f
            30, 31 -> convertAzimuthValue((topics["MI/MMXU/PPV/phsCA/val/ang"] as? Float ?: 0.0f) - (topics["MI/MMXU/PhV/phsA/val/ang"] as? Float ?: 0.0f))
            32, 33 -> topics["MI/MMXU/A/phsA/val/mag"] as? Float ?: 0.0f
            34, 35 -> convertAzimuthValue((topics["MI/MMXU/A/phsA/val/ang"] as? Float ?: 0.0f) - (topics["MI/MMXU/PhV/phsA/val/ang"] as? Float ?: 0.0f))
            36, 37 -> topics["MI/MMXU/A/phsB/val/mag"] as? Float ?: 0.0f
            38, 39 -> convertAzimuthValue((topics["MI/MMXU/A/phsB/val/ang"] as? Float ?: 0.0f) - (topics["MI/MMXU/PhV/phsA/val/ang"] as? Float ?: 0.0f))
            40, 41 -> topics["MI/MMXU/A/phsC/val/mag"] as? Float ?: 0.0f
            42, 43 -> convertAzimuthValue((topics["MI/MMXU/A/phsC/val/ang"] as? Float ?: 0.0f) - (topics["MI/MMXU/PhV/phsA/val/ang"] as? Float ?: 0.0f))
            44, 45 -> topics["MI/MMXU/A/neut/val/mag"] as? Float ?: 0.0f
            46, 47 -> convertAzimuthValue((topics["MI/MMXU/A/neut/val/ang"] as? Float ?: 0.0f) - (topics["MI/MMXU/PhV/phsA/val/ang"] as? Float ?: 0.0f))
            48, 49 -> topics["MI/MMXU/A/net/val/mag"] as? Float ?: 0.0f
            50, 51 -> convertAzimuthValue((topics["MI/MMXU/A/net/val/ang"] as? Float ?: 0.0f) - (topics["MI/MMXU/PhV/phsA/val/ang"] as? Float ?: 0.0f))
            52, 53 -> topics["MI/MMXU/A/res/val/mag"] as? Float ?: 0.0f
            54, 55 -> convertAzimuthValue((topics["MI/MMXU/A/res/val/ang"] as? Float ?: 0.0f) - (topics["MI/MMXU/PhV/phsA/val/ang"] as? Float ?: 0.0f))
            56, 57 -> topics["MI/MMXU/Hz/mag"] as? Float ?: 0.0f
            58, 59 -> if((topics["MI/MMXU/TotPF/mag"] as? Float ?: 0.0f) < 0) (topics["MI/MMXU/TotPF/mag"] as? Float ?: 0.0f) * -1 else (topics["MI/MMXU/TotPF/mag"] as? Float ?: 0.0f)
            60, 61 -> topics["MI/MMXU/W/phsA/val/mag"] as? Float ?: 0.0f
            62, 63 -> topics["MI/MMXU/W/phsB/val/mag"] as? Float ?: 0.0f
            64, 65 -> topics["MI/MMXU/W/phsC/val/mag"] as? Float ?: 0.0f
            66, 67 -> topics["MI/MMXU/TotW/mag"] as? Float ?: 0.0f
            68, 69 -> topics["MI/MMXU/VAr/phsA/val/mag"] as? Float ?: 0.0f
            70, 71 -> topics["MI/MMXU/VAr/phsB/val/mag"] as? Float ?: 0.0f
            72, 73 -> topics["MI/MMUX/VAr/phsC/val/mag"] as? Float ?: 0.0f
            74, 75 -> topics["MI/MMXU/TotVAr/mag"] as? Float ?: 0.0f
            76, 77 -> topics["MI/MMXU/VA/phsA/val/mag"] as? Float ?: 0.0f
            78, 79 -> topics["MI/MMXU/VA/phsB/val/mag"] as? Float ?: 0.0f
            80, 81 -> topics["MI/MMXU/VA/phsC/val/mag"] as? Float ?: 0.0f
            82, 83 -> topics["MI/MMXU/TotVA/mag"] as? Float ?: 0.0f
            84, 85, 86, 87 -> convertEnergyValue(topics["MI/MMTR/Wh/phsA/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR/Wh/phsA/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR/Wh/phsA/actVal/Giga"] as? Float ?: 0.0f)
            88, 89, 90, 91 -> convertEnergyValue(topics["MI/MMTR/Wh/phsB/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR/Wh/phsB/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR/Wh/phsB/actVal/Giga"] as? Float ?: 0.0f)
            92, 93, 94, 95 -> convertEnergyValue(topics["MI/MMTR/Wh/phsC/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR/Wh/phsC/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR/Wh/phsC/actVal/Giga"] as? Float ?: 0.0f)
            96, 97, 98, 99 -> convertEnergyValue(topics["MI/MMTR/TotWh/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR/TotWh/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR/TotWh/actVal/Giga"] as? Float ?: 0.0f)
            100, 101, 102, 103 -> convertEnergyValue(topics["MI/MMTR/VArh/phsA/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR/VArh/phsA/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR/VArh/phsA/actVal/Giga"] as? Float ?: 0.0f)
            104, 105, 106, 107 -> convertEnergyValue(topics["MI/MMTR/VArh/phsB/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR/VArh/phsB/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR/VArh/phsB/actVal/Giga"] as? Float ?: 0.0f)
            108, 109, 110, 111 -> convertEnergyValue(topics["MI/MMTR/VArh/phsC/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR/VArh/phsC/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR/VArh/phsC/actVal/Giga"] as? Float ?: 0.0f)
            112, 113, 114, 115 -> convertEnergyValue(topics["MI/MMTR/TotVArh/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR/TotVArh/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR/TotVArh/actVal/Giga"] as? Float ?: 0.0f)
            116, 117, 118, 119 -> convertEnergyValue(topics["MI/MMTR/LgVArh/phsA/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR/LgVArh/phsA/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR/LgVArh/phsA/actVal/Giga"] as? Float ?: 0.0f)
            120, 121, 122, 123 -> convertEnergyValue(topics["MI/MMTR/LgVArh/phsB/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR/LgVArh/phsB/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR/LgVArh/phsB/actVal/Giga"] as? Float ?: 0.0f)
            124, 125, 126, 127 -> convertEnergyValue(topics["MI/MMTR/LgVArh/phsC/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR/LgVArh/phsC/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR/LgVArh/phsC/actVal/Giga"] as? Float ?: 0.0f)
            128, 129, 130, 131 -> convertEnergyValue(topics["MI/MMTR/LgTotVArh/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR/LgTotVArh/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR/LgTotVArh/actVal/Giga"] as? Float ?: 0.0f)
            132, 133, 134, 135 -> convertEnergyValue(topics["MI/MMTR/VAh/phsA/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR/VAh/phsA/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR/VAh/phsA/actVal/Giga"] as? Float ?: 0.0f)
            136, 137, 138, 139 -> convertEnergyValue(topics["MI/MMTR/VAh/phsB/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR/VAh/phsB/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR/VAh/phsB/actVal/Giga"] as? Float ?: 0.0f)
            140, 141, 142, 143 -> convertEnergyValue(topics["MI/MMTR/VAh/phsC/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR/VAh/phsC/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR/VAh/phsC/actVal/Giga"] as? Float ?: 0.0f)
            144, 145, 146, 147 -> convertEnergyValue(topics["MI/MMTR/TotVAh/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR/TotVAh/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR/TotVAh/actVal/Giga"] as? Float ?: 0.0f)
            148, 149, 150, 151 -> convertEnergyValue(topics["MI/MMTR_Reverse/Wh/phsA/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/Wh/phsA/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/Wh/phsA/actVal/Giga"] as? Float ?: 0.0f)
            152, 153, 154, 155 -> convertEnergyValue(topics["MI/MMTR_Reverse/Wh/phsB/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/Wh/phsB/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/Wh/phsB/actVal/Giga"] as? Float ?: 0.0f)
            156, 157, 158, 159 -> convertEnergyValue(topics["MI/MMTR_Reverse/Wh/phsC/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/Wh/phsC/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/Wh/phsC/actVal/Giga"] as? Float ?: 0.0f)
            160, 161, 162, 163 -> convertEnergyValue(topics["MI/MMTR_Reverse/TotWh/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/TotWh/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/TotWh/actVal/Giga"] as? Float ?: 0.0f)
            164, 165, 166, 167 -> convertEnergyValue(topics["MI/MMTR_Reverse/VArh/phsA/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/VArh/phsA/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/VArh/phsA/actVal/Giga"] as? Float ?: 0.0f)
            168, 169, 170, 171 -> convertEnergyValue(topics["MI/MMTR_Reverse/VArh/phsB/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/VArh/phsB/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/VArh/phsB/actVal/Giga"] as? Float ?: 0.0f)
            172, 173, 174, 175 -> convertEnergyValue(topics["MI/MMTR_Reverse/VArh/phsC/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/VArh/phsC/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/VArh/phsC/actVal/Giga"] as? Float ?: 0.0f)
            176, 177, 178, 179 -> convertEnergyValue(topics["MI/MMTR_Reverse/TotVArh/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/TotVArh/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/TotVArh/actVal/Giga"] as? Float ?: 0.0f)
            180, 181, 182, 183 -> convertEnergyValue(topics["MI/MMTR_Reverse/LgVArh/phsA/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/LgVArh/phsA/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/LgVArh/phsA/actVal/Giga"] as? Float ?: 0.0f)
            184, 185, 186, 187 -> convertEnergyValue(topics["MI/MMTR_Reverse/LgVArh/phsB/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/LgVArh/phsB/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/LgVArh/phsB/actVal/Giga"] as? Float ?: 0.0f)
            188, 189, 190, 191 -> convertEnergyValue(topics["MI/MMTR_Reverse/LgVArh/phsC/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/LgVArh/phsC/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/LgVArh/phsC/actVal/Giga"] as? Float ?: 0.0f)
            192, 193, 194, 195 -> convertEnergyValue(topics["MI/MMTR_Reverse/LgTotVArh/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/LgTotVArh/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/LgTotVArh/actVal/Giga"] as? Float ?: 0.0f)
            196, 197, 198, 199 -> convertEnergyValue(topics["MI/MMTR_Reverse/VAh/phsA/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/VAh/phsA/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/VAh/phsA/actVal/Giga"] as? Float ?: 0.0f)
            200, 201, 202, 203 -> convertEnergyValue(topics["MI/MMTR_Reverse/VAh/phsB/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/VAh/phsB/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/VAh/phsB/actVal/Giga"] as? Float ?: 0.0f)
            204, 205, 206, 207 -> convertEnergyValue(topics["MI/MMTR_Reverse/VAh/phsC/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/VAh/phsC/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/VAh/phsC/actVal/Giga"] as? Float ?: 0.0f)
            208, 209, 210, 211 -> convertEnergyValue(topics["MI/MMTR_Reverse/TotVAh/actVal/High"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/TotVAh/actVal/Low"] as? Float ?: 0.0f, topics["MI/MMTR_Reverse/TotVAh/actVal/Giga"] as? Float ?: 0.0f)
            212, 213 -> topics["MI/MMXU/AuxHz/mag"] as? Float ?: 0.0f
            214, 215 -> topics["MI/MMXU/Hz2/mag"] as? Float ?: 0.0f
            216, 217 -> topics["MI/MMXU/PhV2/phsA/val/mag"] as? Float ?: 0.0f
            218, 219 -> 0.0f
            220, 221 -> topics["MI/MMXU/PhV2/phsB/val/mag"] as? Float ?: 0.0f
            222, 223 -> convertAzimuthValue((topics["MI/MMXU/PhV/phsB/val/ang"] as? Float ?: 0.0f) - (topics["MI/MMXU/PhV/phsA/val/ang"] as? Float ?: 0.0f))
            224, 225 -> topics["MI/MMXU/PhV2/phsC/val/mag"] as? Float ?: 0.0f
            226, 227 -> convertAzimuthValue((topics["MI/MMXU/PhV2/phsC/val/ang"] as? Float ?: 0.0f) - (topics["MI/MMXU/PhV2/phsA/val/ang"] as? Float ?: 0.0f))
            228, 229 -> topics["MI/MMXU/PhV2/neut/val/mag"] as? Float ?: 0.0f
            230, 231 -> convertAzimuthValue((topics["MI/MMXU/PhV2/neut/val/ang"] as? Float ?: 0.0f) - (topics["MI/MMXU/PhV2/phsA/val/ang"] as? Float ?: 0.0f))
            232, 233 -> topics["MI/MMXU/PPV2/phsAB/val/mag"] as? Float ?: 0.0f
            234, 235 -> convertAzimuthValue((topics["MI/MMXU/PPV2/phsAB/val/ang"] as? Float ?: 0.0f) - (topics["MI/MMXU/PhV2/phsA/val/ang"] as? Float ?: 0.0f))
            236, 237 -> topics["MI/MMXU/PPV2/phsBC/val/mag"] as? Float ?: 0.0f
            238, 239 -> convertAzimuthValue((topics["MI/MMXU/PPV2/phsBC/val/ang"] as? Float ?: 0.0f) - (topics["MI/MMXU/PhV2/phsA/val/ang"] as? Float ?: 0.0f))
            240, 241 -> topics["MI/MMXU/PPV2/phsCA/val/mag"] as? Float ?: 0.0f
            242, 243 -> convertAzimuthValue((topics["MI/MMXU/PPV2/phsCA/val/ang"] as? Float ?: 0.0f) - (topics["MI/MMXU/PhV2/phsA/val/ang"] as? Float ?: 0.0f))
            3000, 3001 -> topics["MI/MHAI/ThdPhV/phsA/val/mag"] as? Float ?: 0.0f
            3002, 3003 -> topics["MI/MHAI/ThdPhV/phsB/val/mag"] as? Float ?: 0.0f
            3004, 3005 -> topics["MI/MHAI/ThdPhV/phsC/val/mag"] as? Float ?: 0.0f
            3500, 3501 -> topics["MI/MHAI/ThdA/phsA/val/mag"] as? Float ?: 0.0f
            3502, 3503 -> topics["MI/MHAI/ThdA/phsB/val/mag"] as? Float ?: 0.0f
            3504, 3505 -> topics["MI/MHAI/ThdA/phsC/val/mag"] as? Float ?: 0.0f
            3506, 3507 -> topics["MI/MHAI/TddA/phsA/val/mag"] as? Float ?: 0.0f
            3508, 3509 -> topics["MI/MHAI/TddA/phsB/val/mag"] as? Float ?: 0.0f
            3510, 3511 -> topics["MI/MHAI/TddA/phsC/val/mag"] as? Float ?: 0.0f
            4000, 4001 -> topics["MI/MHAI/ThdPhV2/phsA/val/mag"] as? Float ?: 0.0f
            4002, 4003 -> topics["MI/MHAI/ThdPhV2/phsB/val/mag"] as? Float ?: 0.0f
            4004, 4005 -> topics["MI/MHAI/ThdPhV2/phsC/val/mag"] as? Float ?: 0.0f
            5000, 5001 -> topics["MI/MHAI/HKf/phsA/val/mag"] as? Float ?: 0.0f
            5002, 5003 -> topics["MI/MHAI/HKf/phsB/val/mag"] as? Float ?: 0.0f
            5004, 5005 -> topics["MI/MHAI/HKf/phsC/val/mag"] as? Float ?: 0.0f
            5006, 5007 -> topics["MI/MHAI/HCfPhV/phsA/val/mag"] as? Float ?: 0.0f
            5008, 5009 -> topics["MI/MHAI/HCfPhV/phsB/val/mag"] as? Float ?: 0.0f
            5010, 5011 -> topics["MI/MHAI/HCfPhV/phsC/val/mag"] as? Float ?: 0.0f
            5012, 5013 -> topics["MI/MHAI/HCfA/phsA/val/mag"] as? Float ?: 0.0f
            5014, 5015 -> topics["MI/MHAI/HCfA/phsB/val/mag"] as? Float ?: 0.0f
            5016, 5017 -> topics["MI/MHAI/HCfA/phsC/val/mag"] as? Float ?: 0.0f
            else -> 0.0f
        }
    }



    class LineAttr
    {
        var index = 0
    }

    class SymbolAttr
    {
        var index = 0
        var onOff = 0
        var state = 0
        var category = 0
        var dataPoint = 0
    }

    class TextAttr
    {
        var exist = 0
        var enableMap = 0
        var category = 0
        var dataPoint = 0
        var dataType = 0
        var stringFormat = String() // 128
        var fuu = 0
        var stringFuu =  String() // 32
        var transparent = 0
        var fontName = String() // 128
        var fontType = 0
        var fontSize = 0
        var fontBold = 0
        var fontColor = 0
    }

    class MIMICData
    {
        var rowCount = 0
        var colCount = 0
        var cellSize =  Size(0, 0)
    }

    class LineData {
        var x = 0
        var y = 0
        var lineAttr = LineAttr()
        var bitmap: Bitmap? = null
    }

    class SymbolData {
        var x = 0
        var y = 0
        var mode = 0
        var symbolAttr = SymbolAttr()
        var bitmaps = mutableListOf<Bitmap>()
    }

    class TextData {
        var x: Int = 0
        var y: Int = 0
        var textAttr = TextAttr()
    }

    class UnitValue
    {
        var value = 0.0f
        var unit = ""
    }

    companion object {
        private val lineFileNames = arrayOf(
            "LINE_L1.bmp", "LINE_L2.bmp", "LINE_L3.bmp", "LINE_L4.bmp", "LINE_L5.bmp", "LINE_L6.bmp",
            "LINE_L7.bmp", "LINE_L8.bmp", "LINE_L9.bmp", "LINE_L10.bmp", "LINE_L11.bmp",
            "LINE_S1.bmp", "LINE_S2.bmp", "LINE_S3.bmp", "LINE_S4.bmp", "LINE_S5.bmp", "LINE_S6.bmp",
            "LINE_S7.bmp", "LINE_S8.bmp", "LINE_S9.bmp", "LINE_S11.bmp", "LINE_S10.bmp", "LINE_S12.bmp",
            "LINE_S13.bmp", "LINE_S14.bmp", "LINE_S15.bmp")
        private val symbolFileNames = arrayOf(
            arrayOf("SB_CBOFF_01.bmp", "SB_CBON_01.bmp", "SB_CBX_01.bmp"),
            arrayOf("SB_CBOFF_02.bmp", "SB_CBON_02.bmp", "SB_CBX_02.bmp"),
            arrayOf("SB_CBOFF_03.bmp", "SB_CBON_03.bmp", "SB_CBX_03.bmp"),
            arrayOf("SB_CBOFF_04.bmp", "SB_CBON_04.bmp", "SB_CBX_04.bmp"),
            arrayOf("SB_DSOFF_01.bmp", "SB_DSON_01.bmp", "SB_DSX_01.bmp"),
            arrayOf("SB_DSOFF_02.bmp", "SB_DSON_02.bmp", "SB_DSX_02.bmp"),
            arrayOf("SB_DSOFF_03.bmp", "SB_DSON_03.bmp", "SB_DSX_03.bmp"),
            arrayOf("SB_DSOFF_04.bmp", "SB_DSON_04.bmp", "SB_DSX_04.bmp"),
            arrayOf("LED_BK.bmp", "LED_G.bmp"),
            arrayOf("LED_BK.bmp", "LED_R.bmp"),
            arrayOf("LED_BK.bmp", "LED_Y.bmp"),
            arrayOf("SB_A1.bmp"), arrayOf("SB_A2.bmp"), arrayOf("SB_A3.bmp"), arrayOf("SB_A4.bmp"),
            arrayOf("SB_T1.bmp"), arrayOf("SB_T2.bmp"), arrayOf("SB_T3.bmp"), arrayOf("SB_T4.bmp"),
            arrayOf("SB_CT1.bmp"), arrayOf("SB_CT2.bmp"), arrayOf("SB_CT3.bmp"), arrayOf("SB_CT4.bmp"),
            arrayOf("SB_B1.bmp"), arrayOf("SB_B2.bmp"),
            arrayOf("SB_PT1.bmp"), arrayOf("SB_PT2.bmp"),
            arrayOf("SB_S1.bmp"), arrayOf("SB_S2.bmp"),
            arrayOf("SB_G1.bmp"),
            arrayOf("SB_LED1.bmp"),
            arrayOf("SB_M1.bmp"),
            arrayOf("SB_Y1.bmp"), arrayOf("SB_Y2.bmp"), arrayOf("SB_Y3.bmp"),
            arrayOf("SB_Y4.bmp"), arrayOf("SB_Y5.bmp"), arrayOf("SB_Y6.bmp"),
            arrayOf("SB_Coil1.bmp"), arrayOf("SB_Coil2.bmp"),
            arrayOf("SB_MOF1.bmp"),
            arrayOf("SB_LA1.bmp"), arrayOf("SB_LA2.bmp"),
            arrayOf("SB_TD1.bmp"),
            arrayOf("SB_CAP1.bmp"), arrayOf("SB_CAP2.bmp"), arrayOf("SB_CAP3.bmp"),
            arrayOf("SB_VCB1OFF.bmp", "SB_VCB1ON.bmp"),
            arrayOf("SB_VCB2OFF.bmp", "SB_VCB2ON.bmp"),
            arrayOf("SB_ACB1OFF.bmp", "SB_ACB1ON.bmp"),
            arrayOf("SB_ACB2OFF.bmp", "SB_ACB2ON.bmp"),
            arrayOf("SB_SWa1OFF.bmp", "SB_SWa1ON.bmp"),
            arrayOf("SB_SWa2OFF.bmp", "SB_SWa2ON.bmp"),
            arrayOf("SB_SWa3OFF.bmp", "SB_SWa3ON.bmp"),
            arrayOf("SB_SWa4OFF.bmp", "SB_SWa4ON.bmp"),
            arrayOf("SB_SWb1OFF.bmp", "SB_SWb1ON.bmp"),
            arrayOf("SB_SWb2OFF.bmp", "SB_SWb2ON.bmp"),
            arrayOf("SB_SWb3OFF.bmp", "SB_SWb3ON.bmp"),
            arrayOf("SB_SWb4OFF.bmp", "SB_SWb4ON.bmp"))
    }
}

fun convertEnergyValue(high: Float, low: Float, giga: Float): Float {
    return high + (low / 10000) + (giga * 1000000000)
}