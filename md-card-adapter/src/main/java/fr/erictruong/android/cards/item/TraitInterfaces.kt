package fr.erictruong.android.cards.item

import android.support.v7.widget.helper.ItemTouchHelper
import android.view.View

interface Textable {
    var text1: CharSequence
}

interface Headlineable {
    var headline: CharSequence
}

interface Displayable {
    var display: CharSequence
}

interface Bodyable {
    var body: CharSequence
}

interface Buttonable {
    var text: CharSequence?
    var action: () -> Unit?
}

interface SixButtonable {
    var button1: Buttonable?
    var button2: Buttonable?
    var button3: Buttonable?
    var button4: Buttonable?
    var button5: Buttonable?
    var button6: Buttonable?

//    var button1Text: CharSequence?
//    var button2Text: CharSequence?
//    var button3Text: CharSequence?
//    var button4Text: CharSequence?
//    var button5Text: CharSequence?
//    var button6Text: CharSequence?
//    var button1Action: (view: View, item: Buttonable) -> Unit?
//    var button2Action: (view: View, item: Buttonable) -> Unit?
//    var button3Action: (view: View, item: Buttonable) -> Unit?
//    var button4Action: (view: View, item: Buttonable) -> Unit?
//    var button5Action: (view: View, item: Buttonable) -> Unit?
//    var button6Action: (view: View, item: Buttonable) -> Unit?
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
