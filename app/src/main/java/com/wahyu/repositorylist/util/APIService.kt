package com.wahyu.repositorylist.util

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {

    @GET("https://api.github.com/users/{user}/repos")
    fun getRepositories(@Path("user") user: String) : Call<List<RepoListResponse>>
}