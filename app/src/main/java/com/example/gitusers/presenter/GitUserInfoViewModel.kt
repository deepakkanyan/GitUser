package com.example.gitusers.presenter


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GitUserInfoViewModel : ViewModel() {

    private val _visitProfile = MutableLiveData<String>()
    val visitProfile: LiveData<String>
        get() = _visitProfile


    fun visitProfile(url: String) {
        _visitProfile.value = url
    }

}