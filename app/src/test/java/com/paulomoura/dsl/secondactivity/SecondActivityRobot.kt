package com.paulomoura.dsl.secondactivity

import android.app.Activity
import android.widget.Button
import com.paulomoura.dsl.BaseRobot
import com.paulomoura.dsl.R

infix fun SecondActivityRobot.andVerifyButton5(function: SecondActivityRobot.() -> Unit): SecondActivityRobot = this.apply(function)

class SecondActivityRobot : BaseRobot() {
    var activity = Activity()

    fun buttonsTextsAreBeingShownCorrectly() {
        assert(activity.findViewById<Button>(R.id.button1).text == "Button1")
        assert(activity.findViewById<Button>(R.id.button2).text == "Button2")
        assert(activity.findViewById<Button>(R.id.button3).text == "Button3")
        assert(activity.findViewById<Button>(R.id.button4).text == "Button4")
        assert(activity.findViewById<Button>(R.id.button5).text == "Button5")
        assert(activity.findViewById<Button>(R.id.button6).text == "Button6")
    }

    fun isTextCorrect() {
        assert(activity.findViewById<Button>(R.id.button5).text == "Button5")
    }
}