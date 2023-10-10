package com.example.kotlin.favoritemovie

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.favoritemovie.data.network.model.MovieBase
import com.example.kotlin.favoritemovie.databinding.ActivityMainBinding
import com.example.kotlin.favoritemovie.framework.adapters.MovieAdapter

class MinActivity: Activity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter: MovieAdapter = MovieAdapter()
    private lateinit var data:ArrayList<MovieBase>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        setUpRecyclerView(testData())
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun testData():ArrayList<MovieBase>{
        var result = ArrayList<MovieBase>()

        result.add(MovieBase("movie1",""))
        result.add(MovieBase("movie2",""))
        result.add(MovieBase("movie3",""))

        return result
    }

    private fun setUpRecyclerView(dataForList:ArrayList<MovieBase>){
        binding.RVMovie.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false)
        binding.RVMovie.layoutManager = linearLayoutManager
        adapter.MovieAdapter(dataForList)
        binding.RVMovie.adapter = adapter
    }

}