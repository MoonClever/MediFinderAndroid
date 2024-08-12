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


    @GET("event.json")
    fun getReactionCountQuery(
        @Query("search", encoded = true)   countCriteria: String?,
        @Query("count") countKey: String?,
        @Query("limit") limitConstant: String?
    ): Call<AdverseCount>

}