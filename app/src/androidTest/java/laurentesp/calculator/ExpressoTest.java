package laurentesp.calculator;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by SOEOSSA on 07/10/2016.
 */

public class ExpressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void checkIfActivityIsVisible(){
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfButton0isVisible(){
        onView(withId(R.id.button_0)).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfButton1isVisible(){
        onView(withId(R.id.button_1)).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfButton2isVisible(){
        onView(withId(R.id.button_2)).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfButton3isVisible(){
        onView(withId(R.id.button_3)).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfButton4isVisible(){
        onView(withId(R.id.button_4)).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfButton5isVisible(){
        onView(withId(R.id.button_5)).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfButton6isVisible(){
        onView(withId(R.id.button_6)).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfButton7isVisible(){
        onView(withId(R.id.button_7)).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfButton8isVisible(){
        onView(withId(R.id.button_8)).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfButton9isVisible(){
        onView(withId(R.id.button_9)).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfButtonCisVisible(){
        onView(withId(R.id.button_C)).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfButtonAddisVisible(){
        onView(withId(R.id.button_Add)).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfButtonSubisVisible(){
        onView(withId(R.id.button_Sub)).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfButtonMultisVisible(){
        onView(withId(R.id.button_Mult)).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfButtonDivisVisible(){
        onView(withId(R.id.button_Div)).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfButtonEqisVisible(){
        onView(withId(R.id.button_Eq)).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfAtLaunchZeroIsDisplayed() {
        // Press the button.
        onView(withId(R.id.text_view_0)).check(matches(withText("0")));
    }

    @Test
    public void checkIfThereIsNoZeroBeforeFirstNumber() {
        // Press the button.
        onView(withId(R.id.button_C)).perform(click());
        onView(withId(R.id.button_1)).perform(click());
        onView(withId(R.id.text_view_0)).check(matches(withText("1")));
    }

    @Test
    public void checkIfNumberConcatenates() {
        // Press the button.
        onView(withId(R.id.button_C)).perform(click());
        onView(withId(R.id.button_2)).perform(click());
        onView(withId(R.id.button_1)).perform(click());
        onView(withId(R.id.text_view_0)).check(matches(withText("21")));
    }


}
