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

public class OurMissionPage {
    private static int missionText = R.id.our_mission_title_text_view;

    public static void loadMissionPage() {
        onView(isRoot()).perform(Utils.waitDisplayed(missionText, 5000));
    }

    public static void checkMissionName(){
//        ViewInteraction textView = onView(childAtPosition(
//                childAtPosition(
//                        withId(claimContainer),
//                        0),
//                0));
//        textView.check(matches(withText("Claims")));
        ViewInteraction textView = onView(withId(missionText));
        textView.check(matches(withText("Love is all")));
    }
}
