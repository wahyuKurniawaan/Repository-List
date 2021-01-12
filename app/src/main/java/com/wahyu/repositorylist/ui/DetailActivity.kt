package com.wahyu.repositorylist.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.wahyu.repositorylist.R
import com.wahyu.repositorylist.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title =  intent.getStringExtra("name") ?: "Null"
        viewAction()
        viewOnGithub()
    }

    private fun viewAction() {
        binding.repoForks.text = intent.getIntExtra("forkCount", 0).toString()
        binding.repoFullDescription.text = intent.getStringExtra("description")
        binding.repoLanguage.text = intent.getStringExtra("language")
        binding.repoOpenIssues.text = intent.getIntExtra("issuesCount", 0).toString()
        binding.repoStars.text = intent.getIntExtra("starsCount", 0).toString()
        binding.repoTitle.text = intent.getStringExtra("name")
        binding.repoWatchers.text = intent.getIntExtra("watcherCount", 0).toString()
    }

    private fun viewOnGithub(){
        val url = intent.getStringExtra("htmlUrl")
        binding.goToGithub.setOnClickListener {
            Log.d("view on github", "view on github")
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}