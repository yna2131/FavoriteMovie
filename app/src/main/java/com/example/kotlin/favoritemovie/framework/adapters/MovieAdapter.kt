package com.example.kotlin.favoritemovie.framework.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.favoritemovie.data.network.model.MovieBase
import com.example.kotlin.favoritemovie.databinding.ItemMovieBinding
import com.example.kotlin.favoritemovie.framework.adapters.viewholders.MovieViewHolder

/**
 * @brief This class is the adapter for the RecyclerView that will show the list of movies
 * @author Yuna Chung A01709043
 * @date 2023.10.10
 * @version 1.0.0
 */
class MovieAdapter: RecyclerView.Adapter<MovieViewHolder>() {
    var data:ArrayList<MovieBase> = ArrayList()
    private lateinit var context: Context

    fun MovieAdapter(basicData : ArrayList<MovieBase>, context:Context){
        this.data = basicData
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item,context)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
