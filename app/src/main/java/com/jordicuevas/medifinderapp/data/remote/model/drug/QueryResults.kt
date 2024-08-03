package com.jordicuevas.medifinderapp.data.remote.model.drug

import com.google.gson.annotations.SerializedName

data class QueryResults (

    @SerializedName("skip " ) var skip : Int? = null,
    @SerializedName("limit" ) var limit : Int? = null,
    @SerializedName("total" ) var total : Int? = null
)
