package fr.erictruong.android.lists.holder

import android.support.annotation.IntDef
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import fr.erictruong.android.lists.Bindable
import fr.erictruong.android.lists.R
import fr.erictruong.android.lists.item.*
import fr.erictruong.android.lists.stub.*

abstract class Holder(parent: ViewGroup, resource: Int) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(resource, parent, false)), Bindable<MaterialListItem> {

    companion object {
        const val ONE_LINE = 0
        const val TWO_LINE = 1
        const val THREE_LINE = 2
    }

    @IntDef(ONE_LINE.toLong(), TWO_LINE.toLong(), THREE_LINE.toLong())
    @Retention(AnnotationRetention.SOURCE)
    annotation class ViewType
}

fun getLayout(viewType: Int, @LayoutRes layout1: Int, @LayoutRes layout2: Int = 0, @LayoutRes layout3: Int = 0): Int {
    when (viewType) {
        Holder.ONE_LINE -> return layout1
        Holder.TWO_LINE -> return layout2
        Holder.THREE_LINE -> return layout3
        else -> throw IllegalArgumentException("Unknown view type: " + viewType)
    }
}

// *********************
// Single trait classes.
// *********************

class TextViewHolder : Holder {

    companion object {
        val TYPE: Int = 1
    }

    private val actionStub: ActionStub
    private val textStub: TextStub

    constructor(parent: ViewGroup, viewType: Int) : super(parent, getLayout(viewType, R.layout.list_tile_one_line, R.layout.list_tile_two_line, R.layout.list_tile_three_line)) {
        actionStub = ActionStub(itemView)
        textStub = TextStub(itemView)
    }

    override fun bind(item: MaterialListItem) {
        actionStub.bind(item)
        textStub.bind(item as Textable)
    }

    override fun unbind() {
        actionStub.unbind()
        textStub.unbind()
    }
}

class IconViewHolder : Holder {

    companion object {
        val TYPE: Int = 2
    }

    private val actionStub: ActionStub
    private val textStub: TextStub
    private val iconStub: IconStub

    constructor(parent: ViewGroup, viewType: Int) : super(parent, getLayout (viewType, R.layout.list_tile_one_line_icon, R.layout.list_tile_two_line_icon, R.layout.list_tile_three_line_icon)) {
        actionStub = ActionStub(itemView)
        textStub = TextStub(itemView)
        iconStub = IconStub(itemView)
    }

    override fun bind(item: MaterialListItem) {
        actionStub.bind(item)
        textStub.bind(item as Textable)
        iconStub.bind(item as Iconable)
    }

    override fun unbind() {
        actionStub.unbind()
        textStub.unbind()
        iconStub.unbind()
    }
}

class AvatarViewHolder : Holder {

    companion object {
        val TYPE: Int = 3
    }

    private val actionStub: ActionStub
    private val textStub: TextStub
    private val avatarStub: AvatarStub

    constructor(parent: ViewGroup, viewType: Int) : super(parent, getLayout (viewType, R.layout.list_tile_one_line_avatar, R.layout.list_tile_two_line_avatar, R.layout.list_tile_three_line_avatar)) {
        actionStub = ActionStub(itemView)
        textStub = TextStub(itemView)
        avatarStub = AvatarStub(itemView)
    }

    override fun bind(item: MaterialListItem) {
        actionStub.bind(item)
        textStub.bind(item as Textable)
        avatarStub.bind(item as Avatarable)
    }

    override fun unbind() {
        actionStub.unbind()
        textStub.unbind()
        avatarStub.unbind()
    }
}

class CheckBoxViewHolder : Holder {

    companion object {
        val TYPE: Int = 4
    }

    private val actionStub: ActionStub
    private val textStub: TextStub
    private val checkBoxStub: CheckBoxStub

    constructor(parent: ViewGroup, viewType: Int) : super(parent, getLayout (viewType, R.layout.list_tile_one_line_checkbox_end)) {
        actionStub = ActionStub(itemView)
        textStub = TextStub(itemView)
        checkBoxStub = CheckBoxStub(itemView)
    }

