package com.example.demo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.demo.R
import com.example.demo.model.UserDataClass
import com.example.demo.viewmodel.DetailActivityViewModel
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class
DetailActivity : AppCompatActivity() {

    private lateinit var detailActivityViewModel: DetailActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initViewModel()
        getDataFromServer()
    }

    private fun initViewModel() {
        detailActivityViewModel = ViewModelProvider(this).get(DetailActivityViewModel::class.java)
    }

    private fun getDataFromServer() {
        wp7progressBarDetail.showProgressBar()
        val profileName = intent.getStringExtra("username")

        detailActivityViewModel.getDetailUserCards(profileName)!!.observe(this, Observer { data ->
            wp7progressBarDetail.hideProgressBar()
            setData(data)
        })
    }

    private fun setData(data: UserDataClass) {
        tvTitle.text = data.login
        tvType.text = data.type
        //Picasso.get().load(data.avatar_url).into(ivUserIconMain)
        Picasso.get().load(data.avatar_url)
            .error(R.drawable.user)
            .placeholder(R.drawable.user)
            .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
            .into(ivUserIconMain);
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}