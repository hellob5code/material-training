package fr.erictruong.material.training.ui.components.cards;

import android.content.Context;
import android.content.Intent;

import fr.erictruong.android.core.activity.RecyclerActivity;

public class SampleCardActivity extends RecyclerActivity {

    public static final String EXTRA_CARD_VIEW_TYPE = "extra_card_view_type";

    private static final int ITEM_COUNT = 15;

    public static void start(Context context, int viewType) {
        Intent starter = new Intent(context, SampleCardActivity.class);
        starter.putExtra(EXTRA_CARD_VIEW_TYPE, viewType);
        context.startActivity(starter);
    }
}
