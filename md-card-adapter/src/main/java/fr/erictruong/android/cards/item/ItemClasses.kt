package fr.erictruong.android.cards.item

import fr.erictruong.android.cards.holder.DisplayBodyViewHolder
import fr.erictruong.android.cards.holder.HeadlineBodyViewHolder
import fr.erictruong.android.cards.holder.Holder

abstract class MaterialCardItem(var id: Long,
                                var viewType: Int) {

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
     * Concatenate holderType (i.e. which view holder class to instantiate) and viewType (i.e. one-line, two-line, three-line)
     */
    abstract fun encodeViewType(viewType: Int): Int
}

class DisplayBodyItem(id: Long = NO_ID,
                      viewType: Int = Holder.NORMAL,
                      override var display: CharSequence,
                      override var body: CharSequence = "") : MaterialCardItem(id, viewType), Displayable, Bodyable {

    override fun encodeViewType(viewType: Int): Int {
        return (viewType * MAGIC_NUMBER) + DisplayBodyViewHolder.TYPE
    }

    override fun toString(): String = "DisplayBodyItem(id=$id, viewType=$viewType)"
}

class HeadlineBodyItem(id: Long = NO_ID,
                       viewType: Int = Holder.NORMAL,
                       override var headline: CharSequence,
                       override var body: CharSequence = "",
                       override var button1: Buttonable? = null,
                       override var button2: Buttonable? = null,
                       override var button3: Buttonable? = null,
                       override var button4: Buttonable? = null,
                       override var button5: Buttonable? = null,
                       override var button6: Buttonable? = null
//                       override var button1Text: CharSequence?,
//                       override var button2Text: CharSequence?,
//                       override var button3Text: CharSequence?,
//                       override var button4Text: CharSequence?,
//                       override var button5Text: CharSequence?,
//                       override var button6Text: CharSequence?,
//                       override var button1Action: (view: View, item: Buttonable) -> Unit?,
//                       override var button2Action: (view: View, item: Buttonable) -> Unit?,
//                       override var button3Action: (view: View, item: Buttonable) -> Unit?,
//                       override var button4Action: (view: View, item: Buttonable) -> Unit?,
//                       override var button5Action: (view: View, item: Buttonable) -> Unit?,
//                       override var button6Action: (view: View, item: Buttonable) -> Unit?
) : MaterialCardItem(id, viewType), Headlineable, Bodyable, SixButtonable {

    override fun encodeViewType(viewType: Int): Int {
        return (viewType * MAGIC_NUMBER) + HeadlineBodyViewHolder.TYPE
    }

    override fun toString(): String = "HeadlineBodyItem(id=$id, viewType=$viewType)"
}