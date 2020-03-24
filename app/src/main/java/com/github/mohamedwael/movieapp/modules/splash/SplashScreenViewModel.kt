package com.github.mohamedwael.movieapp.modules.splash

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

const val SPLASH_TIMER = 3000L

class SplashScreenViewModel : ViewModel() {
    val moveToNextScreen = MutableLiveData<Boolean>()

    fun startSplashTimer() {
        Handler().postDelayed({
            moveToNextScreen.value = true
        }, SPLASH_TIMER)
    }

}
