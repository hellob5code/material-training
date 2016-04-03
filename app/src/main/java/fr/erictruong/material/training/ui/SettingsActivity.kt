package fr.erictruong.material.training.ui

import android.os.Bundle
import android.preference.PreferenceActivity
import android.support.v4.app.NavUtils
import android.view.MenuItem

/**
 * TODO: Implement activity with PreferenceFragment.
 * PreferenceFragment is used in your ActionBarActivity when running on an API v11+ device.
 * For devices before that, this activity provides a normal PreferenceActivity which is not material-styled.
 */
class SettingsActivity : PreferenceActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this)
        }
        return super.onOptionsItemSelected(item)
    }
}
