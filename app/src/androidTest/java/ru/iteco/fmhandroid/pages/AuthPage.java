package ru.iteco.fmhandroid.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.data.Data;
import ru.iteco.fmhandroid.data.Utils;

public class AuthPage {
    private static int auth = R.id.nav_host_fragment;
    private static int loginField = R.id.login_text_input_layout;
    private static int passField = R.id.password_text_input_layout;
    private static int signButton = R.id.enter_button;


    public static void loadAuthPage() {
        onView(isRoot()).perform(Utils.waitDisplayed(loginField, 5000));
    }

    public static void textInputCorrectLoginField(){
        onView(withId(loginField)).perform(click());
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginField),
                        0), 0)))
                .perform(replaceText(Data.correctUser().getLogin()), closeSoftKeyboard());
    }
    public static void textInputCorrectPassField(){
        onView(withId(passField)).perform(click());
        onView(
                allOf(childAtPosition(childAtPosition(withId(passField),
                        0), 0)))
                .perform(replaceText(Data.correctUser().getPassword()), closeSoftKeyboard());
    }
    public static void textInputInCorrectPassField(){
        onView(withId(passField)).perform(click());
        onView(
                allOf(childAtPosition(childAtPosition(withId(passField),
                        0), 0)))
                .perform(replaceText(Data.inCorrectUser().getPassword()), closeSoftKeyboard());
    }
    public static void textInputCorrectBothAuth(){
        onView(withId(loginField)).perform(click());
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginField),
                        0), 0)))
                .perform(replaceText(Data.correctUser().getLogin()));
        onView(withId(passField)).perform(click());
        onView(
                allOf(childAtPosition(childAtPosition(withId(passField),
                        0), 0)))
                .perform(replaceText(Data.correctUser().getPassword()), closeSoftKeyboard());
    }
    public static void pressSignButton(){
        onView(withId(signButton)).perform(click());
    }

    public static void checkWrongLoginPass(){
        onView(allOf(withText("Wrong login or password3"), isDisplayed()));
    }
    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };

    }
}