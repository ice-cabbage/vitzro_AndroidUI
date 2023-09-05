package com.vitzrotech.vipam3500

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

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

    fun messageArrived(topic: String, value: Int) {
    }

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
        }
    }

    fun messageArrived(topic: String, value: String) {
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