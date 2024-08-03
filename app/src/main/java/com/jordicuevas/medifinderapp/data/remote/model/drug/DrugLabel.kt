package com.jordicuevas.medifinderapp.data.remote.model.drug

import com.google.gson.annotations.SerializedName


data class DrugLabel (

    @SerializedName("meta"    ) var meta    : Meta?              = Meta(),
    @SerializedName("results" ) var results : ArrayList<Results> = arrayListOf()

)