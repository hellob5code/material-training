package fr.erictruong.android.lists.item

import android.support.annotation.DrawableRes
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.View
import fr.erictruong.android.lists.holder.Holder


//companion object {
//    val NO_ID: Long = -1
//    val MAGIC_NUMBER: Int = 100
//
//    fun decodeViewType(viewType: Int): Int {
//        return viewType / MAGIC_NUMBER
//    }
//
//    fun decodeHolderType(viewType: Int): Int {
//        return viewType % MAGIC_NUMBER
//    }
//}
//
//
///**
// * Concatenate holderType (i.e. which view holder class to instantiate) and viewType (i.e. one-line, two-line, three-line)
// */
//abstract fun encodeViewType(viewType: Int): Int

interface MaterialListItem {
    var id: Long
    var viewType: Int
    var action: (view: View, item: MaterialListItem) -> Unit
}

// *********************
// Single trait classes.
// *********************

data class TextItem(
        override var id: Long = RecyclerView.NO_ID,
        override var viewType: Int = Holder.ONE_LINE,
        override var action: (view: View, item: MaterialListItem) -> Unit,
        override var text1: CharSequence,
        override var text2: CharSequence? = "",
        override var text3: CharSequence? = ""
) : MaterialListItem, Textable

data class IconItem(
        override var id: Long = RecyclerView.NO_ID,
        override var viewType: Int = Holder.ONE_LINE,
        override var action: (view: View, item: MaterialListItem) -> Unit,
        override var text1: CharSequence,
        override var text2: CharSequence? = "",
        override var text3: CharSequence? = "",
        @DrawableRes override var icon: Int
) : MaterialListItem, Textable, Iconable

data class AvatarItem(
        override var id: Long = RecyclerView.NO_ID,
        override var viewType: Int = Holder.ONE_LINE,
        override var action: (view: View, item: MaterialListItem) -> Unit,
        override var text1: CharSequence,
        override var text2: CharSequence? = "",
        override var text3: CharSequence? = "",
        override var avatarUrl: String
) : MaterialListItem, Textable, Avatarable

data class CheckBoxItem(
        override var id: Long = RecyclerView.NO_ID,
        override var viewType: Int = Holder.ONE_LINE,
        override var action: (view: View, item: MaterialListItem) -> Unit,
        override var text1: CharSequence,
        override var text2: CharSequence? = "",
        override var text3: CharSequence? = "",
        override var isChecked: Boolean = false,
        override var checkAction: (View, Checkable) -> Unit
) : MaterialListItem, Textable, Checkable

data class SwitchItem(
        override var id: Long = RecyclerView.NO_ID,
        override var viewType: Int = Holder.ONE_LINE,
        override var action: (view: View, item: MaterialListItem) -> Unit,
        override var text1: CharSequence,
        override var text2: CharSequence? = "",
        override var text3: CharSequence? = "",
        override var isChecked: Boolean = false,
        override var checkAction: (view: View, item: Checkable) -> Unit
) : MaterialListItem, Textable, Checkable

data class ExpandItem(
        override var id: Long = RecyclerView.NO_ID,
        override var viewType: Int = Holder.ONE_LINE,
        override var action: (view: View, item: MaterialListItem) -> Unit,
        override var text1: CharSequence,
        override var text2: CharSequence? = "",
        override var text3: CharSequence? = "",
        override var isChecked: Boolean = false,
        override var checkAction: (view: View, item: Checkable) -> Unit
) : MaterialListItem, Textable, Checkable

// *********************
// Double trait classes.
// *********************

data class AvatarIconItem(
        override var id: Long = RecyclerView.NO_ID,
        override var viewType: Int = Holder.ONE_LINE,
        override var action: (view: View, item: MaterialListItem) -> Unit,
        override var text1: CharSequence,
        override var text2: CharSequence? = "",
        override var text3: CharSequence? = "",
        override var avatarUrl: String,
        @DrawableRes override var icon: Int
) : MaterialListItem, Textable, Avatarable, Iconable

data class CheckBoxIconItem(
        override var id: Long = RecyclerView.NO_ID,
        override var viewType: Int = Holder.ONE_LINE,
        override var action: (view: View, item: MaterialListItem) -> Unit,
        override var text1: CharSequence,
        override var text2: CharSequence? = "",
        override var text3: CharSequence? = "",
        override var isChecked: Boolean = false,
        override var checkAction: (view: View, item: Checkable) -> Unit,
        @DrawableRes override var icon: Int
) : MaterialListItem, Textable, Checkable, Iconable

data class AvatarCheckBoxItem(
        override var id: Long = RecyclerView.NO_ID,
        override var viewType: Int = Holder.ONE_LINE,
        override var action: (view: View, item: MaterialListItem) -> Unit,
        override var text1: CharSequence,
        override var text2: CharSequence? = "",
        override var text3: CharSequence? = "",
        override var avatarUrl: String,
        override var isChecked: Boolean = false,
        override var checkAction: (view: View, item: Checkable) -> Unit
) : MaterialListItem, Textable, Avatarable, Checkable

data class IconSwitchItem(
        override var id: Long = RecyclerView.NO_ID,
        override var viewType: Int = Holder.ONE_LINE,
        override var action: (view: View, item: MaterialListItem) -> Unit,
        override var text1: CharSequence,
        override var text2: CharSequence? = "",
        override var text3: CharSequence? = "",
        @DrawableRes override var icon: Int,
        override var isChecked: Boolean = false,
        override var checkAction: (view: View, item: Checkable) -> Unit
) : MaterialListItem, Textable, Iconable, Checkable

data class AvatarReorderItem(
        override var id: Long = RecyclerView.NO_ID,
        override var viewType: Int = Holder.ONE_LINE,
        override var action: (view: View, item: MaterialListItem) -> Unit,
        override var text1: CharSequence,
        override var text2: CharSequence? = "",
        override var text3: CharSequence? = "",
        override var avatarUrl: String,
        override var itemTouchHelper: ItemTouchHelper
) : MaterialListItem, Textable, Avatarable, Reorderable

data class IconExpandItem(
        override var id: Long = RecyclerView.NO_ID,
        override var viewType: Int = Holder.ONE_LINE,
        override var action: (view: View, item: MaterialListItem) -> Unit,
        override var text1: CharSequence,
        override var text2: CharSequence? = "",
        override var text3: CharSequence? = "",
        @DrawableRes override var icon: Int,
        override var isChecked: Boolean = false,
        override var checkAction: (view: View, item: Checkable) -> Unit
) : MaterialListItem, Textable, Iconable, Checkable