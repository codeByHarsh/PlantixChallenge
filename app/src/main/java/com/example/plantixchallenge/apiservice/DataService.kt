package com.example.plantixchallenge.apiservice

import com.example.plantixchallenge.datamodel.DataModel
import retrofit2.Call
import retrofit2.http.GET

interface DataService {
    @GET("https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/facts.json")
    fun getAllData(): Call<DataModel>
}