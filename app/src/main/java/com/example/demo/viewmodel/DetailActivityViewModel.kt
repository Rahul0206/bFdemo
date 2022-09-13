package com.example.demo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demo.model.UserDataClass
import com.example.demo.repository.MainActivityRepository

class DetailActivityViewModel : ViewModel() {

    private var servicesDetailLiveData: MutableLiveData<UserDataClass>? = null

    fun getDetailUserCards(user: String?): MutableLiveData<UserDataClass>? {
        servicesDetailLiveData = MainActivityRepository.getServicesDetailApiCall(user)
        return servicesDetailLiveData
    }
}