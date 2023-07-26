package ru.iteco.fmhandroid.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import static ru.iteco.fmhandroid.data.Utils.childAtPosition;

import ru.iteco.fmhandroid.R;

public class TapBarPage {
    public static int logOutImage = R.id.authorization_image_button;
    public static int logOutButton = android.R.id.title;
    public static int mainMenu = R.id.main_menu_image_button;
    public static int tapBar = android.R.id.title;
    public static int tapContent = android.R.id.content;
    public static int ourMission = R.id.our_mission_image_button;
    public static void logOut(){
        onView(withId(logOutImage)).perform(click());
        onView(withId(logOutButton)).perform(click());
    }
    public static void tapBar(){
        onView(withId(mainMenu)).perform(click());
    }
    public static void tapClaims(){
        onView(allOf(withId(tapBar), withText("Claims"),
                childAtPosition(childAtPosition(
                        withId(tapContent),0), 0)))
                .perform(click());
    }
    public static void tapNews(){
        onView(allOf(withId(tapBar), withText("News"),
                childAtPosition(childAtPosition(
                        withId(tapContent),0), 0)))
                .perform(click());
    }
    public static void tapAbout(){
        onView(allOf(withId(tapBar), withText("About"),
                childAtPosition(childAtPosition(
                        withId(tapContent),0), 0)))
                .perform(click());
    }

    public static void tapOurMission(){
        onView(withId(ourMission)).perform(click());
    }

}
