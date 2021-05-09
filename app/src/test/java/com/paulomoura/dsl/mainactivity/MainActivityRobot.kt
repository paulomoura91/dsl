package com.paulomoura.dsl.mainactivity

import android.app.Activity
import android.widget.Button
import android.widget.TextView
import com.paulomoura.dsl.BaseRobot
import com.paulomoura.dsl.R

class MainActivityRobot : BaseRobot() {
    var activity = Activity()

    fun textViewsTextsAreBeingInitializedCorrectly() {
        assert(activity.findViewById<TextView>(R.id.textView1).text == "TextView1")
        assert(activity.findViewById<TextView>(R.id.textView2).text == "TextView2")
    }

    fun clickButton() {
        activity.findViewById<Button>(R.id.buttonChangeTexts).performClick()
    }

    fun textViewsTextsHaveChanged() {
        assert(activity.findViewById<TextView>(R.id.textView1).text == "TEXTVIEW1 ALTERADO")
        assert(activity.findViewById<TextView>(R.id.textView2).text == "TEXTVIEW2 ALTERADO")
    }
}

