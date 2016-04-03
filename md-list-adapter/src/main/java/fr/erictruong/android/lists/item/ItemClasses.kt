package fr.erictruong.android.lists.item

import android.support.annotation.DrawableRes
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.View
import fr.erictruong.android.lists.MaterialListAdapter

open class MaterialListItem(var id: Long,
                            var viewType: Int,
                            var action: (view: View, item: MaterialListItem) -> Unit) {

    companion object {
        val NO_ID: Long = -1
    }

    override fun toString(): String = "MaterialListItem(id=$id, viewType=$viewType)"
}

// *********************
// Single trait classes.
// *********************

open class TextItem(id: Long = NO_ID,
                    @MaterialListAdapter.TextViewType viewType: Int = MaterialListAdapter.VIEW_TYPE_ONE_LINE,
                    action: (view: View, item: MaterialListItem) -> Unit,
                    override var text1: CharSequence,
                    override var text2: CharSequence? = "",
                    override var text3: CharSequence? = "") : MaterialListItem(id, viewType, action), Textable {

    override fun toString(): String = "TextItem(id=$id, viewType=$viewType)"
}

open class IconItem(id: Long = NO_ID,
                    @MaterialListAdapter.IconViewType viewType: Int = MaterialListAdapter.VIEW_TYPE_ONE_LINE_ICON,
                    action: (view: View, item: MaterialListItem) -> Unit,
                    text1: CharSequence,
                    text2: CharSequence? = "",
                    text3: CharSequence? = "",
                    @DrawableRes override var icon: Int) : TextItem(id, viewType, action, text1, text2, text3), Iconable {

    override fun toString(): String = "IconItem(id=$id, viewType=$viewType)"
}

open class AvatarItem(id: Long = NO_ID,
                      @MaterialListAdapter.AvatarViewType viewType: Int = MaterialListAdapter.VIEW_TYPE_ONE_LINE_AVATAR,
                      action: (view: View, item: MaterialListItem) -> Unit,
                      text1: CharSequence,
                      text2: CharSequence? = "",
                      text3: CharSequence? = "",
                      override var avatarUrl: String) : TextItem(id, viewType, action, text1, text2, text3), Avatarable {

    override fun toString(): String = "AvatarItem(id=$id, viewType=$viewType)"
}

open class CheckBoxItem(id: Long = NO_ID,
                        viewType: Int = MaterialListAdapter.VIEW_TYPE_ONE_LINE_CHECKBOX,
                        action: (view: View, item: MaterialListItem) -> Unit,
                        text1: CharSequence,
                        text2: CharSequence? = "",
                        text3: CharSequence? = "",
                        override var isChecked: Boolean,
                        override var checkAction: (View, Checkable) -> Unit) : TextItem(id, viewType, action, text1, text2, text3), Checkable {

    override fun toString(): String = "CheckBoxItem(id=$id, viewType=$viewType)"
}

open class ReorderItem(id: Long = NO_ID,
                       viewType: Int = 99, // TODO: Create real ID and replace current placeholder.
                       action: (view: View, item: MaterialListItem) -> Unit,
                       text1: CharSequence,
                       text2: CharSequence? = "",
                       text3: CharSequence? = "",
                       override var itemTouchHelper: ItemTouchHelper) : TextItem(id, viewType, action, text1, text2, text3), Reorderable {

    override fun toString(): String = "ReorderItem(id=$id, viewType=$viewType)"
}

class SwitchItem(id: Long = NO_ID,
                 viewType: Int = MaterialListAdapter.VIEW_TYPE_ONE_LINE_SWITCH,
                 action: (view: View, item: MaterialListItem) -> Unit,
                 text1: CharSequence,
                 text2: CharSequence? = "",
                 text3: CharSequence? = "",
                 isChecked: Boolean = false,
                 checkAction: (view: View, item: Checkable) -> Unit) : CheckBoxItem(id, viewType, action, text1, text2, text3, isChecked, checkAction) {

    override fun toString(): String = "SwitchItem(id=$id, viewType=$viewType)"
}

open class ExpandItem(id: Long = NO_ID,
                      viewType: Int = MaterialListAdapter.VIEW_TYPE_ONE_LINE_EXPAND,
                      action: (view: View, item: MaterialListItem) -> Unit,
                      text1: CharSequence,
                      text2: CharSequence? = "",
                      text3: CharSequence? = "",
                      isChecked: Boolean = false,
                      checkAction: (view: View, item: Checkable) -> Unit) : CheckBoxItem(id, viewType, action, text1, text2, text3, isChecked, checkAction) {

    override fun toString(): String = "ExpandItem(id=$id, viewType=$viewType)"
}

