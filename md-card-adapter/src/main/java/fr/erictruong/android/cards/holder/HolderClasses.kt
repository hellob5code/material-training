package fr.erictruong.android.cards.holder

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Space
import android.widget.TextView
import fr.erictruong.android.cards.Bindable
import fr.erictruong.android.cards.R
import fr.erictruong.android.cards.item.*
import fr.erictruong.android.cards.stub.*

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

    constructor(parent: ViewGroup, viewType: Int) : super(parent, getLayout(viewType, R.layout.card_headline_body1)) {
        headlineStub = HeadlineStub(itemView)
        bodyStub = BodyStub(itemView)

        headline = itemView.findViewById(R.id.headline) as TextView
        body = itemView.findViewById(R.id.body) as TextView
        spaceHeadlineBody = itemView.findViewById(R.id.space_headline_body) as Space
    }

    override fun bind(item: MaterialCardItem) {
        headlineStub.bind(item as Headlineable)
        bodyStub.bind(item as Bodyable)

        if (headline.visibility == View.VISIBLE && body.visibility == View.VISIBLE) {
            spaceHeadlineBody.visibility = View.VISIBLE
        } else {
            spaceHeadlineBody.visibility = View.GONE
        }
    }

    override fun unbind() {
        headlineStub.unbind()
        bodyStub.unbind()
    }
}

class HeadlineBodyThreeButtonViewHolder : Holder {

    companion object {
        val TYPE: Int = 3
    }

    private val headlineStub: HeadlineStub
    private val bodyStub: BodyStub
    private val threeButtonStub: ThreeButtonStub

    private val headline: TextView
    private val body: TextView
    private val spaceHeadlineBody: Space

    constructor(parent: ViewGroup, viewType: Int) : super(parent, getLayout(viewType, R.layout.card_headline_body1_three_button)) {
        headlineStub = HeadlineStub(itemView)
        bodyStub = BodyStub(itemView)
        threeButtonStub = ThreeButtonStub(itemView)

        headline = itemView.findViewById(R.id.headline) as TextView
        body = itemView.findViewById(R.id.body) as TextView
        spaceHeadlineBody = itemView.findViewById(R.id.space_headline_body) as Space
    }

    override fun bind(item: MaterialCardItem) {
        headlineStub.bind(item as Headlineable)
        bodyStub.bind(item as Bodyable)
        threeButtonStub.bind(item as ThreeButtonable)

        if (headline.visibility == View.VISIBLE && body.visibility == View.VISIBLE) {
            spaceHeadlineBody.visibility = View.VISIBLE
        } else {
            spaceHeadlineBody.visibility = View.GONE
        }
    }

    override fun unbind() {
        headlineStub.unbind()
        bodyStub.unbind()
        threeButtonStub.unbind()
    }
}

class HeadlineBodySixButtonViewHolder : Holder {

    companion object {
        val TYPE: Int = 4
    }

    private val headlineStub: HeadlineStub
    private val bodyStub: BodyStub
    private val sixButtonStub: SixButtonStub

    private val headline: TextView
    private val body: TextView
    private val spaceHeadlineBody: Space

    constructor(parent: ViewGroup, viewType: Int) : super(parent, getLayout(viewType, R.layout.card_headline_body1_six_button)) {
        headlineStub = HeadlineStub(itemView)
        bodyStub = BodyStub(itemView)
        sixButtonStub = SixButtonStub(itemView)

        headline = itemView.findViewById(R.id.headline) as TextView
        body = itemView.findViewById(R.id.body) as TextView
        spaceHeadlineBody = itemView.findViewById(R.id.space_headline_body) as Space
    }

    override fun bind(item: MaterialCardItem) {
        headlineStub.bind(item as Headlineable)
        bodyStub.bind(item as Bodyable)
        sixButtonStub.bind(item as SixButtonable)

        if (headline.visibility == View.VISIBLE && body.visibility == View.VISIBLE) {
            spaceHeadlineBody.visibility = View.VISIBLE
        } else {
            spaceHeadlineBody.visibility = View.GONE
        }
    }

    override fun unbind() {
        headlineStub.unbind()
        bodyStub.unbind()
        sixButtonStub.unbind()
    }
}
