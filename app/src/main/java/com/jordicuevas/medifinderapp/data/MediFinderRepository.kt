package com.jordicuevas.medifinderapp.data

import com.jordicuevas.medifinderapp.data.remote.MediFinderApi
import com.jordicuevas.medifinderapp.data.remote.model.adverse.AdverseCount
import com.jordicuevas.medifinderapp.data.remote.model.drug.DrugLabel
import retrofit2.Call
import retrofit2.Retrofit

class MediFinderRepository (private val retrofit: Retrofit){

    private val mediFinderApi = retrofit.create(MediFinderApi::class.java)

    fun getDrugNameLabel(nameCriteria: String?, limitConstant: String?):
            Call<DrugLabel> = mediFinderApi.getDrugNameLabel(
                nameCriteria, limitConstant
            )

    fun getReactionCountQuery(countCriteria: String?, limitConstant: String?):
            Call<AdverseCount> = mediFinderApi.getReactionCountQuery(
                countCriteria, limitConstant
            )
}