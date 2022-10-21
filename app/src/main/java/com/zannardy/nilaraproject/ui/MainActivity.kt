package com.zannardy.nilaraproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.zannardy.nilaraproject.R
import com.zannardy.nilaraproject.databinding.ActivityMainBinding
import com.zannardy.nilaraproject.model.NilaraConfig

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        initView()
        initObservables()
    }

    private fun initView() {
        binding.btnCallNilaraService.setOnClickListener {
            mainViewModel.callNilaraService(NilaraConfig(
                deviceId = "202",
                src = "83994069703",
                dst = "83991218491"
            ))
            binding.textView.text = "Carregando..."
            binding.btnCallNilaraService.visibility = View.GONE
            binding.loading.visibility = View.VISIBLE
        }
    }

    private fun initObservables() {
        mainViewModel.message.observe(this) {
            binding.textView.text = it
            binding.btnCallNilaraService.visibility = View.VISIBLE
            binding.loading.visibility = View.GONE
        }
    }
}