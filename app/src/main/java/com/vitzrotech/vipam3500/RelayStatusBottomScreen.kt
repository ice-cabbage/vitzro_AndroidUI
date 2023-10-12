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

enum class BitData {
    TOCA1, TOCB1, TOCC1, TOCN1, TOCA2, TOCB2, TOCC2, TOCN2,
    TDOCA, TDOCB, TDOCC, TDOCN, IDOCA, IDOCB, IDOCC, IDOCN,
    IOCA1, IOCB1, IOCC1, IOCN1, IOCA2, IOCB2, IOCC2, IOCN2,
    TUVA1, TUVB1, TUVC1, TUVA2, TUVB2, TUVC2, TUVAux, TOVAux,
    TOVA1, TOVB1, TOVC1, TOVN1, TOVA2, TOVB2, TOVC2, TOVN2,
    TOF1, TOF2, TOF3, TOF4, TUF1, TUF2, TUF3, TUF4, TSG,
    TNSOV, TNSOC, TPOA, TPOB, TPOC, TSEF1, TSEF2,
    TUCA, TUCB, TUCC, M48, M51, TTR, MSS, M66, Synch,
    HARA1, HARB1, HARC1, HARA2, HARB2, HARC2 }

data class Relay_Status(val name: String, val trip: Boolean, val mod: Boolean)

operator fun Array<UInt>.get(bit: BitData): Boolean {
    var b = bit.ordinal
    val i = b / 32
    b %= 32
    return this[i].shr(b).and(1u) == 1u
}

@Composable
fun RelayStatusBottomScreen(viewModel: SharedViewModel) {
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
        Relay_Status("TOCR-1",   op[BitData.TOCA1] || op[BitData.TOCB1] || op[BitData.TOCC1], mod0.getBit(0)),
        Relay_Status("TOCR-2",   op[BitData.TOCA2] || op[BitData.TOCB2] || op[BitData.TOCC2], mod0.getBit(1)),
        Relay_Status("IOCR-1",   op[BitData.IOCA1] || op[BitData.IOCB1] || op[BitData.IOCC1], mod0.getBit(2)),
        Relay_Status("IOCR-2",   op[BitData.IOCA2] || op[BitData.IOCB2] || op[BitData.IOCC2], mod0.getBit(3)),
        Relay_Status("TOCGR-1",  op[BitData.TOCN1], mod0.getBit(4)),
        Relay_Status("TOCGR-2",  op[BitData.TOCN2], mod0.getBit(5)),
        Relay_Status("IOCGR-1",  op[BitData.IOCN1], mod0.getBit(6)),
        Relay_Status("IOCGR-2",  op[BitData.IOCN2], mod0.getBit(7)),
        Relay_Status("OVGR-1",   op[BitData.TOVN1], mod0.getBit(8)),
        Relay_Status("OVGR-2",   op[BitData.TOVN2], mod0.getBit(9)),
        Relay_Status("SGR",      op[BitData.TSG], mod0.getBit(10)),
        Relay_Status("TDGR",     op[BitData.TDOCN], mod0.getBit(11)),
        Relay_Status("IDGR",     op[BitData.IDOCN], mod0.getBit(12)),
        Relay_Status("TOVR-1",   op[BitData.TOVA1] || op[BitData.TOVB1] || op[BitData.TOVC1], mod0.getBit(13)),
        Relay_Status("TOVR-2",   op[BitData.TOVA2] || op[BitData.TOVB2] || op[BitData.TOVC2], mod0.getBit(14)),
        Relay_Status("TOVR-A",   op[BitData.TOVAux], mod1.getBit(0)),
        Relay_Status("TUVR-1",   op[BitData.TUVA1] || op[BitData.TUVB1] || op[BitData.TUVC1], mod1.getBit(1)),
        Relay_Status("TUVR-2",   op[BitData.TUVA2] || op[BitData.TUVB2] || op[BitData.TUVC2], mod1.getBit(2)),
        Relay_Status("TUVR-A",   op[BitData.TUVAux], mod1.getBit(3)),
        Relay_Status("POR",      op[BitData.TPOA] || op[BitData.TPOB] || op[BitData.TPOC], mod1.getBit(4)),
        Relay_Status("NSOVR",    op[BitData.TNSOV], mod1.getBit(5)),
        Relay_Status("TDOCR",    op[BitData.TDOCA] || op[BitData.TDOCB] || op[BitData.TDOCC], mod1.getBit(6)),
        Relay_Status("IDOCR",    op[BitData.IDOCA] || op[BitData.IDOCB] || op[BitData.IDOCC], mod1.getBit(7)),
        Relay_Status("Sync",     op[BitData.Synch], mod1.getBit(8)),
        Relay_Status("NSOCR",    op[BitData.TNSOC], mod1.getBit(9)),
        Relay_Status("Inrush-1", op[BitData.HARA1] || op[BitData.HARB1] || op[BitData.HARC1], mod1.getBit(10)),
        Relay_Status("Inrush-2", op[BitData.HARA2] || op[BitData.HARB2] || op[BitData.HARC2], mod1.getBit(11)),
        Relay_Status("UFR-1",    op[BitData.TUF1], mod1.getBit(12)),
        Relay_Status("UFR-2",    op[BitData.TUF2], mod1.getBit(13)),
        Relay_Status("UFR-3",    op[BitData.TUF3], mod1.getBit(14)),
        Relay_Status("UFR-4",    op[BitData.TUF4], mod1.getBit(15)),
        Relay_Status("OFR-1",    op[BitData.TOF1], mod2.getBit(0)),
        Relay_Status("OFR-2",    op[BitData.TOF2], mod2.getBit(1)),
        Relay_Status("OFR-3",    op[BitData.TOF3], mod2.getBit(2)),
        Relay_Status("OFR-4",    op[BitData.TOF4], mod2.getBit(3)),
        Relay_Status("UCR",      op[BitData.TUCA] || op[BitData.TUCB] || op[BitData.TUCC], mod2.getBit(4)),
        Relay_Status("THR",      op[BitData.TTR], mod2.getBit(5)),
        Relay_Status("S/L",      op[BitData.M48] || op[BitData.M51], mod2.getBit(6)),
        Relay_Status("NCHR",     op[BitData.MSS] || op[BitData.M66], mod2.getBit(7)),
        Relay_Status("SEF-1",    op[BitData.TSEF1], mod2.getBit(8)),
        Relay_Status("SEF-2",    op[BitData.TSEF2], mod2.getBit(9)))
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
fun RelayStatus_ScreenPreview() {
    VIPAM3500Theme {
        RelayStatusBottomScreen(viewModel())
    }
}