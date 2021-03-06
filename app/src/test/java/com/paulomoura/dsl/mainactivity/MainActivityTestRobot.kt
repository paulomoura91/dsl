package com.paulomoura.dsl.mainactivity

import android.app.Activity
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.paulomoura.dsl.MainActivity
import com.paulomoura.dsl.andVerifyThat
import com.paulomoura.dsl.initRobot
import com.paulomoura.dsl.then
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTestRobot {

    private lateinit var mainActivity: Activity

    @Before
    fun `launch Activity to run the tests`() {
        ActivityScenario.launch(MainActivity::class.java).onActivity {
            mainActivity = it
        }
    }

    @Test
    fun `verify if TextViews are being shown correctly right after Activity starts`() {
        initRobot(MainActivityRobot::class.java) {
            activity = mainActivity
        } andVerifyThat {
            textViewsTextsAreBeingInitializedCorrectly()
        }
    }

    @Test
    fun `verify if TextViews are being shown correctly after performing the button click`() {
        initRobot(MainActivityRobot::class.java) {
            activity = mainActivity
        } then {
            clickButton()
        } andVerifyThat {
            textViewsTextsHaveChanged()
        }
    }
}





