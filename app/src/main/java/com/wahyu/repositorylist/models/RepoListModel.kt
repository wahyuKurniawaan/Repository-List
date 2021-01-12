package com.wahyu.repositorylist.models

data class RepoListModel(
    val name: String?,
    val description: String?,
    val forkCount: Int?,
    val language: String?,
    val starsCount: Int?,
    val watcherCount: Int?,
    val issuesCount: Int?,
    val htmlUrl: String?
//    val owner: Owner?,
) {
//    data class Owner(
//        val avatarUrl: String?
//    )
}
