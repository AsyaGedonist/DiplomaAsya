package ru.iteco.fmhandroid.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static ru.iteco.fmhandroid.data.Utils.waitDisplayed;

import ru.iteco.fmhandroid.R;

public class MainPage {
    public static int mainImage = R.id.trademark_image_view;
    public static int logOutImage = R.id.authorization_image_button;
    public static int logOutButton = android.R.id.title;
    public static void loadMainPage() {
        onView(isRoot()).perform(waitDisplayed(mainImage, 5000));
    }

    public static void logOut(){
        onView(withId(logOutImage)).perform(click());
        onView(withId(logOutButton)).perform(click());
    }
}
