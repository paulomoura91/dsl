package com.paulomoura.dsl;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTestJava {
    
    private Activity mainActivity;
    
    @Before
    public void launchActivityToRunTheTests() {
        ActivityScenario.launch(MainActivity.class).onActivity(activity -> mainActivity = activity);
    }
    
    @Test
    public void verifyTextViewsTextsWhenActivityStarts() {
        boolean textView1IsCorrect = false, textView2IsCorrect = false;
        View textView1 = mainActivity.findViewById(R.id.textView1);
        if (textView1 instanceof TextView) {
            textView1IsCorrect = ((TextView) textView1).getText().equals("TextView1");
        }
        View textView2 = mainActivity.findViewById(R.id.textView2);
        if (textView2 instanceof TextView) {
            textView2IsCorrect = ((TextView) textView2).getText().equals("TextView2");
        }
        Assert.assertTrue(textView1IsCorrect && textView2IsCorrect);
    }

    @Test
    public void verifyTextViewsTextsAfterButtonClick() {
        mainActivity.findViewById(R.id.buttonChangeTexts).performClick();
        boolean textView1IsCorrect = false, textView2IsCorrect = false;
        View textView1 = mainActivity.findViewById(R.id.textView1);
        if (textView1 instanceof TextView) {
            textView1IsCorrect = ((TextView) textView1).getText().equals("TEXTVIEW1 ALTERADO");
        }
        View textView2 = mainActivity.findViewById(R.id.textView2);
        if (textView2 instanceof TextView) {
            textView2IsCorrect = ((TextView) textView2).getText().equals("TEXTVIEW2 ALTERADO");
        }
        Assert.assertTrue(textView1IsCorrect && textView2IsCorrect);
    }
}
