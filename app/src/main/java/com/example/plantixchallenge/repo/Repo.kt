package com.example.plantixchallenge.repo

import androidx.lifecycle.MutableLiveData
import com.example.plantixchallenge.apiservice.ApiService
import com.example.plantixchallenge.apiservice.DataService
import com.example.plantixchallenge.constants.Constants
import com.example.plantixchallenge.datamodel.DataModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repo {
    fun getData(): MutableLiveData<DataModel> {

        val getData: MutableLiveData<DataModel> = MutableLiveData()

        ApiService.getRetrofitClint(Constants.BASE_URL)
            .create(DataService::class.java)
            .getAllData()
            .enqueue(object : Callback<DataModel> {
                override fun onResponse(
                    call: Call<DataModel>,
                    response: Response<DataModel>
                ) {
                    getData.postValue(response.body())
                }

                override fun onFailure(call: Call<DataModel>, t: Throwable) {

                }

            })
        return getData
    }

}