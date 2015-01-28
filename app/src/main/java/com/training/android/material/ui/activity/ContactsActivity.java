package com.training.android.material.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.SlidingPanelLayout;
import android.widget.SlidingPanelLayout.SlidingPanelState;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.training.android.material.R;
import com.training.android.material.ui.adapter.MaterialListAdapter;
import com.training.android.material.ui.listcontrol.IconListControl;
import com.training.android.material.ui.tile.SingleLineListTile;
import com.training.android.material.ui.tile.Tile;

import java.util.ArrayList;
import java.util.List;

public class ContactsActivity extends ActionBarActivity {

    @InjectView(R.id.contacts_sliding_panel) SlidingPanelLayout slidingPanel;
    @InjectView(R.id.contacts_sheet) View sheet;
    @InjectView(R.id.contacts_recycler) RecyclerView recycler;

    private List<Tile> myDataset = new ArrayList<Tile>();

    private float mLastTouchY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        ButterKnife.inject(this);
        slidingPanel.setPanelView(sheet);
        slidingPanel.enableIntermediateState(false);
        slidingPanel.enableSmallState(false);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        recycler.setHasFixedSize(true);

        myDataset.add(new SingleLineListTile(0, "Share", new IconListControl(this, R.drawable.ic_share_grey600_24dp), null));
        myDataset.add(new SingleLineListTile(0, "Upload", new IconListControl(this, R.drawable.ic_cloud_upload_grey600_24dp), null));
        myDataset.add(new SingleLineListTile(0, "Copy", new IconListControl(this, R.drawable.ic_content_copy_grey600_24dp), null));
        myDataset.add(new SingleLineListTile(0, "Print this page", new IconListControl(this, R.drawable.ic_local_print_shop_grey600_24dp), null));

        RecyclerView.Adapter adapter = new MaterialListAdapter(myDataset, true, false);
        recycler.setAdapter(adapter);
        recycler.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent event) {
                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    case (MotionEvent.ACTION_DOWN): {
                        slidingPanel.onTouchPanel(event); // Pass touch down event
                        mLastTouchY = event.getRawY(); // Remember where we started (for dragging)
                        break;
                    }
                    case MotionEvent.ACTION_MOVE: {
                        final float y = event.getRawY();
                        final float dy = y - mLastTouchY; // Calculate the distance moved

                        if (Math.abs(dy) > SlidingPanelLayout.SWIPE_MIN_DISTANCE) {
                            return true; // Do intercept
                        }

                        mLastTouchY = y;
                        break;
                    }
                    case (MotionEvent.ACTION_POINTER_UP): {
                        mLastTouchY = event.getRawY();
                        break;
                    }
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent event) {
                slidingPanel.onTouchPanel(event);
            }
        });
        recycler.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    recycler.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    recycler.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
                // Calculate list content height
                int childrenHeight = 0;
                childrenHeight += recycler.getPaddingTop();
                childrenHeight += recycler.getPaddingBottom();
                for (int i = 0; i < recycler.getChildCount(); i++) {
                    childrenHeight += recycler.getChildAt(i).getHeight();
                }
                slidingPanel.setFullPanelHeight(childrenHeight);
            }
        });
    }

    @OnClick(R.id.contacts_btn)
    protected void btnClicked() {
        SlidingPanelState state = slidingPanel.getState();

        if (state == SlidingPanelState.CLOSED) {
            slidingPanel.changeSlidingPanelState(SlidingPanelState.FULL);
        } else {
            slidingPanel.changeSlidingPanelState(state);
//            slidingPanel.postDelayed(new Runnable() {
//                public void run() {
//                }
//            }, 200);
        }
    }
}
