package com.pioneer.mypractiseapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory constructor(private val service: MyApi): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.service) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}