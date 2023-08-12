package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.pages.AuthPage;
import ru.iteco.fmhandroid.pages.MainPage;
import ru.iteco.fmhandroid.pages.TapBarPage;
import ru.iteco.fmhandroid.ui.AppActivity;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AuthtorizationTests {

    @Before
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterAll
    static void tearDownAll() {

    }

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @After
    public void SetOut(){
        try {
            TapBarPage.logOut();
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
