package com.example.kotlin.favoritemovie.framework.views.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.kotlin.favoritemovie.MainActivity
import com.example.kotlin.favoritemovie.databinding.ActivitySplashscreenBinding
import com.example.kotlin.favoritemovie.framework.viewmodel.SplashscreenViewModel

/**
 * @brief This class is the SplashscreenActivity class.
 * @author Yuna Chung A01709043
 * @date 2023.10.10
 * @version 1.0.0
 */
class SplashscreenActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySplashscreenBinding
    private val viewModel: SplashscreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        initializeBinding()

        viewModel.onCreate()

        initializeObservers()
    }

    private fun initializeBinding(){
        binding = ActivitySplashscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initializeObservers(){
        viewModel.finishedLoading.observe(this, Observer {finishedLoading->
            if(finishedLoading){
                passViewGoToMain()
            }
        })
    }

    private fun passViewGoToMain() {
        var intent: Intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        startActivity(intent)
        finish()
    }
}