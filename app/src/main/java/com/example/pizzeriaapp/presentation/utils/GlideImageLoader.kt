package com.example.pizzeriaapp.presentation.utils

import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.pizzeriaapp.R

class GlideImageLoader : IImageLoader {
    override fun loadRoundedImage(url: String, imageView: ImageView) {
        val transformation = RoundedCorners(CORNER_RADIUS)
        Glide
            .with(imageView)
            .load(Uri.parse(url))
            .placeholder(R.drawable.pizza_1)
            .centerCrop()
            .transform(transformation)
            .into(imageView)
    }

    companion object {
        private const val CORNER_RADIUS = 25
    }
}