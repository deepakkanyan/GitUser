package com.example.gitusers.domain

import com.example.gitusers.data.GitUserApis
import com.example.gitusers.data.model.GitUserInfo
import com.example.gitusers.data.model.GitUserList
import com.example.gitusers.module.baseReponse.GitSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class GitUserClientResponse(private val githubApi: GitUserApis): GitUserClient {

    override suspend fun getUsersList(page: Int, pageSize: Int): GitSource<GitUserList> = withContext(Dispatchers.IO) {
        try {
            val response = githubApi.getUsersList(page, pageSize)
            if (response.isSuccessful) {
                GitSource.success(response.body())

            } else {
                GitSource.error(response.message())
            }
        } catch (ex: Throwable) {
            GitSource.error("${ex.message}")
        }
    }

    override suspend fun getUserInfo(username: String): GitSource<GitUserInfo> = withContext(Dispatchers.IO) {
        try {
            val response = githubApi.getUserInfo(username)
            if (response.isSuccessful) {
                GitSource.success(response.body())

            } else {
                GitSource.error(response.message())
            }
        } catch (ex: Throwable) {
            GitSource.error("${ex.message}")
        }
    }
}