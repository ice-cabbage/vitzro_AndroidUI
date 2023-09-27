package com.vitzrotech.vipam3500

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.collections.ArrayDeque

class SharedViewModel : ViewModel() {
    val totW = mutableStateOf(0.0f)
    val totVAR = mutableStateOf(0.0f)
    val totVA = mutableStateOf(0.0f)
    val totPF = mutableStateOf(0.0f)
    val hz = mutableStateOf(0.0f)
    val vABMag = mutableStateOf(0.0f)
    val vABAng = mutableStateOf(0.0f)
    val vBCMag = mutableStateOf(0.0f)
    val vBCAng = mutableStateOf(0.0f)
    val vCAMag = mutableStateOf(0.0f)
    val vCAAng = mutableStateOf(0.0f)
    val vAMag = mutableStateOf(0.0f)
    val vAAng = mutableStateOf(0.0f)
    val vBMag = mutableStateOf(0.0f)
    val vBAng = mutableStateOf(0.0f)
    val vCMag = mutableStateOf(0.0f)
    val vCAng = mutableStateOf(0.0f)
    val vNMag = mutableStateOf(0.0f)
    val vNAng = mutableStateOf(0.0f)
    val vRMag = mutableStateOf(0.0f)
    val vRAng = mutableStateOf(0.0f)
    val iAMag = mutableStateOf(0.0f)
    val iAAng = mutableStateOf(0.0f)
    val iBMag = mutableStateOf(0.0f)
    val iBAng = mutableStateOf(0.0f)
    val iCMag = mutableStateOf(0.0f)
    val iCAng = mutableStateOf(0.0f)
    val iNMag = mutableStateOf(0.0f)
    val iNAng = mutableStateOf(0.0f)
    val iEMag = mutableStateOf(0.0f)
    val iEAng = mutableStateOf(0.0f)
    val iRMag = mutableStateOf(0.0f)
    val iRAng = mutableStateOf(0.0f)
    val wAMag = mutableStateOf(0.0f)
    val wBMag = mutableStateOf(0.0f)
    val wCMag = mutableStateOf(0.0f)
    val varAMag = mutableStateOf(0.0f)
    val varBMag = mutableStateOf(0.0f)
    val varCMag = mutableStateOf(0.0f)
    val vaAMag = mutableStateOf(0.0f)
    val vaBMag = mutableStateOf(0.0f)
    val vaCMag = mutableStateOf(0.0f)
    val whA = mutableStateOf(0.0f)
    val whB = mutableStateOf(0.0f)
    val whC = mutableStateOf(0.0f)
    val wh = mutableStateOf(0.0f)
    val varhA = mutableStateOf(0.0f)
    val varhB = mutableStateOf(0.0f)
    val varhC = mutableStateOf(0.0f)
    val varh = mutableStateOf(0.0f)
    val lgVarhA = mutableStateOf(0.0f)
    val lgVarhB = mutableStateOf(0.0f)
    val lgVarhC = mutableStateOf(0.0f)
    val lgVarh = mutableStateOf(0.0f)
    val vahA = mutableStateOf(0.0f)
    val vahB = mutableStateOf(0.0f)
    val vahC = mutableStateOf(0.0f)
    val vah = mutableStateOf(0.0f)
    val rWhA = mutableStateOf(0.0f)
    val rWhB = mutableStateOf(0.0f)
    val rWhC = mutableStateOf(0.0f)
    val rWh = mutableStateOf(0.0f)
    val rVarhA = mutableStateOf(0.0f)
    val rVarhB = mutableStateOf(0.0f)
    val rVarhC = mutableStateOf(0.0f)
    val rVarh = mutableStateOf(0.0f)
    val rLgVarhA = mutableStateOf(0.0f)
    val rLgVarhB = mutableStateOf(0.0f)
    val rLgVarhC = mutableStateOf(0.0f)
    val rLgVarh = mutableStateOf(0.0f)
    val rVahA = mutableStateOf(0.0f)
    val rVahB = mutableStateOf(0.0f)
    val rVahC = mutableStateOf(0.0f)
    val rVah = mutableStateOf(0.0f)
    val auxHz = mutableStateOf(0.0f)
    val hz2 = mutableStateOf(0.0f)
    val v2AMag = mutableStateOf(0.0f)
    val v2AAng = mutableStateOf(0.0f)
    val v2BMag = mutableStateOf(0.0f)
    val v2BAng = mutableStateOf(0.0f)
    val v2CMag = mutableStateOf(0.0f)
    val v2CAng = mutableStateOf(0.0f)
    val v2NMag = mutableStateOf(0.0f)
    val v2NAng = mutableStateOf(0.0f)
    val v2ABMag = mutableStateOf(0.0f)
    val v2ABAng = mutableStateOf(0.0f)
    val v2BCMag = mutableStateOf(0.0f)
    val v2BCAng = mutableStateOf(0.0f)
    val v2CAMag = mutableStateOf(0.0f)
    val v2CAAng = mutableStateOf(0.0f)
    val thdVA = mutableStateOf(0.0f)
    val thdVB = mutableStateOf(0.0f)
    val thdVC = mutableStateOf(0.0f)
    val thdIA = mutableStateOf(0.0f)
    val thdIB = mutableStateOf(0.0f)
    val thdIC = mutableStateOf(0.0f)
    val tddIA = mutableStateOf(0.0f)
    val tddIB = mutableStateOf(0.0f)
    val tddIC = mutableStateOf(0.0f)
    val thdV2A = mutableStateOf(0.0f)
    val thdV2B = mutableStateOf(0.0f)
    val thdV2C = mutableStateOf(0.0f)
    val hkfA = mutableStateOf(0.0f)
    val hkfB = mutableStateOf(0.0f)
    val hkfC = mutableStateOf(0.0f)
    val hcfVA = mutableStateOf(0.0f)
    val hcfVB = mutableStateOf(0.0f)
    val hcfVC = mutableStateOf(0.0f)
    val hcfIA = mutableStateOf(0.0f)
    val hcfIB = mutableStateOf(0.0f)
    val hcfIC = mutableStateOf(0.0f)

    val seqV1 = mutableStateOf(0.0f)
    val seqV2 = mutableStateOf(0.0f)
    val seqV3 = mutableStateOf(0.0f)
    val seqA1 = mutableStateOf(0.0f)
    val seqA2 = mutableStateOf(0.0f)
    val seqA3 = mutableStateOf(0.0f)
    val rmsVa = mutableStateOf(0.0f)
    val rmsVb = mutableStateOf(0.0f)
    val rmsVc = mutableStateOf(0.0f)
    val rmsVn = mutableStateOf(0.0f)
    val rmsIa = mutableStateOf(0.0f)
    val rmsIb = mutableStateOf(0.0f)
    val rmsIc = mutableStateOf(0.0f)
    val rmsIn = mutableStateOf(0.0f)
    val rms = mutableStateOf(0.0f)

    val lmbVa = mutableStateOf(0.0f)
    val lmbVb = mutableStateOf(0.0f)
    val lmbVc = mutableStateOf(0.0f)
    val lmbVab = mutableStateOf(0.0f)
    val lmbVbc = mutableStateOf(0.0f)
    val lmbVca = mutableStateOf(0.0f)
    val lmbNgv = mutableStateOf(0.0f)
    val lmbZroV = mutableStateOf(0.0f)
    val lmbla = mutableStateOf(0.0f)
    val lmblb = mutableStateOf(0.0f)
    val lmblc = mutableStateOf(0.0f)
    val lmbNgA = mutableStateOf(0.0f)
    val lmbZroA = mutableStateOf(0.0f)

    val ka = mutableStateOf(0.0f)
    val kb = mutableStateOf(0.0f)
    val kc = mutableStateOf(0.0f)
    val eleca = mutableStateOf(0.0f)
    val elecb = mutableStateOf(0.0f)
    val elecc = mutableStateOf(0.0f)
    val vola = mutableStateOf(0.0f)
    val volb = mutableStateOf(0.0f)
    val volc = mutableStateOf(0.0f)

    val lev = mutableStateOf(0.0f)
    val ia = mutableStateOf(0.0f)
    val ib = mutableStateOf(0.0f)
    val ic = mutableStateOf(0.0f)

    val ma1 = mutableStateOf(0.0f)
    val ma2 = mutableStateOf(0.0f)
    val ma3 = mutableStateOf(0.0f)
    val ma4 = mutableStateOf(0.0f)

    //최대 전류
    val maxCur = mutableStateOf(0.0f)
    val maxCurPh = mutableStateOf(0.0f)
    val maxCurY = mutableStateOf(0)
    val maxCurMon = mutableStateOf(0)
    val maxCurD = mutableStateOf(0)
    val maxCurH = mutableStateOf(0)
    val maxCurMin = mutableStateOf(0)
    val maxCurS = mutableStateOf(0)
    val maxCurms = mutableStateOf(0)

    //최소 전류
    val minCur = mutableStateOf(0.0f)
    val minCurPh = mutableStateOf(0.0f)
    val minCurY = mutableStateOf(0)
    val minCurMon = mutableStateOf(0)
    val minCurD = mutableStateOf(0)
    val minCurH = mutableStateOf(0)
    val minCurMin = mutableStateOf(0)
    val minCurS = mutableStateOf(0)
    val minCurms = mutableStateOf(0)

    //최대 전압
    val maxVol = mutableStateOf(0.0f)
    val maxVolPh = mutableStateOf(0.0f)
    val maxVolY = mutableStateOf(0)
    val maxVolMon = mutableStateOf(0)
    val maxVolD = mutableStateOf(0)
    val maxVolH = mutableStateOf(0)
    val maxVolMin = mutableStateOf(0)
    val maxVolS = mutableStateOf(0)
    val maxVolms = mutableStateOf(0)

    //최소 전압
    val minVol = mutableStateOf(0.0f)
    val minVolPh = mutableStateOf(0.0f)
    val minVolY = mutableStateOf(0)
    val minVolMon = mutableStateOf(0)
    val minVolD = mutableStateOf(0)
    val minVolH = mutableStateOf(0)
    val minVolMin = mutableStateOf(0)
    val minVolS = mutableStateOf(0)
    val minVolms = mutableStateOf(0)

    //최대 주파수
    val maxFreq = mutableStateOf(0.0f)
    val maxFreqPh = mutableStateOf(0.0f)
    val maxFreqY = mutableStateOf(0)
    val maxFreqMon = mutableStateOf(0)
    val maxFreqD = mutableStateOf(0)
    val maxFreqH = mutableStateOf(0)
    val maxFreqMin = mutableStateOf(0)
    val maxFreqS = mutableStateOf(0)
    val maxFreqms = mutableStateOf(0)

