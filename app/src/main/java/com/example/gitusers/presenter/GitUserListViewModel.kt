package com.example.gitusers.presenter


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gitusers.data.model.GitUserList
import com.example.gitusers.domain.GitUserClient

import com.example.gitusers.module.baseReponse.Status
import kotlinx.coroutines.launch


class GitUserListViewModel(private val githubApiClient: GitUserClient) : ViewModel() {


    private val _gitUserList = MutableLiveData<GitUserList?>()
    val gitUserList: LiveData<GitUserList?>
        get() = _gitUserList


    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading


    private val _isError = MutableLiveData<Boolean>()
    val isError: LiveData<Boolean>
        get() = _isError


    init {
        fetchUser()
    }

      private fun fetchUser() {
        viewModelScope.launch {

            val response = githubApiClient.getUsersList(1, 25)
            when (response.status) {
                Status.SUCCESS -> {
                    _gitUserList.postValue(response.data)
                }
                else -> {
                    _isError.postValue(true)
                }
            }

        }
    }

}