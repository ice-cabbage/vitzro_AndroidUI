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
    val iRMag = mutableStateOf(0.0f)
    val iRAng = mutableStateOf(0.0f)
    val wAMag = mutableStateOf(0.0f)
    val wAAng = mutableStateOf(0.0f)
    val wBMag = mutableStateOf(0.0f)
    val wBAng = mutableStateOf(0.0f)
    val wCMag = mutableStateOf(0.0f)
    val wCAng = mutableStateOf(0.0f)
    val wNMag = mutableStateOf(0.0f)
    val wNAng = mutableStateOf(0.0f)
    val varAMag = mutableStateOf(0.0f)
    val varAAng = mutableStateOf(0.0f)
    val varBMag = mutableStateOf(0.0f)
    val varBAng = mutableStateOf(0.0f)
    val varCMag = mutableStateOf(0.0f)
    val varCAng = mutableStateOf(0.0f)
    val varNMag = mutableStateOf(0.0f)
    val varNAng = mutableStateOf(0.0f)
    val vaAMag = mutableStateOf(0.0f)
    val vaAAng = mutableStateOf(0.0f)
    val vaBMag = mutableStateOf(0.0f)
    val vaBAng = mutableStateOf(0.0f)
    val vaCMag = mutableStateOf(0.0f)
    val vaCAng = mutableStateOf(0.0f)
    val vaNMag = mutableStateOf(0.0f)
    val vaNAng = mutableStateOf(0.0f)
    val pfAMag = mutableStateOf(0.0f)
    val pfAAng = mutableStateOf(0.0f)
    val pfBMag = mutableStateOf(0.0f)
    val pfBAng = mutableStateOf(0.0f)
    val pfCMag = mutableStateOf(0.0f)
    val pfCAng = mutableStateOf(0.0f)
    val pfNMag = mutableStateOf(0.0f)
    val pfNAng = mutableStateOf(0.0f)
    val zAMag = mutableStateOf(0.0f)
    val zAAng = mutableStateOf(0.0f)
    val zBMag = mutableStateOf(0.0f)
    val zBAng = mutableStateOf(0.0f)
    val zCMag = mutableStateOf(0.0f)
    val zCAng = mutableStateOf(0.0f)
    val cb1 = mutableStateOf(0x0u)
    val cb2 = mutableStateOf(0x0u)

    fun messageArrived(topic: String, value: Int) {
    }

    fun messageArrived(topic: String, value: UInt) {
        when(topic) {
            "System/SymStu/CBStatus1" -> cb1.value = value
            "System/SymStu/CBStatus2" -> cb2.value = value
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
            "MI/MMXU/A/res/val/mag" -> iRMag.value = value
            "MI/MMXU/A/res/val/ang" -> iRAng.value = value
            "MI/MMXU/W/phsA/val/mag" -> wAMag.value = value
            "MI/MMXU/W/phsA/val/ang" -> wAAng.value = value
            "MI/MMXU/W/phsB/val/mag" -> wBMag.value = value
            "MI/MMXU/W/phsB/val/ang" -> wBAng.value = value
            "MI/MMXU/W/phsC/val/mag" -> wCMag.value = value
            "MI/MMXU/W/phsC/val/ang" -> wCAng.value = value
            "MI/MMXU/W/neut/val/mag" -> wNMag.value = value
            "MI/MMXU/W/neut/val/ang" -> wNAng.value = value
            "MI/MMXU/VAr/phsA/val/mag" -> varAMag.value = value
            "MI/MMXU/VAr/phsA/val/ang" -> varAAng.value = value
            "MI/MMXU/VAr/phsB/val/mag" -> varBMag.value = value
            "MI/MMXU/VAr/phsB/val/ang" -> varBAng.value = value
            "MI/MMXU/VAr/phsC/val/mag" -> varCMag.value = value
            "MI/MMXU/VAr/phsC/val/ang" -> varCAng.value = value
            "MI/MMXU/VAr/neut/val/mag" -> varNMag.value = value
            "MI/MMXU/VAr/neut/val/ang" -> varNAng.value = value
            "MI/MMXU/VA/phsA/val/mag" -> vaAMag.value = value
            "MI/MMXU/VA/phsA/val/ang" -> vaAAng.value = value
            "MI/MMXU/VA/phsB/val/mag" -> vaBMag.value = value
            "MI/MMXU/VA/phsB/val/ang" -> vaBAng.value = value
            "MI/MMXU/VA/phsC/val/mag" -> vaCMag.value = value
            "MI/MMXU/VA/phsC/val/ang" -> vaCAng.value = value
            "MI/MMXU/VA/neut/val/mag" -> vaNMag.value = value
            "MI/MMXU/VA/neut/val/ang" -> vaNAng.value = value
            "MI/MMXU/PF/phsA/val/mag" -> pfAMag.value = value
            "MI/MMXU/PF/phsA/val/ang" -> pfAAng.value = value
            "MI/MMXU/PF/phsB/val/mag" -> pfBMag.value = value
            "MI/MMXU/PF/phsB/val/ang" -> pfBAng.value = value
            "MI/MMXU/PF/phsC/val/mag" -> pfCMag.value = value
            "MI/MMXU/PF/phsC/val/ang" -> pfCAng.value = value
            "MI/MMXU/PF/neut/val/mag" -> pfNMag.value = value
            "MI/MMXU/PF/neut/val/ang" -> pfNAng.value = value
            "MI/MMXU/Z/phsA/val/mag" -> zAMag.value = value
            "MI/MMXU/Z/phsA/val/ang" -> zAAng.value = value
            "MI/MMXU/Z/phsB/val/mag" -> zBMag.value = value
            "MI/MMXU/Z/phsB/val/ang" -> zBAng.value = value
            "MI/MMXU/Z/phsC/val/mag" -> zCMag.value = value
            "MI/MMXU/Z/phsC/val/ang" -> zCAng.value = value
        }
    }

    fun messageArrived(topic: String, value: String) {
    }
}