    //최소 주파수
    val minFreq = mutableStateOf(0.0f)
    val minFreqPh = mutableStateOf(0.0f)
    val minFreqY = mutableStateOf(0)
    val minFreqMon = mutableStateOf(0)
    val minFreqD = mutableStateOf(0)
    val minFreqH = mutableStateOf(0)
    val minFreqMin = mutableStateOf(0)
    val minFreqS = mutableStateOf(0)
    val minFreqms = mutableStateOf(0)

    //최대 유효전력
    val maxWatt = mutableStateOf(0.0f)
    val maxWattPh = mutableStateOf(0.0f)
    val maxWattY = mutableStateOf(0)
    val maxWattMon = mutableStateOf(0)
    val maxWattD = mutableStateOf(0)
    val maxWattH = mutableStateOf(0)
    val maxWattMin = mutableStateOf(0)
    val maxWattS = mutableStateOf(0)
    val maxWattms = mutableStateOf(0)

    //최소 유효전력
    val minWatt = mutableStateOf(0.0f)
    val minWattPh = mutableStateOf(0.0f)
    val minWattY = mutableStateOf(0)
    val minWattMon = mutableStateOf(0)
    val minWattD = mutableStateOf(0)
    val minWattH = mutableStateOf(0)
    val minWattMin = mutableStateOf(0)
    val minWattS = mutableStateOf(0)
    val minWattms = mutableStateOf(0)

    //최대 무효전력
    val maxVar = mutableStateOf(0.0f)
    val maxVarPh = mutableStateOf(0.0f)
    val maxVarY = mutableStateOf(0)
    val maxVarMon = mutableStateOf(0)
    val maxVarD = mutableStateOf(0)
    val maxVarH = mutableStateOf(0)
    val maxVarMin = mutableStateOf(0)
    val maxVarS = mutableStateOf(0)
    val maxVarms = mutableStateOf(0)

    //최소 무효전력
    val minVar = mutableStateOf(0.0f)
    val minVarPh = mutableStateOf(0.0f)
    val minVarY = mutableStateOf(0)
    val minVarMon = mutableStateOf(0)
    val minVarD = mutableStateOf(0)
    val minVarH = mutableStateOf(0)
    val minVarMin = mutableStateOf(0)
    val minVarS = mutableStateOf(0)
    val minVarms = mutableStateOf(0)

    //peak디맨드
    //전류A상
    val pdaY = mutableStateOf(0)
    val pdaMon = mutableStateOf(0)
    val pdaD = mutableStateOf(0)
    val pdaH = mutableStateOf(0)
    val pdaMin = mutableStateOf(0)
    val pdaS = mutableStateOf(0)
    val pdaMs = mutableStateOf(0)
    val pda = mutableStateOf(0.0f)

    //전류B상
    val pdbY = mutableStateOf(0)
    val pdbMon = mutableStateOf(0)
    val pdbD = mutableStateOf(0)
    val pdbH = mutableStateOf(0)
    val pdbMin = mutableStateOf(0)
    val pdbS = mutableStateOf(0)
    val pdbMs = mutableStateOf(0)
    val pdb = mutableStateOf(0.0f)

    //전류C상
    val pdcY = mutableStateOf(0)
    val pdcMon = mutableStateOf(0)
    val pdcD = mutableStateOf(0)
    val pdcH = mutableStateOf(0)
    val pdcMin = mutableStateOf(0)
    val pdcS = mutableStateOf(0)
    val pdcMs = mutableStateOf(0)
    val pdc = mutableStateOf(0.0f)

    //유효전력
    val pdAPY = mutableStateOf(0)
    val pdAPMon = mutableStateOf(0)
    val pdAPD = mutableStateOf(0)
    val pdAPH = mutableStateOf(0)
    val pdAPMin = mutableStateOf(0)
    val pdAPS = mutableStateOf(0)
    val pdAPMs = mutableStateOf(0)
    val pdAP = mutableStateOf(0.0f)

    //무효전력
    val pdRPY = mutableStateOf(0)
    val pdRPMon = mutableStateOf(0)
    val pdRPD = mutableStateOf(0)
    val pdRPH = mutableStateOf(0)
    val pdRPMin = mutableStateOf(0)
    val pdRPS = mutableStateOf(0)
    val pdRPMs = mutableStateOf(0)
    val pdRP = mutableStateOf(0.0f)

    //over디맨드
    //전류A상
    val odaY = mutableStateOf(0)
    val odaMon = mutableStateOf(0)
    val odaD = mutableStateOf(0)
    val odaH = mutableStateOf(0)
    val odaMin = mutableStateOf(0)
    val odaS = mutableStateOf(0)
    val odaMs = mutableStateOf(0)
    val oda = mutableStateOf(0.0f)

    //전류B상
    val odbY = mutableStateOf(0)
    val odbMon = mutableStateOf(0)
    val odbD = mutableStateOf(0)
    val odbH = mutableStateOf(0)
    val odbMin = mutableStateOf(0)
    val odbS = mutableStateOf(0)
    val odbMs = mutableStateOf(0)
    val odb = mutableStateOf(0.0f)

    //전류C상
    val odcY = mutableStateOf(0)
    val odcMon = mutableStateOf(0)
    val odcD = mutableStateOf(0)
    val odcH = mutableStateOf(0)
    val odcMin = mutableStateOf(0)
    val odcS = mutableStateOf(0)
    val odcMs = mutableStateOf(0)
    val odc = mutableStateOf(0.0f)

    //유효전력
    val odAPY = mutableStateOf(0)
    val odAPMon = mutableStateOf(0)
    val odAPD = mutableStateOf(0)
    val odAPH = mutableStateOf(0)
    val odAPMin = mutableStateOf(0)
    val odAPS = mutableStateOf(0)
    val odAPMs = mutableStateOf(0)
    val odAP = mutableStateOf(0.0f)

    //무효전력
    val odRPY = mutableStateOf(0)
    val odRPMon = mutableStateOf(0)
    val odRPD = mutableStateOf(0)
    val odRPH = mutableStateOf(0)
    val odRPMin = mutableStateOf(0)
    val odRPS = mutableStateOf(0)
    val odRPMs = mutableStateOf(0)
    val odRP = mutableStateOf(0.0f)

    //PLC IO Memory
    val fir = mutableStateOf(0)
    val sec = mutableStateOf(0)
    val thr = mutableStateOf(0)
    val four = mutableStateOf(0)

    val cb1 = mutableStateOf(0x0u)
    val cb2 = mutableStateOf(0x0u)
    val diStatus1 = mutableStateOf(0x0u)
    val diStatus2 = mutableStateOf(0x0u)
    val diStatus3 = mutableStateOf(0x0u)
    val diStatus4 = mutableStateOf(0x0u)
    val diStatus5 = mutableStateOf(0x0u)
    val diStatus6 = mutableStateOf(0x0u)
    val doStatus1 = mutableStateOf(0x0u)
    val doStatus2 = mutableStateOf(0x0u)
    val doStatus3 = mutableStateOf(0x0u)
    val doStatus4 = mutableStateOf(0x0u)
    val opStored1 = mutableStateOf(0x0u)
    val opStored2 = mutableStateOf(0x0u)
    val opStored3 = mutableStateOf(0x0u)
    val opStored4 = mutableStateOf(0x0u)
    val opStored5 = mutableStateOf(0x0u)
    val str1 = mutableStateOf(0x0u)
    val str2 = mutableStateOf(0x0u)
    val str3 = mutableStateOf(0x0u)
    val str4 = mutableStateOf(0x0u)
    val str5 = mutableStateOf(0x0u)
    val relayMod0 = mutableStateOf(0x0u)
    val relayMod1 = mutableStateOf(0x0u)
    val relayMod2 = mutableStateOf(0x0u)
    val interlock = mutableStateOf(0x0u)

    //device info
    val Dtype = mutableStateOf("")
    val DspV = mutableStateOf(0.0f)
    val MMIV = mutableStateOf(0.0f)
    val ComV = mutableStateOf(0.0f)
    val PLCV = mutableStateOf(0.0f)

    //power system
    val WirA = mutableStateOf("")
    val WirB = mutableStateOf("")
    val Phs = mutableStateOf("")
    val NorFreq = mutableStateOf(0)
    val PT1 = mutableStateOf(0)
    val PT2 = mutableStateOf(0.0f)
    val AuxPT1 = mutableStateOf(0)
    val AuxPT2 = mutableStateOf(0.0f)
    val GPT1 = mutableStateOf(0)
    val GPT2 = mutableStateOf(0.0f)
    val CT1 = mutableStateOf(0)
    val CT2 = mutableStateOf(0)
    val NCT1 = mutableStateOf(0)
    val NCT2 = mutableStateOf(0)
    val ZCT1 = mutableStateOf(0.000f)
    val ZCT2 = mutableStateOf(0.000f)

    //Addition Info
    val VTfail = mutableStateOf("")
    val sup = mutableStateOf("")
    val wave = mutableStateOf("")
    val trend = mutableStateOf("")
    val UVvol = mutableStateOf(0.0f)
    val UCcur = mutableStateOf(0.0f)
    val NVvol = mutableStateOf(0.0f)
    val NCcur = mutableStateOf(0.0f)
    val POvol = mutableStateOf(0.0f)
    val TDcur = mutableStateOf(0.0f)
    val DMtime = mutableStateOf(0)

    //Motor Status Info
    val mod = mutableStateOf("")
    val fullCur = mutableStateOf(0.0f)
    val lockCur = mutableStateOf(0.0f)
    val lockTime = mutableStateOf(0.0f)
    val safeTime = mutableStateOf(0.0f)

    //DO control

    //Breaker Failure
    val mo = mutableStateOf("")
    val failure = mutableStateOf("")
    val delaySec = mutableStateOf(0.0f)
    val detect = mutableStateOf(0.0f)

