package ru.iteco.fmhandroid.ui;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.pages.AuthPage;
import ru.iteco.fmhandroid.pages.ClaimPage;
import ru.iteco.fmhandroid.pages.EditNewsPage;
import ru.iteco.fmhandroid.pages.MainPage;
import ru.iteco.fmhandroid.pages.NewClaimPage;
import ru.iteco.fmhandroid.pages.NewNewsPage;
import ru.iteco.fmhandroid.pages.NewsPage;
import ru.iteco.fmhandroid.pages.TapBarPage;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class NewsTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        try {
            MainPage.loadMainPage();
            TapBarPage.tapBar();
            TapBarPage.tapNews();
        } catch (Exception e) {
            AuthPage.loadAuthPage();
            AuthPage.textInputCorrectBothAuth();
            AuthPage.pressSignButton();
            MainPage.loadMainPage();
            TapBarPage.tapBar();
            TapBarPage.tapNews();
        }
    }

    @Test
    public void testCase48AddNews() {
        NewsPage.editNews();
        EditNewsPage.loadEditNewsPage();
        EditNewsPage.addNews();
        NewNewsPage.loadNewNewsPage();
        NewNewsPage.checkNewsName();
    }
//    @Test
//    public void testCase55AddNewsPositive() throws InterruptedException {
//        NewsPage.editNews();
//        EditNewsPage.loadEditNewsPage();
//        EditNewsPage.addNews();
//        NewNewsPage.loadNewNewsPage();
//        NewNewsPage.chooseCategory();
//        NewNewsPage.nameNews();
//        NewNewsPage.nowDate();
//        NewNewsPage.nowTime();
//        NewNewsPage.descriptionNews();
//        NewNewsPage.saveNews();
//        EditNewsPage.loadEditNewsPage();
//        EditNewsPage.checkNameOfFirst();
//    }
}
