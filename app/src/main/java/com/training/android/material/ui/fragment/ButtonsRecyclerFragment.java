package com.training.android.material.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.training.android.material.R;
import com.training.android.material.ui.activity.DummyInlineButtons1Activity;
import com.training.android.material.ui.activity.DummyInlineButtons2Activity;
import com.training.android.material.ui.activity.DummyInlineButtons3Activity;
import com.training.android.material.ui.activity.DummyPersistentFooterButtonsActivity;
import com.training.android.material.ui.adapter.MaterialCardAdapter;
import com.training.android.material.ui.card.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import static com.training.android.material.ui.card.Card.TYPE_PRIMARY_HEADLINE_BODY_2;

public class ButtonsRecyclerFragment extends CardFragment {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRecyclerAdapter(new MaterialCardAdapter(populateDataset()));
    }

    private List<Card> populateDataset() {
        List<Card> dataset = new ArrayList<Card>();
        dataset.add(new HeadlineBodyCard(0, TYPE_PRIMARY_HEADLINE_BODY_2, "Buttons", "A button consists of text and/or an image that clearly communicates what action will occur when the user touches it.  There are three types of main buttons:\n\n\u2022 Floating action button: a circular button made of paper that lifts and emits ink reactions on press.\n\u2022 Raised button: a typically rectangular button made of paper that lifts and emits ink reactions on press.\n\u2022 Flat button: a button made of ink that emits ink reactions on press but does not lift.\nIn addition, fully saturated icons in your design generally always denote affordances.\n\nButtons should be designed in accordance with your app’s color theme."));
        dataset.add(new SubheaderCard(0, "Usage"));
        dataset.add(new RichAreaHeadlineBodyCard(0, R.layout.btn_raised, "Raised button", null));
        dataset.add(new RichAreaHeadlineBodyCard(0, R.layout.btn_flat, "Flat button", null));
        dataset.add(new HeadlineBodyCard(0, "Choosing button style", "Choosing a button style depends on the primacy of the button, the number of containers on screen, and the overall layout of the screen.\n\nFirst, look at the button’s function: is it important and ubiquitous enough to be a floating action button?\n\nNext, choose raised or flat dimensionality depending on the container it will be in and how many z-space layers you have on screen. There should not be layers upon layers upon layers of objects on the screen.\n\nFinally, look at your specific layout. You should primarily use one type of button per container. Only mix button types when you have a good reason to, such as emphasizing an important function."));
        dataset.add(new HeadlineBodyThreeButtonCard(0, "Buttons in dialogs", "Use ink buttons on dialogs to prevent too many layers of dimension.",
                "Example #1",
                null));
        dataset.add(new HeadlineBodyThreeButtonCard(0, "Buttons inline", "Choose raised or flat buttons depending on your specific layout. Make sure to allow enough padding around flat buttons so the user can easily find them.",
                "Example #1",
                new Callable() {
                    public Void call() {
                        startActivity(new Intent(getActivity(), DummyInlineButtons1Activity.class));
                        return null;
                    }
                }));
        dataset.add(new HeadlineBodyThreeButtonCard(0, "Persistent footer buttons", "If your app requires actions to be persistent and readily available to the user, first consider using the floating action button.\n\nIf a floating action button isn’t quite right, but the button still needs to be easy to access, consider persistent footer buttons.\n\nNever use raised buttons within persistent button areas.\n\nWith the addition of a divider, a persistent footer button can also be used for scrollable dialogs.",
                "Example #1",
                new Callable() {
                    public Void call() {
                        startActivity(new Intent(getActivity(), DummyPersistentFooterButtonsActivity.class));
                        return null;
                    }
                }));
        dataset.add(new SubheaderCard(0, "Flat & raised buttons"));
        dataset.add(new HeadlineBodySixVerticalButtonCard(0, "Raised buttons", "Raised buttons emphasize functions that would otherwise get lost on a busy or wide space. They add dimension to mostly flat layouts.",
                "Use raised buttons to give more prominence to actions in layouts with a lot of varying content.",
                "Raised buttons can even help delineate sections of content on a page.",
                "Raised buttons stand out more than flat buttons.",
                new Callable() {
                    public Void call() {
                        startActivity(new Intent(getActivity(), DummyInlineButtons2Activity.class));
                        return null;
                    }
                },
                new Callable() {
                    public Void call() {
                        startActivity(new Intent(getActivity(), DummyInlineButtons3Activity.class));
                        return null;
                    }
                },
                null));
        dataset.add(new HeadlineBodyThreeButtonCard(0, "Flat buttons", "Use flat buttons for contexts such as toolbars and dialogs to avoid gratuitous layering.",
                "Example #1",
                "Example #2",
                "Example #3",
                null,
                null,
                null));
        dataset.add(new HeadlineBodySixVerticalButtonCard(0, "Flat and raised button states", "Button states for mocks:\n\nRaised buttons behave like a piece of material resting on another sheet – they lift and color on press.\nFlat buttons are printed on the material. They do not lift but fill with color on press.\nWhen representing button states in mocks, use graphic rings to represent the focus states.",
                "Flat Light/Light theme",
                "Flat Dark/Dark theme",
                "Raised Light/Light theme",
                "Raised Dark/Dark theme",
                null,
                null,
                null,
                null));
        dataset.add(new HeadlineBodyThreeButtonCard(0, "A note on accessibility", "To ensure usability for people with disabilities, make sure that your buttons have a height of 36dp, but that the touchable target has a minimum height of 48dp.",
                "Example #1",
                null));
        dataset.add(new SubheaderCard(0, "Floating action button"));
        dataset.add(new HeadlineBodyThreeButtonCard(0, "Floating action button", "Floating action buttons are used for a special type of promoted action. They are distinguished by a circled icon floating above the UI and have special motion behaviors related to morphing, launching, and the transferring anchor point.\n\nFloating action buttons come in two sizes: the default, which should be used in most cases, and the mini, which should only be used to create visual continuity with other elements on the screen.\n\nThe floating action button should be placed 16dp min from the edge on mobile and 24dp min on tablet/desktop",
                "Example #1",
                "Example #2",
                null,
                null));
        dataset.add(new HeadlineBodySixVerticalButtonCard(0, "Associated content", "Not every screen needs a floating action button. A floating action button should represent the primary action in an application. In the screen on the left, the primary action is to touch images in a gallery, so no button is needed. On the right, the primary action is to add files.\n\nTry to use only one floating action button per screen, as it should represent only the most common action and is prominent on the screen.\n\nDon’t use floating action buttons in dialogs. Use a flat button.\n\nDon’t attach a floating action button to a side drawer; it could distract a user from the task they want to accomplish. Side drawers are for navigation.\n\nDon’t associate floating action buttons with pulldown menus.",
                "Example #1",
                "Example #2",
                "Example #3",
                "Example #4",
                null,
                null,
                null,
                null));
        dataset.add(new HeadlineBodySixVerticalButtonCard(0, "Related actions", "Put overflow actions in the overflow menu in toolbars, not in floating action buttons.\n\nIf the hallmark of the app is adding file types, a floating action button can morph into related actions after it is first touched.\n\nHowever, if a set of actions that appear after touching a floating action button are unrelated to the button and are not a natural extension of it, then place the actions into an overflow menu.\n\nIf a floating action button morphs into a toolbar, that toolbar should contain related actions. In this example, the button lets the user select the media type to add.\n\nDon’t morph floating action buttons into a toolbar that contains unrelated or confusing actions.\n\nA floating action button can contain a list of contacts.\n\nThe list of contacts shouldn’t contain unrelated actions.",
                "Example #1",
                "Example #2",
                "Example #3",
                "Example #4",
                "Example #5",
                "Example #6",
                null,
                null,
                null,
                null,
                null,
                null));
        dataset.add(new HeadlineBodyThreeButtonCard(0, "Qualities", "Make floating action buttons positive actions like Create, Favorite, Share, Navigate, and Explore.\n\nIn general, avoid using floating action buttons for destructive actions like Archive or Trash; nonspecific actions; alerts or errors; limited tasks like cutting text; or controls that should be in a toolbar, like volume control or changing a font color. Floating action buttons don’t contain app bar icons or status bar info like notifications. Don’t layer badges or other elements over a floating action button.\n\nUse the circle-shaped icon consistently to enforce the primary action pattern across apps.\n\nDon’t make floating action buttons bounce.",
                "Example #1",
                "Example #2",
                "Example #3",
                null,
                null,
                null));
        return dataset;
    }
}
