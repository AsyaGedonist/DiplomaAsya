package ru.iteco.fmhandroid.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import static ru.iteco.fmhandroid.data.Utils.childAtPosition;

import android.annotation.SuppressLint;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.data.Utils;

public class ClaimPage {

    private static int claimContainer = R.id.container_list_claim_include;

    public static void loadClaimPage() {
        onView(isRoot()).perform(Utils.waitDisplayed(claimContainer, 5000));
    }

    public static void checkClaimsName(){
        ViewInteraction textView = onView(childAtPosition(
                childAtPosition(
                        withId(claimContainer),
                        0),
                0));
        textView.check(matches(withText("Claims")));
    }

}
