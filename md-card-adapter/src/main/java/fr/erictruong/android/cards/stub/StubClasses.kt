package fr.erictruong.android.cards.stub

//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import android.widget.TextView
//import fr.erictruong.android.cards.Bindable
//import fr.erictruong.android.cards.R
//import fr.erictruong.android.cards.item.*
//
//open class Stub(val itemView: View)
//
//class DisplayStub(itemView: View) : Stub(itemView), Bindable<Displayable> {
//
//    private val display: TextView
//
//    init {
//        display = itemView.findViewById(R.id.display) as TextView
//    }
//
//    override fun bind(item: Displayable) {
//        if (item.displayColor != null) {
//            display.setTextColor(item.displayColor as Int)
//        }
//        if (item.display.length == 0) {
//            display.visibility = View.GONE
//        } else {
//            display.visibility = View.VISIBLE
//            display.text = item.display
//        }
//    }
//
//    override fun unbind() {
//        // Nothing to do
//    }
//}
//
//class HeadlineStub(itemView: View) : Stub(itemView), Bindable<Headlineable> {
//
//    private val headline: TextView
//
//    init {
//        headline = itemView.findViewById(R.id.headline) as TextView
//    }
//
//    override fun bind(item: Headlineable) {
//        if (item.headlineColor != null) {
//            headline.setTextColor(item.headlineColor as Int)
//        }
//        if (item.headline == null || item.headline.length == 0) {
//            headline.visibility = View.GONE
//        } else {
//            headline.visibility = View.VISIBLE
//            headline.text = item.headline
//        }
//    }
//
//    override fun unbind() {
//        // Nothing to do
//    }
//}
//
//class BodyStub(itemView: View) : Stub(itemView), Bindable<Bodyable> {
//
//    private val body: TextView
//
//    init {
//        body = itemView.findViewById(R.id.body) as TextView
//    }
//
//    override fun bind(item: Bodyable) {
//        if (item.bodyAppearance != null) {
//            body.setTextAppearance(item.bodyAppearance as Int)
//        }
//        if (item.body.length == 0) {
//            body.visibility = View.GONE
//        } else {
//            body.visibility = View.VISIBLE
//            body.text = item.body
//        }
//    }
//
//    override fun unbind() {
//        // Nothing to do
//    }
//}
//
//class ThreeButtonStub(itemView: View) : Stub(itemView), Bindable<ThreeButtonable> {
//
//    private val actionArea: ViewGroup
//    private val btn1: Button
//    private val btn2: Button
//    private val btn3: Button
//
//    init {
//        actionArea = itemView.findViewById(R.id.action_area) as ViewGroup
//        btn1 = itemView.findViewById(R.id.button_1) as Button
//        btn2 = itemView.findViewById(R.id.button_2) as Button
//        btn3 = itemView.findViewById(R.id.button_3) as Button
//    }
//
//    override fun bind(item: ThreeButtonable) {
//        // Assume one action area
//        if (item.button1 == null || item.button1?.length == 0) {
//            actionArea.visibility = View.GONE
//        } else {
//            actionArea.visibility = View.VISIBLE
//            btn1.text = item.button1
//            if (item.button1Action == null) {
//                btn1.isEnabled = false
//            } else {
//                btn1.isEnabled = true
//                btn1.setOnClickListener { v ->
//                    println("AAA A " + item.button1Action)
//                    item.button1Action
//                    println("AAA B")
//                }
//            }
//            disableOrHideButton(btn2, item.button2, item.button2Action)
//            disableOrHideButton(btn3, item.button3, item.button3Action)
//        }
//    }
//
//    private fun disableOrHideButton(btn: Button?, button: CharSequence?, action: (() -> Unit)?) {
//        if (btn != null) {
//            if (button == null || button.length == 0) {
//                btn.visibility = View.GONE
//            } else {
//                btn.visibility = View.VISIBLE
//                btn.text = button
//                if (action == null) {
//                    btn.isEnabled = false
//                } else {
//                    btn.isEnabled = true
//                    btn.setOnClickListener { v -> action }
//                }
//            }
//        }
//    }
//
//    override fun unbind() {
//        // Nothing to do
//    }
//}
//
//class SixButtonStub(itemView: View) : Stub(itemView), Bindable<SixButtonable> {
//
//    private val actionArea1: ViewGroup
//    private val actionArea2: ViewGroup
//    private val actionArea3: ViewGroup
//    private val actionArea4: ViewGroup
//    private val actionArea5: ViewGroup
//    private val actionArea6: ViewGroup
//    private val btn1: Button
//    private val btn2: Button
//    private val btn3: Button
//    private val btn4: Button
//    private val btn5: Button
//    private val btn6: Button
//
//    init {
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
//    }
//
//    override fun bind(item: SixButtonable) {
//        // Assume multiple action areas
//        disableOrHideButton(actionArea1, btn1, item.button1, item.button1Action)
//        disableOrHideButton(actionArea2, btn2, item.button2, item.button2Action)
//        disableOrHideButton(actionArea3, btn3, item.button3, item.button3Action)
//        disableOrHideButton(actionArea4, btn4, item.button4, item.button4Action)
//        disableOrHideButton(actionArea5, btn5, item.button5, item.button5Action)
//        disableOrHideButton(actionArea6, btn6, item.button6, item.button6Action)
//    }
//
//    private fun disableOrHideButton(area: ViewGroup, btn: Button, button: CharSequence?, action: (() -> Unit)?) {
//        if (button == null || button.length == 0) {
//            area.visibility = View.GONE
//        } else {
//            area.visibility = View.VISIBLE
//            btn.text = button
//            if (action == null) {
//                btn.isEnabled = false
//            } else {
//                btn.isEnabled = true
//                btn.setOnClickListener { v -> action }
//            }
//        }
//    }
//
//    override fun unbind() {
//        // Nothing to do
//    }
//}