    private var whAH = 0.0f
    private var whAL = 0.0f
    private var whAG = 0.0f
    private var whBH = 0.0f
    private var whBL = 0.0f
    private var whBG = 0.0f
    private var whCH = 0.0f
    private var whCL = 0.0f
    private var whCG = 0.0f
    private var whH = 0.0f
    private var whL = 0.0f
    private var whG = 0.0f
    private var varhAH = 0.0f
    private var varhAL = 0.0f
    private var varhAG = 0.0f
    private var varhBH = 0.0f
    private var varhBL = 0.0f
    private var varhBG = 0.0f
    private var varhCH = 0.0f
    private var varhCL = 0.0f
    private var varhCG = 0.0f
    private var varhH = 0.0f
    private var varhL = 0.0f
    private var varhG = 0.0f
    private var lgVarhAH = 0.0f
    private var lgVarhAL = 0.0f
    private var lgVarhAG = 0.0f
    private var lgVarhBH = 0.0f
    private var lgVarhBL = 0.0f
    private var lgVarhBG = 0.0f
    private var lgVarhCH = 0.0f
    private var lgVarhCL = 0.0f
    private var lgVarhCG = 0.0f
    private var lgVarhH = 0.0f
    private var lgVarhL = 0.0f
    private var lgVarhG = 0.0f
    private var vahAH = 0.0f
    private var vahAL = 0.0f
    private var vahAG = 0.0f
    private var vahBH = 0.0f
    private var vahBL = 0.0f
    private var vahBG = 0.0f
    private var vahCH = 0.0f
    private var vahCL = 0.0f
    private var vahCG = 0.0f
    private var vahH = 0.0f
    private var vahL = 0.0f
    private var vahG = 0.0f
    private var rWhAH = 0.0f
    private var rWhAL = 0.0f
    private var rWhAG = 0.0f
    private var rWhBH = 0.0f
    private var rWhBL = 0.0f
    private var rWhBG = 0.0f
    private var rWhCH = 0.0f
    private var rWhCL = 0.0f
    private var rWhCG = 0.0f
    private var rWhH = 0.0f
    private var rWhL = 0.0f
    private var rWhG = 0.0f
    private var rVarhAH = 0.0f
    private var rVarhAL = 0.0f
    private var rVarhAG = 0.0f
    private var rVarhBH = 0.0f
    private var rVarhBL = 0.0f
    private var rVarhBG = 0.0f
    private var rVarhCH = 0.0f
    private var rVarhCL = 0.0f
    private var rVarhCG = 0.0f
    private var rVarhH = 0.0f
    private var rVarhL = 0.0f
    private var rVarhG = 0.0f
    private var rLgVarhAH = 0.0f
    private var rLgVarhAL = 0.0f
    private var rLgVarhAG = 0.0f
    private var rLgVarhBH = 0.0f
    private var rLgVarhBL = 0.0f
    private var rLgVarhBG = 0.0f
    private var rLgVarhCH = 0.0f
    private var rLgVarhCL = 0.0f
    private var rLgVarhCG = 0.0f
    private var rLgVarhH = 0.0f
    private var rLgVarhL = 0.0f
    private var rLgVarhG = 0.0f
    private var rVahAH = 0.0f
    private var rVahAL = 0.0f
    private var rVahAG = 0.0f
    private var rVahBH = 0.0f
    private var rVahBL = 0.0f
    private var rVahBG = 0.0f
    private var rVahCH = 0.0f
    private var rVahCL = 0.0f
    private var rVahCG = 0.0f
    private var rVahH = 0.0f
    private var rVahL = 0.0f
    private var rVahG = 0.0f

    fun messageArrived(topic: String, value: String) {
        when(topic) {
            //device info
            "System/SymCfg/PowerSystem/SysTy" -> Dtype.value = value

            //power system
            "System/SymCfg/sPowerSystem/Wiring" -> WirA.value = value
            "System/SymCfg/sPowerSystem/Wiring2" -> WirB.value = value
            "System/SymCfg/sPowerSystem/MxTy" -> Phs.value = value

            //Addition Factulty
            "sSG/sRySet/sRPSRy/sRVTF/Mod" -> VTfail.value = value
            "System/SymCfg/sPowerSystem/CTPTDiagnostic" -> sup.value = value
            "System/SymCfg/sWvCfg/eSelWvPos" -> wave.value = value
            "System/SymCfg/sPowerSystem/RMSTrendMod" -> trend.value = value

            //Motor Status Info
            "SG/RySet/MSURy/RMSI/Mod" -> mod.value = value

            //Breaker Failure
            "SG/RySet/RPSRy/RBRF/Mod" -> mo.value = value
            "SG/RySet/RPSRy/RBRF/FailMod" -> failure.value = value
        }
    }

