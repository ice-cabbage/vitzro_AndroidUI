package com.vitzrotech.vipam3500

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme

data class Sequence (
    val name: String = "",
    val volt: Float = 0.0f,
    val unit: String = ""
)

@Composable
fun SequenceScreen(viewModel: SharedViewModel) {
    val seqV1 by remember { viewModel.seqV1 }
    val seqV2 by remember { viewModel.seqV2 }
    val seqV3 by remember { viewModel.seqV3 }
    val seqA1 by remember { viewModel.seqA1 }
    val seqA2 by remember { viewModel.seqA1 }
    val seqA3 by remember { viewModel.seqA3 }

    val seq = arrayOf(
        Sequence("PSeq Vol : ", seqV1, "V"),
        Sequence("NSeq Vol : ", seqV2, "V"),
        Sequence("ZSeq Vol : ", seqV3, "V"),
        Sequence("PSeq Cur : ", seqA1, "A"),
        Sequence("NSeq Cur : ", seqA2, "A"),
        Sequence("ZSeq Cur : ", seqA3, "A")
    )
    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding(20.dp)) {
        items(seq.size) {
            val v = seq[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.name,
                    Modifier
                        .weight(0.5f)
                        .padding(24.dp, 10.dp),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.volt.toUnitString("%.02f", v.unit)}",
                    Modifier
                        .weight(0.4f)
                        .padding(24.dp, 10.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview
@Composable
fun SequenceScreenPreview() {
    VIPAM3500Theme {
        SequenceScreen(viewModel())
    }
}