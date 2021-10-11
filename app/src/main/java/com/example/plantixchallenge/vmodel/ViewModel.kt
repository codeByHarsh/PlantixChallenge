package com.example.plantixchallenge.vmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.plantixchallenge.datamodel.DataModel
import com.example.plantixchallenge.repo.Repo

class ViewModel1 : ViewModel() {
    private var repo: Repo = Repo()
    private lateinit var mutableLiveData: MutableLiveData<DataModel>


    fun getDataModelVM(): LiveData<DataModel> {

        if (this::mutableLiveData.isInitialized) {
            return mutableLiveData
        } else {
            mutableLiveData = repo.getData()
            return mutableLiveData
        }
    }

}