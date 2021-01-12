package com.wahyu.repositorylist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.wahyu.repositorylist.databinding.ActivityMainBinding
import com.wahyu.repositorylist.ui.RepoListActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(R.string.home_title)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnSubmit.setOnClickListener {
            val intent = Intent(this, RepoListActivity::class.java)
            intent.putExtra("user", binding.etInputUsername.text.toString())
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        val dialog = AlertDialog.Builder(this)
            .setTitle("Exit Application ?")
            .setCancelable(false)
            .setPositiveButton("Yes") { dialog, id ->
                super.onBackPressed()}
            .setNegativeButton("No") {  dialog, id -> }
        dialog.show()
    }
}