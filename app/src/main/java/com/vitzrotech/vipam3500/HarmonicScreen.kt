package com.vitzrotech.vipam3500

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

data class Unitbutton(
    val buttonName: String = "",
    val dst: String = ""
)

@Composable
fun HarmonicScreen(viewModel: NavHostController) {
    val unitList = arrayListOf(
        Unitbutton("홀수", "oddnum"),
        Unitbutton("짝수", "evenum"),

        Unitbutton("Va", "VA"),
        Unitbutton("Ia", "IA"),
        Unitbutton("Vb", "VB"),
        Unitbutton("Ib", "IB"),
        Unitbutton("Vc", "VC"),
        Unitbutton("Ic", "IC")
    )
    val gridItems = unitList.chunked(2)

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
                        .padding(10.dp, 10.dp)

                    Button(
                        onClick = {

                        },
                        modifier = modifier,
                        shape = RectangleShape
                    ) {
                        Text(text = item.buttonName)
                    }
                }
            }
        }
    }
}

private fun initBarChart(barChart: BarChart) {
    barChart.setDrawGridBackground(false)
    barChart.setDrawBarShadow(false)
    barChart.setDrawBorders(false)

    val description = Description()
    description.isEnabled = false
    barChart.description = description

    barChart.animateY(1000)
    barChart.animateX(1000)

    val xAxis: XAxis = barChart.xAxis
    xAxis.position = XAxis.XAxisPosition.BOTTOM
    xAxis.granularity = 1f
    xAxis.textColor = 0xff0080ff.toInt()
    xAxis.setDrawAxisLine(false)
    xAxis.setDrawGridLines(false)

    val leftAxis: YAxis = barChart.axisLeft
    leftAxis.setDrawAxisLine(false)
    leftAxis.textColor = 0xfff35050.toInt()

    val rightAxis: YAxis = barChart.axisRight
    rightAxis.setDrawAxisLine(false)
    rightAxis.textColor = 0xff0ece2f.toInt()

    val legend: Legend = barChart.legend
    legend.form = Legend.LegendForm.LINE
    legend.textSize = 20f
    legend.textColor = 0xff000000.toInt()
    legend.verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
    legend.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER
    legend.orientation = Legend.LegendOrientation.HORIZONTAL
    legend.setDrawInside(false)
}

private fun setDate(barChart: BarChart) {
    barChart.setScaleEnabled(false)
    val valueList = ArrayList<BarEntry>()
    val title = "고조파"

    for (i in 0 until 5) {
        valueList.add(BarEntry(i.toFloat(), i * 100f))
    }
    //집에 가고 싶다
    val barDataSet = BarDataSet(valueList, title)
    barDataSet.setColors(
        R.color.hmc_1st, R.color.hmc_2nd, R.color.hmc_3rd,
        R.color.hmc_4th, R.color.hmc_5th
    )

    val data = BarData(barDataSet)
    barChart.data = data
    barChart.invalidate()
}

@Preview
@Composable
fun HarmonicScreenPreview() {
    VIPAM3500Theme {
        HarmonicScreen(rememberNavController())
    }
}