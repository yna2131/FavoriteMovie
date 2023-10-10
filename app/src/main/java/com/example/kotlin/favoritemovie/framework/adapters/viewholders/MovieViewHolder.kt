package com.example.kotlin.favoritemovie.framework.adapters.viewholders

import android.content.Context
import android.content.Intent
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
import okhttp3.Dispatcher

class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)
    fun bind(item: MovieBase, context: Context){
        binding.TVName.text = item.name
        getMovieInfo(item.url,binding.IVPhoto,context)

        }

    private fun getMovieInfo(url:String, imageView: ImageView, context: Context){
        var MovieStringNumber:String = url.replace("https://api.themoviedb.org/3/movie/","")
        MovieStringNumber = MovieStringNumber.replace("/","")
        val MovieNumber:Int = Integer.parseInt(MovieStringNumber)

        CoroutineScope(Dispatchers.IO).launch {
            val MovieInfoRequirement = MovieInfoRequirement()
            val result: Movie? = MovieInfoRequirement(MovieNumber)
            CoroutineScope(Dispatchers.Main).launch {
                val urlImage = result?.sprites?.other?.official_artwork?.front_default.toString()

                val requestOptions = RequestOptions()
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .fitCenter()
                    .priority(Priority.HIGH)

                Glide.with(context).load(urlImage)
                    .apply(requestOptions)
                    .into(imageView)
        }
    }
    }
}