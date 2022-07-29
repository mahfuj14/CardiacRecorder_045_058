package com.example.sqlitecrud;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.os.SystemClock;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Ui testing is done
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ui_test {


    @Rule
    public ActivityScenarioRule<fetchdata> activityRule =
            new ActivityScenarioRule<>(fetchdata.class);

    @Test
    public void apptextview() {
        onView(withText("Rocord")).check(matches(isDisplayed()));
    }

    /**
     * For inserting item
     */
    @Test
    public void insertItem() {
        onView(withId(R.id.fbtn)).perform(click());
        SystemClock.sleep(3000);
        onView(withId(R.id.sysPress)).perform(click(), ViewActions.typeText("110"), pressImeActionButton());
        onView(withId(R.id.diasPress)).perform(click(), ViewActions.typeText("70"), pressImeActionButton());
        onView(withId(R.id.hrtRate)).perform(click(), ViewActions.typeText("65"), pressImeActionButton());
        onView(withId(R.id.cmnt)).perform(click(), ViewActions.typeText("Good"), pressImeActionButton());
        onView(withId(R.id.sbmt_add)).perform(click());
        SystemClock.sleep(4000);
    }

    /**
     * For updating item
     */
    @Test
     public void editItem(){
        onView(withId(R.id.edit)).perform(click());
        SystemClock.sleep(4000);
        onView(withId(R.id.upSYs)).perform(ViewActions.clearText(),ViewActions.typeText("110"),pressImeActionButton());
        onView(withId(R.id.updias)).perform(ViewActions.clearText(),ViewActions.typeText("70"),pressImeActionButton());
        onView(withId(R.id.uphrtRate)).perform(ViewActions.clearText(),ViewActions.typeText("65"),pressImeActionButton());
        onView(withId(R.id.upcomment)).perform(ViewActions.clearText(),ViewActions.typeText("bad"),pressImeActionButton());
        onView(withId(R.id.sbmt_up)).perform(click());
        SystemClock.sleep(4000);
    }

    /**
     * For deleting item
     */
    @Test
    public  void deleteItem()
    {
        SystemClock.sleep(4000);
        onView(withId(R.id.deleteList)).perform(click());
        SystemClock.sleep(5000);
    }

}
