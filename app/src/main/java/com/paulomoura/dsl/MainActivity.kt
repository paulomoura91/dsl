package com.paulomoura.dsl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        button.setOnClickListener {
            textView1.text = "TEXTVIEW1 ALTERADO"
            textView2.text = "TEXTVIEW2 ALTERADO"
        }
    }
}