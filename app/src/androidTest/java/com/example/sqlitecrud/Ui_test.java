package com.example.sqlitecrud;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class Ui_test {

    @Rule
    public ActivityScenarioRule<fetchdata> activityRule =
            new ActivityScenarioRule<>(fetchdata.class);

    @Test
    public void insertItem()
    {
        onView(withId(R.id.fbtn)).perform(click());
        onView(withId(R.id.sysPress)).perform(click(),ViewActions.typeText("120"),pressImeActionButton());
        onView(withId(R.id.diasPress)).perform(click(),ViewActions.typeText("80"),pressImeActionButton());
        onView(withId(R.id.hrtRate)).perform(click(),ViewActions.typeText("75"),pressImeActionButton());
        onView(withId(R.id.comment)).perform(click(),ViewActions.typeText("Good"),pressImeActionButton());
        onView(withId(R.id.sbmt_add)).perform(click());
    }

    
}
