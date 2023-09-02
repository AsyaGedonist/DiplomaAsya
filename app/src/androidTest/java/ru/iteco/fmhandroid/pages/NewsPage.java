package ru.iteco.fmhandroid.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import static ru.iteco.fmhandroid.data.Utils.childAtPosition;
import static ru.iteco.fmhandroid.pages.NewNewsPage.description;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.data.Utils;

public class NewsPage {
    private static int newsContainer = R.id.container_list_news_include;
    private static int editNews = R.id.edit_news_material_button;


    public static void loadNewsPage() {
        Allure.step("Загрузка страницы Новостей");
        onView(isRoot()).perform(Utils.waitDisplayed(newsContainer, 5000));
    }
    public static void checkNamesPage(){
        Allure.step("Проверка загрузки страницы Новостей");
        ViewInteraction textView = onView(childAtPosition(
                childAtPosition(
                        withId(newsContainer),
                        0),
                0));
        textView.check(matches(withText("News")));
    }
    public static void editNews(){
        Allure.step("Редактировать новости");
        onView(withId(editNews)).perform(click());
    }
    public static void openFirstNews(){
        Allure.step("Открыть описание первой новости");
        onView(withId(R.id.news_list_recycler_view))
                .perform(actionOnItemAtPosition(0, click()));
    }

    public static void loadDescription() {
        Allure.step("Загрузка описания новости");
        onView(isRoot())
                .perform(Utils.waitDisplayed(R.id.news_item_description_text_view, 5000));
    }

    public static void checkDescription() {
        Allure.step("Проверка описания новости");
        ViewInteraction textView = onView(
                allOf(withId(R.id.news_item_description_text_view), withText(description),
                        withParent(withParent(withId(R.id.news_item_material_card_view))),
                        isDisplayed()));
        textView.check(matches(withText(description)));

    }
}