    fun messageArrived(topic: String, value: Int) {
        when(topic) {
            "MI/MSTA/MaxAmps/t/tm_year" -> maxCurY.value = value
            "MI/MSTA/MaxAmps/t/tm_mon" -> maxCurMon.value = value
            "MI/MSTA/MaxAmps/t/tm_mday" -> maxCurD.value = value
            "MI/MSTA/MaxAmps/t/tm_hour" -> maxCurH.value = value
            "MI/MSTA/MaxAmps/t/tm_min" -> maxCurMin.value = value
            "MI/MSTA/MaxAmps/t/tm_sec" -> maxCurS.value = value
            "MI/MSTA/MaxAmps/t/tm_ms" -> maxCurms.value = value

            "MI/MSTA/MinAmps/t/tm_year" -> minCurY.value = value
            "MI/MSTA/MinAmps/t/tm_mon" -> minCurMon.value = value
            "MI/MSTA/MinAmps/t/tm_mday" -> minCurD.value = value
            "MI/MSTA/MinAmps/t/tm_hour" -> minCurH.value = value
            "MI/MSTA/MinAmps/t/tm_min" -> minCurMin.value = value
            "MI/MSTA/MinAmps/t/tm_sec" -> minCurS.value = value
            "MI/MSTA/MinAmps/t/tm_ms" -> minCurms.value = value

            "MI/MSTA/MaxVolts/t/tm_year" -> maxVolY.value = value
            "MI/MSTA/MaxVolts/t/tm_mon" -> maxVolMon.value = value
            "MI/MSTA/MaxVolts/t/tm_mday" -> maxVolD.value = value
            "MI/MSTA/MaxVolts/t/tm_hour" -> maxVolH.value = value
            "MI/MSTA/MaxVolts/t/tm_min" -> maxVolMin.value = value
            "MI/MSTA/MaxVolts/t/tm_sec" -> maxVolS.value = value
            "MI/MSTA/MaxVolts/t/tm_ms" -> maxVolms.value = value

            "MI/MSTA/MinVolts/t/tm_year" -> minVolY.value = value
            "MI/MSTA/MinVolts/t/tm_mon" -> minVolMon.value = value
            "MI/MSTA/MinVolts/t/tm_mday" -> minVolD.value = value
            "MI/MSTA/MinVolts/t/tm_hour" -> minVolH.value = value
            "MI/MSTA/MinVolts/t/tm_min" -> minVolMin.value = value
            "MI/MSTA/MinVolts/t/tm_sec" -> minVolS.value = value
            "MI/MSTA/MinVolts/t/tm_ms" -> minVolms.value = value

            "MI/MSTA/MaxHz/t/tm_year" -> maxFreqY.value = value
            "MI/MSTA/MaxHz/t/tm_mon" -> maxFreqMon.value = value
            "MI/MSTA/MaxHz/t/tm_mday" -> maxFreqD.value = value
            "MI/MSTA/MaxHz/t/tm_hour" -> maxFreqH.value = value
            "MI/MSTA/MaxHz/t/tm_min" -> maxFreqMin.value = value
            "MI/MSTA/MaxHz/t/tm_sec" -> maxFreqS.value = value
            "MI/MSTA/MaxHz/t/tm_ms" -> maxFreqms.value = value

            "MI/MSTA/MinHz/t/tm_year" -> minFreqY.value = value
            "MI/MSTA/MinHz/t/tm_mon" -> minFreqMon.value = value
            "MI/MSTA/MinHz/t/tm_mday" -> minFreqD.value = value
            "MI/MSTA/MinHz/t/tm_hour" -> minFreqH.value = value
            "MI/MSTA/MinHz/t/tm_min" -> minFreqMin.value = value
            "MI/MSTA/MinHz/t/tm_sec" -> minFreqS.value = value
            "MI/MSTA/MinHz/t/tm_ms" -> minFreqms.value = value

            "MI/MSTA/MaxTotW/t/tm_year" -> maxWattY.value = value
            "MI/MSTA/MaxTotW/t/tm_mon" -> maxWattMon.value = value
            "MI/MSTA/MaxTotW/t/tm_mday" -> maxWattD.value = value
            "MI/MSTA/MaxTotW/t/tm_hour" -> maxWattH.value = value
            "MI/MSTA/MaxTotW/t/tm_min" -> maxWattMin.value = value
            "MI/MSTA/MaxTotW/t/tm_sec" -> maxWattS.value = value
            "MI/MSTA/MaxTotW/t/tm_ms" -> maxWattms.value = value

            "MI/MSTA/MinTotW/t/tm_year" -> minWattY.value = value
            "MI/MSTA/MinTotW/t/tm_mon" -> minWattMon.value = value
            "MI/MSTA/MinTotW/t/tm_mday" -> minWattD.value = value
            "MI/MSTA/MinTotW/t/tm_hour" -> minWattH.value = value
            "MI/MSTA/MinTotW/t/tm_min" -> minWattMin.value = value
            "MI/MSTA/MinTotW/t/tm_sec" -> minWattS.value = value
            "MI/MSTA/MinTotW/t/tm_ms" -> minWattms.value = value

            "MI/MSTA/MaxTotVAr/t/tm_year" -> maxVarY.value = value
            "MI/MSTA/MaxTotVAr/t/tm_mon" -> maxVarMon.value = value
            "MI/MSTA/MaxTotVAr/t/tm_mday" -> maxVarD.value = value
            "MI/MSTA/MaxTotVAr/t/tm_hour" -> maxVarH.value = value
            "MI/MSTA/MaxTotVAr/t/tm_min" -> maxVarMin.value = value
            "MI/MSTA/MaxTotVAr/t/tm_sec" -> maxVarS.value = value
            "MI/MSTA/MaxTotVAr/t/tm_ms" -> maxVarms.value = value

            "MI/MSTA/MinTotVAr/t/tm_year" -> minVarY.value = value
            "MI/MSTA/MinTotVAr/t/tm_mon" -> minVarMon.value = value
            "MI/MSTA/MinTotVAr/t/tm_mday" -> minVarD.value = value
            "MI/MSTA/MinTotVAr/t/tm_hour" -> minVarH.value = value
            "MI/MSTA/MinTotVAr/t/tm_min" -> minVarMin.value = value
            "MI/MSTA/MinTotVAr/t/tm_sec" -> minVarS.value = value
            "MI/MSTA/MinTotVAr/t/tm_ms" -> minVarms.value = value

            //peak demand
            //current phase A
            "MI/MMTR/PKDmdA_phsA/t/tm_year" -> pdaY.value = value
            "MI/MMTR/PKDmdA_phsA/t/tm_mon" -> pdaMon.value = value
            "MI/MMTR/PKDmdA_phsA/t/tm_mday" -> pdaD.value = value
            "MI/MMTR/PKDmdA_phsA/t/tm_hour" -> pdaH.value = value
            "MI/MMTR/PKDmdA_phsA/t/tm_min" -> pdaMin.value = value
            "MI/MMTR/PKDmdA_phsA/t/tm_sec" -> pdaS.value = value
            "MI/MMTR/PKDmdA_phsA/t/tm_ms" -> pdaMs.value = value

            //current phase B
            "MI/MMTR/PKDmdA_phsB/t/tm_year" -> pdbY.value = value
            "MI/MMTR/PKDmdA_phsB/t/tm_mon" -> pdbMon.value = value
            "MI/MMTR/PKDmdA_phsB/t/tm_mday" -> pdbD.value = value
            "MI/MMTR/PKDmdA_phsB/t/tm_hour" -> pdbH.value = value
            "MI/MMTR/PKDmdA_phsB/t/tm_min" -> pdbMin.value = value
            "MI/MMTR/PKDmdA_phsB/t/tm_sec" -> pdbS.value = value
            "MI/MMTR/PKDmdA_phsB/t/tm_ms" -> pdbMs.value = value

            //current phase C
            "MI/MMTR/PKDmdA_phsC/t/tm_year" -> pdcY.value = value
            "MI/MMTR/PKDmdA_phsC/t/tm_mon" -> pdcMon.value = value
            "MI/MMTR/PKDmdA_phsC/t/tm_mday" -> pdcD.value = value
            "MI/MMTR/PKDmdA_phsC/t/tm_hour" -> pdcH.value = value
            "MI/MMTR/PKDmdA_phsC/t/tm_min" -> pdcMin.value = value
            "MI/MMTR/PKDmdA_phsC/t/tm_sec" -> pdcS.value = value
            "MI/MMTR/PKDmdA_phsC/t/tm_ms" -> pdcMs.value = value

            //Active Power
            "MI/MMTR/PKDmdW/t/tm_year" -> pdAPY.value = value
            "MI/MMTR/PKDmdW/t/tm_mon" -> pdAPMon.value = value
            "MI/MMTR/PKDmdW/t/tm_mday" -> pdAPD.value = value
            "MI/MMTR/PKDmdW/t/tm_hour" -> pdAPH.value = value
            "MI/MMTR/PKDmdW/t/tm_min" -> pdAPMin.value = value
            "MI/MMTR/PKDmdW/t/tm_sec" -> pdAPS.value = value
            "MI/MMTR/PKDmdW/t/tm_ms" -> pdAPMs.value = value

            //Reactive Power
            "MI/MMTR/PKDmdVAr/t/tm_year" -> pdRPY.value = value
            "MI/MMTR/PKDmdVAr/t/tm_mon" -> pdRPMon.value = value
            "MI/MMTR/PKDmdVAr/t/tm_mday" -> pdRPD.value = value
            "MI/MMTR/PKDmdVAr/t/tm_hour" -> pdRPH.value = value
            "MI/MMTR/PKDmdVAr/t/tm_min" -> pdRPMin.value = value
            "MI/MMTR/PKDmdVAr/t/tm_sec" -> pdRPS.value = value
            "MI/MMTR/PKDmdVAr/t/tm_ms" -> pdRPMs.value = value

            //Over demand
            //current A
            "MI/MMTR/OVDmdA_phsA/t/tm_year" -> odaY.value = value
            "MI/MMTR/OVDmdA_phsA/t/tm_mon" -> odaMon.value = value
            "MI/MMTR/OVDmdA_phsA/t/tm_mday" -> odaD.value = value
            "MI/MMTR/OVDmdA_phsA/t/tm_hour" -> odaH.value = value
            "MI/MMTR/OVDmdA_phsA/t/tm_min" -> odaMin.value = value
            "MI/MMTR/OVDmdA_phsA/t/tm_sec" -> odaS.value = value
            "MI/MMTR/OVDmdA_phsA/t/tm_ms" -> odaMs.value = value

            //current B
            "MI/MMTR/OVDmdA_phsB/t/tm_year" -> odbY.value = value
            "MI/MMTR/OVDmdA_phsB/t/tm_mon" -> odbMon.value = value
            "MI/MMTR/OVDmdA_phsB/t/tm_mday" -> odbD.value = value
            "MI/MMTR/OVDmdA_phsB/t/tm_hour" -> odbH.value = value
            "MI/MMTR/OVDmdA_phsB/t/tm_min" -> odbMin.value = value
            "MI/MMTR/OVDmdA_phsB/t/tm_sec" -> odbS.value = value
            "MI/MMTR/OVDmdA_phsB/t/tm_ms" -> odbMs.value = value

            //current C
            "MI/MMTR/OVDmdA_phsC/t/tm_year" -> odcY.value = value
            "MI/MMTR/OVDmdA_phsC/t/tm_mon" -> odcMon.value = value
            "MI/MMTR/OVDmdA_phsC/t/tm_mday" -> odcD.value = value
            "MI/MMTR/OVDmdA_phsC/t/tm_hour" -> odcH.value = value
            "MI/MMTR/OVDmdA_phsC/t/tm_min" -> odcMin.value = value
            "MI/MMTR/OVDmdA_phsC/t/tm_sec" -> odcS.value = value
            "MI/MMTR/OVDmdA_phsC/t/tm_ms" -> odcMs.value = value

            //Active Power
            "MI/MMTR/OVDmdW/t/tm_year" -> odAPY.value = value
            "MI/MMTR/OVDmdW/t/tm_mon" -> odAPMon.value = value
            "MI/MMTR/OVDmdW/t/tm_mday" -> odAPD.value = value
            "MI/MMTR/OVDmdW/t/tm_hour" -> odAPH.value = value
            "MI/MMTR/OVDmdW/t/tm_min" -> odAPMin.value = value
            "MI/MMTR/OVDmdW/t/tm_sec" -> odAPS.value = value
            "MI/MMTR/OVDmdW/t/tm_ms" -> odAPMs.value = value

            //Reactive Power
            "MI/MMTR/OVDmdVAr/t/tm_year" -> odRPY.value = value
            "MI/MMTR/OVDmdVAr/t/tm_mon" -> odRPMon.value = value
            "MI/MMTR/OVDmdVAr/t/tm_mday" -> odRPD.value = value
            "MI/MMTR/OVDmdVAr/t/tm_hour" -> odRPH.value = value
            "MI/MMTR/OVDmdVAr/t/tm_min" -> pdRPMin.value = value
            "MI/MMTR/OVDmdVAr/t/tm_sec" -> pdRPS.value = value
            "MI/MMTR/OVDmdVAr/t/tm_ms" -> pdRPMs.value = value

            //PLC IO Memory
            "System/SymIn/DetailInterlockStatus1/all" -> fir.value = value
            "System/SymIn/DetailInterlockStatus2/all" -> sec.value = value
            "System/SymIn/DetailInterlockStatus3/all" -> thr.value = value
            "System/SymIn/DetailInterlockStatus4/all" -> four.value = value

            //power system
            "System/SymCfg/sPowerSystem/NormalFreq" -> NorFreq.value = value
            "System/SymCfg/sPowerSystem/PT_P/Set1" -> PT1.value = value
            "System/SymCfg/sPowerSystem/PT_R/Set1" -> AuxPT1.value = value
            "System/SymCfg/sPowerSystem/PT_N/Set1" -> GPT1.value = value
            "System/SymCfg/sPowerSystem/CT_P/Set1" -> CT1.value = value
            "System/SymCfg/sPowerSystem/CT_N/Set1" -> NCT1.value = value
            "System/SymCfg/sPowerSystem/CT_N/Set2" -> NCT2.value = value

            //Addition Factulty
            "System/SymCfg/sPowerSystem/DmdSetTms/Set1" -> DMtime.value = value

        }
    }

    //집에 가고 싶다
    //일하기 싫다
    //아무것도 하기 싫다
    //배고프다

