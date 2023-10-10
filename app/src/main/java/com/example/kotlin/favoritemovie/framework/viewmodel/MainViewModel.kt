package com.example.kotlin.favoritemovie.framework.viewmodel

import com.example.kotlin.favoritemovie.utils.Constants
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.favoritemovie.data.network.model.MovieObject
import com.example.kotlin.favoritemovie.domain.MovieListRequirement
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val movieObjectLiveData = MutableLiveData<MovieObject?>()
    private val movieListRequirement = MovieListRequirement()

    fun getMovieList() {
        viewModelScope.launch(Dispatchers.IO){
            val result: MovieObject? = movieListRequirement(Constants.MAX_MOVIE_NUMBER)
            CoroutineScope(Dispatchers.Main).launch {
                movieObjectLiveData.postValue(result)
            }
        }
    }
}