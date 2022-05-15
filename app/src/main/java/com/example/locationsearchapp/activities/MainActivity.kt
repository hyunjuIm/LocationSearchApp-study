package com.example.locationsearchapp.activities

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import com.example.locationsearchapp.adapter.SearchRecyclerAdapter
import com.example.locationsearchapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var searchRecyclerAdapter: SearchRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()
        initView()
    }

    private fun initView() = with(binding) {
        emptyResultTextView.isVisible = false
        recyclerView.adapter = searchRecyclerAdapter
    }

    private fun initAdapter() {
        searchRecyclerAdapter = SearchRecyclerAdapter{
            Log.d(TAG, "initAdapter: 클릭됨")
        }
    }
}