    fun messageArrived(topic: String, value: UInt) {
        when(topic) {
            "System/SymStu/CBStatus1" -> cb1.value = value
            "System/SymStu/CBStatus2" -> cb2.value = value
            "System/SymStu/DIStatus1/all" -> diStatus1.value = value
            "System/SymStu/DIStatus2/all" -> diStatus2.value = value
            "System/SymStu/DIStatus3/all" -> diStatus3.value = value
            "System/SymStu/DIStatus4/all" -> diStatus4.value = value
            "System/SymStu/DIStatus5/all" -> diStatus5.value = value
            "System/SymStu/DIStatus6/all" -> diStatus6.value = value
            "System/SymStu/DOStatus1/all" -> doStatus1.value = value
            "System/SymStu/DOStatus2/all" -> doStatus2.value = value
            "System/SymStu/DOStatus3/all" -> doStatus3.value = value
            "System/SymStu/DOStatus4/all" -> doStatus4.value = value
            "System/SymStu/Op_Stored/all/bit1" -> opStored1.value = value
            "System/SymStu/Op_Stored/all/bit2" -> opStored2.value = value
            "System/SymStu/Op_Stored/all/bit3" -> opStored3.value = value
            "System/SymStu/Op_Stored/all/bit4" -> opStored4.value = value
            "System/SymStu/Op_Stored/all/bit5" -> opStored5.value = value
            "System/SymStu/str/all/bit1" -> str1.value = value
            "System/SymStu/str/all/bit2" -> str2.value = value
            "System/SymStu/str/all/bit3" -> str3.value = value
            "System/SymStu/str/all/bit4" -> str4.value = value
            "System/SymStu/str/all/bit5" -> str5.value = value
            "SG/RySet/TOCRy/PTOCP1/Mod/ctlVal" -> relayMod0.value = relayMod0.value.setBit(0, value)
            "SG/RySet/TOCRy/PTOCP2/Mod/ctlVal" -> relayMod0.value = relayMod0.value.setBit(1, value)
            "SG/RySet/IOCRy/PIOCP1/Mod/ctlVal" -> relayMod0.value = relayMod0.value.setBit(2, value)
            "SG/RySet/IOCRy/PIOCP2/Mod/ctlVal" -> relayMod0.value = relayMod0.value.setBit(3, value)
            "SG/RySet/TOCRy/PTOCN1/Mod/ctlVal" -> relayMod0.value = relayMod0.value.setBit(4, value)
            "SG/RySet/TOCRy/PTOCN2/Mod/ctlVal" -> relayMod0.value = relayMod0.value.setBit(5, value)
            "SG/RySet/IOCRy/PIOCN1/Mod/ctlVal" -> relayMod0.value = relayMod0.value.setBit(6, value)
            "SG/RySet/IOCRy/PIOCN2/Mod/ctlVal" -> relayMod0.value = relayMod0.value.setBit(7, value)
            "SG/RySet/TOVRy/PTOVN1/Mod/ctlVal" -> relayMod0.value = relayMod0.value.setBit(8, value)
            "SG/RySet/TOVRy/PTOVN2/Mod/ctlVal" -> relayMod0.value = relayMod0.value.setBit(9, value)
            "SG/RySet/SDERy/PSDE/Mod/ctlVal"   -> relayMod0.value = relayMod0.value.setBit(10, value)
            "SG/RySet/TDOCRy/PTOCN/Mod/ctlVal" -> relayMod0.value = relayMod0.value.setBit(11, value)
            "SG/RySet/IDOCRy/PTOCN/Mod/ctlVal" -> relayMod0.value = relayMod0.value.setBit(12, value)
            "SG/RySet/TOVRy/PTOVP1/Mod/ctlVal" -> relayMod0.value = relayMod0.value.setBit(13, value)
            "SG/RySet/TOVRy/PTOVP2/Mod/ctlVal" -> relayMod0.value = relayMod0.value.setBit(14, value)
            "SG/RySet/TOVRy/PTOVP3/Mod/ctlVal" -> relayMod1.value = relayMod1.value.setBit(0, value)
            "SG/RySet/TUVRy/PTUVP1/Mod/ctlVal" -> relayMod1.value = relayMod1.value.setBit(1, value)
            "SG/RySet/TUVRy/PTUVP2/Mod/ctlVal" -> relayMod1.value = relayMod1.value.setBit(2, value)
            "SG/RySet/TUVRy/PTUVP3/Mod/ctlVal" -> relayMod1.value = relayMod1.value.setBit(3, value)
            "SG/RySet/TPORy/PTOV1/Mod/ctlVal"  -> relayMod1.value = relayMod1.value.setBit(4, value)
            "SG/RySet/TNSRy/PTOV/Mod/ctlVal"   -> relayMod1.value = relayMod1.value.setBit(5, value)
            "SG/RySet/TDOCRy/PTOCP/Mod/ctlVal" -> relayMod1.value = relayMod1.value.setBit(6, value)
            "SG/RySet/IDOCRy/PTOCP/Mod/ctlVal" -> relayMod1.value = relayMod1.value.setBit(7, value)
            "SG/RySet/RECRy/RSYN/Mod/ctlVal"   -> relayMod1.value = relayMod1.value.setBit(8, value)
            "SG/RySet/TNSRy/PTOC/Mod/ctlVal"   -> relayMod1.value = relayMod1.value.setBit(9, value)
            "SG/RySet/HARRy/PHAR1/Mod/ctlVal"  -> relayMod1.value = relayMod1.value.setBit(10, value)
            "SG/RySet/HARRy/PHAR2/Mod/ctlVal"  -> relayMod1.value = relayMod1.value.setBit(11, value)
            "SG/RySet/TUFRy/PTUF1/Mod/ctlVal"  -> relayMod1.value = relayMod1.value.setBit(12, value)
            "SG/RySet/TUFRy/PTUF2/Mod/ctlVal"  -> relayMod1.value = relayMod1.value.setBit(13, value)
            "SG/RySet/TUFRy/PTUF3/Mod/ctlVal"  -> relayMod1.value = relayMod1.value.setBit(14, value)
            "SG/RySet/TUFRy/PTUF4/Mod/ctlVal"  -> relayMod1.value = relayMod1.value.setBit(15, value)
            "SG/RySet/TOFRy/PTOF1/Mod/ctlVal"  -> relayMod2.value = relayMod2.value.setBit(0, value)
            "SG/RySet/TOFRy/PTOF2/Mod/ctlVal"  -> relayMod2.value = relayMod2.value.setBit(1, value)
            "SG/RySet/TOFRy/PTOF3/Mod/ctlVal"  -> relayMod2.value = relayMod2.value.setBit(2, value)
            "SG/RySet/TOFRy/PTOF4/Mod/ctlVal"  -> relayMod2.value = relayMod2.value.setBit(3, value)
            "SG/RySet/TUCRy/PTUCP1/Mod/ctlVal" -> relayMod2.value = relayMod2.value.setBit(4, value)
            "SG/RySet/MSURy/PTTR/Mod/ctlVal"   -> relayMod2.value = relayMod2.value.setBit(5, value)
            "SG/RySet/MSURy/PMSS/Mod/ctlVal"   -> relayMod2.value = relayMod2.value.setBit(6, value)
            "SG/RySet/MSURy/PMRI/Mod/ctlVal"   -> relayMod2.value = relayMod2.value.setBit(7, value)
            "SG/RySet/TOCRy/PSEF1/Mod/ctlVal"  -> relayMod2.value = relayMod2.value.setBit(8, value)
            "SG/RySet/TOCRy/PSEF2/Mod/ctlVal"  -> relayMod2.value = relayMod2.value.setBit(9, value)
            "System/SymIn/CB1ON_Interlock/Value" -> interlock.value = interlock.value.setBit(0, value)
            "System/SymIn/CB1OFF_Interlock/Value" -> interlock.value = interlock.value.setBit(1, value)
            "System/SymIn/CB2ON_Interlock/Value" -> interlock.value = interlock.value.setBit(2, value)
            "System/SymIn/CB2OFF_Interlock/Value" -> interlock.value = interlock.value.setBit(3, value)
            "System/SymIn/DS1ON_Interlock/Value" -> interlock.value = interlock.value.setBit(4, value)
            "System/SymIn/DS1OFF_Interlock/Value" -> interlock.value = interlock.value.setBit(5, value)
            "System/SymIn/DS2ON_Interlock/Value" -> interlock.value = interlock.value.setBit(6, value)
            "System/SymIn/DS2OFF_Interlock/Value" -> interlock.value = interlock.value.setBit(7, value)
            "System/SymIn/ESON_Interlock/Value" -> interlock.value = interlock.value.setBit(8, value)
            "System/SymIn/ESOFF_Interlock/Value" -> interlock.value = interlock.value.setBit(9, value)
            "System/SymIn/ES2ON_Interlock/Value" -> interlock.value = interlock.value.setBit(10, value)
            "System/SymIn/ES2OFF_Interlock/Value" -> interlock.value = interlock.value.setBit(11, value)
        }
    }

