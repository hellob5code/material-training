package fr.erictruong.android.cards.item

import android.text.style.UpdateAppearance
import fr.erictruong.android.cards.holder.*

interface MaterialCardItem {
    var id: Long
    var viewType: Int

    //    fun decodeViewType(viewType: Int): Int = viewType / MAGIC_NUMBER

    //    fun decodeHolderType(viewType: Int): Int = viewType % MAGIC_NUMBER

    //    /**
    //     * Concatenate holderType (i.e. which view holder class to instantiate) and viewType (i.e. one-line, two-line, three-line)
    //     */
    //    fun encodeViewType(viewType: Int): Int
}

class DisplayBodyItem(override var id: Long, override var viewType: Int = Holder.NORMAL,
                      override var display: CharSequence, override var displayColor: Int? = null, override var displayAppearance: Int? = null,
                      override var body: CharSequence = "", override var bodyColor: Int? = null, override var bodyAppearance: Int? = null
) : MaterialCardItem, Displayable, Bodyable {

    override fun encodeViewType(viewType: Int): Int {
        return (viewType * MAGIC_NUMBER) + DisplayBodyViewHolder.TYPE
    }

    override fun toString(): String = "DisplayBodyItem(id=$id, viewType=$viewType)"
}

class HeadlineBodyItem(id: Long = NO_ID,
                       viewType: Int = Holder.NORMAL,
                       override var headline: CharSequence, override var headlineColor: Int? = null,
                       override var body: CharSequence = "", override var bodyAppearance: Int? = null
) : MaterialCardItem(id, viewType), Headlineable, Bodyable {

    override fun encodeViewType(viewType: Int): Int {
        return (viewType * MAGIC_NUMBER) + HeadlineBodyViewHolder.TYPE
    }

    override fun toString(): String = "HeadlineBodyItem(id=$id, viewType=$viewType)"
}

class HeadlineBodyThreeButtonItem(id: Long = NO_ID,
                                  viewType: Int = Holder.NORMAL,
                                  override var headline: CharSequence, override var headlineColor: Int? = null,
                                  override var body: CharSequence = "", override var bodyAppearance: Int? = null,
                                  override var button1: CharSequence? = null, override var button1Action: (() -> Unit)? = null,
                                  override var button2: CharSequence? = null, override var button2Action: (() -> Unit)? = null,
                                  override var button3: CharSequence? = null, override var button3Action: (() -> Unit)? = null
) : MaterialCardItem(id, viewType), Headlineable, Bodyable, ThreeButtonable {

    override fun encodeViewType(viewType: Int): Int {
        return (viewType * MAGIC_NUMBER) + HeadlineBodyThreeButtonViewHolder.TYPE
    }

    override fun toString(): String = "HeadlineBodyThreeButtonItem(id=$id, viewType=$viewType)"
}

class HeadlineBodySixButtonItem(id: Long = NO_ID,
                                viewType: Int = Holder.NORMAL,
                                override var headline: CharSequence, override var headlineColor: Int? = null,
                                override var body: CharSequence = "", override var bodyAppearance: Int? = null,
                                override var button1: CharSequence? = null, override var button1Action: (() -> Unit)? = null,
                                override var button2: CharSequence? = null, override var button2Action: (() -> Unit)? = null,
                                override var button3: CharSequence? = null, override var button3Action: (() -> Unit)? = null,
                                override var button4: CharSequence? = null, override var button4Action: (() -> Unit)? = null,
                                override var button5: CharSequence? = null, override var button5Action: (() -> Unit)? = null,
                                override var button6: CharSequence? = null, override var button6Action: (() -> Unit)? = null
) : MaterialCardItem(id, viewType), Headlineable, Bodyable, SixButtonable {

    override fun encodeViewType(viewType: Int): Int {
        return (viewType * MAGIC_NUMBER) + HeadlineBodySixButtonViewHolder.TYPE
    }

    override fun toString(): String = "HeadlineBodySixButtonItem(id=$id, viewType=$viewType)"
}