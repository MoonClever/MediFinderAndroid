package com.jordicuevas.medifinderapp.data.remote.model.drug

import com.google.gson.annotations.SerializedName
import com.jordicuevas.medifinderapp.data.remote.model.drug.Openfda


data class Results (
  @SerializedName("openfda"                               ) var openfda                           : Openfda?          = Openfda()
)