package com.github.mohamedwael.movieapp.applevel

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue


fun Context.toPixel(dp: Float): Float {
    val r: Resources = resources
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp,
        r.displayMetrics
    )
}