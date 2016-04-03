package fr.erictruong.material.training.ui.components.text_fields

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.view.Menu
import android.view.MenuItem
import fr.erictruong.material.training.R
import fr.erictruong.material.training.extension.consume
import org.jetbrains.anko.onFocusChange
import org.jetbrains.anko.toast
import kotlinx.android.synthetic.main.activity_register_dmv_application.register_dmv_application_til_first_name as tilFirstName
import kotlinx.android.synthetic.main.activity_register_dmv_application.register_dmv_application_til_middle_name as tilMiddleName
import kotlinx.android.synthetic.main.activity_register_dmv_application.register_dmv_application_til_last_name as tilLastName
import kotlinx.android.synthetic.main.activity_register_dmv_application.register_dmv_application_edt_first_name as edtFirstName
import kotlinx.android.synthetic.main.activity_register_dmv_application.register_dmv_application_edt_middle_name as edtMiddleName
import kotlinx.android.synthetic.main.activity_register_dmv_application.register_dmv_application_edt_last_name as edtLastName

class RegisterDmvApplicationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_dmv_application)

        tilFirstName.isErrorEnabled = true
        tilMiddleName.isErrorEnabled = true
        tilLastName.isErrorEnabled = true

        edtMiddleName.onFocusChange { view, hasFocus ->
            if (hasFocus) {
                tilMiddleName.error = "Example of helper text on focus only"
            } else {
                tilMiddleName.error = ""
            }
        }
        tilLastName.error = "Example of persistent helper text"
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
