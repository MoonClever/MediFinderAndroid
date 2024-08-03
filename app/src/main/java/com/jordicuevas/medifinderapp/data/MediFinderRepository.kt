package com.jordicuevas.medifinderapp.data

import com.jordicuevas.medifinderapp.data.remote.MediFinderApi
import com.jordicuevas.medifinderapp.data.remote.model.adverse.AdverseCount
import com.jordicuevas.medifinderapp.data.remote.model.drug.DrugLabel
import retrofit2.Call
import retrofit2.Retrofit

class MediFinderRepository (private val retrofit: Retrofit){

    private val mediFinderApi = retrofit.create(MediFinderApi::class.java)

    fun getDrugNameLabel(nameCriteria: String?, searchTerm:String?, limitConstant: String?):
            Call<DrugLabel> = mediFinderApi.getDrugNameLabel(
                nameCriteria, searchTerm, limitConstant
            )

    fun getReactionCountQuery(searchTerm1: String?, searchTerm2: String?, reactionSearch: String?):
            Call<AdverseCount> = mediFinderApi.getReactionCountQuery(
                searchTerm1, searchTerm2, reactionSearch
            )

}