// *********************
// Double trait classes.
// *********************

class AvatarIconItem(id: Long = NO_ID,
                     @MaterialListAdapter.AvatarIconViewType viewType: Int = MaterialListAdapter.VIEW_TYPE_ONE_LINE_AVATAR_ICON,
                     action: (view: View, item: MaterialListItem) -> Unit,
                     text1: CharSequence,
                     text2: CharSequence? = "",
                     text3: CharSequence? = "",
                     avatarUrl: String,
                     @DrawableRes override var icon: Int) : AvatarItem(id, viewType, action, text1, text2, text3, avatarUrl), Iconable {

    override fun toString(): String = "AvatarIconItem(id=$id, viewType=$viewType)"
}

class CheckBoxIconItem(id: Long = NO_ID,
                       viewType: Int = MaterialListAdapter.VIEW_TYPE_ONE_LINE_CHECKBOX_ICON,
                       action: (view: View, item: MaterialListItem) -> Unit,
                       text1: CharSequence,
                       text2: CharSequence? = "",
                       text3: CharSequence? = "",
                       isChecked: Boolean = false,
                       checkAction: (view: View, item: Checkable) -> Unit,
                       override var icon: Int) : CheckBoxItem(id, viewType, action, text1, text2, text3, isChecked, checkAction), Iconable {

    override fun toString(): String = "CheckBoxIconItem(id=$id, viewType=$viewType)"
}

class AvatarCheckBoxItem(id: Long = NO_ID,
                         viewType: Int = MaterialListAdapter.VIEW_TYPE_ONE_LINE_AVATAR_CHECKBOX,
                         action: (view: View, item: MaterialListItem) -> Unit,
                         text1: CharSequence,
                         text2: CharSequence? = "",
                         text3: CharSequence? = "",
                         avatarUrl: String,
                         override var isChecked: Boolean = false,
                         override var checkAction: (view: View, item: Checkable) -> Unit) : AvatarItem(id, viewType, action, text1, text2, text3, avatarUrl), Checkable {

    override fun toString(): String = "AvatarCheckBoxItem(id=$id, viewType=$viewType)"
}

class IconSwitchItem(id: Long = NO_ID,
                     viewType: Int = MaterialListAdapter.VIEW_TYPE_ONE_LINE_ICON_SWITCH,
                     action: (view: View, item: MaterialListItem) -> Unit,
                     text1: CharSequence,
                     text2: CharSequence? = "",
                     text3: CharSequence? = "",
                     @DrawableRes icon: Int,
                     override var isChecked: Boolean = false,
                     override var checkAction: (view: View, item: Checkable) -> Unit) : IconItem(id, viewType, action, text1, text2, text3, icon), Checkable {

    override fun toString(): String = "IconSwitchItem(id=$id, viewType=$viewType)"
}

class AvatarReorderItem(id: Long = NO_ID,
                        viewType: Int = MaterialListAdapter.VIEW_TYPE_ONE_LINE_AVATAR_REORDER,
                        action: (view: View, item: MaterialListItem) -> Unit,
                        text1: CharSequence,
                        text2: CharSequence? = "",
                        text3: CharSequence? = "",
                        avatarUrl: String,
                        override var itemTouchHelper: ItemTouchHelper) : AvatarItem(id, viewType, action, text1, text2, text3, avatarUrl), Reorderable {

    override fun toString(): String = "AvatarReorderableItem(id=$id, viewType=$viewType)"
}

class IconExpandItem(id: Long = NO_ID,
                     viewType: Int = MaterialListAdapter.VIEW_TYPE_ONE_LINE_ICON_EXPAND,
                     action: (view: View, item: MaterialListItem) -> Unit,
                     text1: CharSequence,
                     text2: CharSequence? = "",
                     text3: CharSequence? = "",
                     @DrawableRes icon: Int,
                     override var isChecked: Boolean = false,
                     override var checkAction: (view: View, item: Checkable) -> Unit) : IconItem(id, viewType, action, text1, text2, text3, icon), Checkable {

    override fun toString(): String = "IconExpandItem(id=$id, viewType=$viewType)"
}