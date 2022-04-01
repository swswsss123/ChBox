package com.example.checkbook

import android.accessibilityservice.AccessibilityButtonController
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.checkbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    lateinit var  binding: ActivityMainBinding
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        APP = this
        setContentView(binding.root)
        navController = Navigation.findNavController(this,R.id.nav_graph)  //поиск фрагмента nav_graph и XML Активити мейн
    }
}