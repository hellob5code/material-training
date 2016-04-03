package fr.erictruong.material.training.ui.components.text_fields

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import fr.erictruong.material.training.R
import fr.erictruong.material.training.extension.consume
import org.jetbrains.anko.toast

class RegisterContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_contact)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.validate, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_validate -> consume { onActionValidate() }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun onActionValidate() {
        // TODO
        toast("Placeholder action")
        finish()
    }
}
