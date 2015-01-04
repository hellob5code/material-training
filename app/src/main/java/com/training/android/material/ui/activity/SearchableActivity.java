package com.training.android.material.ui.activity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.training.android.material.R;

public class SearchableActivity extends ActionBarActivity {

    private static final String TAG = SearchableActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchable);
        ActionBar toolbar = getSupportActionBar();
        if (toolbar != null) {
            toolbar.setIcon(R.drawable.action_ic_search);
            toolbar.setDisplayShowHomeEnabled(true);
            toolbar.setDisplayShowTitleEnabled(false);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_searchable, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.search));
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName())); // Assumes current activity is the searchable activity
        searchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by default

        searchView.setQueryHint(getString(R.string.searchable_hint_search, "stuff"));

        Display display = getWindowManager().getDefaultDisplay();
        Point displaySize = new Point();
        display.getSize(displaySize);

        int offset = getResources().getDimensionPixelSize(R.dimen.material_list_icon_size_plus_16dp);
        searchView.setMaxWidth(displaySize.x - offset);

        // Use icon as margin to align search edittext to keyline
        ImageView searchMagIcon = (ImageView) searchView.findViewById(android.support.v7.appcompat.R.id.search_mag_icon);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) searchMagIcon.getLayoutParams();
        layoutParams.width = getResources().getDimensionPixelSize(R.dimen.margin_small);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Log.d(TAG, "Search query=" + query);
        }
    }
}
