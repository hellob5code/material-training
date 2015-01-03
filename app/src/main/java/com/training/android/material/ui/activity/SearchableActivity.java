package com.training.android.material.ui.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import com.training.android.material.R;

public class SearchableActivity extends Activity {

    private static final String TAG = SearchableActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchable);
        ActionBar toolbar = getActionBar();
        if (toolbar != null) {
            toolbar.setIcon(R.drawable.action_ic_search);
            toolbar.setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_searchable, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName())); // Assumes current activity is the searchable activity
        searchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by default

        searchView.setQueryHint(getString(R.string.searchable_hint_search, "stuff"));

        // Use icon as margin to align search edittext to keyline
        int searchMagIconId = getResources().getIdentifier("android:id/search_mag_icon", null, null);
        ImageView searchMagIcon = (ImageView) searchView.findViewById(searchMagIconId);
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
