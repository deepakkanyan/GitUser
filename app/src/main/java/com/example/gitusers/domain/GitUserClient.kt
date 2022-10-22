package com.example.gitusers.domain


import com.example.gitusers.data.model.GitUserInfo
import com.example.gitusers.data.model.GitUserList
import com.example.gitusers.module.baseReponse.GitSource


interface GitUserClient {
    suspend fun getUsersList(page: Int, pageSize: Int): GitSource<GitUserList>
    suspend fun getUserInfo(username: String): GitSource<GitUserInfo>
}