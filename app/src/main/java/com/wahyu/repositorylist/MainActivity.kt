package com.wahyu.repositorylist

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.wahyu.repositorylist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
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