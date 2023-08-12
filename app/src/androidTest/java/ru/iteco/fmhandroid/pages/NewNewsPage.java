package ru.iteco.fmhandroid.pages;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;
import static ru.iteco.fmhandroid.data.Utils.childAtPosition;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.RootMatchers;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.data.Data;
import ru.iteco.fmhandroid.data.Utils;

public class NewNewsPage {

    private static int nameCreating = R.id.custom_app_bar_title_text_view;
    private static int nameNews = R.id.custom_app_bar_sub_title_text_view;
    private static int chooseCategory = R.id.text_input_end_icon;
    private static int nameField = R.id.news_item_title_text_input_edit_text;
    private static int dateField = R.id.news_item_publish_date_text_input_edit_text;
    private static int timeField = R.id.news_item_publish_time_text_input_edit_text;
    private static int descriptionField = R.id.news_item_description_text_input_edit_text;

    public static void loadNewNewsPage() {
        onView(isRoot()).perform(Utils.waitDisplayed(nameCreating, 5000));
    }

    public static void checkNewsName(){
        ViewInteraction textView = onView(withId(nameNews));
        textView.check(matches(withText("News")));
    }
    public static void chooseCategory() {
        onView(allOf(withId(chooseCategory),
                withContentDescription("Show dropdown menu")))
                    .perform(click());
        onView(withText("Объявление"))
                .inRoot(RootMatchers.isPlatformPopup())
                    .perform(click());
    }
    public static void nameNews() {
        onView(withId(nameField))
                .perform(replaceText("Объявление2208"));
    }
    public static void nowDate() {
        onView(withId(dateField)).perform(click());
        onView(allOf(withId(android.R.id.button1), withText("OK")))
                .perform(click());
    }
    public static void nowTime() {
        onView(withId(timeField)).perform(click());
        onView(allOf(withId(android.R.id.button1), withText("OK")))
                .perform(click());
    }
    public static void descriptionNews() {
        onView(withId(descriptionField))
                .perform(replaceText("2208"));
    }
    public static void saveNews() {
        onView(withId(R.id.save_button)).perform(click());
    }
}
