package ru.iteco.fmhandroid.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import static ru.iteco.fmhandroid.data.Utils.childAtPosition;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.data.Utils;

public class NewsPage {
    private static int newsContainer = R.id.container_list_news_include;

    public static void loadNewsPage() {
        onView(isRoot()).perform(Utils.waitDisplayed(newsContainer, 5000));
    }
    public static void checkNewsName(){
        ViewInteraction textView = onView(childAtPosition(
                childAtPosition(
                        withId(newsContainer),
                        0),
                0));
        textView.check(matches(withText("News")));
    }
}
