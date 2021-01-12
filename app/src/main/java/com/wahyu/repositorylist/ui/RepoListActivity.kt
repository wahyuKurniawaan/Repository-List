package com.wahyu.repositorylist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wahyu.repositorylist.R
import com.wahyu.repositorylist.adapter.RepoRecycleListAdapter
import com.wahyu.repositorylist.databinding.ActivityRepoListBinding
import com.wahyu.repositorylist.models.RepoListModel
import com.wahyu.repositorylist.util.APIService
import com.wahyu.repositorylist.util.RepoListResponse
import com.wahyu.repositorylist.util.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRepoListBinding
    var apiService: APIService? = null
    var reposList: MutableList<RepoListModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_repo_list)
        apiService = RetrofitClient.getApiClient(this)?.create(APIService::class.java)
        getRepos()
        viewActions()
    }

    private fun viewActions() {
        binding.rvRepo.adapter = RepoRecycleListAdapter()
        binding.rvRepo.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

    private fun getRepos() {

        val user = intent.getStringExtra("user") ?: "null"

        apiService?.getRepositories(user)?.enqueue(object : Callback<List<RepoListResponse>> {
            override fun onFailure(call: Call<List<RepoListResponse>>?, t: Throwable?) {
            }

            override fun onResponse(
                call: Call<List<RepoListResponse>>?,
                response: Response<List<RepoListResponse>>?
            ) {
                if (response != null) {
                    if (response.isSuccessful) {
                        val list = response.body()?.map {
                            RepoListModel(
                                it.name,
                                it.description,
                                it.forkCount,
                                it.language,
                                it.starsCount,
                                it.watcherCount,
                                it.issuesCount,
                                it.htmlUrl
                            )
                        }
                        (binding.rvRepo.adapter as RepoRecycleListAdapter).addList(list!!)
                    }
                }
            }
        })
    }
}