package paularanas.com.capstone_project;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import paularanas.com.capstone_project.ui.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;



/**
 * Created by Paul on 7/13/2016.
 */

@RunWith(JUnit4.class)
public class GardenDisplayUITest {

    @Rule
    public ActivityTestRule mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void viewPagerGardenDisplayUITest() {
        onView(withId(R.id.main_pager)).perform(swipeLeft());
        onView(withText("Welcome"));
        onView(withId(R.id.main_pager)).perform(swipeLeft()).check(matches(hasDescendant(withId(R.id.start_button))));
        onView(withId(R.id.main_pager)).perform(swipeLeft());
        onView(withId(R.id.main_pager)).perform(swipeRight());
        onView(withId(R.id.main_pager)).perform(swipeRight());
        onView(withId(R.id.main_pager)).perform(swipeRight());

    }
    @Test
    public void DetailsGardenDisplayUITest() {
        onView(withId(R.id.recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.pager)).perform(swipeLeft());
        onView(withId(R.id.pager)).perform(swipeLeft());
    }

}
