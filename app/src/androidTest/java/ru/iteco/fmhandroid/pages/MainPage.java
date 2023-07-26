package ru.iteco.fmhandroid.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.data.Utils.childAtPosition;
import static ru.iteco.fmhandroid.data.Utils.waitDisplayed;

import android.annotation.SuppressLint;

import ru.iteco.fmhandroid.R;

public class MainPage {
    public static int mainImage = R.id.trademark_image_view;

    public static void loadMainPage() {
        onView(isRoot()).perform(waitDisplayed(mainImage, 5000));
    }

}
