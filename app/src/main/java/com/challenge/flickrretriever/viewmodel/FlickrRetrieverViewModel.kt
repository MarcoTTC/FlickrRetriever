package com.challenge.flickrretriever.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.challenge.flickrretriever.network.RetrofitClientInstance
import com.challenge.flickrretriever.network.service.FlickrRetrieverService
import retrofit2.Retrofit

class FlickrRetrieverViewModel() : ViewModel() {

    enum class State {
        LOADING,
        SUCCESS,
        FAILED
    }

    private val _viewModelState: MutableLiveData<State> = MutableLiveData()
    val viewModelState: LiveData<State>
        get() = _viewModelState

    private var retrofitInstance: Retrofit
    private var flickrRetrieverService: FlickrRetrieverService

    init {
        _viewModelState.value = State.LOADING

        retrofitInstance = RetrofitClientInstance.getRetrofitInstance()
        flickrRetrieverService = retrofitInstance.create(FlickrRetrieverService::class.java)
    }

    suspend fun retrieveThumbsBasedOnSearch(searchValue: String = "") {
        TODO()
    }
}