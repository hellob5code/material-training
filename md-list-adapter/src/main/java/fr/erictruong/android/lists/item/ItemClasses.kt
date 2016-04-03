package fr.erictruong.android.lists.item

import android.support.annotation.DrawableRes
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.View
import fr.erictruong.android.lists.holder.*

interface MaterialListItem {
    val id: Long
    @MaterialListHolder.ViewType val viewType: Int
    val action: (view: View, item: MaterialListItem) -> Unit
}

// *********************
// Trait interfaces.
// *********************

interface Textable {
    val text1: CharSequence
    val text2: CharSequence?
    val text3: CharSequence?
}

interface Iconable {
    /*@DrawableRes*/ val icon: Int
}

interface Avatarable {
    val avatarUrl: String
}

interface Checkable {
    var isChecked: Boolean
    val checkAction: (view: View, item: Checkable) -> Unit
}

interface Reorderable {
    val itemTouchHelper: ItemTouchHelper
}

// *********************
// Single trait classes.
// *********************

data class TextItem(
        override val id: Long = RecyclerView.NO_ID,
        override val viewType: Int = MaterialListHolder.ONE_LINE,
        override val action: (view: View, item: MaterialListItem) -> Unit,
        override val text1: CharSequence,
        override val text2: CharSequence? = "",
        override val text3: CharSequence? = ""
) : MaterialListItem, Textable

data class IconItem(
        override val id: Long = RecyclerView.NO_ID,
        override val viewType: Int = MaterialListHolder.ONE_LINE,
        override val action: (view: View, item: MaterialListItem) -> Unit,
        override val text1: CharSequence,
        override val text2: CharSequence? = "",
        override val text3: CharSequence? = "",
        override val icon: Int
) : MaterialListItem, Textable, Iconable

data class AvatarItem(
        override val id: Long = RecyclerView.NO_ID,
        override val viewType: Int = MaterialListHolder.ONE_LINE,
        override val action: (view: View, item: MaterialListItem) -> Unit,
        override val text1: CharSequence,
        override val text2: CharSequence? = "",
        override val text3: CharSequence? = "",
        override val avatarUrl: String
) : MaterialListItem, Textable, Avatarable

data class CheckBoxItem(
        override val id: Long = RecyclerView.NO_ID,
        override val viewType: Int = MaterialListHolder.ONE_LINE,
        override val action: (view: View, item: MaterialListItem) -> Unit,
        override val text1: CharSequence,
        override val text2: CharSequence? = "",
        override val text3: CharSequence? = "",
        override var isChecked: Boolean = false,
        override val checkAction: (View, Checkable) -> Unit
) : MaterialListItem, Textable, Checkable

data class SwitchItem(
        override val id: Long = RecyclerView.NO_ID,
        override val viewType: Int = MaterialListHolder.ONE_LINE,
        override val action: (view: View, item: MaterialListItem) -> Unit,
        override val text1: CharSequence,
        override val text2: CharSequence? = "",
        override val text3: CharSequence? = "",
        override var isChecked: Boolean = false,
        override val checkAction: (view: View, item: Checkable) -> Unit
) : MaterialListItem, Textable, Checkable

data class ExpandItem(
        override val id: Long = RecyclerView.NO_ID,
        override val viewType: Int = MaterialListHolder.ONE_LINE,
        override val action: (view: View, item: MaterialListItem) -> Unit,
        override val text1: CharSequence,
        override val text2: CharSequence? = "",
        override val text3: CharSequence? = "",
        override var isChecked: Boolean = false,
        override val checkAction: (view: View, item: Checkable) -> Unit
) : MaterialListItem, Textable, Checkable

// *********************
// Double trait classes.
// *********************

data class AvatarIconItem(
        override val id: Long = RecyclerView.NO_ID,
        override val viewType: Int = MaterialListHolder.ONE_LINE,
        override val action: (view: View, item: MaterialListItem) -> Unit,
        override val text1: CharSequence,
        override val text2: CharSequence? = "",
        override val text3: CharSequence? = "",
        override val avatarUrl: String,
        override val icon: Int
) : MaterialListItem, Textable, Avatarable, Iconable

data class CheckBoxIconItem(
        override val id: Long = RecyclerView.NO_ID,
        override val viewType: Int = MaterialListHolder.ONE_LINE,
        override val action: (view: View, item: MaterialListItem) -> Unit,
        override val text1: CharSequence,
        override val text2: CharSequence? = "",
        override val text3: CharSequence? = "",
        override var isChecked: Boolean = false,
        override val checkAction: (view: View, item: Checkable) -> Unit,
        override val icon: Int
) : MaterialListItem, Textable, Checkable, Iconable

data class AvatarCheckBoxItem(
        override val id: Long = RecyclerView.NO_ID,
        override val viewType: Int = MaterialListHolder.ONE_LINE,
        override val action: (view: View, item: MaterialListItem) -> Unit,
        override val text1: CharSequence,
        override val text2: CharSequence? = "",
        override val text3: CharSequence? = "",
        override val avatarUrl: String,
        override var isChecked: Boolean = false,
        override val checkAction: (view: View, item: Checkable) -> Unit
) : MaterialListItem, Textable, Avatarable, Checkable

data class IconSwitchItem(
        override val id: Long = RecyclerView.NO_ID,
        override val viewType: Int = MaterialListHolder.ONE_LINE,
        override val action: (view: View, item: MaterialListItem) -> Unit,
        override val text1: CharSequence,
        override val text2: CharSequence? = "",
        override val text3: CharSequence? = "",
        override val icon: Int,
        override var isChecked: Boolean = false,
        override val checkAction: (view: View, item: Checkable) -> Unit
) : MaterialListItem, Textable, Iconable, Checkable

data class AvatarReorderItem(
        override val id: Long = RecyclerView.NO_ID,
        override val viewType: Int = MaterialListHolder.ONE_LINE,
        override val action: (view: View, item: MaterialListItem) -> Unit,
        override val text1: CharSequence,
        override val text2: CharSequence? = "",
        override val text3: CharSequence? = "",
        override val avatarUrl: String,
        override val itemTouchHelper: ItemTouchHelper
) : MaterialListItem, Textable, Avatarable, Reorderable

data class IconExpandItem(
        override val id: Long = RecyclerView.NO_ID,
        override val viewType: Int = MaterialListHolder.ONE_LINE,
        override val action: (view: View, item: MaterialListItem) -> Unit,
        override val text1: CharSequence,
        override val text2: CharSequence? = "",
        override val text3: CharSequence? = "",
        override val icon: Int,
        override var isChecked: Boolean = false,
        override val checkAction: (view: View, item: Checkable) -> Unit
) : MaterialListItem, Textable, Iconable, Checkable
