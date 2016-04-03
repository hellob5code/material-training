package fr.erictruong.material.training.ui.components.text_fields

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.erictruong.material.training.R
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.nestedScrollView

class TextFieldsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return TextFieldsFragmentUI().createView(AnkoContext.create(context, this))
    }
}

class TextFieldsFragmentUI : AnkoComponent<Fragment> {

    override fun createView(ui: AnkoContext<Fragment>) = with(ui) {
        nestedScrollView {
            verticalLayout {
                padding = dimen(R.dimen.padding_medium)
                bottomPadding += dimen(R.dimen.action_bar_size)
                textView("Labels")
                button("Floating inline labels #1") { onClick { ctx.startActivity<RegisterApplicationActivity>() } }
                button("Floating inline labels #2") { onClick { ctx.startActivity<RegisterReminderActivity>() } }

                textView("Single-line text field")
                button("Single-line text field #1") { onClick { ctx.startActivity<RegisterEventActivity>() } }
                button("Single-line text field #2") { onClick { ctx.startActivity<RegisterContactActivity>() } }

                textView("Multi-line text field")
                button("Multi-line text field") { onClick { ctx.startActivity<RegisterApplicationActivity>() } }

                textView("Full-width text field")
                button("Full-width text field") { onClick { ctx.startActivity<ComposeEmailActivity>() } }

                textView("Character counter")
                button("Single line with character counter") { onClick { ctx.startActivity<RegisterNoteActivity>() } }
                button("Multi-line with character counter") { onClick { ctx.startActivity<RegisterNoteActivity>() } }
                button("Full-width text field with character counter") { onClick { ctx.startActivity<ComposeEmailActivity>() } }

                textView("Auto-complete text field")
                button("Auto-complete text field in dropdown") { onClick { /*ctx.startActivity<Activity>()*/ } }.enabled = false
                button("Inset auto-complete") { onClick { /*ctx.startActivity<Activity>()*/ } }.enabled = false
                button("Full-width inline auto-complete") { onClick { /*ctx.startActivity<Activity>()*/ } }.enabled = false
                button("In-line auto-complete") { onClick { /*ctx.startActivity<Activity>()*/ } }.enabled = false

                textView("Search filter")
                button("The app bar acts as a text input field") { onClick { /*ctx.startActivity<Activity>()*/ } }.enabled = false

                textView("Required fields")
                button("Required fields are marked with an asterisk") { onClick { /*ctx.startActivity<RegisterDmvApplicationActivity>()*/ } }.enabled = false

                textView("Password input")
                button("Password input is disguised by default") { onClick { /*ctx.startActivity<Activity>()*/ } }.enabled = false
            }
        }
    }
}
