package com.example.pizzeriaapp.presentation.utils

import android.widget.ImageView

interface IImageLoader {
    fun loadRoundedImage(url: String, imageView: ImageView)
}