package ru.iteco.fmhandroid.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.allOf;
import static ru.iteco.fmhandroid.data.Utils.childAtPosition;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.data.Utils;

public class EditNewsPage {

    private static int fragmentContainer = R.id.nav_host_fragment;
    private static int newsContainer =
            R.id.container_custom_app_bar_include_on_fragment_news_control_panel;
    private static int newsCard = R.id.news_item_material_card_view;
    private static int addNewsButton = R.id.add_news_image_view;

    public static void loadEditNewsPage() {
        onView(isRoot()).perform(Utils.waitDisplayed(newsContainer, 5000));
    }

    public static void addNews(){
        onView(withId(addNewsButton)).perform(click());
    }
//    public static void checkNameOfFirst() {
////        ViewInteraction textView = onView(
////                allOf(withId(R.id.news_item_title_text_view),
////                        withParent(withParent(
////                                childAtPosition(
////                                    withId(R.id.news_list_recycler_view),
////                                        0)))));
////        textView.check(matches(withText("Объявление22208")));
//    }

}
