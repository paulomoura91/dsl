package com.paulomoura.dsl.mainactivity

import android.app.Activity
import android.widget.Button
import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.paulomoura.dsl.MainActivity
import com.paulomoura.dsl.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTestKotlin {

    private lateinit var mainActivity: Activity

    @Before
    fun `launch Activity to run the tests`() {
        ActivityScenario.launch(MainActivity::class.java).onActivity {
            mainActivity = it
        }
    }

    @Test
    fun `verify if TextViews are being shown correctly right after Activity starts`() {
        assert(mainActivity.findViewById<TextView>(R.id.textView1).text == "TextView1")
        assert(mainActivity.findViewById<TextView>(R.id.textView2).text == "TextView2")
    }

    @Test
    fun `verify if TextViews are being shown correctly after performing the button click`() {
        mainActivity.findViewById<Button>(R.id.buttonChangeTexts).performClick()
        assert(mainActivity.findViewById<TextView>(R.id.textView1).text == "TEXTVIEW1 ALTERADO")
        assert(mainActivity.findViewById<TextView>(R.id.textView2).text == "TEXTVIEW2 ALTERADO")
    }
}