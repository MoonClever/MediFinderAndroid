package com.jordicuevas.medifinderapp.data.remote.model

data class MedicineDetail(

    var timePerDose: Int? = 0,

    var quantity: Int? = 0,

    var genName: String? = null,

    var branName: String? = null,

    var route: String? = null,

    var activeIngredient: String? = null,

    var purpose: String? = null,

    var thumbnail: String? = null,

    var indications: String? = null,

    var notUse: String? = null

)
