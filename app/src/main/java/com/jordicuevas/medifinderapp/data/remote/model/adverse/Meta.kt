package com.jordicuevas.medifinderapp.data.remote.model.adverse

import com.google.gson.annotations.SerializedName


data class Meta (

  @SerializedName("disclaimer"   ) var disclaimer  : String? = null,
  @SerializedName("terms"        ) var terms       : String? = null,
  @SerializedName("license"      ) var license     : String? = null,
  @SerializedName("last_updated" ) var lastUpdated : String? = null

)