package fr.erictruong.android.lists.stub

import android.graphics.Color
import android.support.annotation.ColorInt
import android.support.v4.view.MotionEventCompat
import android.support.v7.widget.RecyclerView
import android.view.MotionEvent
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import com.squareup.picasso.Picasso
import fr.erictruong.android.core.transform.CircleStrokeTransformation
import fr.erictruong.android.core.util.ThemeUtils
import fr.erictruong.android.core.util.ViewUtils
import fr.erictruong.android.lists.Bindable
import fr.erictruong.android.lists.R
import fr.erictruong.android.lists.item.*

open class Stub(val itemView: View)

class ActionStub(itemView: View) : Stub(itemView), Bindable<MaterialListItem> {

    override fun bind(item: MaterialListItem) {
        itemView.setOnClickListener { v -> item.action(v, item) }
    }

    override fun unbind() {
        // Nothing to do
    }
}

class TextStub(itemView: View) : Stub(itemView), Bindable<Textable> {

    private val text1: TextView
    private val text2: TextView?
    private val text3: TextView?

    init {
        text1 = itemView.findViewById(R.id.text1) as TextView
        text2 = itemView.findViewById(R.id.text2) as TextView?
        text3 = itemView.findViewById(R.id.text3) as TextView?
    }

    override fun bind(item: Textable) {
        text1.text = item.text1
        text2?.text = item.text2
        text3?.text = item.text3
    }

    override fun unbind() {
        // Nothing to do
    }
}

class IconStub(itemView: View) : Stub(itemView), Bindable<Iconable> {

    private val icon: ImageView

    init {
        icon = itemView.findViewById(R.id.icon) as ImageView
    }

    override fun bind(item: Iconable) {
        icon.setImageResource(item.icon)
    }

    override fun unbind() {
        // Nothing to do
    }
}

class AvatarStub(itemView: View) : Stub(itemView), Bindable<Avatarable> {

    private val avatar: ImageView

    private val picasso: Picasso
    private val circleStrokeTransformation: CircleStrokeTransformation

    init {
        val context = itemView.context
        avatar = itemView.findViewById(R.id.avatar) as ImageView
        picasso = Picasso.with(context)
        circleStrokeTransformation = CircleStrokeTransformation(context, Color.WHITE, 0)
    }

    override fun bind(item: Avatarable) {
        picasso.load(item.avatarUrl)
                .placeholder(R.drawable.circle)
                .transform(circleStrokeTransformation)
                .into(avatar)
    }

    override fun unbind() {
        // Nothing to do
    }
}

class CheckBoxStub(itemView: View) : Stub(itemView), Bindable<Checkable> {

    private val checkbox: CheckBox

    init {
        val context = itemView.context
        checkbox = itemView.findViewById(R.id.checkbox) as CheckBox
        val marginSmall = context.resources.getDimensionPixelSize(R.dimen.margin_small)
        ViewUtils.expandTouchArea(itemView, checkbox, marginSmall)
    }

    override fun bind(item: Checkable) {
        checkbox.isChecked = item.isChecked
        checkbox.setOnCheckedChangeListener { buttonView, isChecked ->
            item.isChecked = isChecked
            item.checkAction(buttonView, item)
        }
    }

    override fun unbind() {
        checkbox.setOnCheckedChangeListener(null)
    }
}

class ReorderStub(itemView: View) : Stub(itemView), Bindable<Reorderable> {

    private val icon: ImageView
    private var holder: RecyclerView.ViewHolder? = null

    init {
        icon = itemView.findViewById(R.id.icon) as ImageView
    }

    override fun bind(item: Reorderable) {
        icon.setImageResource(R.drawable.ic_reorder_black_24dp_alpha54)
        icon.setOnTouchListener { v, event ->
            if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                item.itemTouchHelper.startDrag(holder)
            }
            false
        }
    }

    override fun unbind() {
        // Nothing to do
    }

    fun setViewHolder(holder: RecyclerView.ViewHolder) {
        this.holder = holder
    }
}

class SwitchStub(itemView: View) : Stub(itemView), Bindable<Checkable> {

    private val switch_: Switch

    init {
        val context = itemView.context
        switch_ = itemView.findViewById(R.id.switch_) as Switch
        val marginSmall = context.resources.getDimensionPixelSize(R.dimen.margin_small)
        ViewUtils.expandTouchArea(itemView, switch_, marginSmall)
    }

    override fun bind(item: Checkable) {
        switch_.isChecked = item.isChecked
        switch_.setOnCheckedChangeListener { buttonView, isChecked ->
            item.isChecked = isChecked
            item.checkAction(buttonView, item)
        }
    }

    override fun unbind() {
        switch_.setOnCheckedChangeListener(null)
    }
}

class ExpandStub(itemView: View) : Stub(itemView), Bindable<Checkable> {

    private val icon: ImageView?
    private val text1: TextView
    private val checkbox: CheckBox

    @ColorInt
    private val defaultColor: Int
    @ColorInt
    private val colorAccent: Int

    init {
        val context = itemView.context
        icon = itemView.findViewById(R.id.icon) as ImageView
        text1 = itemView.findViewById(R.id.text1) as TextView
        defaultColor = text1.textColors.defaultColor
        colorAccent = ThemeUtils.obtainColorAccent(context)
        checkbox = itemView.findViewById(R.id.checkbox) as CheckBox
        checkbox.setButtonDrawable(R.drawable.selector_expand)
        val marginSmall = context.resources.getDimensionPixelSize(R.dimen.margin_small)
        ViewUtils.expandTouchArea(itemView, checkbox, marginSmall)
    }

    override fun bind(item: Checkable) {
        if (item.isChecked) {
            icon?.setColorFilter(colorAccent)
        } else {
            icon?.clearColorFilter()
        }
        text1.setTextColor(if (item.isChecked) colorAccent else defaultColor)
        checkbox.isChecked = item.isChecked
        checkbox.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                icon?.setColorFilter(colorAccent)
            } else {
                icon?.clearColorFilter()
            }
            text1.setTextColor(if (isChecked) colorAccent else defaultColor)
            item.isChecked = isChecked
            item.checkAction(buttonView, item)
        }
    }

    override fun unbind() {
        checkbox.setOnCheckedChangeListener(null)
    }
}