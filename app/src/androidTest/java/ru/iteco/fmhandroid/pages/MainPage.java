package ru.iteco.fmhandroid.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;

import static ru.iteco.fmhandroid.data.Utils.waitDisplayed;

import ru.iteco.fmhandroid.R;

public class MainPage {
    public static int mainImage = R.id.trademark_image_view;

    public static void loadMainPage() {
        onView(isRoot()).perform(waitDisplayed(mainImage, 5000));
    }

}
