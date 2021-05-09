package com.paulomoura.dsl

import android.app.Activity
import android.widget.Button
import android.widget.TextView

fun initRobot(function: Robot.() -> Unit): Robot = Robot().apply(function)
infix fun Robot.then(function: Robot.() -> Unit): Robot = this.apply(function)
infix fun Robot.andVerifyThat(function: Robot.() -> Unit): Robot = this.apply(function)

class Robot {
    var activity = Activity()

    fun textViewsTextsAreBeingInitializedCorrectly() {
        assert(activity.findViewById<TextView>(R.id.textView1).text == "TextView1")
        assert(activity.findViewById<TextView>(R.id.textView2).text == "TextView2")
    }

    fun clickButton() {
        activity.findViewById<Button>(R.id.button).performClick()
    }

    fun textViewsTextsHaveChanged() {
        assert(activity.findViewById<TextView>(R.id.textView1).text == "TEXTVIEW1 ALTERADO")
        assert(activity.findViewById<TextView>(R.id.textView2).text == "TEXTVIEW2 ALTERADO")
    }
}

