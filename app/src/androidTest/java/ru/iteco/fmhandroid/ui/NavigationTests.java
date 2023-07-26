package ru.iteco.fmhandroid.ui;

import androidx.test.espresso.action.Tap;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.pages.AboutPage;
import ru.iteco.fmhandroid.pages.AuthPage;
import ru.iteco.fmhandroid.pages.ClaimPage;
import ru.iteco.fmhandroid.pages.MainPage;
import ru.iteco.fmhandroid.pages.NewsPage;
import ru.iteco.fmhandroid.pages.OurMissionPage;
import ru.iteco.fmhandroid.pages.TapBarPage;
import ru.iteco.fmhandroid.ui.AppActivity;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class NavigationTests {

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
    public void testCase28goToClaims(){
        TapBarPage.tapBar();
        TapBarPage.tapClaims();
        ClaimPage.loadClaimPage();
        ClaimPage.checkClaimsName();
    }

    @Test
    public void testCase30goToNews(){
        TapBarPage.tapBar();
        TapBarPage.tapNews();
        NewsPage.loadNewsPage();
        NewsPage.checkNewsName();
    }

    @Test
    public void testCase32goToAbout(){
        TapBarPage.tapBar();
        TapBarPage.tapAbout();
        AboutPage.loadAboutPage();
        AboutPage.checkLabelName();
    }

    @Test
    public void testCase34goOurMission(){
        TapBarPage.tapOurMission();
        OurMissionPage.loadMissionPage();
        OurMissionPage.checkMissionName();
    }
}
