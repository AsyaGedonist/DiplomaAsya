package ru.iteco.fmhandroid.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.data.Utils.childAtPosition;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.data.Utils;

public class AboutPage {
    private static int aboutLabel = R.id.about_company_info_label_text_view;

    public static void loadAboutPage() {
        onView(isRoot()).perform(Utils.waitDisplayed(aboutLabel, 5000));
    }
    public static void checkLabelName(){
        ViewInteraction textView = onView(withId(aboutLabel));
        textView.check(matches(withText("© I-Teco, 2022")));
    }
}
