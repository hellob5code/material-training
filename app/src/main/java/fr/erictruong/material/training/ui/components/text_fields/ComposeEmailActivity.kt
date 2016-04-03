package fr.erictruong.material.training.ui.components.text_fields

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import fr.erictruong.material.training.R
import fr.erictruong.material.training.extension.consume
import org.jetbrains.anko.toast

class ComposeEmailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compose_email)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.send, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_send -> consume { onActionSend() }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun onActionSend() {
        // TODO
        toast("Placeholder action")
        finish()
    }
}
