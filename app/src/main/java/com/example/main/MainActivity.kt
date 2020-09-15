package com.example.imagefromapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, MainFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}