    override fun bind(item: MaterialListItem) {
        actionStub.bind(item)
        textStub.bind(item as Textable)
        checkBoxStub.bind(item as Checkable)
    }

    override fun unbind() {
        actionStub.unbind()
        textStub.unbind()
        checkBoxStub.unbind()
    }
}

class SwitchViewHolder : Holder {

    companion object {
        val TYPE: Int = 6
    }

    private val actionStub: ActionStub
    private val textStub: TextStub
    private val switchStub: SwitchStub

    constructor(parent: ViewGroup, viewType: Int) : super(parent, getLayout (viewType, R.layout.list_tile_one_line_icon_switch)) {
        actionStub = ActionStub(itemView)
        textStub = TextStub(itemView)
        switchStub = SwitchStub(itemView)
    }

    override fun bind(item: MaterialListItem) {
        actionStub.bind(item)
        textStub.bind(item as Textable)
        switchStub.bind(item as Checkable)
    }

    override fun unbind() {
        actionStub.unbind()
        textStub.unbind()
        switchStub.unbind()
    }
}

class ExpandViewHolder : Holder {

    companion object {
        val TYPE: Int = 7
    }

    private val actionStub: ActionStub
    private val textStub: TextStub
    private val expandStub: ExpandStub

    constructor(parent: ViewGroup, viewType: Int) : super(parent, getLayout (viewType, R.layout.list_tile_one_line_checkbox_end)) {
        actionStub = ActionStub(itemView)
        textStub = TextStub(itemView)
        expandStub = ExpandStub(itemView)
    }

    override fun bind(item: MaterialListItem) {
        actionStub.bind(item)
        textStub.bind(item as Textable)
        expandStub.bind(item as Checkable)
    }

    override fun unbind() {
        actionStub.unbind()
        textStub.unbind()
        expandStub.unbind()
    }
}

// *********************
// Double trait classes.
// *********************

class AvatarIconViewHolder : Holder {

    companion object {
        val TYPE: Int = 11
    }

    private val actionStub: ActionStub
    private val textStub: TextStub
    private val iconStub: IconStub
    private val avatarStub: AvatarStub

    constructor(parent: ViewGroup, viewType: Int) : super(parent, getLayout (viewType, R.layout.list_tile_one_line_avatar_icon, R.layout.list_tile_two_line_avatar_icon, R.layout.list_tile_three_line_avatar_icon)) {
        actionStub = ActionStub(itemView)
        textStub = TextStub(itemView)
        iconStub = IconStub(itemView)
        avatarStub = AvatarStub(itemView)
    }

    override fun bind(item: MaterialListItem) {
        actionStub.bind(item)
        textStub.bind(item as Textable)
        iconStub.bind(item as Iconable)
        avatarStub.bind(item as Avatarable)
    }

    override fun unbind() {
        actionStub.unbind()
        textStub.unbind()
        iconStub.unbind()
        avatarStub.unbind()
    }
}

class CheckBoxIconViewHolder : Holder {

    companion object {
        val TYPE: Int = 12
    }

    private val actionStub: ActionStub
    private val textStub: TextStub
    private val iconStub: IconStub
    private val checkBoxStub: CheckBoxStub

    constructor(parent: ViewGroup, viewType: Int) : super(parent, getLayout (viewType, R.layout.list_tile_one_line_checkbox_icon)) {
        actionStub = ActionStub(itemView)
        textStub = TextStub(itemView)
        iconStub = IconStub(itemView)
        checkBoxStub = CheckBoxStub(itemView)
    }

    override fun bind(item: MaterialListItem) {
        actionStub.bind(item)
        textStub.bind(item as Textable)
        iconStub.bind(item as Iconable)
        checkBoxStub.bind(item as Checkable)
    }

