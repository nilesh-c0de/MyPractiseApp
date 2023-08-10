package com.pioneer.mypractiseapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(var repository: MainRepository) : ViewModel() {

    private var _albums = MutableStateFlow<Album>(Album())
    var albums: StateFlow<Album> = _albums

    init {
        fetchAlbums()
    }

    private fun fetchAlbums() {
        viewModelScope.launch {
            val response = repository.getAlbums()
            if (response.isSuccessful && response.body() != null) {
                response.body()?.let {
                    _albums.emit(it)
                }
            }
        }
    }
}