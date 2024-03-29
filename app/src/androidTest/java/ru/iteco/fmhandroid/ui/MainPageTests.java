package ru.iteco.fmhandroid.ui;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.pages.AuthPage;
import ru.iteco.fmhandroid.pages.MainPage;
import ru.iteco.fmhandroid.pages.NewClaimPage;
import ru.iteco.fmhandroid.pages.NewNewsPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class MainPageTests {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    @Before
    public void setUp() {
        try {
            MainPage.loadMainPage();
        } catch (Exception e) {
            AuthPage.loadAuthPage();
            AuthPage.textInputCorrectBothAuth();
            AuthPage.pressSignButton();
            MainPage.loadMainPage();
        }
    }
    @Test
    public void testCase39AddClaimFromMain() {
        MainPage.addNewClaim();
        NewClaimPage.loadNewClaimPage();
        NewClaimPage.checkClaimsName();
    }

    @Test
    public void testCase38AddNewsFromMain() {
        MainPage.addNewsWithPosition();
        NewNewsPage.loadNewNewsPage();
        NewNewsPage.checkNewsName();
    }
}
