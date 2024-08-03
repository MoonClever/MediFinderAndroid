package com.jordicuevas.medifinderapp.data.remote.model.adverse

import com.google.gson.annotations.SerializedName


data class Results (

  @SerializedName("term"  ) var term  : String? = null,
  @SerializedName("count" ) var count : Int?    = null

)