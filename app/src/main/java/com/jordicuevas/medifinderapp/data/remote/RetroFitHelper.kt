package com.jordicuevas.medifinderapp.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.jordicuevas.medifinderapp.utils.Constants

class RetroFitHelper {

    fun getRetroFit(): Retrofit {
        val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply{
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder().apply{
            addInterceptor(interceptor)
        }.build()

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

}