package com.example.demo.repository


import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.demo.model.UserDataClass
import com.example.demo.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityRepository {

    private val modelLiveData = MutableLiveData<ArrayList<UserDataClass>>()
    private val modelDetailLiveData = MutableLiveData<UserDataClass>()

    fun getServicesApiCall(): MutableLiveData<ArrayList<UserDataClass>> {

        val call = RetrofitClient.apiInterface.getServices()

        call.enqueue(object : Callback<ArrayList<UserDataClass>> {
            override fun onFailure(call: Call<ArrayList<UserDataClass>>, t: Throwable) {
                // TODO("Not yet implemented")
                Log.e("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<ArrayList<UserDataClass>>,
                response: Response<ArrayList<UserDataClass>>
            ) {
                // TODO("Not yet implemented")
                val response: ArrayList<UserDataClass>? = response.body()
                modelLiveData.postValue(response)

            }
        })

        return modelLiveData
    }

    fun getServicesDetailApiCall(user: String?): MutableLiveData<UserDataClass> {

        val call = RetrofitClient.apiInterface.getDetailServices(user)

        call.enqueue(object : Callback<UserDataClass> {
            override fun onFailure(call: Call<UserDataClass>, t: Throwable) {
                // TODO("Not yet implemented")
                Log.e("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<UserDataClass>,
                response: Response<UserDataClass>
            ) {
                // TODO("Not yet implemented")
                val response: UserDataClass? = response.body()
                modelDetailLiveData.postValue(response)

            }
        })

        return modelDetailLiveData
    }

}