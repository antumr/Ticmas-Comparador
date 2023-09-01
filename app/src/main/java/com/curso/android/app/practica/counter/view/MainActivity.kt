package com.curso.android.app.practica.counter.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.curso.android.app.practica.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.textResult.observe(this) {
            binding.result.text = "${it.result}"
        }

        binding.resultButton.setOnClickListener {
            val firstValue = binding.firstString.text.toString()
            val secondValue = binding.secondString.text.toString()
            mainViewModel.compare(firstValue, secondValue)
        }

    }
}
