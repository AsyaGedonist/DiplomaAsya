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
import ru.iteco.fmhandroid.pages.ClaimPage;
import ru.iteco.fmhandroid.pages.MainPage;
import ru.iteco.fmhandroid.pages.NewClaimPage;
import ru.iteco.fmhandroid.pages.TapBarPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ClaimTests {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        try {
            MainPage.loadMainPage();
            TapBarPage.tapBar();
            TapBarPage.tapClaims();
        } catch (Exception e) {
            AuthPage.loadAuthPage();
            AuthPage.textInputCorrectBothAuth();
            AuthPage.pressSignButton();
            MainPage.loadMainPage();
            TapBarPage.tapBar();
            TapBarPage.tapClaims();
        }
    }

    @Test
    public void testCase70AddNewClaim() {
        ClaimPage.addNewClaim();
        NewClaimPage.loadNewClaimPage();
        NewClaimPage.checkClaimsName();
    }
}
