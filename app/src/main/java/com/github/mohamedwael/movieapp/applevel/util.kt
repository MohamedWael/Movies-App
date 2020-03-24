package com.github.mohamedwael.movieapp.applevel

import android.content.Context
import android.content.res.Resources
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.util.TypedValue
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.github.mohamedwael.movieapp.R
import com.github.mohamedwael.movieapp.applevel.network.loadImage


fun Context.toPixel(dp: Float): Float {
    val r: Resources = resources
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp,
        r.displayMetrics
    )
}

object ImageBindingAdapter {
    @JvmStatic
    @BindingAdapter("app:imageFromUri")
    fun imageFromUri(imageView: ImageView, uri: String) {
        loadImage(uri, imageView).error(R.mipmap.ic_launcher).into(imageView)
    }
}