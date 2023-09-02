package ru.iteco.fmhandroid.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import android.view.WindowManager;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Root;
import org.hamcrest.Description;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.allOf;

import static ru.iteco.fmhandroid.data.Utils.childAtPosition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Before;
import org.junit.Rule;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.data.Data;
import ru.iteco.fmhandroid.data.Utils;
import ru.iteco.fmhandroid.ui.AppActivity;


public class AuthPage {
    private static int auth = R.id.nav_host_fragment;
    private static int loginField = R.id.login_text_input_layout;
    private static int passField = R.id.password_text_input_layout;
    private static int signButton = R.id.enter_button;
    public static View decorView;
    private static String wrongPassOrLogin = "Wrong login or password";
    private static String lessSymbols = "Field length can't be less then 3 symbols";
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    @Before
    public void setUp() {
        mActivityScenarioRule.getScenario().onActivity(new ActivityScenario.ActivityAction<AppActivity>() {
            @Override
            public void perform(AppActivity activity) {
                decorView = activity.getWindow().getDecorView();
            }
        });
    }
    public static void loadAuthPage() {
        Allure.step("Загрузка страницы Авторизации");
        onView(isRoot()).perform(Utils.waitDisplayed(loginField, 5000));
    }

    public static void checkWrongLoginPass(){
        Allure.step("Проверка сообщения об ошибке - некорректный логин или пароль");
        onView(withText(wrongPassOrLogin))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }
    public static void checkLessSymbolsLoginPass(){
        Allure.step("Проверка сообщения об ошибке - недостаточное количество символов");
        onView(withText(lessSymbols))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    public static void checkSymbolsUpperLineLoginField(){
        Allure.step("Проверка верхней границы поля Логин");
        ViewInteraction editText = onView(
                allOf(childAtPosition(childAtPosition(withId(loginField),
                        0), 0)));
        editText.check(matches(withText("12345678901234567890123456789012")));
    }
    public static void checkSymbolsUpperLinePassField(){
        Allure.step("Проверка верхней границы поля Пароль");
        ViewInteraction editText = onView(
                allOf(childAtPosition(childAtPosition(withId(passField),
                        0), 0)));
        editText.check(matches(withText("12345678901234567890123456789012")));
    }
    public static void checkNoSymbolsLoginField(){
        Allure.step("Проверка отсутсвия символов в поле");
        ViewInteraction editText = onView(
                allOf(childAtPosition(childAtPosition(withId(loginField),
                        0), 0)));
        editText.check(matches(withText("")));
    }
    public static void textInputCorrectBothAuth(){
        Allure.step("Ввод корректных данных для авторизации");
        onView(withId(loginField)).perform(click());
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginField),
                        0), 0)))
                .perform(replaceText(Data.correctUser().getLogin()));
        onView(withId(passField)).perform(click());
        onView(
                allOf(childAtPosition(childAtPosition(withId(passField),
                        0), 0)))
                .perform(replaceText(Data.correctUser().getPassword()), closeSoftKeyboard());
    }
    public static void pressSignButton(){
        Allure.step("Нажать кнопку входа");
        onView(withId(signButton)).perform(click());
    }
    public static void textInputCorrectLoginField(){
        Allure.step("Ввод корректного логина");
        onView(withId(loginField)).perform(click());
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginField),
                        0), 0)))
                .perform(replaceText(Data.correctUser().getLogin()), closeSoftKeyboard());
    }
    public static void textInputCorrectPassField(){
        Allure.step("Ввод корректного пароля");
        onView(withId(passField)).perform(click());
        onView(
                allOf(childAtPosition(childAtPosition(withId(passField),
                        0), 0)))
                .perform(replaceText(Data.correctUser().getPassword()), closeSoftKeyboard());
    }
    public static void textInputInCorrectPassField(){
        Allure.step("Ввод некорректного пароля");
        onView(withId(passField)).perform(click());
        onView(
                allOf(childAtPosition(childAtPosition(withId(passField),
                        0), 0)))
                .perform(replaceText(Data.inCorrectUser().getPassword()), closeSoftKeyboard());
    }
    public static void textInputLessSymbolsLoginField(){
        Allure.step("Ввод недостаточного количества символов в поле логин");
        onView(withId(loginField)).perform(click());
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginField),
                        0), 0)))
                .perform(replaceText(Data.bottomLineUser().getLogin()), closeSoftKeyboard());
    }
    public static void textInputLessSymbolsPassField(){
        Allure.step("Ввод недостаточного количества символов в поле пароль");
        onView(withId(passField)).perform(click());
        onView(
                allOf(childAtPosition(childAtPosition(withId(passField),
                        0), 0)))
                .perform(replaceText(Data.bottomLineUser().getPassword()), closeSoftKeyboard());
    }
    public static void textInputMoreSymbolsLoginField(){
        Allure.step("Ввод большего количества символов в поле логин");
        onView(withId(loginField)).perform(click());
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginField),
                        0), 0)))
                .perform(replaceText(Data.upperLineUser().getLogin()), closeSoftKeyboard());
    }
    public static void textInputMoreSymbolsPassField(){
        Allure.step("Ввод большего количества символов в поле пароль");
        onView(withId(passField)).perform(click());
        onView(
                allOf(childAtPosition(childAtPosition(withId(passField),
                        0), 0)))
                .perform(replaceText(Data.upperLineUser().getPassword()), closeSoftKeyboard());
    }
    public static void textInputRusSymbolsLoginField(){
        Allure.step("Ввод символов кириллицы");
        onView(withId(loginField)).perform(click());
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginField),
                        0), 0)))
                .perform(replaceText(Data.badLogin().getRusSymbols()), closeSoftKeyboard());
    }
    public static void textInputSpecSymbolsLoginField(){
        Allure.step("Ввод спец символов");
        onView(withId(loginField)).perform(click());
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginField),
                        0), 0)))
                .perform(replaceText(Data.badLogin().getSpecSymbols()), closeSoftKeyboard());
    }
    public static void textInputSpaceSymbolLoginField(){
        Allure.step("Ввод символа пробела");
        onView(withId(loginField)).perform(click());
        onView(
                allOf(childAtPosition(childAtPosition(withId(loginField),
                        0), 0)))
                .perform(replaceText(Data.badLogin().getSpaceSymbol()), closeSoftKeyboard());
    }
}