package com.jordicuevas.medifinderapp.data.remote.model.adverse

import com.google.gson.annotations.SerializedName


data class AdverseCount (

    @SerializedName("meta"    ) var meta    : Meta?              = Meta(),
    @SerializedName("results" ) var results : ArrayList<Results> = arrayListOf()

)