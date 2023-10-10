package com.example.kotlin.favoritemovie

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.favoritemovie.data.network.model.MovieBase
import com.example.kotlin.favoritemovie.databinding.ActivityMainBinding
import com.example.kotlin.favoritemovie.framework.adapters.MovieAdapter
import com.example.kotlin.favoritemovie.framework.viewmodel.MainViewModel

class MainActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter: MovieAdapter = MovieAdapter()
    private lateinit var data:ArrayList<MovieBase>

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        initializeObservers()
        viewModel.getMovieList()
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setUpRecyclerView(dataForList:ArrayList<MovieBase>){
        binding.RVMovie.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false)
        binding.RVMovie.layoutManager = linearLayoutManager
        adapter.MovieAdapter(dataForList,this)
        binding.RVMovie.adapter = adapter
    }

    private fun initializeObservers(){
        viewModel.movieObjectLiveData.observe(this) { movieObject ->
            if (movieObject != null) {
                setUpRecyclerView(movieObject.results)
            }
        }
    }

}