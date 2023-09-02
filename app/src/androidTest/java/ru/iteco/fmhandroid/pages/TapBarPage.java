package ru.iteco.fmhandroid.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import static ru.iteco.fmhandroid.data.Utils.childAtPosition;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class TapBarPage {
    public static int logOutImage = R.id.authorization_image_button;
    public static int logOutButton = android.R.id.title;
    public static int mainMenu = R.id.main_menu_image_button;
    public static int tapBar = android.R.id.title;
    public static int tapContent = android.R.id.content;
    public static int ourMission = R.id.our_mission_image_button;
    public static void logOut(){
        Allure.step("Выйти из личного кабинета");
        onView(withId(logOutImage)).perform(click());
        onView(withId(logOutButton)).perform(click());
    }
    public static void tapBar(){
        Allure.step("Открыть меню TapBar");
        onView(withId(mainMenu)).perform(click());
    }
    public static void tapClaims(){
        Allure.step("Открыть претензии из TapBar");
        onView(allOf(withId(tapBar), withText("Claims"),
                childAtPosition(childAtPosition(
                        withId(tapContent),0), 0)))
                .perform(click());
    }
    public static void tapNews(){
        Allure.step("Открыть новости из TapBar");
        onView(allOf(withId(tapBar), withText("News"),
                childAtPosition(childAtPosition(
                        withId(tapContent),0), 0)))
                .perform(click());
    }
    public static void tapAbout(){
        Allure.step("Открыть страницу About из TapBar");
        onView(allOf(withId(tapBar), withText("About"),
                childAtPosition(childAtPosition(
                        withId(tapContent),0), 0)))
                .perform(click());
    }

    public static void tapOurMission(){
        Allure.step("Открыть блок Цитат из TapBar");
        onView(withId(ourMission)).perform(click());
    }

}
