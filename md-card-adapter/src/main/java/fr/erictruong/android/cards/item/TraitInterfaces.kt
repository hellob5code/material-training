package fr.erictruong.android.cards.item

import android.support.v7.widget.helper.ItemTouchHelper
import android.view.View

interface Textable {
    var text1: CharSequence
}

interface Displayable {
    var display: CharSequence
    var displayColor:  Int?
    var displayAppearance: Int?
}

interface Headlineable {
    var headline: CharSequence
    var headlineColor: Int?
    var headlineAppearance: Int?
}

interface Bodyable {
    var body: CharSequence
    var bodyColor: Int?
    var bodyAppearance: Int?
}

interface Buttonable {
    var text: CharSequence?
    var action: () -> Unit?
}

interface ThreeButtonable {
    var button1: CharSequence?
    var button1Action: (() -> Unit)?
    var button2: CharSequence?
    var button2Action: (() -> Unit)?
    var button3: CharSequence?
    var button3Action: (() -> Unit)?
}

interface SixButtonable {
    var button1: CharSequence?
    var button1Action: (() -> Unit)?
    var button2: CharSequence?
    var button2Action: (() -> Unit)?
    var button3: CharSequence?
    var button3Action: (() -> Unit)?
    var button4: CharSequence?
    var button4Action: (() -> Unit)?
    var button5: CharSequence?
    var button5Action: (() -> Unit)?
    var button6: CharSequence?
    var button6Action: (() -> Unit)?
}

interface Iconable {
    var icon: Int
}

interface Avatarable {
    var avatarUrl: String
}

interface Checkable {
    var isChecked: Boolean
    var checkAction: (view: View, item: Checkable) -> Unit
}

interface Reorderable {
    var itemTouchHelper: ItemTouchHelper
}
