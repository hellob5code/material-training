package fr.erictruong.android.lists.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import fr.erictruong.android.lists.Bindable
import fr.erictruong.android.lists.item.Avatarable
import fr.erictruong.android.lists.item.Checkable
import fr.erictruong.android.lists.item.Iconable
import fr.erictruong.android.lists.item.MaterialListItem
import fr.erictruong.android.lists.item.Reorderable
import fr.erictruong.android.lists.item.Textable
import fr.erictruong.android.lists.stub.ActionStub
import fr.erictruong.android.lists.stub.AvatarStub
import fr.erictruong.android.lists.stub.CheckBoxStub
import fr.erictruong.android.lists.stub.ExpandStub
import fr.erictruong.android.lists.stub.IconStub
import fr.erictruong.android.lists.stub.ReorderStub
import fr.erictruong.android.lists.stub.SwitchStub
import fr.erictruong.android.lists.stub.TextStub

// *********************
// Single trait classes.
// *********************

class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), Bindable<MaterialListItem> {

    private val actionStub: ActionStub
    private val textStub: TextStub

    init {
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

class IconViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), Bindable<MaterialListItem> {

    private val actionStub: ActionStub
    private val textStub: TextStub
    private val iconStub: IconStub

    init {
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

class AvatarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), Bindable<MaterialListItem> {

    private val actionStub: ActionStub
    private val textStub: TextStub
    private val avatarStub: AvatarStub

    init {
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

class CheckBoxViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), Bindable<MaterialListItem> {

    private val actionStub: ActionStub
    private val textStub: TextStub
    private val checkBoxStub: CheckBoxStub

    init {
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

class SwitchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), Bindable<MaterialListItem> {

    private val actionStub: ActionStub
    private val textStub: TextStub
    private val switchStub: SwitchStub

    init {
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

class ExpandViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), Bindable<MaterialListItem> {

    private val actionStub: ActionStub
    private val textStub: TextStub
    private val expandStub: ExpandStub

    init {
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

class AvatarIconViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), Bindable<MaterialListItem> {

    private val actionStub: ActionStub
    private val textStub: TextStub
    private val iconStub: IconStub
    private val avatarStub: AvatarStub

    init {
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

class CheckBoxIconViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), Bindable<MaterialListItem> {

    private val actionStub: ActionStub
    private val textStub: TextStub
    private val iconStub: IconStub
    private val checkBoxStub: CheckBoxStub

    init {
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

class AvatarCheckBoxViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), Bindable<MaterialListItem> {

    private val actionStub: ActionStub
    private val textStub: TextStub
    private val checkBoxStub: CheckBoxStub
    private val avatarStub: AvatarStub

    init {
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

class IconSwitchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), Bindable<MaterialListItem> {

    private val actionStub: ActionStub
    private val textStub: TextStub
    private val switchStub: SwitchStub
    private val iconStub: IconStub

    init {
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

class AvatarReorderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), Bindable<MaterialListItem> {

    private val actionStub: ActionStub
    private val textStub: TextStub
    private val reorderStub: ReorderStub
    private val avatarStub: AvatarStub

    init {
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

class IconExpandViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), Bindable<MaterialListItem> {

    private val actionStub: ActionStub
    private val textStub: TextStub
    private val expandStub: ExpandStub
    private val iconStub: IconStub

    init {
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