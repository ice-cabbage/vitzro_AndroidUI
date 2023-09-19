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

data class Mand (
    val aName: String = "",
    val aYear: Int = 0,
    val aMon: Int = 0,
    val aDay: Int = 0,
    val aHour: Int = 0,
    val aMin: Int = 0,
    val aSec: Int = 0,
    val aMs: Int = 0,
    val aFlva: Float = 0.0f,
    val aUnit: String = ""
)

data class Dmand (
    val bName: String = "",
    val bYear: Int = 0,
    val bMon: Int = 0,
    val bDay: Int = 0,
    val bHour: Int = 0,
    val bMin: Int = 0,
    val bSec: Int = 0,
    val bMs: Int = 0,
    val bFlva: Float = 0.0f,
    val bUnit: String = ""
)

data class Peak (
    val DMType: String = ""
)

data class Over (
    val DMD: String = ""
)

@Composable
fun DemandScreen(viewModel: SharedViewModel) {
    val pdaY by remember { viewModel.pdaY }
    val pdaMon by remember { viewModel.pdaMon }
    val pdaD by remember { viewModel.pdaD }
    val pdaH by remember { viewModel.pdaH }
    val pdaMin by remember { viewModel.pdaMin }
    val pdaS by remember { viewModel.pdaS }
    val pdaMs by remember { viewModel.pdaMs }
    val pda by remember { viewModel.pda }

    val pdbY by remember { viewModel.pdbY }
    val pdbMon by remember { viewModel.pdbMon }
    val pdbD by remember { viewModel.pdbD }
    val pdbH by remember { viewModel.pdbH }
    val pdbMin by remember { viewModel.pdbMin }
    val pdbS by remember { viewModel.pdbS }
    val pdbMs by remember { viewModel.pdbMs }
    val pdb by remember { viewModel.pdb }

    val pdcY by remember { viewModel.pdcY }
    val pdcMon by remember { viewModel.pdcMon }
    val pdcD by remember { viewModel.pdcD }
    val pdcH by remember { viewModel.pdcH }
    val pdcMin by remember { viewModel.pdcMin }
    val pdcS by remember { viewModel.pdcS }
    val pdcMs by remember { viewModel.pdcMs }
    val pdc by remember { viewModel.pdc }

    val pdAPY by remember { viewModel.pdAPY }
    val pdAPMon by remember { viewModel.pdAPMon }
    val pdAPD by remember { viewModel.pdAPD }
    val pdAPH by remember { viewModel.pdAPH }
    val pdAPMin by remember { viewModel.pdAPMin }
    val pdAPS by remember { viewModel.pdAPS }
    val pdAPMs by remember { viewModel.pdAPMs }
    val pdAP by remember { viewModel.pdAP }

    val pdRPY by remember { viewModel.pdRPY }
    val pdRPMon by remember { viewModel.pdRPMon }
    val pdRPD by remember { viewModel.pdRPD }
    val pdRPH by remember { viewModel.pdRPH }
    val pdRPMin by remember { viewModel.pdRPMin }
    val pdRPS by remember { viewModel.pdRPS }
    val pdRPMs by remember { viewModel.pdRPMs }
    val pdRP by remember { viewModel.pdRP }

    val odaY by remember { viewModel.odaY }
    val odaMon by remember { viewModel.odaMon }
    val odaD by remember { viewModel.odaD }
    val odaH by remember { viewModel.odaH }
    val odaMin by remember { viewModel.odaMin }
    val odaS by remember { viewModel.odaS }
    val odaMs by remember { viewModel.odaMs }
    val oda by remember { viewModel.oda }

    val odbY by remember { viewModel.odbY }
    val odbMon by remember { viewModel.odbMon }
    val odbD by remember { viewModel.odbD }
    val odbH by remember { viewModel.odbH }
    val odbMin by remember { viewModel.odbMin }
    val odbS by remember { viewModel.odbS }
    val odbMs by remember { viewModel.odbMs }
    val odb by remember { viewModel.odb }

    val odcY by remember { viewModel.odcY }
    val odcMon by remember { viewModel.odcMon }
    val odcD by remember { viewModel.odcD }
    val odcH by remember { viewModel.odcH }
    val odcMin by remember { viewModel.odcMin }
    val odcS by remember { viewModel.odcS }
    val odcMs by remember { viewModel.odcMs }
    val odc by remember { viewModel.odc }

    val odAPY by remember { viewModel.odAPY }
    val odAPMon by remember { viewModel.odAPMon }
    val odAPD by remember { viewModel.odAPD }
    val odAPH by remember { viewModel.odAPH }
    val odAPMin by remember { viewModel.odAPMin }
    val odAPS by remember { viewModel.odAPS }
    val odAPMs by remember { viewModel.odAPMs }
    val odAP by remember { viewModel.odAP }

    val odRPY by remember { viewModel.odRPY }
    val odRPMon by remember { viewModel.odRPMon }
    val odRPD by remember { viewModel.odRPD }
    val odRPH by remember { viewModel.odRPH }
    val odRPMin by remember { viewModel.odRPMin }
    val odRPS by remember { viewModel.odRPS }
    val odRPMs by remember { viewModel.odRPMs }
    val odRP by remember { viewModel.odRP }

    val de = arrayOf(
        Mand("Current Phase A", pdaY, pdaMon, pdaD, pdaH, pdaMin, pdaS, pdaMs, pda, "A"),
        Mand("Current phase B", pdbY, pdbMon, pdbD, pdbH, pdbMin, pdbS, pdbMs, pdb, "A"),
        Mand("Current phase C", pdcY, pdcMon, pdcD, pdcH, pdcMin, pdcS, pdcMs, pdc, "A"),
        Mand("Active Power", pdAPY, pdAPMon, pdAPD, pdAPH, pdAPMin, pdAPS, pdAPMs, pdAP, "W"),
        Mand("Reactive Power", pdRPY, pdRPMon, pdRPD, pdRPH, pdRPMin, pdRPS, pdRPMs, pdRP, "Var"),
    )

    val and = arrayOf(
        Dmand("Current Phase A", odaY, odaMon, odaD, odaH, odaMin, odaS, odaMs, oda, "A"),
        Dmand("Current phase B", odbY, odbMon, odbD, odbH, odbMin, odbS, odbMs, odb, "A"),
        Dmand("Current phase C", odcY, odcMon, odcD, odcH, odcMin, odcS, odcMs, odc, "A"),
        Dmand("Active Power", odAPY, odAPMon, odAPD, odAPH, odAPMin, odAPS, odAPMs, odAP, "W"),
        Dmand("Reactive Power", odRPY, odRPMon, odRPD, odRPH, odRPMin, odRPS, odRPMs, odRP, "Var")
    )

    val md = arrayOf(
        Peak("Peak Demand")
    )

    val em = arrayOf(
        Over("Over Demand")
    )

    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
        items(em.size) {
            val v = em[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.DMD,
                    Modifier
                        .weight(1f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
            }
        }
        items(de.size) {
            val v = de[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.aName,
                    Modifier
                        .weight(0.6f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.aYear},${v.aMon},${v.aDay},${v.aHour},${v.aMin},${v.aSec},${v.aMs}",
                    Modifier
                        .weight(0.5f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.aFlva.toUnitString("%.02f", v.aUnit)}",
                    Modifier
                        .weight(0.3f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
            }
        }
        items(md.size) {
            val v = md[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.DMType,
                    Modifier
                        .weight(1f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
            }
        }
        items(and.size) {
            val v = and[it]
            Row(Modifier.fillMaxWidth()) {
                Text(v.bName,
                    Modifier
                        .weight(0.6f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.bYear},${v.bMon},${v.bDay},${v.bHour},${v.bMin},${v.bSec},${v.bMs}",
                    Modifier
                        .weight(0.5f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
                Text(
                    "${v.bFlva.toUnitString("%.02f", v.bUnit)}",
                    Modifier
                        .weight(0.3f)
                        .height(40.dp)
                        .border(0.6.dp, Color.Black),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
@Preview
@Composable
fun DemandScreenPreview() {
    VIPAM3500Theme {
        DemandScreen(viewModel())
    }
}