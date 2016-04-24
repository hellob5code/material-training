package fr.erictruong.android.cards.holder

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Space
import android.widget.TextView
import fr.erictruong.android.cards.Bindable
import fr.erictruong.android.cards.R
import fr.erictruong.android.cards.item.Bodyable
import fr.erictruong.android.cards.item.Displayable
import fr.erictruong.android.cards.item.Headlineable
import fr.erictruong.android.cards.item.MaterialCardItem
import fr.erictruong.android.cards.stub.BodyStub
import fr.erictruong.android.cards.stub.DisplayStub
import fr.erictruong.android.cards.stub.HeadlineStub

abstract class Holder(parent: ViewGroup, resource: Int) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(resource, parent, false)), Bindable<MaterialCardItem> {

    companion object {
        const val NORMAL = 0
    }

//    @IntDef(NORMAL.toLong())
//    @Retention(AnnotationRetention.SOURCE)
//    annotation class ViewType
}

fun getLayout(viewType: Int, @LayoutRes normal: Int): Int {
    when (viewType) {
        Holder.NORMAL -> return normal
        else -> throw IllegalArgumentException("Unknown view type: " + viewType)
    }
}

class DisplayBodyViewHolder : Holder {

    companion object {
        val TYPE: Int = 1
    }

    private val displayStub: DisplayStub
    private val bodyStub: BodyStub

    private val display: TextView
    private val body: TextView
    private val spaceDisplayBody: Space

    constructor(parent: ViewGroup, viewType: Int) : super(parent, getLayout(viewType, R.layout.card_display1_body1)) {
        displayStub = DisplayStub(itemView)
        bodyStub = BodyStub(itemView)

        display = itemView.findViewById(R.id.display) as TextView
        body = itemView.findViewById(R.id.body) as TextView
        spaceDisplayBody = itemView.findViewById(R.id.space_display_body) as Space
    }

    override fun bind(item: MaterialCardItem) {
        displayStub.bind(item as Displayable)
        bodyStub.bind(item as Bodyable)

        if (display.visibility == View.VISIBLE && body.visibility == View.VISIBLE) {
            spaceDisplayBody.visibility = View.VISIBLE
        } else {
            spaceDisplayBody.visibility = View.GONE
        }
    }

    override fun unbind() {
        displayStub.unbind()
        bodyStub.unbind()
    }
}

class HeadlineBodyViewHolder : Holder {

    companion object {
        val TYPE: Int = 2
    }

    private val headlineStub: HeadlineStub
    private val bodyStub: BodyStub

    private val headline: TextView
    private val body: TextView
    private val spaceHeadlineBody: Space
//    private val actionArea: ViewGroup?
//    private val actionArea1: ViewGroup?
//    private val actionArea2: ViewGroup?
//    private val actionArea3: ViewGroup?
//    private val actionArea4: ViewGroup?
//    private val actionArea5: ViewGroup?
//    private val actionArea6: ViewGroup?
//    private val btn1: Button?
//    private val btn2: Button?
//    private val btn3: Button?
//    private val btn4: Button?
//    private val btn5: Button?
//    private val btn6: Button?

    constructor(parent: ViewGroup, viewType: Int) : super(parent, getLayout(viewType, R.layout.card_headline_body1)) {
        headlineStub = HeadlineStub(itemView)
        bodyStub = BodyStub(itemView)

        headline = itemView.findViewById(R.id.headline) as TextView
        body = itemView.findViewById(R.id.body) as TextView
        spaceHeadlineBody = itemView.findViewById(R.id.space_headline_body) as Space
//        actionArea = itemView.findViewById(R.id.action_area) as ViewGroup
//        actionArea1 = itemView.findViewById(R.id.action_area_1) as ViewGroup
//        actionArea2 = itemView.findViewById(R.id.action_area_2) as ViewGroup
//        actionArea3 = itemView.findViewById(R.id.action_area_3) as ViewGroup
//        actionArea4 = itemView.findViewById(R.id.action_area_4) as ViewGroup
//        actionArea5 = itemView.findViewById(R.id.action_area_5) as ViewGroup
//        actionArea6 = itemView.findViewById(R.id.action_area_6) as ViewGroup
//        btn1 = itemView.findViewById(R.id.button_1) as Button
//        btn2 = itemView.findViewById(R.id.button_2) as Button
//        btn3 = itemView.findViewById(R.id.button_3) as Button
//        btn4 = itemView.findViewById(R.id.button_4) as Button
//        btn5 = itemView.findViewById(R.id.button_5) as Button
//        btn6 = itemView.findViewById(R.id.button_6) as Button
    }

    override fun bind(item: MaterialCardItem) {
        headlineStub.bind(item as Headlineable)
        bodyStub.bind(item as Bodyable)

        if (headline.visibility == View.VISIBLE && body.visibility == View.VISIBLE) {
            spaceHeadlineBody.visibility = View.VISIBLE
        } else {
            spaceHeadlineBody.visibility = View.GONE
        }

//        if (actionArea == null) {
//            // Assume multiple action areas
//            disableOrHideButton(actionArea1, btn1, item.button1, item.action1)
//            disableOrHideButton(actionArea2, btn2, item.button2, item.action2)
//            disableOrHideButton(actionArea3, btn3, item.button3, item.action3)
//            disableOrHideButton(actionArea4, btn4, item.button4, item.action4)
//            disableOrHideButton(actionArea5, btn5, item.button5, item.action5)
//            disableOrHideButton(actionArea6, btn6, item.button6, item.action6)
//        } else {
//            // Assume one action area
//            if (item.button1 == null || item.button1.length == 0) {
//                actionArea.visibility = View.GONE
//            } else {
//                actionArea.visibility = View.VISIBLE
//                btn1!!.text = item.button1
//                if (item.action1 == null) {
//                    btn1.isEnabled = false
//                } else {
//                    btn1.isEnabled = true
//                    btn1.setOnClickListener(item.action1)
//                }
//                disableOrHideButton(btn2, item.button2, item.action2)
//                disableOrHideButton(btn3, item.button3, item.action3)
//            }
//        }
    }

    private fun disableOrHideButton(area: ViewGroup?, btn: Button, button: CharSequence?, action: View.OnClickListener?) {
        if (area != null) {
            if (button == null || button.length == 0) {
                area.visibility = View.GONE
            } else {
                area.visibility = View.VISIBLE
                btn.text = button
                if (action == null) {
                    btn.isEnabled = false
                } else {
                    btn.isEnabled = true
                    btn.setOnClickListener(action)
                }
            }
        }
    }

    private fun disableOrHideButton(btn: Button?, button: CharSequence?, action: View.OnClickListener?) {
        if (btn != null) {
            if (button == null || button.length == 0) {
                btn.visibility = View.GONE
            } else {
                btn.visibility = View.VISIBLE
                btn.text = button
                if (action == null) {
                    btn.isEnabled = false
                } else {
                    btn.isEnabled = true
                    btn.setOnClickListener(action)
                }
            }
        }
    }

    override fun unbind() {
        headlineStub.unbind()
        bodyStub.unbind()
    }
}
