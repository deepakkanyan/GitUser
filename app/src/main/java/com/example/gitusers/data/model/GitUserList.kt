package com.example.gitusers.data.model

import com.google.gson.annotations.SerializedName

data class GitUserList(
    @SerializedName("total_count") var totalCount: Long,
    @SerializedName("incomplete_results") var incompleteResults: Boolean,
    @SerializedName("items") var items: List<GitUserInfo>
)