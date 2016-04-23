package fr.erictruong.android.lists.item

import android.support.annotation.DrawableRes
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.View
import fr.erictruong.android.lists.holder.*

abstract class MaterialListItem(var id: Long,
                                @Holder.ViewType var viewType: Int,
                                var action: (view: View, item: MaterialListItem) -> Unit) {

    companion object {
        val NO_ID: Long = -1
        val MAGIC_NUMBER: Int = 100

        fun decodeViewType(viewType: Int): Int {
            return viewType / MAGIC_NUMBER
        }

        fun decodeHolderType(viewType: Int): Int {
            return viewType % MAGIC_NUMBER
        }
    }

    /**
     * Concatenate holderType (i.e. which view holder class to instanciate) and viewType (i.e. one-line, two-line, three-line)
     */
    abstract fun encodeViewType(viewType: Int): Int
}

// *********************
// Single trait classes.
// *********************

open class TextItem(id: Long = NO_ID,
                    @Holder.ViewType viewType: Int = Holder.ONE_LINE,
                    action: (view: View, item: MaterialListItem) -> Unit,
                    override var text1: CharSequence,
                    override var text2: CharSequence? = "",
                    override var text3: CharSequence? = "") : MaterialListItem(id, viewType, action), Textable {

    override fun encodeViewType(viewType: Int): Int {
        return (viewType * MAGIC_NUMBER) + TextViewHolder.TYPE
    }

    override fun toString(): String = "TextItem(id=$id, viewType=$viewType)"
}

open class IconItem(id: Long = NO_ID,
                    @Holder.ViewType viewType: Int = Holder.ONE_LINE,
                    action: (view: View, item: MaterialListItem) -> Unit,
                    text1: CharSequence,
                    text2: CharSequence? = "",
                    text3: CharSequence? = "",
                    @DrawableRes override var icon: Int) : TextItem(id, viewType, action, text1, text2, text3), Iconable {

    override fun encodeViewType(viewType: Int): Int {
        return (viewType * MAGIC_NUMBER) + IconViewHolder.TYPE
    }

    override fun toString(): String = "IconItem(id=$id, viewType=$viewType)"
}

open class AvatarItem(id: Long = NO_ID,
                      @Holder.ViewType viewType: Int = Holder.ONE_LINE,
                      action: (view: View, item: MaterialListItem) -> Unit,
                      text1: CharSequence,
                      text2: CharSequence? = "",
                      text3: CharSequence? = "",
                      override var avatarUrl: String) : TextItem(id, viewType, action, text1, text2, text3), Avatarable {

    override fun encodeViewType(viewType: Int): Int {
        return (viewType * MAGIC_NUMBER) + AvatarViewHolder.TYPE
    }

    override fun toString(): String = "AvatarItem(id=$id, viewType=$viewType)"
}

open class CheckBoxItem(id: Long = NO_ID,
                        @Holder.ViewType viewType: Int = Holder.ONE_LINE,
                        action: (view: View, item: MaterialListItem) -> Unit,
                        text1: CharSequence,
                        text2: CharSequence? = "",
                        text3: CharSequence? = "",
                        override var isChecked: Boolean,
                        override var checkAction: (View, Checkable) -> Unit) : TextItem(id, viewType, action, text1, text2, text3), Checkable {

    override fun encodeViewType(viewType: Int): Int {
        return (viewType * MAGIC_NUMBER) + CheckBoxViewHolder.TYPE
    }

    override fun toString(): String = "CheckBoxItem(id=$id, viewType=$viewType)"
}

open class SwitchItem(id: Long = NO_ID,
                 @Holder.ViewType viewType: Int = Holder.ONE_LINE,
                 action: (view: View, item: MaterialListItem) -> Unit,
                 text1: CharSequence,
                 text2: CharSequence? = "",
                 text3: CharSequence? = "",
                 isChecked: Boolean = false,
                 checkAction: (view: View, item: Checkable) -> Unit) : CheckBoxItem(id, viewType, action, text1, text2, text3, isChecked, checkAction) {

    override fun encodeViewType(viewType: Int): Int {
        return (viewType * MAGIC_NUMBER) + SwitchViewHolder.TYPE
    }

    override fun toString(): String = "SwitchItem(id=$id, viewType=$viewType)"
}

open class ExpandItem(id: Long = NO_ID,
                      @Holder.ViewType viewType: Int = Holder.ONE_LINE,
                      action: (view: View, item: MaterialListItem) -> Unit,
                      text1: CharSequence,
                      text2: CharSequence? = "",
                      text3: CharSequence? = "",
                      isChecked: Boolean = false,
                      checkAction: (view: View, item: Checkable) -> Unit) : CheckBoxItem(id, viewType, action, text1, text2, text3, isChecked, checkAction) {

    override fun encodeViewType(viewType: Int): Int {
        return (viewType * MAGIC_NUMBER) + ExpandViewHolder.TYPE
    }

    override fun toString(): String = "ExpandItem(id=$id, viewType=$viewType)"
}

