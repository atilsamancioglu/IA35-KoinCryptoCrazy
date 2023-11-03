package com.atilsamancioglu.koinretrofit.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.atilsamancioglu.koinretrofit.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}