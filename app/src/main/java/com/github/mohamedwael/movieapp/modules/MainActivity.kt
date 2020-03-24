package com.github.mohamedwael.movieapp.modules

import android.os.Bundle
import com.blogspot.mowael.baselibrary.activities.BaseActivity
import com.github.mohamedwael.movieapp.R
import com.github.mohamedwael.movieapp.modules.movies.view.MoviesFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
