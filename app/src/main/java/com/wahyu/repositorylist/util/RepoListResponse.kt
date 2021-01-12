package com.wahyu.repositorylist.util

import com.google.gson.annotations.SerializedName

data class RepoListResponse(
    val name: String?,
    val description: String?,
    @SerializedName("forks_count") val forkCount: Int?,
    val language: String?,
    val owner: Owner?,
    @SerializedName("stargazers_count") val starsCount: Int?,
    @SerializedName("watchers_count") val watcherCount: Int?,
    @SerializedName("open_issues") val issuesCount: Int?,
    @SerializedName("html_url") val htmlUrl: String?,
) {
    data class Owner(
        @SerializedName("avatar_url") val avatarUrl: String?
    )
}