    override fun unbind() {
        actionStub.unbind()
        textStub.unbind()
        iconStub.unbind()
        checkBoxStub.unbind()
    }
}

class AvatarCheckBoxViewHolder : Holder {

    companion object {
        val TYPE: Int = 13
    }

    private val actionStub: ActionStub
    private val textStub: TextStub
    private val checkBoxStub: CheckBoxStub
    private val avatarStub: AvatarStub

    constructor(parent: ViewGroup, viewType: Int) : super(parent, getLayout (viewType, R.layout.list_tile_one_line_avatar_checkbox)) {
        actionStub = ActionStub(itemView)
        textStub = TextStub(itemView)
        checkBoxStub = CheckBoxStub(itemView)
        avatarStub = AvatarStub(itemView)
    }

    override fun bind(item: MaterialListItem) {
        actionStub.bind(item)
        textStub.bind(item as Textable)
        checkBoxStub.bind(item as Checkable)
        avatarStub.bind(item as Avatarable)
    }

    override fun unbind() {
        actionStub.unbind()
        textStub.unbind()
        checkBoxStub.unbind()
        avatarStub.unbind()
    }
}

class IconSwitchViewHolder : Holder {

    companion object {
        val TYPE: Int = 14
    }

    private val actionStub: ActionStub
    private val textStub: TextStub
    private val switchStub: SwitchStub
    private val iconStub: IconStub

    constructor(parent: ViewGroup, viewType: Int) : super(parent, getLayout (viewType, R.layout.list_tile_one_line_icon_switch)) {
        actionStub = ActionStub(itemView)
        textStub = TextStub(itemView)
        switchStub = SwitchStub(itemView)
        iconStub = IconStub(itemView)
    }

    override fun bind(item: MaterialListItem) {
        actionStub.bind(item)
        textStub.bind(item as Textable)
        switchStub.bind(item as Checkable)
        iconStub.bind(item as Iconable)
    }

    override fun unbind() {
        actionStub.unbind()
        textStub.unbind()
        switchStub.unbind()
        iconStub.unbind()
    }
}

class AvatarReorderViewHolder : Holder {

    companion object {
        val TYPE: Int = 15
    }

    private val actionStub: ActionStub
    private val textStub: TextStub
    private val reorderStub: ReorderStub
    private val avatarStub: AvatarStub

    constructor(parent: ViewGroup, viewType: Int) : super(parent, getLayout (viewType, R.layout.list_tile_one_line_avatar_icon)) {
        actionStub = ActionStub(itemView)
        textStub = TextStub(itemView)
        reorderStub = ReorderStub(itemView)
        avatarStub = AvatarStub(itemView)
    }

    override fun bind(item: MaterialListItem) {
        actionStub.bind(item)
        textStub.bind(item as Textable)
        reorderStub.bind(item as Reorderable)
        reorderStub.setViewHolder(this)
        avatarStub.bind(item as Avatarable)
    }

    override fun unbind() {
        actionStub.unbind()
        textStub.unbind()
        reorderStub.unbind()
        avatarStub.unbind()
    }
}

class IconExpandViewHolder : Holder {

    companion object {
        val TYPE: Int = 16
    }

    private val actionStub: ActionStub
    private val textStub: TextStub
    private val expandStub: ExpandStub
    private val iconStub: IconStub

    constructor(parent: ViewGroup, viewType: Int) : super(parent, getLayout (viewType, R.layout.list_tile_one_line_icon_expand)) {
        actionStub = ActionStub(itemView)
        textStub = TextStub(itemView)
        expandStub = ExpandStub(itemView)
        iconStub = IconStub(itemView)
    }

    override fun bind(item: MaterialListItem) {
        actionStub.bind(item)
        textStub.bind(item as Textable)
        expandStub.bind(item as Checkable)
        iconStub.bind(item as Iconable)
    }

    override fun unbind() {
        actionStub.unbind()
        textStub.unbind()
        expandStub.unbind()
        iconStub.unbind()
    }
}