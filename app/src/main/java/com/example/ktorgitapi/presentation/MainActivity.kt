package com.example.ktorgitapi.presentation

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.ktorgitapi.domain.use_case.GetGithubUseCase
import com.example.ktorgitapi.R
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val res = GetGithubUseCase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            var text = res.get()
            var info: TextView = findViewById(R.id.text)
            info.text = text
        }
    }
}
