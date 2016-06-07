package fr.erictruong.android.lists.holder

import android.support.annotation.IntDef
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import fr.erictruong.android.core.util.ViewUtils
import fr.erictruong.android.lists.R

fun inflate(parent: ViewGroup, resource: Int) = LayoutInflater.from(parent.context).inflate(resource, parent, false)

inline fun inflate(parent: ViewGroup, resource: () -> Int): View = LayoutInflater.from(parent.context).inflate(resource(), parent, false)

abstract class MaterialListHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    companion object {
        const val ONE_LINE = 0
        const val TWO_LINE = 1
        const val THREE_LINE = 2
    }

    @IntDef(ONE_LINE.toLong(), TWO_LINE.toLong(), THREE_LINE.toLong())
    @Retention(AnnotationRetention.SOURCE)
    annotation class ViewType
}

// *********************
// Single trait classes.
// *********************

open class TextViewHolder : MaterialListHolder {

    val text1 by lazy { itemView.findViewById(R.id.text1) as TextView }
    val text2 by lazy { itemView.findViewById(R.id.text1) as TextView? }
    val text3 by lazy { itemView.findViewById(R.id.text1) as TextView? }

    constructor(parent: ViewGroup, viewType: Int) : super(inflate(parent) {
        when (viewType) {
            ONE_LINE -> R.layout.list_tile_one_line
            TWO_LINE -> R.layout.list_tile_two_line
            THREE_LINE -> R.layout.list_tile_three_line
            else -> throw IllegalArgumentException("Unknown view type: " + viewType)
        }
    })
}

open class IconViewHolder : MaterialListHolder {

    val text1 by lazy { itemView.findViewById(R.id.text1) as TextView }
    val text2 by lazy { itemView.findViewById(R.id.text1) as TextView? }
    val text3 by lazy { itemView.findViewById(R.id.text1) as TextView? }
    val icon by lazy { itemView.findViewById(R.id.icon) as ImageView }

    constructor(parent: ViewGroup, viewType: Int) : super(inflate(parent) {
        when (viewType) {
            ONE_LINE -> R.layout.list_tile_one_line_icon
            TWO_LINE -> R.layout.list_tile_two_line_icon
            THREE_LINE -> R.layout.list_tile_three_line_icon
            else -> throw IllegalArgumentException("Unknown view type: " + viewType)
        }
    })
}

open class AvatarViewHolder : MaterialListHolder {

    val text1 by lazy { itemView.findViewById(R.id.text1) as TextView }
    val text2 by lazy { itemView.findViewById(R.id.text1) as TextView? }
    val text3 by lazy { itemView.findViewById(R.id.text1) as TextView? }
    val avatar by lazy { itemView.findViewById(R.id.avatar) as ImageView }

    constructor(parent: ViewGroup, viewType: Int) : super(inflate(parent) {
        when (viewType) {
            ONE_LINE -> R.layout.list_tile_one_line_avatar
            TWO_LINE -> R.layout.list_tile_two_line_avatar
            THREE_LINE -> R.layout.list_tile_three_line_avatar
            else -> throw IllegalArgumentException("Unknown view type: " + viewType)
        }
    })
}

open class CheckBoxViewHolder : MaterialListHolder {

    val text1 by lazy { itemView.findViewById(R.id.text1) as TextView }
    val text2 by lazy { itemView.findViewById(R.id.text1) as TextView? }
    val text3 by lazy { itemView.findViewById(R.id.text1) as TextView? }
    val checkbox by lazy { itemView.findViewById(R.id.checkbox) as CheckBox }

    constructor(parent: ViewGroup, viewType: Int) : super(inflate(parent, R.layout.list_tile_one_line_checkbox))
}

open class SwitchViewHolder : MaterialListHolder {

    val text1 by lazy { itemView.findViewById(R.id.text1) as TextView }
    val text2 by lazy { itemView.findViewById(R.id.text1) as TextView? }
    val text3 by lazy { itemView.findViewById(R.id.text1) as TextView? }
    val toggle by lazy { itemView.findViewById(R.id.toggle) as Switch }

    constructor(parent: ViewGroup, viewType: Int) : super(inflate(parent, R.layout.list_tile_one_line_switch))
}

open class ExpandViewHolder : MaterialListHolder {

