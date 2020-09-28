package id.ac.ui.cs.mobileprogramming.yama.caloriemeter;

import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityInstrumentedTest {

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule(MainActivity.class);

    MainActivity mainActivity;

    @Before
    public void setUp() throws Exception {
        mainActivity = (MainActivity) activityTestRule.getActivity();
    }

    @Test
    public void addCounter() {
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.show_count)).check(matches(withText("1")));
    }

    @Test
    public void subCounter() {
        onView(withId(R.id.button_dec)).perform(click());
        onView(withId(R.id.show_count)).check(matches(withText("-1")));
    }

    @Test
    public void resetCounter() {
        onView(withId(R.id.button_dec)).perform(click());
        onView(withId(R.id.button_reset)).perform(click());
        onView(withId(R.id.show_count)).check(matches(withText("0")));
    }
}