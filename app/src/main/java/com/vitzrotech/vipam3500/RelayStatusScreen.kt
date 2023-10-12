package com.vitzrotech.vipam3500

import android.content.res.Configuration.ORIENTATION_PORTRAIT
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme

enum class Bit {
    TOCA1, TOCB1, TOCC1, TOCN1, TOCA2, TOCB2, TOCC2, TOCN2,
    TDOCA, TDOCB, TDOCC, TDOCN, IDOCA, IDOCB, IDOCC, IDOCN,
    IOCA1, IOCB1, IOCC1, IOCN1, IOCA2, IOCB2, IOCC2, IOCN2,
    TUVA1, TUVB1, TUVC1, TUVA2, TUVB2, TUVC2, TUVAux, TOVAux,
    TOVA1, TOVB1, TOVC1, TOVN1, TOVA2, TOVB2, TOVC2, TOVN2,
    TOF1, TOF2, TOF3, TOF4, TUF1, TUF2, TUF3, TUF4, TSG,
    TNSOV, TNSOC, TPOA, TPOB, TPOC, TSEF1, TSEF2,
    TUCA, TUCB, TUCC, M48, M51, TTR, MSS, M66, Synch,
    HARA1, HARB1, HARC1, HARA2, HARB2, HARC2 }

data class RelayStatus(val name: String, val trip: Boolean, val mod: Boolean)

operator fun Array<UInt>.get(bit: Bit): Boolean {
    var b = bit.ordinal
    val i = b / 32
    b %= 32
    return this[i].shr(b).and(1u) == 1u
}

