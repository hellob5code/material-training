package fr.erictruong.training.material.matcher;

import android.support.test.espresso.matcher.BoundedMatcher;
import fr.erictruong.training.material.ui.tile.NavigationDrawerChild;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

import static android.support.test.internal.util.Checks.checkNotNull;
import static org.hamcrest.Matchers.equalTo;

public class CustomMatchers {

    public static Matcher<Object> withNavigationDrawerChildText(String expectedText) {
        checkNotNull(expectedText);
        return withNavigationDrawerChildText(equalTo(expectedText));
    }

    public static Matcher<Object> withNavigationDrawerChildText(final Matcher<String> itemTextMatcher) {
        checkNotNull(itemTextMatcher);
        return new BoundedMatcher<Object, NavigationDrawerChild>(NavigationDrawerChild.class) {
            @Override
            public boolean matchesSafely(NavigationDrawerChild child) {
                return itemTextMatcher.matches(child.getText());
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("(text is equals to ");
                itemTextMatcher.describeTo(description);
                description.appendText(")");
            }
        };
    }
}
