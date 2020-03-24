package com.github.mohamedwael.movieapp.applevel.network

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.request.RequestOptions

fun loadImage(
    imageUrl: String,
    view: ImageView
): RequestBuilder<Drawable> {
    val progress = getCircularImageProgress(view.context)
    progress.start()
    return Glide.with(view)
        .load(imageUrl)
        .apply(RequestOptions.placeholderOf(progress))
        .apply(RequestOptions.centerCropTransform())
}

private fun getCircularImageProgress(context: Context): CircularProgressDrawable {
    val circularProgress = CircularProgressDrawable(context)
    circularProgress.strokeWidth = 5f
    circularProgress.centerRadius = 30f
    return circularProgress
}