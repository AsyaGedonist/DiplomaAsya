package ru.iteco.fmhandroid.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static ru.iteco.fmhandroid.data.Utils.childAtPosition;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.data.Utils;

public class NewClaimPage {

    private static int nameCreating = R.id.custom_app_bar_title_text_view;
    private static int nameClaims = R.id.custom_app_bar_sub_title_text_view;

    public static void loadNewClaimPage() {
        Allure.step("Загрузка страницы Создания Претензии");
        onView(isRoot()).perform(Utils.waitDisplayed(nameCreating, 5000));
    }

    public static void checkClaimsName(){
        Allure.step("Проверка загрузки страницы Претензии");
        ViewInteraction textView = onView(withId(nameClaims));
        textView.check(matches(withText("Claims")));
    }
}
