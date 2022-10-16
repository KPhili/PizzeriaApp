package com.example.pizzeriaapp.data.retrofit

import com.example.pizzeriaapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class HttpInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain
            .request()
            .newBuilder()
            .addHeader(
                "X-RapidAPI-Key",
                BuildConfig.API_KEY
            )
            .addHeader("X-RapidAPI-Host", "pizzaallapala.p.rapidapi.com")
            .build()
        return chain.proceed(request)
    }
}