// *********************
// Double trait classes.
// *********************

class AvatarIconItem(id: Long = NO_ID,
                     @Holder.ViewType viewType: Int = Holder.ONE_LINE,
                     action: (view: View, item: MaterialListItem) -> Unit,
                     text1: CharSequence,
                     text2: CharSequence? = "",
                     text3: CharSequence? = "",
                     avatarUrl: String,
                     @DrawableRes override var icon: Int) : AvatarItem(id, viewType, action, text1, text2, text3, avatarUrl), Iconable {

    override fun encodeViewType(viewType: Int): Int {
        return (viewType * MAGIC_NUMBER) + AvatarIconViewHolder.TYPE
    }

    override fun toString(): String = "AvatarIconItem(id=$id, viewType=$viewType)"
}

class CheckBoxIconItem(id: Long = NO_ID,
                       @Holder.ViewType viewType: Int = Holder.ONE_LINE,
                       action: (view: View, item: MaterialListItem) -> Unit,
                       text1: CharSequence,
                       text2: CharSequence? = "",
                       text3: CharSequence? = "",
                       isChecked: Boolean = false,
                       checkAction: (view: View, item: Checkable) -> Unit,
                       override var icon: Int) : CheckBoxItem(id, viewType, action, text1, text2, text3, isChecked, checkAction), Iconable {

    override fun encodeViewType(viewType: Int): Int {
        return (viewType * MAGIC_NUMBER) + CheckBoxIconViewHolder.TYPE
    }

    override fun toString(): String = "CheckBoxIconItem(id=$id, viewType=$viewType)"
}

class AvatarCheckBoxItem(id: Long = NO_ID,
                         @Holder.ViewType viewType: Int = Holder.ONE_LINE,
                         action: (view: View, item: MaterialListItem) -> Unit,
                         text1: CharSequence,
                         text2: CharSequence? = "",
                         text3: CharSequence? = "",
                         avatarUrl: String,
                         override var isChecked: Boolean = false,
                         override var checkAction: (view: View, item: Checkable) -> Unit) : AvatarItem(id, viewType, action, text1, text2, text3, avatarUrl), Checkable {

    override fun encodeViewType(viewType: Int): Int {
        return (viewType * MAGIC_NUMBER) + AvatarCheckBoxViewHolder.TYPE
    }

    override fun toString(): String = "AvatarCheckBoxItem(id=$id, viewType=$viewType)"
}

class IconSwitchItem(id: Long = NO_ID,
                     @Holder.ViewType viewType: Int = Holder.ONE_LINE,
                     action: (view: View, item: MaterialListItem) -> Unit,
                     text1: CharSequence,
                     text2: CharSequence? = "",
                     text3: CharSequence? = "",
                     @DrawableRes icon: Int,
                     override var isChecked: Boolean = false,
                     override var checkAction: (view: View, item: Checkable) -> Unit) : IconItem(id, viewType, action, text1, text2, text3, icon), Checkable {

    override fun encodeViewType(viewType: Int): Int {
        return (viewType * MAGIC_NUMBER) + IconSwitchViewHolder.TYPE
    }

    override fun toString(): String = "IconSwitchItem(id=$id, viewType=$viewType)"
}

class AvatarReorderItem(id: Long = NO_ID,
                        @Holder.ViewType viewType: Int = Holder.ONE_LINE,
                        action: (view: View, item: MaterialListItem) -> Unit,
                        text1: CharSequence,
                        text2: CharSequence? = "",
                        text3: CharSequence? = "",
                        avatarUrl: String,
                        override var itemTouchHelper: ItemTouchHelper) : AvatarItem(id, viewType, action, text1, text2, text3, avatarUrl), Reorderable {

    override fun encodeViewType(viewType: Int): Int {
        return (viewType * MAGIC_NUMBER) + AvatarReorderViewHolder.TYPE
    }

    override fun toString(): String = "AvatarReorderableItem(id=$id, viewType=$viewType)"
}

class IconExpandItem(id: Long = NO_ID,
                     @Holder.ViewType viewType: Int = Holder.ONE_LINE,
                     action: (view: View, item: MaterialListItem) -> Unit,
                     text1: CharSequence,
                     text2: CharSequence? = "",
                     text3: CharSequence? = "",
                     @DrawableRes icon: Int,
                     override var isChecked: Boolean = false,
                     override var checkAction: (view: View, item: Checkable) -> Unit) : IconItem(id, viewType, action, text1, text2, text3, icon), Checkable {

    override fun encodeViewType(viewType: Int): Int {
        return (viewType * MAGIC_NUMBER) + IconExpandViewHolder.TYPE
    }

    override fun toString(): String = "IconExpandItem(id=$id, viewType=$viewType)"
}