package laurentesp.calculator;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
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

    @Before
    public void initCalc(){
        // Launch before each tests
        onView(withId(R.id.button_C)).perform(click());
    }

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
        onView(withId(R.id.text_view_0)).check(matches(withText("0")));
    }

    @Test
    public void checkIfThereIsNoZeroBeforeFirstNumber() {
        onView(withId(R.id.button_1)).perform(click());
        onView(withId(R.id.text_view_0)).check(matches(withText("1")));
    }

    @Test
    public void checkIfNumberConcatenates() {
        onView(withId(R.id.button_2)).perform(click());
        onView(withId(R.id.button_1)).perform(click());
        onView(withId(R.id.text_view_0)).check(matches(withText("21")));
    }

    @Test
    public void checkIfOperatorDoesNotChangeTheDisplay() {
        onView(withId(R.id.button_2)).perform(click());
        onView(withId(R.id.button_1)).perform(click());
        onView(withId(R.id.button_Add)).perform(click());
        onView(withId(R.id.text_view_0)).check(matches(withText("21")));
    }

    @Test
    public void checkIfAfterOperatorNewOperandIsReset() {
        onView(withId(R.id.button_2)).perform(click());
        onView(withId(R.id.button_1)).perform(click());
        onView(withId(R.id.button_Add)).perform(click());
        onView(withId(R.id.button_3)).perform(click());
        onView(withId(R.id.text_view_0)).check(matches(withText("3")));
    }

    @Test
    public void checkIfAddIsOk() {
        onView(withId(R.id.button_2)).perform(click());
        onView(withId(R.id.button_1)).perform(click());
        onView(withId(R.id.button_Add)).perform(click());
        onView(withId(R.id.button_4)).perform(click());
        onView(withId(R.id.button_Eq)).perform(click());
        onView(withId(R.id.text_view_0)).check(matches(withText("25")));
    }

    @Test
    public void checkIfSubIsOk() {
        // Press the button.
        onView(withId(R.id.button_2)).perform(click());
        onView(withId(R.id.button_1)).perform(click());
        onView(withId(R.id.button_Sub)).perform(click());
        onView(withId(R.id.button_4)).perform(click());
        onView(withId(R.id.button_Eq)).perform(click());
        onView(withId(R.id.text_view_0)).check(matches(withText("17")));
    }

    @Test
    public void checkIfDivIsOk() {
        onView(withId(R.id.button_2)).perform(click());
        onView(withId(R.id.button_1)).perform(click());
        onView(withId(R.id.button_Div)).perform(click());
        onView(withId(R.id.button_3)).perform(click());
        onView(withId(R.id.button_Eq)).perform(click());
        onView(withId(R.id.text_view_0)).check(matches(withText("7")));
    }

    @Test
    public void checkIfMultIsOk() {
        onView(withId(R.id.button_2)).perform(click());
        onView(withId(R.id.button_1)).perform(click());
        onView(withId(R.id.button_Mult)).perform(click());
        onView(withId(R.id.button_3)).perform(click());
        onView(withId(R.id.button_Eq)).perform(click());
        onView(withId(R.id.text_view_0)).check(matches(withText("63")));
    }

    @Test
    public void checkIfOperatorChangedIsOk() {
        onView(withId(R.id.button_2)).perform(click());
        onView(withId(R.id.button_1)).perform(click());
        onView(withId(R.id.button_Mult)).perform(click());
        onView(withId(R.id.button_Add)).perform(click());
        onView(withId(R.id.button_3)).perform(click());
        onView(withId(R.id.button_Eq)).perform(click());
        onView(withId(R.id.text_view_0)).check(matches(withText("24")));
    }

    @Test
    public void checkIfOperandIsEmptyBeforeDot() {
        onView(withId(R.id.button_Dot)).perform(click());
        onView(withId(R.id.text_view_0)).check(matches(withText("0.")));
    }

    @Test
    public void checkIfResultIsDisplayedWhenNewOperatorIsClicked() {
        onView(withId(R.id.button_2)).perform(click());
        onView(withId(R.id.button_1)).perform(click());
        onView(withId(R.id.button_Add)).perform(click());
        onView(withId(R.id.button_3)).perform(click());
        onView(withId(R.id.button_Add)).perform(click());
        onView(withId(R.id.text_view_0)).check(matches(withText("24")));
    }

    @Test
    public void checkIfResultIsErrorWhenDivideByZero() {
        onView(withId(R.id.button_8)).perform(click());
        onView(withId(R.id.button_1)).perform(click());
        onView(withId(R.id.button_Div)).perform(click());
        onView(withId(R.id.button_0)).perform(click());
        onView(withId(R.id.button_Eq)).perform(click());
        onView(withId(R.id.text_view_0)).check(matches(withText(InstrumentationRegistry.getTargetContext().getString(R.string.error_div_by_zero))));
    }

    @Test
    public void checkIfOldResultIsErrorThenResultIsError() {
        onView(withId(R.id.button_8)).perform(click());
        onView(withId(R.id.button_1)).perform(click());
        onView(withId(R.id.button_Div)).perform(click());
        onView(withId(R.id.button_0)).perform(click());
        onView(withId(R.id.button_Eq)).perform(click());
        onView(withId(R.id.button_Add)).perform(click());
        onView(withId(R.id.button_1)).perform(click());
        onView(withId(R.id.button_Eq)).perform(click());
        onView(withId(R.id.text_view_0)).check(matches(withText(InstrumentationRegistry.getTargetContext().getString(R.string.error_div_by_zero))));
    }

    @Test
    public void checkOnlyOneDotIfMultipleClicksOnDot() {
        onView(withId(R.id.button_8)).perform(click());
        onView(withId(R.id.button_Dot)).perform(click());
        onView(withId(R.id.button_1)).perform(click());
        onView(withId(R.id.button_Dot)).perform(click());
        onView(withId(R.id.button_Dot)).perform(click());
        onView(withId(R.id.text_view_0)).check(matches(withText("8.1")));
    }

    @Test
    public void checkDuplicateSecondOperand() {
        onView(withId(R.id.button_8)).perform(click());
        onView(withId(R.id.button_Dot)).perform(click());
        onView(withId(R.id.button_1)).perform(click());
        onView(withId(R.id.button_Add)).perform(click());
        onView(withId(R.id.button_Eq)).perform(click());
        onView(withId(R.id.text_view_0)).check(matches(withText("16.2")));
    }

    @Test
    public void checkIfNoFirstOperand() {
        onView(withId(R.id.button_Add)).perform(click());
        onView(withId(R.id.button_4)).perform(click());
        onView(withId(R.id.button_Eq)).perform(click());
        onView(withId(R.id.text_view_0)).check(matches(withText("4")));
    }



}
