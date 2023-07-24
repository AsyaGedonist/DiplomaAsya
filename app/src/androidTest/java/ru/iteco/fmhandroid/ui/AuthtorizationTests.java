package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isFocused;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.pages.AuthPage;
import ru.iteco.fmhandroid.pages.MainPage;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AuthtorizationTests {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @After
    public void SetOut(){
        try {
            MainPage.logOut();
        } catch (Exception e) {
        }
    }
    @Test
    public void testCase1AuthIsDisplayed() {
        AuthPage.loadAuthPage();
    }

    @Test
    public void testCase4SuccessfulAuth(){
        AuthPage.loadAuthPage();
        AuthPage.textInputCorrectBothAuth();
        AuthPage.pressSignButton();
        MainPage.loadMainPage();
    }

//    @Test
//    public void testCase6WrongPass()  {
//        AuthPage.loadAuthPage();
//        AuthPage.textInputCorrectLoginField();
//        AuthPage.textInputInCorrectPassField();
//        AuthPage.pressSignButton();
//        AuthPage.checkWrongLoginPass();
//    }

//    @Test
//    public void testCase11LoginBottomLine() {
//        AuthPage.loadAuthPage();
//        AuthPage.textInputLessSymbolsLoginField();
//        AuthPage.textInputCorrectPassField();
//        AuthPage.checkLessSymbolsLoginPass();
//    }

    @Test
    public void testCase14LoginUpperLine(){
        AuthPage.loadAuthPage();
        AuthPage.textInputMoreSymbolsLoginField();
        AuthPage.checkSymbolsUpperLineLoginField();
    }
    @Test
    public void testCase15LoginRusSymbols(){
        AuthPage.loadAuthPage();
        AuthPage.textInputRusSymbolsLoginField();
        AuthPage.checkNoSymbolsLoginField();
    }
    @Test
    public void testCase16LoginBadSpecSymbols(){
        AuthPage.loadAuthPage();
        AuthPage.textInputSpecSymbolsLoginField();
        AuthPage.checkNoSymbolsLoginField();
    }
    @Test
    public void testCase17LoginSpaceSymbol(){
        AuthPage.loadAuthPage();
        AuthPage.textInputSpaceSymbolLoginField();
        AuthPage.checkNoSymbolsLoginField();
    }
//    @Test
//    public void testCase21PassBottomLine(){
//        AuthPage.loadAuthPage();
//        AuthPage.textInputCorrectLoginField();
//        AuthPage.textInputLessSymbolsPassField();
//        check?
//    }
    @Test
    public void testCase24PassUpperLine(){
        AuthPage.loadAuthPage();
        AuthPage.textInputMoreSymbolsPassField();
        AuthPage.checkSymbolsUpperLinePassField();
    }
}
