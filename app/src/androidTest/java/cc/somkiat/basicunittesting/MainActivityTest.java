package cc.somkiat.basicunittesting;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void saveCorrectlyTest() {
        closeSoftKeyboard();
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).perform(scrollTo(), replaceText("XenXorX"));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("XenXorX@gmail.com"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
    }

    @Test
    public void saveEmptyName() {
        closeSoftKeyboard();
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).perform(scrollTo(), replaceText(""));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("XenXorX@gmail.com"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
    }

    @Test
    public void saveEmptyEmail() {
        closeSoftKeyboard();
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).perform(scrollTo(), replaceText("XenXorX"));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText(""));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
    }

    @Test
    public void saveWrongName() {
        closeSoftKeyboard();
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).perform(scrollTo(), replaceText("ภาษาไทย"));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("XenXorX@gmail.com"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
    }

    @Test
    public void saveWrongEmail() {
        closeSoftKeyboard();
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).perform(scrollTo(), replaceText("XenXorX"));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("XenXorXgmailcom"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
    }

    @Test
    public void revertTest() {
        closeSoftKeyboard();
        onView(withId(R.id.userNameInput)).perform(scrollTo(), replaceText("XenXorX"));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("XenXorX@gmail.com"));
        closeSoftKeyboard();
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).check(matches(withText("")));
        onView(withId(R.id.emailInput)).check(matches(withText("")));
    }
}
