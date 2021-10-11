package com.example.plantixchallenge.apiservice

import com.example.plantixchallenge.constants.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {
    companion object {

        private lateinit var retrofit: Retrofit

        fun getRetrofitClint(url1: String): Retrofit {

            return if (this::retrofit.isInitialized) {
                retrofit
            } else {
                retrofit = Retrofit.Builder()
                    .baseUrl(url1)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofit
            }
        }

    }
}