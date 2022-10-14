package com.example.pizzeriaapp.data.retrofit

import okhttp3.Interceptor
import okhttp3.Response

class HttpInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain
            .request()
            .newBuilder()
            .addHeader(
                "X-RapidAPI-Key",
                "69ad8c310dmsh96651eb4e31f1c4p187bc3jsn6f6db4b19ffa"
            )
            .addHeader("X-RapidAPI-Host", "pizzaallapala.p.rapidapi.com")
            .build()
        return chain.proceed(request)
    }
}