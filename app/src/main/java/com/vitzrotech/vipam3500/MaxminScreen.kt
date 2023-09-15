package com.vitzrotech.vipam3500

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme

data class Max (
    val name: String = "",
    val flva: Float = 0.0f,
    val inva: Int = 0,
    val unit: String = ""
)

//이리노 존나 사랑해 시발
//이리노 그냥 존ㄴㄴㄴㄴ나 잘생겼네
//??? : 제가 태어나서 지금까지 봐온 남성분들 중 가장 출중한 외모를 가지고 계십니다.
//??? : 아이돌 해주셔서 감사드립니다 이리노씨.

@Composable
fun MaxminScreen(viewModel: SharedViewModel) {
    //val time = "$year-$month"
    val maxCur by remember { viewModel.maxCur }
    val maxCurPh by remember { viewModel.maxCurPh }
    val maxCurY by remember { viewModel.maxCurY }
    val maxCurMon by remember { viewModel.maxCurMon }
    val maxCurD by remember { viewModel.maxCurD }
    val maxCurH by remember { viewModel.maxCurH }
    val maxCurMin by remember { viewModel.maxCurMin }
    val maxCurS by remember { viewModel.maxCurS }
    val maxCurms by remember { viewModel.maxCurms }

    val minCur by remember { viewModel.minCur }
    val minCurPh by remember { viewModel.minCurPh }
    val minCurY by remember { viewModel.minCurY }
    val minCurMon by remember { viewModel.minCurMon }
    val minCurD by remember { viewModel.minCurD }
    val minCurH by remember { viewModel.minCurH }
    val minCurMin by remember { viewModel.minCurMin }
    val minCurS by remember { viewModel.minCurS }
    val minCurms by remember { viewModel.minCurms }

    val maxVol by remember { viewModel.maxVol }
    val maxVolPh by remember { viewModel.maxVolPh }
    val maxVolY by remember { viewModel.maxVolY }
    val maxVolMon by remember { viewModel.maxVolMon }
    val maxVolD by remember { viewModel.maxVolD }
    val maxVolH by remember { viewModel.maxVolH }
    val maxVolMin by remember { viewModel.maxVolMin }
    val maxVolS by remember { viewModel.maxVolS }
    val maxVolms by remember { viewModel.maxVolms }

    val minVol by remember { viewModel.minVol }
    val minVolPh by remember { viewModel.minVolPh }
    val minVolY by remember { viewModel.minVolY }
    val minVolMon by remember { viewModel.minVolMon }
    val minVolD by remember { viewModel.minVolD }
    val minVolH by remember { viewModel.minVolH }
    val minVolMin by remember { viewModel.minVolMin }
    val minVolS by remember { viewModel.minVolS }
    val minVolms by remember { viewModel.minVolms }

    val maxFreq by remember { viewModel.maxFreq }
    val maxFreqPh by remember { viewModel.maxFreqPh }
    val maxFreqY by remember { viewModel.maxFreqY }
    val maxFreqMon by remember { viewModel.maxFreqMon }
    val maxFreqD by remember { viewModel.maxFreqD }
    val maxFreqH by remember { viewModel.maxFreqH }
    val maxFreqMin by remember { viewModel.maxFreqMin }
    val maxFreqS by remember { viewModel.maxFreqS }
    val maxFreqms by remember { viewModel.maxFreqms }

    val minFreq by remember { viewModel.minFreq }
    val minFreqPh by remember { viewModel.minFreqPh }
    val minFreqY by remember { viewModel.minFreqY }
    val minFreqMon by remember { viewModel.minFreqMon }
    val minFreqD by remember { viewModel.minFreqD }
    val minFreqH by remember { viewModel.minFreqH }
    val minFreqMin by remember { viewModel.minFreqMin }
    val minFreqS by remember { viewModel.minFreqS }
    val minFreqms by remember { viewModel.minFreqms }

    val maxWatt by remember { viewModel.maxWatt }
    val maxWattPh by remember { viewModel.maxWattPh }
    val maxWattY by remember { viewModel.maxWattY }
    val maxWattMon by remember { viewModel.maxWattMon }
    val maxWattD by remember { viewModel.maxWattD }
    val maxWattH by remember { viewModel.maxWattH }
    val maxWattMin by remember { viewModel.maxWattMin }
    val maxWattS by remember { viewModel.maxWattS }
    val maxWattms by remember { viewModel.maxWattms }

    val minWatt by remember { viewModel.minWatt }
    val minWattPh by remember { viewModel.minWattPh }
    val minWattY by remember { viewModel.minWattY }
    val minWattMon by remember { viewModel.minWattMon }
    val minWattD by remember { viewModel.minWattD }
    val minWattH by remember { viewModel.minWattH }
    val minWattMin by remember { viewModel.minWattMin }
    val minWattS by remember { viewModel.minWattS }
    val minWattms by remember { viewModel.minWattms }
}

@Preview
@Composable
fun MaxminScreenPreview() {
    VIPAM3500Theme {
        MaxminScreen(viewModel())
    }
}