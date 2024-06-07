package com.challenge.flickrretriever.network.service

import retrofit2.Response
import retrofit2.http.GET

interface FlickrRetrieverService {

    @GET("services/feeds/photos_public.gne?format=json&nojsoncallback=1&tags=porcupine")
    suspend fun retrieveFlickrThumbs(): Response<String>

}