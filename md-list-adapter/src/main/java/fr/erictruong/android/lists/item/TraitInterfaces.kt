package fr.erictruong.android.lists.item

import android.support.v7.widget.helper.ItemTouchHelper
import android.view.View

interface Textable {
    var text1: CharSequence
    var text2: CharSequence?
    var text3: CharSequence?
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