    val text1 by lazy { itemView.findViewById(R.id.text1) as TextView }
    val text2 by lazy { itemView.findViewById(R.id.text1) as TextView? }
    val text3 by lazy { itemView.findViewById(R.id.text1) as TextView? }
    val checkbox by lazy { itemView.findViewById(R.id.checkbox) as CheckBox }

    constructor(parent: ViewGroup, viewType: Int) : super(inflate(parent, R.layout.list_tile_one_line_expand))
}

// *********************
// Double trait classes.
// *********************

open class AvatarIconViewHolder : MaterialListHolder {

    val text1 by lazy { itemView.findViewById(R.id.text1) as TextView }
    val text2 by lazy { itemView.findViewById(R.id.text1) as TextView? }
    val text3 by lazy { itemView.findViewById(R.id.text1) as TextView? }
    val avatar by lazy { itemView.findViewById(R.id.avatar) as ImageView }
    val icon by lazy { itemView.findViewById(R.id.icon) as ImageView }

    constructor(parent: ViewGroup, viewType: Int) : super(inflate(parent) {
        when (viewType) {
            ONE_LINE -> R.layout.list_tile_one_line_avatar_icon
            TWO_LINE -> R.layout.list_tile_two_line_avatar_icon
            THREE_LINE -> R.layout.list_tile_three_line_avatar_icon
            else -> throw IllegalArgumentException("Unknown view type: " + viewType)
        }
    })
}

open class CheckBoxIconViewHolder : MaterialListHolder {

    val text1 by lazy { itemView.findViewById(R.id.text1) as TextView }
    val text2 by lazy { itemView.findViewById(R.id.text1) as TextView? }
    val text3 by lazy { itemView.findViewById(R.id.text1) as TextView? }
    val checkbox by lazy { itemView.findViewById(R.id.checkbox) as CheckBox }
    val icon by lazy { itemView.findViewById(R.id.icon) as ImageView }

    constructor(parent: ViewGroup, viewType: Int) : super(inflate(parent, R.layout.list_tile_one_line_checkbox_icon))
}

open class AvatarCheckBoxViewHolder : MaterialListHolder {

    val text1 by lazy { itemView.findViewById(R.id.text1) as TextView }
    val text2 by lazy { itemView.findViewById(R.id.text1) as TextView? }
    val text3 by lazy { itemView.findViewById(R.id.text1) as TextView? }
    val avatar by lazy { itemView.findViewById(R.id.avatar) as ImageView }
    val checkbox by lazy { itemView.findViewById(R.id.checkbox) as CheckBox }

    constructor(parent: ViewGroup, viewType: Int) : super(inflate(parent, R.layout.list_tile_one_line_avatar_checkbox))
}

open class IconSwitchViewHolder : MaterialListHolder {

    val text1 by lazy { itemView.findViewById(R.id.text1) as TextView }
    val text2 by lazy { itemView.findViewById(R.id.text1) as TextView? }
    val text3 by lazy { itemView.findViewById(R.id.text1) as TextView? }
    val icon by lazy { itemView.findViewById(R.id.icon) as ImageView }
    val toggle by lazy { itemView.findViewById(R.id.toggle) as Switch }

    constructor(parent: ViewGroup, viewType: Int) : super(inflate(parent, R.layout.list_tile_one_line_icon_switch))
}

open class AvatarReorderViewHolder : MaterialListHolder {

    val text1 by lazy { itemView.findViewById(R.id.text1) as TextView }
    val text2 by lazy { itemView.findViewById(R.id.text1) as TextView? }
    val text3 by lazy { itemView.findViewById(R.id.text1) as TextView? }
    val avatar by lazy { itemView.findViewById(R.id.avatar) as ImageView }
    val icon by lazy { itemView.findViewById(R.id.icon) as ImageView }

    constructor(parent: ViewGroup, viewType: Int) : super(inflate(parent, R.layout.list_tile_one_line_avatar_icon))
}

open class IconExpandViewHolder : MaterialListHolder {

    val text1 by lazy { itemView.findViewById(R.id.text1) as TextView }
    val text2 by lazy { itemView.findViewById(R.id.text1) as TextView? }
    val text3 by lazy { itemView.findViewById(R.id.text1) as TextView? }
    val icon by lazy { itemView.findViewById(R.id.icon) as ImageView }
    val checkbox by lazy { itemView.findViewById(R.id.checkbox) as CheckBox }

    constructor(parent: ViewGroup, viewType: Int) : super(inflate(parent, R.layout.list_tile_one_line_icon_expand))
}
