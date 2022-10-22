package com.example.gitusers.data

import com.example.gitusers.data.model.GitUserInfo
import com.example.gitusers.data.model.GitUserList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitUserApis {
    @GET("search/users?q=repos:>1")
    suspend fun getUsersList(
        @Query("page") page: Int,
        @Query("per_page") pageSize: Int
    ): Response<GitUserList>

    @GET("users/{username}")
    suspend fun getUserInfo(
        @Path("username") username: String
    ): Response<GitUserInfo>

}