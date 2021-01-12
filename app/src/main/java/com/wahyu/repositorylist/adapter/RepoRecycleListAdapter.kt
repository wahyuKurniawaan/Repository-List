package com.wahyu.repositorylist.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.wahyu.repositorylist.R
import com.wahyu.repositorylist.databinding.ReposListItemBinding
import com.wahyu.repositorylist.models.RepoListModel
import com.wahyu.repositorylist.ui.DetailActivity

class RepoRecycleListAdapter : RecyclerView.Adapter<RepoRecycleListAdapter.ViewHolder>() {

    private val repos = mutableListOf<RepoListModel>()

    fun addList(list: List<RepoListModel>) {
        repos.clear()
        repos.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.repos_list_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val repo = repos[position]

        holder.binding.repoTitleTextView.text = repo.name
        holder.binding.repoDescriptionTextView.text = repo.description
        holder.binding.repoWatchersTextView.text = repo.forkCount.toString()
        holder.binding.repoLanguage.text = repo.language

        holder.binding.root.setOnClickListener {
            val intent = Intent(holder.binding.root.context, DetailActivity::class.java)
            intent.putExtra("name", repo.name)
            intent.putExtra("description", repo.description)
            intent.putExtra("forkCount", repo.forkCount)
            intent.putExtra("language", repo.language)
            intent.putExtra("starsCount", repo.starsCount)
            intent.putExtra("issuesCount", repo.issuesCount)
            intent.putExtra("watcherCount", repo.watcherCount)
            intent.putExtra("htmlUrl", repo.htmlUrl)
            holder.binding.root.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return repos.size
    }

    class ViewHolder(val binding: ReposListItemBinding) : RecyclerView.ViewHolder(binding.root)

}