    fun messageArrived(topic: String, value: Float) {
        when(topic) {
            "MI/MMXU/TotW/mag" -> totW.value = value
            "MI/MMXU/TotVAr/mag" -> totVAR.value = value
            "MI/MMXU/TotVA/mag" -> totVA.value = value
            "MI/MMXU/TotPF/mag" -> totPF.value = value
            "MI/MMXU/Hz/mag" -> hz.value = value
            "MI/MMXU/PPV/phsAB/val/mag" -> vABMag.value = value
            "MI/MMXU/PPV/phsAB/val/ang" -> vABAng.value = value
            "MI/MMXU/PPV/phsBC/val/mag" -> vBCMag.value = value
            "MI/MMXU/PPV/phsBC/val/ang" -> vBCAng.value = value
            "MI/MMXU/PPV/phsCA/val/mag" -> vCAMag.value = value
            "MI/MMXU/PPV/phsCA/val/ang" -> vCAAng.value = value
            "MI/MMXU/PhV/phsA/val/mag" -> vAMag.value = value
            "MI/MMXU/PhV/phsA/val/ang" -> vAAng.value = value
            "MI/MMXU/PhV/phsB/val/mag" -> vBMag.value = value
            "MI/MMXU/PhV/phsB/val/ang" -> vBAng.value = value
            "MI/MMXU/PhV/phsC/val/mag" -> vCMag.value = value
            "MI/MMXU/PhV/phsC/val/ang" -> vCAng.value = value
            "MI/MMXU/PhV/neut/val/mag" -> vNMag.value = value
            "MI/MMXU/PhV/neut/val/ang" -> vNAng.value = value
            "MI/MMXU/PhV/res/val/mag" -> vRMag.value = value
            "MI/MMXU/PhV/res/val/ang" -> vRAng.value = value
            "MI/MMXU/A/phsA/val/mag" -> iAMag.value = value
            "MI/MMXU/A/phsA/val/ang" -> iAAng.value = value
            "MI/MMXU/A/phsB/val/mag" -> iBMag.value = value
            "MI/MMXU/A/phsB/val/ang" -> iBAng.value = value
            "MI/MMXU/A/phsC/val/mag" -> iCMag.value = value
            "MI/MMXU/A/phsC/val/ang" -> iCAng.value = value
            "MI/MMXU/A/neut/val/mag" -> iNMag.value = value
            "MI/MMXU/A/neut/val/ang" -> iNAng.value = value
            "MI/MMXU/A/net/val/mag" -> iEMag.value = value
            "MI/MMXU/A/net/val/ang" -> iEAng.value = value
            "MI/MMXU/A/res/val/mag" -> iRMag.value = value
            "MI/MMXU/A/res/val/ang" -> iRAng.value = value
            "MI/MMXU/W/phsA/val/mag" -> wAMag.value = value
            "MI/MMXU/W/phsB/val/mag" -> wBMag.value = value
            "MI/MMXU/W/phsC/val/mag" -> wCMag.value = value
            "MI/MMXU/VAr/phsA/val/mag" -> varAMag.value = value
            "MI/MMXU/VAr/phsB/val/mag" -> varBMag.value = value
            "MI/MMXU/VAr/phsC/val/mag" -> varCMag.value = value
            "MI/MMXU/VA/phsA/val/mag" -> vaAMag.value = value
            "MI/MMXU/VA/phsB/val/mag" -> vaBMag.value = value
            "MI/MMXU/VA/phsC/val/mag" -> vaCMag.value = value
            "MI/MSQI/SeqV/c1/mag" -> seqV1.value = value
            "MI/MSQI/SeqV/c2/mag" -> seqV2.value = value
            "MI/MSQI/SeqV/c3/mag" -> seqV3.value = value
            "MI/MSQI/SeqA/c1/mag" -> seqA1.value = value
            "MI/MSQI/SeqA/c2/mag" -> seqA2.value = value
            "MI/MSQI/SeqA/c3/mag" -> seqA3.value = value
            "MI/MMXUT/PhV/phsA/val/mag" -> rmsVa.value = value
            "MI/MMXUT/PhV/phsB/val/mag" -> rmsVb.value - value
            "MI/MMXUT/PhV/phsC/val/mag" -> rmsVc.value = value
            "MI/MMXUT/PhV/neut/val/mag" -> rmsVn.value = value
            "MI/MMXUT/A/phsA/val/mag" -> rmsIa.value = value
            "MI/MMXUT/A/phsB/val/mag" -> rmsIb.value = value
            "MI/MMXUT/A/phsC/val/mag" -> rmsIc.value = value
            "MI/MMXUT/A/neut/val/mag" -> rmsIn.value = value
            "MI/MMXUT/PhV/res/val/mag" -> rms.value = value

            "MI/MSQI/ImbV/phsA/val/mag" -> lmbVa.value = value
            "MI/MSQI/ImbV/phsB/val/mag" -> lmbVb.value = value
            "MI/MSQI/ImbV/phsC/val/mag" -> lmbVc.value = value
            "MI/MSQI/ImbPPV/phsAB/val/mag" -> lmbVab.value = value
            "MI/MSQI/ImbPPV/phsBC/val/mag" -> lmbVbc.value = value
            "MI/MSQI/ImbPPV/phsCA/val/mag" -> lmbVca.value = value
            "MI/MSQI/ImbNgV/mag" -> lmbNgv.value = value
            "MI/MSQI/ImbZroV/mag" -> lmbZroV.value = value
            "MI/MSQI/ImbA/phsA/val/mag" -> lmbla.value = value
            "MI/MSQI/ImbA/phsB/val/mag" -> lmblb.value = value
            "MI/MSQI/ImbA/phsC/val/mag" -> lmblc.value = value
            "MI/MSQI/ImbNgA/mag" -> lmbNgA.value = value
            "MI/MSQI/ImbZroA/mag" -> lmbZroA.value = value

            //열상태
            "MI/MMXU/Thermal/mag" -> lev.value = value
            //부하율 전류 A상
            "MI/MMXU/LoadRate/phsA/val/mag" -> ia.value = value
            //부하율 전류 B상
            "MI/MMXU/LoadRate/phsB/val/mag" -> ib.value = value
            //부하율 전류 C상
            "MI/MMXU/LoadRate/phsC/val/mag" -> ic.value = value

            "MI/MMXU/AIch1_deg/mag" -> ma1.value = value
            "MI/MMXU/AIch2_deg/mag" -> ma2.value = value
            "MI/MMXU/AIch3_deg/mag" -> ma3.value = value
            "MI/MMXU/AIch4_deg/mag" -> ma4.value = value

            "MI/MMTR/Wh/phsA/actVal/High" -> { whAH = value; whA.value = convertEnergyValue(whAH, whAL, whAG) }
            "MI/MMTR/Wh/phsA/actVal/Low" -> { whAL = value; whA.value = convertEnergyValue(whAH, whAL, whAG) }
            "MI/MMTR/Wh/phsA/actVal/Giga" -> { whAG = value; whA.value = convertEnergyValue(whAH, whAL, whAG) }
            "MI/MMTR/Wh/phsB/actVal/High" -> { whBH = value; whB.value = convertEnergyValue(whBH, whBL, whBG) }
            "MI/MMTR/Wh/phsB/actVal/Low" -> { whBL = value; whB.value = convertEnergyValue(whBH, whBL, whBG) }
            "MI/MMTR/Wh/phsB/actVal/Giga" -> { whBG = value; whB.value = convertEnergyValue(whBH, whBL, whBG) }
            "MI/MMTR/Wh/phsC/actVal/High" -> { whCH = value; whC.value = convertEnergyValue(whCH, whCL, whCG) }
            "MI/MMTR/Wh/phsC/actVal/Low" -> { whCL = value; whC.value = convertEnergyValue(whCH, whCL, whCG) }
            "MI/MMTR/Wh/phsC/actVal/Giga" -> { whCG = value; whC.value = convertEnergyValue(whCH, whCL, whCG) }
            "MI/MMTR/TotWh/actVal/High" -> { whH = value; wh.value = convertEnergyValue(whH, whL, whG) }
            "MI/MMTR/TotWh/actVal/Low" -> { whL = value; wh.value = convertEnergyValue(whH, whL, whG) }
            "MI/MMTR/TotWh/actVal/Giga" -> { whG = value; wh.value = convertEnergyValue(whH, whL, whG) }
            "MI/MMTR/VArh/phsA/actVal/High" -> { varhAH = value; varhA.value = convertEnergyValue(varhAH, varhAL, varhAG) }
            "MI/MMTR/VArh/phsA/actVal/Low" -> { varhAL = value; varhA.value = convertEnergyValue(varhAH, varhAL, varhAG) }
            "MI/MMTR/VArh/phsA/actVal/Giga" -> { varhAG = value; varhA.value = convertEnergyValue(varhAH, varhAL, varhAG) }
            "MI/MMTR/VArh/phsB/actVal/High" -> { varhBH = value; varhB.value = convertEnergyValue(varhBH, varhBL, varhBG) }
            "MI/MMTR/VArh/phsB/actVal/Low" -> { varhBL = value; varhB.value = convertEnergyValue(varhBH, varhBL, varhBG) }
            "MI/MMTR/VArh/phsB/actVal/Giga" -> { varhBG = value; varhB.value = convertEnergyValue(varhBH, varhBL, varhBG) }
            "MI/MMTR/VArh/phsC/actVal/High" -> { varhCH = value; varhC.value = convertEnergyValue(varhCH, varhCL, varhCG) }
            "MI/MMTR/VArh/phsC/actVal/Low" -> { varhCL = value; varhC.value = convertEnergyValue(varhCH, varhCL, varhCG) }
            "MI/MMTR/VArh/phsC/actVal/Giga" -> { varhCG = value; varhC.value = convertEnergyValue(varhCH, varhCL, varhCG) }
            "MI/MMTR/TotVArh/actVal/High" -> { varhH = value; varh.value = convertEnergyValue(varhH, varhL, varhG) }
            "MI/MMTR/TotVArh/actVal/Low" -> { varhL = value; varh.value = convertEnergyValue(varhH, varhL, varhG) }
            "MI/MMTR/TotVArh/actVal/Giga" -> { varhG = value; varh.value = convertEnergyValue(varhH, varhL, varhG) }
            "MI/MMTR/LgVArh/phsA/actVal/High" -> { lgVarhAH = value; lgVarhA.value = convertEnergyValue(lgVarhAH, lgVarhAL, lgVarhAG) }
            "MI/MMTR/LgVArh/phsA/actVal/Low" -> { lgVarhAL = value; lgVarhA.value = convertEnergyValue(lgVarhAH, lgVarhAL, lgVarhAG) }
            "MI/MMTR/LgVArh/phsA/actVal/Giga" -> { lgVarhAG = value; lgVarhA.value = convertEnergyValue(lgVarhAH, lgVarhAL, lgVarhAG) }
            "MI/MMTR/LgVArh/phsB/actVal/High" -> { lgVarhBH = value; lgVarhB.value = convertEnergyValue(lgVarhBH, lgVarhBL, lgVarhBG) }
            "MI/MMTR/LgVArh/phsB/actVal/Low" -> { lgVarhBL = value; lgVarhB.value = convertEnergyValue(lgVarhBH, lgVarhBL, lgVarhBG) }
            "MI/MMTR/LgVArh/phsB/actVal/Giga" -> { lgVarhBG = value; lgVarhB.value = convertEnergyValue(lgVarhBH, lgVarhBL, lgVarhBG) }
            "MI/MMTR/LgVArh/phsC/actVal/High" -> { lgVarhCH = value; lgVarhC.value = convertEnergyValue(lgVarhCH, lgVarhCL, lgVarhCG) }
            "MI/MMTR/LgVArh/phsC/actVal/Low" -> { lgVarhCL = value; lgVarhC.value = convertEnergyValue(lgVarhCH, lgVarhCL, lgVarhCG) }
            "MI/MMTR/LgVArh/phsC/actVal/Giga" -> { lgVarhCG = value; lgVarhC.value = convertEnergyValue(lgVarhCH, lgVarhCL, lgVarhCG) }
            "MI/MMTR/LgTotVArh/actVal/High" -> { lgVarhH = value; lgVarh.value = convertEnergyValue(lgVarhH, lgVarhL, lgVarhG) }
            "MI/MMTR/LgTotVArh/actVal/Low" -> { lgVarhL = value; lgVarh.value = convertEnergyValue(lgVarhH, lgVarhL, lgVarhG) }
            "MI/MMTR/LgTotVArh/actVal/Giga" -> { lgVarhG = value; lgVarh.value = convertEnergyValue(lgVarhH, lgVarhL, lgVarhG) }
            "MI/MMTR/VAh/phsA/actVal/High" -> { vahAH = value; vahA.value = convertEnergyValue(vahAH, vahAL, vahAG) }
            "MI/MMTR/VAh/phsA/actVal/Low" -> { vahAL = value; vahA.value = convertEnergyValue(vahAH, vahAL, vahAG) }
            "MI/MMTR/VAh/phsA/actVal/Giga" -> { vahAG = value; vahA.value = convertEnergyValue(vahAH, vahAL, vahAG) }
            "MI/MMTR/VAh/phsB/actVal/High" -> { vahBH = value; vahB.value = convertEnergyValue(vahBH, vahBL, vahBG) }
            "MI/MMTR/VAh/phsB/actVal/Low" -> { vahBL = value; vahB.value = convertEnergyValue(vahBH, vahBL, vahBG) }
            "MI/MMTR/VAh/phsB/actVal/Giga" -> { vahBG = value; vahB.value = convertEnergyValue(vahBH, vahBL, vahBG) }
            "MI/MMTR/VAh/phsC/actVal/High" -> { vahCH = value; vahC.value = convertEnergyValue(vahCH, vahCL, vahCG) }
            "MI/MMTR/VAh/phsC/actVal/Low" -> { vahCL = value; vahC.value = convertEnergyValue(vahCH, vahCL, vahCG) }
            "MI/MMTR/VAh/phsC/actVal/Giga" -> { vahCG = value; vahC.value = convertEnergyValue(vahCH, vahCL, vahCG) }
            "MI/MMTR/TotVAh/actVal/High" -> { vahH = value; vah.value = convertEnergyValue(vahH, vahL, vahG) }
            "MI/MMTR/TotVAh/actVal/Low" -> { vahL = value; vah.value = convertEnergyValue(vahH, vahL, vahG) }
            "MI/MMTR/TotVAh/actVal/Giga" -> { vahG = value; vah.value = convertEnergyValue(vahH, vahL, vahG) }
            "MI/MMTR_Reverse/Wh/phsA/actVal/High" -> { rWhAH = value; rWhA.value = convertEnergyValue(rWhAH, rWhAL, rWhAG) }
            "MI/MMTR_Reverse/Wh/phsA/actVal/Low" -> { rWhAL = value; rWhA.value = convertEnergyValue(rWhAH, rWhAL, rWhAG) }
            "MI/MMTR_Reverse/Wh/phsA/actVal/Giga" -> { rWhAG = value; rWhA.value = convertEnergyValue(rWhAH, rWhAL, rWhAG) }
            "MI/MMTR_Reverse/Wh/phsB/actVal/High" -> { rWhBH = value; rWhB.value = convertEnergyValue(rWhBH, rWhBL, rWhBG) }
            "MI/MMTR_Reverse/Wh/phsB/actVal/Low" -> { rWhBL = value; rWhB.value = convertEnergyValue(rWhBH, rWhBL, rWhBG) }
            "MI/MMTR_Reverse/Wh/phsB/actVal/Giga" -> { rWhBG = value; rWhB.value = convertEnergyValue(rWhBH, rWhBL, rWhBG) }
            "MI/MMTR_Reverse/Wh/phsC/actVal/High" -> { rWhCH = value; rWhC.value = convertEnergyValue(rWhCH, rWhCL, rWhCG) }
            "MI/MMTR_Reverse/Wh/phsC/actVal/Low" -> { rWhCL = value; rWhC.value = convertEnergyValue(rWhCH, rWhCL, rWhCG) }
            "MI/MMTR_Reverse/Wh/phsC/actVal/Giga" -> { rWhCG = value; rWhC.value = convertEnergyValue(rWhCH, rWhCL, rWhCG) }
            "MI/MMTR_Reverse/TotWh/actVal/High" -> { rWhH = value; rWh.value = convertEnergyValue(rWhH, rWhL, rWhG) }
            "MI/MMTR_Reverse/TotWh/actVal/Low" -> { rWhL = value; rWh.value = convertEnergyValue(rWhH, rWhL, rWhG) }
            "MI/MMTR_Reverse/TotWh/actVal/Giga" -> { rWhG = value; rWh.value = convertEnergyValue(rWhH, rWhL, rWhG) }
            "MI/MMTR_Reverse/VArh/phsA/actVal/High" -> { rVarhAH = value; rVarhA.value = convertEnergyValue(rVarhAH, rVarhAL, rVarhAG) }
            "MI/MMTR_Reverse/VArh/phsA/actVal/Low" -> { rVarhAL = value; rVarhA.value = convertEnergyValue(rVarhAH, rVarhAL, rVarhAG) }
            "MI/MMTR_Reverse/VArh/phsA/actVal/Giga" -> { rVarhAG = value; rVarhA.value = convertEnergyValue(rVarhAH, rVarhAL, rVarhAG) }
            "MI/MMTR_Reverse/VArh/phsB/actVal/High" -> { rVarhBH = value; rVarhB.value = convertEnergyValue(rVarhBH, rVarhBL, rVarhBG) }
            "MI/MMTR_Reverse/VArh/phsB/actVal/Low" -> { rVarhBL = value; rVarhB.value = convertEnergyValue(rVarhBH, rVarhBL, rVarhBG) }
            "MI/MMTR_Reverse/VArh/phsB/actVal/Giga" -> { rVarhBG = value; rVarhB.value = convertEnergyValue(rVarhBH, rVarhBL, rVarhBG) }
            "MI/MMTR_Reverse/VArh/phsC/actVal/High" -> { rVarhCH = value; rVarhC.value = convertEnergyValue(rVarhCH, rVarhCL, rVarhCG) }
            "MI/MMTR_Reverse/VArh/phsC/actVal/Low" -> { rVarhCL = value; rVarhC.value = convertEnergyValue(rVarhCH, rVarhCL, rVarhCG) }
            "MI/MMTR_Reverse/VArh/phsC/actVal/Giga" -> { rVarhCG = value; rVarhC.value = convertEnergyValue(rVarhCH, rVarhCL, rVarhCG) }
            "MI/MMTR_Reverse/TotVArh/actVal/High" -> { rVarhH = value; rVarh.value = convertEnergyValue(rVarhH, rVarhL, rVarhG) }
            "MI/MMTR_Reverse/TotVArh/actVal/Low" -> { rVarhL = value; rVarh.value = convertEnergyValue(rVarhH, rVarhL, rVarhG) }
            "MI/MMTR_Reverse/TotVArh/actVal/Giga" -> { rVarhG = value; rVarh.value = convertEnergyValue(rVarhH, rVarhL, rVarhG) }
            "MI/MMTR_Reverse/LgVArh/phsA/actVal/High" -> { rLgVarhAH = value; rLgVarhA.value = convertEnergyValue(rLgVarhAH, rLgVarhAL, rLgVarhAG) }
            "MI/MMTR_Reverse/LgVArh/phsA/actVal/Low" -> { rLgVarhAL = value; rLgVarhA.value = convertEnergyValue(rLgVarhAH, rLgVarhAL, rLgVarhAG) }
            "MI/MMTR_Reverse/LgVArh/phsA/actVal/Giga" -> { rLgVarhAG = value; rLgVarhA.value = convertEnergyValue(rLgVarhAH, rLgVarhAL, rLgVarhAG) }
            "MI/MMTR_Reverse/LgVArh/phsB/actVal/High" -> { rLgVarhBH = value; rLgVarhB.value = convertEnergyValue(rLgVarhBH, rLgVarhBL, rLgVarhBG) }
            "MI/MMTR_Reverse/LgVArh/phsB/actVal/Low" -> { rLgVarhBL = value; rLgVarhB.value = convertEnergyValue(rLgVarhBH, rLgVarhBL, rLgVarhBG) }
            "MI/MMTR_Reverse/LgVArh/phsB/actVal/Giga" -> { rLgVarhBG = value; rLgVarhB.value = convertEnergyValue(rLgVarhBH, rLgVarhBL, rLgVarhBG) }
            "MI/MMTR_Reverse/LgVArh/phsC/actVal/High" -> { rLgVarhCH = value; rLgVarhC.value = convertEnergyValue(rLgVarhCH, rLgVarhCL, rLgVarhCG) }
            "MI/MMTR_Reverse/LgVArh/phsC/actVal/Low" -> { rLgVarhCL = value; rLgVarhC.value = convertEnergyValue(rLgVarhCH, rLgVarhCL, rLgVarhCG) }
            "MI/MMTR_Reverse/LgVArh/phsC/actVal/Giga" -> { rLgVarhCG = value; rLgVarhC.value = convertEnergyValue(rLgVarhCH, rLgVarhCL, rLgVarhCG) }
            "MI/MMTR_Reverse/LgTotVArh/actVal/High" -> { rLgVarhH = value; rLgVarh.value = convertEnergyValue(rLgVarhH, rLgVarhL, rLgVarhG) }
            "MI/MMTR_Reverse/LgTotVArh/actVal/Low" -> { rLgVarhL = value; rLgVarh.value = convertEnergyValue(rLgVarhH, rLgVarhL, rLgVarhG) }
            "MI/MMTR_Reverse/LgTotVArh/actVal/Giga" -> { rLgVarhG = value; rLgVarh.value = convertEnergyValue(rLgVarhH, rLgVarhL, rLgVarhG) }
            "MI/MMTR_Reverse/VAh/phsA/actVal/High" -> { rVahAH = value; rVahA.value = convertEnergyValue(rVahAH, rVahAL, rVahAG) }
            "MI/MMTR_Reverse/VAh/phsA/actVal/Low" -> { rVahAL = value; rVahA.value = convertEnergyValue(rVahAH, rVahAL, rVahAG) }
            "MI/MMTR_Reverse/VAh/phsA/actVal/Giga" -> { rVahAG = value; rVahA.value = convertEnergyValue(rVahAH, rVahAL, rVahAG) }
            "MI/MMTR_Reverse/VAh/phsB/actVal/High" -> { rVahBH = value; rVahB.value = convertEnergyValue(rVahBH, rVahBL, rVahBG) }
            "MI/MMTR_Reverse/VAh/phsB/actVal/Low" -> { rVahBL = value; rVahB.value = convertEnergyValue(rVahBH, rVahBL, rVahBG) }
            "MI/MMTR_Reverse/VAh/phsB/actVal/Giga" -> { rVahBG = value; rVahB.value = convertEnergyValue(rVahBH, rVahBL, rVahBG) }
            "MI/MMTR_Reverse/VAh/phsC/actVal/High" -> { rVahCH = value; rVahC.value = convertEnergyValue(rVahCH, rVahCL, rVahCG) }
            "MI/MMTR_Reverse/VAh/phsC/actVal/Low" -> { rVahCL = value; rVahC.value = convertEnergyValue(rVahCH, rVahCL, rVahCG) }
            "MI/MMTR_Reverse/VAh/phsC/actVal/Giga" -> { rVahCG = value; rVahC.value = convertEnergyValue(rVahCH, rVahCL, rVahCG) }
            "MI/MMTR_Reverse/TotVAh/actVal/High" -> { rVahH = value; rVah.value = convertEnergyValue(rVahH, rVahL, rVahG) }
            "MI/MMTR_Reverse/TotVAh/actVal/Low" -> { rVahL = value; rVah.value = convertEnergyValue(rVahH, rVahL, rVahG) }
            "MI/MMTR_Reverse/TotVAh/actVal/Giga" -> { rVahG = value; rVah.value = convertEnergyValue(rVahH, rVahL, rVahG) }
            "MI/MMXU/AuxHz/mag" -> auxHz.value = value
            "MI/MMXU/Hz2/mag" -> hz2.value = value
            "MI/MMXU/PhV2/phsA/val/mag" -> v2AMag.value = value
            "MI/MMXU/PhV2/phsA/val/ang" -> v2AAng.value = value
            "MI/MMXU/PhV2/phsB/val/mag" -> v2BMag.value = value
            "MI/MMXU/PhV2/phsB/val/ang" -> v2BAng.value = value
            "MI/MMXU/PhV2/phsC/val/mag" -> v2CMag.value = value
            "MI/MMXU/PhV2/phsC/val/ang" -> v2CAng.value = value
            "MI/MMXU/PhV2/neut/val/mag" -> v2NMag.value = value
            "MI/MMXU/PhV2/neut/val/ang" -> v2NAng.value = value
            "MI/MMXU/PPV2/phsAB/val/mag" -> v2ABMag.value = value
            "MI/MMXU/PPV2/phsAB/val/ang" -> v2ABAng.value = value
            "MI/MMXU/PPV2/phsBC/val/mag" -> v2BCMag.value = value
            "MI/MMXU/PPV2/phsBC/val/ang" -> v2BCAng.value = value
            "MI/MMXU/PPV2/phsCA/val/mag" -> v2CAMag.value = value
            "MI/MMXU/PPV2/phsCA/val/ang" -> v2CAAng.value = value
            "MI/MHAI/ThdPhV/phsA/val/mag" -> thdVA.value = value
            "MI/MHAI/ThdPhV/phsB/val/mag" -> thdVB.value = value
            "MI/MHAI/ThdPhV/phsC/val/mag" -> thdVC.value = value
            "MI/MHAI/ThdA/phsA/val/mag" -> thdIA.value = value
            "MI/MHAI/ThdA/phsB/val/mag" -> thdIB.value = value
            "MI/MHAI/ThdA/phsC/val/mag" -> thdIC.value = value
            "MI/MHAI/TddA/phsA/val/mag" -> tddIA.value = value
            "MI/MHAI/TddA/phsB/val/mag" -> tddIB.value = value
            "MI/MHAI/TddA/phsC/val/mag" -> tddIC.value = value
            "MI/MHAI/ThdPhV2/phsA/val/mag" -> thdV2A.value = value
            "MI/MHAI/ThdPhV2/phsB/val/mag" -> thdV2B.value = value
            "MI/MHAI/ThdPhV2/phsC/val/mag" -> thdV2C.value = value
            "MI/MHAI/HKf/phsA/val/mag" -> hkfA.value = value
            "MI/MHAI/HKf/phsB/val/mag" -> hkfB.value = value
            "MI/MHAI/HKf/phsC/val/mag" -> hkfC.value = value
            "MI/MHAI/HCfPhV/phsA/val/mag" -> hcfVA.value = value
            "MI/MHAI/HCfPhV/phsB/val/mag" -> hcfVB.value = value
            "MI/MHAI/HCfPhV/phsC/val/mag" -> hcfVC.value = value
            "MI/MHAI/HCfA/phsA/val/mag" -> hcfIA.value = value
            "MI/MHAI/HCfA/phsB/val/mag" -> hcfIB.value = value
            "MI/MHAI/HCfA/phsC/val/mag" -> hcfIC.value = value

            //최대전류
            "MI/MSTA/MaxAmps/mag" -> maxCur.value = value
            "MI/MSTA/MaxAmps/phase" -> maxCurPh.value = value

            //최소전류
            "MI/MSTA/MinAmps/mag" -> minCur.value = value
            "MI/MSTA/MinAmps/phase" -> minCurPh.value = value

            //최대 전압
            "MI/MSTA/MaxVolts/mag" -> maxVol.value = value
            "MI/MSTA/MaxVolts/phase" -> maxVolPh.value = value

            //최소 전압
            "MI/MSTA/MinVolts/mag" -> minVol.value = value
            "MI/MSTA/MinVolts/phase" -> minVolPh.value = value

            //최대 주파수
            "MI/MSTA/MaxHz/mag" -> maxFreq.value = value
            "MI/MSTA/MaxHz/phase" -> maxFreqPh.value = value

            //최소 주파수
            "MI/MSTA/MinHz/mag" -> minFreq.value = value
            "MI/MSTA/MinHz/phase" -> minFreq.value = value

            //최대 유효전력
            "MI/MSTA/MaxTotW/mag" -> maxWatt.value = value
            "MI/MSTA/MaxTotW/phase" -> maxWattPh.value = value

            //최소 유효전력
            "MI/MSTA/MinTotW/mag" -> minWatt.value = value
            "MI/MSTA/MinTotW/phase" -> minWattPh.value = value

            //최대 무효전력
            "MI/MSTA/MaxTotVAr/mag" -> maxVar.value = value
            "MI/MSTA/MaxTotVAr/phase" -> maxVarPh.value = value

            //최소 무효전력
            "MI/MSTA/MinTotVAr/mag" -> minVar.value = value
            "MI/MSTA/MinTotVAr/phase" -> minVarPh.value = value

            //peak demand
            "MI/MMTR/PKDmdA_phsA/mag" -> pda.value = value
            "MI/MMTR/PKDmdA_phsB/mag" -> pdb.value = value
            "MI/MMTR/PKDmdA_phsC/mag" -> pdc.value = value
            "MI/MMTR/PKDmdW/mag" -> pdAP.value = value
            "MI/MMTR/PKDmdVAr/mag" -> pdRP.value = value

            //over demand
            "MI/MMTR/OVDmdA_phsA/mag" -> oda.value = value
            "MI/MMTR/OVDmdA_phsB/mag" -> odb.value = value
            "MI/MMTR/OVDmdA_phsC/mag" -> odc.value = value
            "MI/MMTR/OVDmdW/mag" -> odAP.value = value
            "MI/MMTR/OVDmdVAr/mag" -> odRP.value = value

            //device info
            "System/SymCfg/DSP/Version" -> DspV.value = value
            "System/SymCfg/MMI/Version" -> MMIV.value = value
            "System/SymCfg/COM/Version" -> ComV.value = value
            "System/SymCfg/PLC/Version" -> PLCV.value = value

            //power system
            "System/SymCfg/sPowerSystem/PT_P/Set2" -> PT2.value = value
            "System/SymCfg/sPowerSystem/PT_R/Set2" -> AuxPT2.value = value
            "System/SymCfg/sPowerSystem/PT_N/Set2" -> GPT2.value = value
            "System/SymCfg/sPowerSystem/CT_R/Set1" -> ZCT1.value = value
            "System/SymCfg/sPowerSystem/CT_R/Set2" -> ZCT2.value = value

            //Addition Factulty
            "System/SymCfg/sPowerSystem/UVRBlkVal" -> UVvol.value = value
            "System/SymCfg/sPowerSystem/UCRBlkVal" -> UCcur.value = value
            "System/SymCfg/sPowerSystem/NVRBlkVal" -> NVvol.value = value
            "System/SymCfg/sPowerSystem/NCRBlkVal" -> NCcur.value = value
            "System/SymCfg/sPowerSystem/POBlkVal" -> POvol.value = value
            "System/SymCfg/sPowerSystem/TddAmpload" -> TDcur.value = value

            //Motor Status Info
            "SG/RySet/MSURy/RMSI/FuLoA" -> fullCur.value = value
            "SG/RySet/MSURy/RMSI/LocRtA" -> lockCur.value = value
            "SG/RySet/MSURy/RMSI/OvLocTm / 1000" -> lockTime.value = value
            "SG/RySet/MSURy/RMSI/StSatTm / 1000" -> safeTime.value = value

            //Breaker Failure
            "SG/RySet/RPSRy/RBRF/FailTmms / 1000" -> delaySec.value = value
            "SG/RySet/RPSRy/RBRF/DetValA" -> detect.value = value

        }
    }

