package com.example.demo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demo.model.UserDataClass
import com.example.demo.repository.MainActivityRepository

class MainActivityViewModel : ViewModel() {

    private var servicesLiveData: MutableLiveData<ArrayList<UserDataClass>>? = null

    fun getUserCards(): MutableLiveData<ArrayList<UserDataClass>>? {
        servicesLiveData = MainActivityRepository.getServicesApiCall()
        return servicesLiveData
    }
}