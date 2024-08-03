package com.jordicuevas.medifinderapp.application

import android.app.Application
import com.jordicuevas.medifinderapp.data.MediFinderRepository
import com.jordicuevas.medifinderapp.data.remote.RetroFitHelper

class MediFinderRFApp: Application() {

    private val retrofit by lazy{
        RetroFitHelper().getRetroFit()
    }

    val repository by lazy{
        MediFinderRepository(retrofit)
    }


}