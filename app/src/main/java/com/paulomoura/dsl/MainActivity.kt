package com.paulomoura.dsl

import android.content.Intent
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
        buttonChangeTexts.setOnClickListener {
            textView1.text = "TEXTVIEW1 ALTERADO"
            textView2.text = "TEXTVIEW2 ALTERADO"
        }
        buttonCallSecondActivity.setOnClickListener { startActivity(Intent(this@MainActivity, SecondActivity::class.java)) }
    }
}