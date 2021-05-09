package com.paulomoura.dsl.secondactivity

import android.app.Activity
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.paulomoura.dsl.SecondActivity
import com.paulomoura.dsl.andVerifyThat
import com.paulomoura.dsl.initRobot
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SecondActivityTest {
    private lateinit var secondActivity: Activity

    @Before
    fun `launch Activity to run the tests`() {
        ActivityScenario.launch(SecondActivity::class.java).onActivity {
            secondActivity = it
        }
    }

    @Test
    fun `verify if buttons are being shown correctly`() {
        initRobot(SecondActivityRobot::class.java) {
            activity = secondActivity
        } andVerifyThat {
            buttonsTextsAreBeingShownCorrectly()
        }
    }

    @Test
    fun `verify if button5 is showing the correct text`() {
        initRobot(SecondActivityRobot::class.java) {
            activity = secondActivity
        } andVerifyButton5 {
            isTextCorrect()
        }
    }
}