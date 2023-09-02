package ru.iteco.fmhandroid.ui;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.pages.AboutPage;
import ru.iteco.fmhandroid.pages.AuthPage;
import ru.iteco.fmhandroid.pages.MainPage;
import ru.iteco.fmhandroid.pages.TapBarPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
//@RunWith(AndroidJUnit4.class)
public class AboutLinksTests {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        try {
            MainPage.loadMainPage();
            TapBarPage.tapBar();
            TapBarPage.tapAbout();
        } catch (Exception e) {
            AuthPage.loadAuthPage();
            AuthPage.textInputCorrectBothAuth();
            AuthPage.pressSignButton();
            MainPage.loadMainPage();
            TapBarPage.tapBar();
            TapBarPage.tapAbout();
        }
    }

    @Test
    public void testCase46PrivacyPolicy(){
        AboutPage.tapPolicyLink();
    }
    @Test
    public void testCase47TermsOfUse(){
        AboutPage.tapTermsOfUse();
    }
}

