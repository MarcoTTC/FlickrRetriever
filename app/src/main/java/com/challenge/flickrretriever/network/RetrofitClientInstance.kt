package com.challenge.flickrretriever.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientInstance {

    companion object {
        private const val BASE_URL = "https://api.flickr.com/"
        private var retrofit: Retrofit? = null

        fun getRetrofitInstance(): Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit as Retrofit
        }
    }
}