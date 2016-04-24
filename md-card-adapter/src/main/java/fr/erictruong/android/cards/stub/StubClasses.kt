package fr.erictruong.android.cards.stub

import android.view.View
import android.widget.TextView
import fr.erictruong.android.cards.Bindable
import fr.erictruong.android.cards.R
import fr.erictruong.android.cards.item.Bodyable
import fr.erictruong.android.cards.item.Displayable
import fr.erictruong.android.cards.item.Headlineable

open class Stub(val itemView: View)

class DisplayStub(itemView: View) : Stub(itemView), Bindable<Displayable> {

    private val display: TextView

    init {
        display = itemView.findViewById(R.id.display) as TextView
    }

    override fun bind(item: Displayable) {
        if (item.displayColor != null) {
            display.setTextColor(item.displayColor as Int)
        }
        if (item.display.length == 0) {
            display.visibility = View.GONE
        } else {
            display.visibility = View.VISIBLE
            display.text = item.display
        }
    }

    override fun unbind() {
        // Nothing to do
    }
}

class HeadlineStub(itemView: View) : Stub(itemView), Bindable<Headlineable> {

    private val headline: TextView

    init {
        headline = itemView.findViewById(R.id.headline) as TextView
    }

    override fun bind(item: Headlineable) {
        if (item.headlineColor != null) {
            headline.setTextColor(item.headlineColor as Int)
        }
        if (item.headline == null || item.headline.length == 0) {
            headline.visibility = View.GONE
        } else {
            headline.visibility = View.VISIBLE
            headline.text = item.headline
        }
    }

    override fun unbind() {
        // Nothing to do
    }
}

class BodyStub(itemView: View) : Stub(itemView), Bindable<Bodyable> {

    private val body: TextView

    init {
        body = itemView.findViewById(R.id.body) as TextView
    }

    override fun bind(item: Bodyable) {
        if (item.bodyAppearance != null) {
            body.setTextAppearance(item.bodyAppearance as Int)
        }
        if (item.body.length == 0) {
            body.visibility = View.GONE
        } else {
            body.visibility = View.VISIBLE
            body.text = item.body
        }
    }

    override fun unbind() {
        // Nothing to do
    }
}
