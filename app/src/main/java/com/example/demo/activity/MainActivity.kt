package com.example.demo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo.R
import com.example.demo.adapter.CardMainAdapter
import com.example.demo.model.UserDataClass
import com.example.demo.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityViewModel: MainActivityViewModel
    private val mAdapter: CardMainAdapter = CardMainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        getDataFromServer()
    }


    private fun initViewModel() {
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    private fun getDataFromServer() {
        wp7progressBar.showProgressBar()
        mainActivityViewModel.getUserCards()!!.observe(this, Observer { data ->
            wp7progressBar.hideProgressBar()
            setAdapter(data as ArrayList<UserDataClass>)
        })
    }

    private fun setAdapter(mItems: ArrayList<UserDataClass>) {
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mAdapter.cardMainAdapter(mItems)
        mRecyclerView.adapter = mAdapter
    }
}