    fun messageArrived(topic: String, value: IntArray) {
        when (topic) {
            "sampled_value" -> {
                for (i in value.indices step 6)
                    addWaveData(value.copyOfRange(i, i  + 6))
            }
        }
    }

    private val svData = ArrayDeque<Int>()
    private val _oscilloscopeState = MutableStateFlow(OscilloscopeState())
    val oscilloscopeState = _oscilloscopeState.asStateFlow()

    private fun addWaveData(value: IntArray) {
        value.forEach {
            svData.add(it)
        }
        while (svData.size > _oscilloscopeState.value.n * 6)
            svData.removeFirst()
        if (svData.size == _oscilloscopeState.value.n * 6) {
            var pos = _oscilloscopeState.value.n / 2 + _oscilloscopeState.value.p * 36 / 10000
            if (pos < 1) pos = 1
            else if (pos >= _oscilloscopeState.value.n) pos = _oscilloscopeState.value.n - 1
            val level = (_oscilloscopeState.value.level * 100).toInt()
            val edge = _oscilloscopeState.value.edge
            if (((edge == 0 || edge == 1) && svData[pos * 6 - 6] < level && svData[pos * 6] >= level) ||
                ((edge == 0 || edge == 2) && svData[pos * 6 - 6] > level && svData[pos * 6] <= level)
            ) {
                _oscilloscopeState.value = _oscilloscopeState.value.copy(
                    svData = svData.toArray(Array(svData.size) { 0 })
                )
            }
        }
    }

