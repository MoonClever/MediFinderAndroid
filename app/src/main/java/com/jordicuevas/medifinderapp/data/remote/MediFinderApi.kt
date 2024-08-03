package com.jordicuevas.medifinderapp.data.remote

import com.jordicuevas.medifinderapp.data.remote.model.adverse.AdverseCount
import com.jordicuevas.medifinderapp.data.remote.model.drug.DrugLabel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface MediFinderApi {

    @GET("label.json")
    fun getDrugNameLabel(
        @Query("search")  nameCriteria: String?,
        @Query("limit") limitConstant: String?
    ): Call<DrugLabel>


    @GET("event.json?search=patient.drug.medicinalproduct:%22{searchTerm1}%22+AND+" +
            "patient.drug.medicinalproduct:%22{searchTerm2}%22+AND+" +
            "patient.reaction.reactionmeddrapt:%22{reactionSearch}%22&" +
            "count=patient.reaction.reactionmeddrapt.exact&limit=1")
    fun getReactionCountQuery(
        @Query("search")   countCriteria: String?,
        @Query("limit") limitConstant: String?
    ): Call<AdverseCount>

}