package com.example.apicativosdefilmes.service.repository.retrofit

import com.example.apicativosdefilmes.service.constants.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit private constructor() {
    companion object {
        private lateinit var retrofit: Retrofit
        private val httpClient = OkHttpClient.Builder()

        private fun getRetrofitInstance(): Retrofit {
            if (!::retrofit.isInitialized){
                retrofit = Retrofit.Builder()
                    .baseUrl(Constants.URL.API_BASE)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit

        }

        fun <S> createService(serviceClass: Class<S>): S {
            return getRetrofitInstance().create(serviceClass)
        }
    }
}