    fun onOscilloscopeEvent(event: OscilloscopeEvent) {
        when(event) {
            is OscilloscopeEvent.Apply -> {
                _oscilloscopeState.value = event.value
            }
            is OscilloscopeEvent.VaEnableChanged -> {
                _oscilloscopeState.value = _oscilloscopeState.value.copy(vaEnable = event.value)
            }
            is OscilloscopeEvent.VbEnableChanged -> {
                _oscilloscopeState.value = _oscilloscopeState.value.copy(vbEnable = event.value)
            }
            is OscilloscopeEvent.VcEnableChanged -> {
                _oscilloscopeState.value = _oscilloscopeState.value.copy(vcEnable = event.value)
            }
            is OscilloscopeEvent.IaEnableChanged -> {
                _oscilloscopeState.value = _oscilloscopeState.value.copy(iaEnable = event.value)
            }
            is OscilloscopeEvent.IbEnableChanged -> {
                _oscilloscopeState.value = _oscilloscopeState.value.copy(ibEnable = event.value)
            }
            is OscilloscopeEvent.IcEnableChanged -> {
                _oscilloscopeState.value = _oscilloscopeState.value.copy(icEnable = event.value)
            }
        }
    }
}

fun UInt.setBit(bit: Int, value: UInt) : UInt {
    return if (value == 0u)
        this.and((1u shl bit).inv())
    else
        this.or(1u shl bit)
}

fun UInt.getBit(bit: Int) : Boolean {
    return this.shr(bit).and(1u) == 1u
}