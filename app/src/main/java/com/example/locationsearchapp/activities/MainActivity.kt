package com.example.locationsearchapp.activities

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import com.example.locationsearchapp.adapter.SearchRecyclerAdapter
import com.example.locationsearchapp.databinding.ActivityMainBinding
import com.example.locationsearchapp.model.LocationLatLngEntity
import com.example.locationsearchapp.model.SearchResultEntity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var searchRecyclerAdapter: SearchRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()
        initView()
        initData()

        setData()
    }

    private fun initView() = with(binding) {
        emptyResultTextView.isVisible = false
        recyclerView.adapter = searchRecyclerAdapter
    }

    private fun initAdapter() {
        searchRecyclerAdapter = SearchRecyclerAdapter()
    }

    private fun initData() {
        searchRecyclerAdapter.notifyDataSetChanged()
    }

    private fun setData() {
        val dataList = (0..10).map {
            SearchResultEntity(
                name = "빌딩 $it",
                fullAddress = "주소 $it",
                locationLatLng = LocationLatLngEntity(
                    it.toFloat(),
                    it.toFloat()
                )
            )
        }
        searchRecyclerAdapter.setSearchResultList(dataList) {
            Log.d(TAG, "setData: $dataList")
        }
    }
}