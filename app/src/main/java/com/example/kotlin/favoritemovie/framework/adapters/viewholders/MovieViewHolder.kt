package com.example.kotlin.favoritemovie.framework.adapters.viewholders

import android.content.Context
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.kotlin.favoritemovie.data.network.model.MovieBase
import com.example.kotlin.favoritemovie.data.network.model.movie.Movie
import com.example.kotlin.favoritemovie.databinding.ItemMovieBinding
import com.example.kotlin.favoritemovie.domain.MovieInfoRequirement
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(item: MovieBase, context:Context){
        binding.TVName.text = item.name
       val urlImage = "https://image.tmdb.org/t/p/original${item.poster_path}"

//        Log.d("urlImage",urlImage)
                val requestOptions = RequestOptions()
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .fitCenter()
                    .priority(Priority.HIGH)

                Glide.with(context).load(urlImage)
                    .apply(requestOptions)
                    .into(binding.IVPhoto)

}
}