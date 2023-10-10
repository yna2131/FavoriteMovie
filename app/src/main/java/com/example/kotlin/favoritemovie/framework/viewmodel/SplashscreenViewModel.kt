package com.example.kotlin.favoritemovie.framework.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.favoritemovie.utils.Constants
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @brief ViewModel for the splashscreen activity
 * @author Yuna Chung A01709043
 * @date 2023.10.10
 * @version 1.0.0
 */
class SplashscreenViewModel: ViewModel(){
    val finishedLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        finishedLoading.postValue(false)
        viewModelScope.launch {
            delay(Constants.SPLASHCREEN_DURATION)
            finishedLoading.postValue(true)
        }
    }
}