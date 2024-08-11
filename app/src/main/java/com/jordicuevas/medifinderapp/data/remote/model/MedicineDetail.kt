package com.jordicuevas.medifinderapp.data.remote.model

import com.jordicuevas.medifinderapp.data.remote.model.drug.Openfda

data class MedicineDetail(

    var timePerDose: Int? = 0,

    var quantity: Int? = 0,

    var medData : Openfda?,

    var thumbnail: String? = null,


)
