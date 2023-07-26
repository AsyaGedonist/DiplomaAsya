package ru.iteco.fmhandroid.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.data.Utils.childAtPosition;
import static ru.iteco.fmhandroid.data.Utils.waitDisplayed;

import android.annotation.SuppressLint;

import ru.iteco.fmhandroid.R;

public class MainPage {
    public static int mainImage = R.id.trademark_image_view;
    public static int claimContainer = R.id.container_list_claim_include_on_fragment_main;
    public static int newsContainer = R.id.container_list_news_include_on_fragment_main;
    public static int newClaim = R.id.add_new_claim_material_button;

    public static void loadMainPage() {
        onView(isRoot()).perform(waitDisplayed(mainImage, 5000));
    }

    public static void addNewClaim(){
        onView(withId(newClaim)).perform(click());
    }
    public static void addNewClaimWithPosition(){
        onView(allOf(childAtPosition(
                childAtPosition(withId(claimContainer),0), 2)))
                    .perform(click());
    }

    public static void addNewsWithPosition(){
        onView(allOf(childAtPosition(
                childAtPosition(withId(newsContainer),0), 2)))
                .perform(click());
    }

}
