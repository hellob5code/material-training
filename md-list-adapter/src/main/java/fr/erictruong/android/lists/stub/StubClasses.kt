package fr.erictruong.android.lists.stub

import android.graphics.Color
import android.support.annotation.DrawableRes
import android.support.v4.view.MotionEventCompat
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.MotionEvent
import android.view.View
import android.widget.*
import com.squareup.picasso.Picasso
import fr.erictruong.android.core.transform.CircleStrokeTransformation
import fr.erictruong.android.lists.R

class ActionStub(val itemView: View) {

    fun bind(onClick: (v: View) -> Unit) {
        itemView.setOnClickListener { v -> onClick(v) }
    }

    fun unbind() {
        // Nothing to do
    }
}

class TextStub(val text1: TextView, val text2: TextView? = null, val text3: TextView? = null) {

    fun bind(text1: CharSequence, text2: CharSequence? = null, text3: CharSequence? = null) {
        this.text1.text = text1
        this.text2?.text = text2
        this.text3?.text = text3
    }

    fun unbind() {
        // Nothing to do
    }
}

class IconStub(val icon: ImageView) {

    fun bind(@DrawableRes icon: Int) {
        this.icon.setImageResource(icon)
    }

    fun unbind() {
        // Nothing to do
    }
}

class AvatarStub(val avatar: ImageView) {

    val picasso = Picasso.with(avatar.context)
    val circleStrokeTransformation = CircleStrokeTransformation(avatar.context, Color.WHITE, 0)

    fun bind(avatarUrl: String) {
        picasso.load(avatarUrl)
                .placeholder(R.drawable.circle)
                .transform(circleStrokeTransformation)
                .into(avatar)
    }

    fun unbind() {
        // Nothing to do
    }
}

class CheckBoxStub(val checkbox: CheckBox) {

    init {
        val context = checkbox.context
        val marginSmall = context.resources.getDimensionPixelSize(R.dimen.margin_small)
//        ViewUtils.expandTouchArea(checkbox, checkbox, marginSmall)
    }

    fun bind(isChecked: Boolean, onCheckedChanged: (buttonView: CompoundButton, isChecked: Boolean) -> Unit) {
        checkbox.isChecked = isChecked
        checkbox.setOnCheckedChangeListener { buttonView, isChecked -> onCheckedChanged(buttonView, isChecked) }
    }

    fun unbind() {
        checkbox.setOnCheckedChangeListener(null)
    }
}

class ReorderStub(val icon: ImageView, val itemTouchHelper : ItemTouchHelper) {

    fun bind(holder: RecyclerView.ViewHolder) {
        icon.setImageResource(R.drawable.ic_reorder_black_24dp_alpha54)
        icon.setOnTouchListener { v, event ->
            if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                itemTouchHelper.startDrag(holder)
            }
            false
        }
    }

    fun unbind() {
        // Nothing to do
    }
}

class SwitchStub(val toggle: Switch) {

    init {
        val context = toggle.context
        val marginSmall = context.resources.getDimensionPixelSize(R.dimen.margin_small)
//        ViewUtils.expandTouchArea(toggle, toggle, marginSmall)
    }

    fun bind(isChecked: Boolean, onCheckedChanged: (buttonView: CompoundButton, isChecked: Boolean) -> Unit) {
        toggle.isChecked = isChecked
        toggle.setOnCheckedChangeListener { buttonView, isChecked -> onCheckedChanged(buttonView, isChecked) }
    }

    fun unbind() {
        toggle.setOnCheckedChangeListener(null)
    }
}

class ExpandStub(val checkbox: CheckBox) {

    init {
        val context = checkbox.context
        val marginSmall = context.resources.getDimensionPixelSize(R.dimen.margin_small)
//        ViewUtils.expandTouchArea(checkbox, checkbox, marginSmall)
    }

    fun bind(isChecked: Boolean, onCheckedChanged: (buttonView: CompoundButton, isChecked: Boolean) -> Unit) {
        checkbox.isChecked = isChecked
        checkbox.setOnCheckedChangeListener { buttonView, isChecked -> onCheckedChanged(buttonView, isChecked) }
    }

    fun unbind() {
        checkbox.setOnCheckedChangeListener(null)
    }

//    private val icon: ImageView?
//    private val text1: TextView
//    private val checkbox: CheckBox
//
//    @ColorInt
//    private val defaultColor: Int
//    @ColorInt
//    private val colorAccent: Int
//
//    init {
//        val context = itemView.context
//        icon = itemView.findViewById(R.id.icon) as ImageView
//        text1 = itemView.findViewById(R.id.text1) as TextView
//        defaultColor = text1.textColors.defaultColor
//        colorAccent = ThemeUtils.obtainColorAccent(context)
//        checkbox = itemView.findViewById(R.id.checkbox) as CheckBox
//        checkbox.setButtonDrawable(R.drawable.selector_expand)
//        val marginSmall = context.resources.getDimensionPixelSize(R.dimen.margin_small)
//        ViewUtils.expandTouchArea(itemView, checkbox, marginSmall)
//    }
//
//    fun bind(item: Checkable) {
//        if (item.isChecked) {
//            icon?.setColorFilter(colorAccent)
//        } else {
//            icon?.clearColorFilter()
//        }
//        text1.setTextColor(if (item.isChecked) colorAccent else defaultColor)
//        checkbox.isChecked = item.isChecked
//        checkbox.setOnCheckedChangeListener { buttonView, isChecked ->
//            if (isChecked) {
//                icon?.setColorFilter(colorAccent)
//            } else {
//                icon?.clearColorFilter()
//            }
//            text1.setTextColor(if (isChecked) colorAccent else defaultColor)
//            item.isChecked = isChecked
//            item.checkAction(buttonView, item)
//        }
//    }
//
//     fun unbind() {
//        checkbox.setOnCheckedChangeListener(null)
//    }
}