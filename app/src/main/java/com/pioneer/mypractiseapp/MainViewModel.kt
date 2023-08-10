package com.pioneer.mypractiseapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(private var service: MyApi) : ViewModel() {

    private val _albums = MutableLiveData<Album>()
    val albums: LiveData<Album> = _albums

    fun fetchAlbums() {
        viewModelScope.launch {
            val response = service.getPosts()
            if (response.isSuccessful) {
                Log.i("nileshphonde", response.body().toString())
                _albums.value = response.body()
            }
        }
    }
}