@Composable
fun RelayStatusScreen(viewModel: SharedViewModel) {
    val opStored1 by remember { viewModel.opStored1 }
    val opStored2 by remember { viewModel.opStored2 }
    val opStored3 by remember { viewModel.opStored3 }
    val opStored4 by remember { viewModel.opStored4 }
    val opStored5 by remember { viewModel.opStored5 }
    val op = arrayOf(opStored1, opStored2, opStored3, opStored4, opStored5)
    val mod0 by remember { viewModel.relayMod0 }
    val mod1 by remember { viewModel.relayMod1 }
    val mod2 by remember { viewModel.relayMod2 }
    val status = arrayOf(
        RelayStatus("TOCR-1",   op[Bit.TOCA1] || op[Bit.TOCB1] || op[Bit.TOCC1], mod0.getBit(0)),
        RelayStatus("TOCR-2",   op[Bit.TOCA2] || op[Bit.TOCB2] || op[Bit.TOCC2], mod0.getBit(1)),
        RelayStatus("IOCR-1",   op[Bit.IOCA1] || op[Bit.IOCB1] || op[Bit.IOCC1], mod0.getBit(2)),
        RelayStatus("IOCR-2",   op[Bit.IOCA2] || op[Bit.IOCB2] || op[Bit.IOCC2], mod0.getBit(3)),
        RelayStatus("TOCGR-1",  op[Bit.TOCN1], mod0.getBit(4)),
        RelayStatus("TOCGR-2",  op[Bit.TOCN2], mod0.getBit(5)),
        RelayStatus("IOCGR-1",  op[Bit.IOCN1], mod0.getBit(6)),
        RelayStatus("IOCGR-2",  op[Bit.IOCN2], mod0.getBit(7)),
        RelayStatus("OVGR-1",   op[Bit.TOVN1], mod0.getBit(8)),
        RelayStatus("OVGR-2",   op[Bit.TOVN2], mod0.getBit(9)),
        RelayStatus("SGR",      op[Bit.TSG], mod0.getBit(10)),
        RelayStatus("TDGR",     op[Bit.TDOCN], mod0.getBit(11)),
        RelayStatus("IDGR",     op[Bit.IDOCN], mod0.getBit(12)),
        RelayStatus("TOVR-1",   op[Bit.TOVA1] || op[Bit.TOVB1] || op[Bit.TOVC1], mod0.getBit(13)),
        RelayStatus("TOVR-2",   op[Bit.TOVA2] || op[Bit.TOVB2] || op[Bit.TOVC2], mod0.getBit(14)),
        RelayStatus("TOVR-A",   op[Bit.TOVAux], mod1.getBit(0)),
        RelayStatus("TUVR-1",   op[Bit.TUVA1] || op[Bit.TUVB1] || op[Bit.TUVC1], mod1.getBit(1)),
        RelayStatus("TUVR-2",   op[Bit.TUVA2] || op[Bit.TUVB2] || op[Bit.TUVC2], mod1.getBit(2)),
        RelayStatus("TUVR-A",   op[Bit.TUVAux], mod1.getBit(3)),
        RelayStatus("POR",      op[Bit.TPOA] || op[Bit.TPOB] || op[Bit.TPOC], mod1.getBit(4)),
        RelayStatus("NSOVR",    op[Bit.TNSOV], mod1.getBit(5)),
        RelayStatus("TDOCR",    op[Bit.TDOCA] || op[Bit.TDOCB] || op[Bit.TDOCC], mod1.getBit(6)),
        RelayStatus("IDOCR",    op[Bit.IDOCA] || op[Bit.IDOCB] || op[Bit.IDOCC], mod1.getBit(7)),
        RelayStatus("Sync",     op[Bit.Synch], mod1.getBit(8)),
        RelayStatus("NSOCR",    op[Bit.TNSOC], mod1.getBit(9)),
        RelayStatus("Inrush-1", op[Bit.HARA1] || op[Bit.HARB1] || op[Bit.HARC1], mod1.getBit(10)),
        RelayStatus("Inrush-2", op[Bit.HARA2] || op[Bit.HARB2] || op[Bit.HARC2], mod1.getBit(11)),
        RelayStatus("UFR-1",    op[Bit.TUF1], mod1.getBit(12)),
        RelayStatus("UFR-2",    op[Bit.TUF2], mod1.getBit(13)),
        RelayStatus("UFR-3",    op[Bit.TUF3], mod1.getBit(14)),
        RelayStatus("UFR-4",    op[Bit.TUF4], mod1.getBit(15)),
        RelayStatus("OFR-1",    op[Bit.TOF1], mod2.getBit(0)),
        RelayStatus("OFR-2",    op[Bit.TOF2], mod2.getBit(1)),
        RelayStatus("OFR-3",    op[Bit.TOF3], mod2.getBit(2)),
        RelayStatus("OFR-4",    op[Bit.TOF4], mod2.getBit(3)),
        RelayStatus("UCR",      op[Bit.TUCA] || op[Bit.TUCB] || op[Bit.TUCC], mod2.getBit(4)),
        RelayStatus("THR",      op[Bit.TTR], mod2.getBit(5)),
        RelayStatus("S/L",      op[Bit.M48] || op[Bit.M51], mod2.getBit(6)),
        RelayStatus("NCHR",     op[Bit.MSS] || op[Bit.M66], mod2.getBit(7)),
        RelayStatus("SEF-1",    op[Bit.TSEF1], mod2.getBit(8)),
        RelayStatus("SEF-2",    op[Bit.TSEF2], mod2.getBit(9)))
    val columns = if (LocalConfiguration.current.orientation == ORIENTATION_PORTRAIT) 2 else 4
    val rows = (status.size + 1) / columns
    Column(
        Modifier
            .fillMaxWidth()
            .padding(
                32.dp, 8.dp,
                if (LocalConfiguration.current.orientation == ORIENTATION_PORTRAIT) 32.dp else 56.dp
            ),
        verticalArrangement = Arrangement.Top,
    ) {
        Row(Modifier.fillMaxWidth()) {
            for (c in 0 until columns) {
                Text("",
                    Modifier
                        .weight(3f)
                        .padding(1.dp, 1.dp))
                Text(stringResource(R.string.mod),
                    Modifier
                        .weight(2f)
                        .padding(1.dp, 1.dp)
                        .background(Color.Blue),
                    color = Color.White, textAlign = TextAlign.Center)
                Text(stringResource(R.string.trip),
                    Modifier
                        .weight(2f)
                        .padding(1.dp, 1.dp)
                        .background(Color.Blue),
                    color = Color.White, textAlign = TextAlign.Center)
            }
        }
        LazyColumn(Modifier.fillMaxWidth()) {
            items(rows) {
                Row(Modifier.fillMaxWidth()) {
                    for (c in 0 until columns) {
                        val index = c * rows + it
                        if (index < status.size) {
                            val s = status[index]
                            Text(s.name,
                                Modifier
                                    .weight(4f)
                                    .padding(1.dp, 1.dp)
                                    .background(Color.Blue),
                                color = Color.White, textAlign = TextAlign.Center)
                            Text("\u2B24",
                                Modifier
                                    .weight(2f)
                                    .padding(1.dp, 1.dp),
                                color = if (s.mod) Color.Red else Color.Gray,
                                textAlign = TextAlign.Center)
                            Text("\u2B24",
                                Modifier
                                    .weight(2f)
                                    .padding(1.dp, 1.dp),
                                color = if (s.trip) Color.Red else Color.Gray,
                                textAlign = TextAlign.Center)
                        } else {
                            Column(Modifier.weight(8f)){}
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun RelayScreenPreview() {
    VIPAM3500Theme {
        RelayStatusScreen(viewModel())
    }
}