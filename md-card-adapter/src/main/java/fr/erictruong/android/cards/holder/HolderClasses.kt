package fr.erictruong.android.cards.holder

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import fr.erictruong.android.cards.R

fun inflate(parent: ViewGroup, resource: Int) = LayoutInflater.from(parent.context).inflate(resource, parent, false)

inline fun inflate(parent: ViewGroup, resource: () -> Int): View = LayoutInflater.from(parent.context).inflate(resource(), parent, false)

open class MediaBody1ViewHolder : RecyclerView.ViewHolder {

    val media_area: ImageView
    val body: TextView

    constructor(parent: ViewGroup, viewType: Int) : super(inflate(parent, R.layout.card_media_body1)) {
        media_area = itemView.findViewById(R.id.media_area) as ImageView
        body = itemView.findViewById(R.id.body) as TextView
    }
}

open class AvatarSubheaderMediaBody1ActionsViewHolder : RecyclerView.ViewHolder {

    val avatar: ImageView
    val title: TextView
    val subtitle: TextView
    val media_area: ImageView
    val body: TextView
    val action1: Button
    val action2: Button

    constructor(parent: ViewGroup, viewType: Int) : super(inflate(parent) {
        when (viewType) {
            0 -> R.layout.card_avatar_subheader_media_body1_actions
            1 -> R.layout.card_avatar_subheader_media_body1_vertical_actions
            else -> throw IllegalArgumentException("Unknown view type: " + viewType)
        }
    }) {
        avatar = itemView.findViewById(R.id.avatar) as ImageView
        title = itemView.findViewById(R.id.title) as TextView
        subtitle = itemView.findViewById(R.id.subtitle) as TextView
        media_area = itemView.findViewById(R.id.media_area) as ImageView
        body = itemView.findViewById(R.id.body) as TextView
        action1 = itemView.findViewById(R.id.action1) as Button
        action2 = itemView.findViewById(R.id.action2) as Button
    }
}

open class HeadlineSubtextBody1ActionsViewHolder : RecyclerView.ViewHolder {

    val headline: TextView
    val subtext: TextView
    val body: TextView
    val action1: Button
    val action2: Button

    constructor(parent: ViewGroup, viewType: Int) : super(inflate(parent, R.layout.card_headline_subtext_body1_actions)) {
        headline = itemView.findViewById(R.id.headline) as TextView
        subtext = itemView.findViewById(R.id.subtext) as TextView
        body = itemView.findViewById(R.id.body) as TextView
        action1 = itemView.findViewById(R.id.action1) as Button
        action2 = itemView.findViewById(R.id.action2) as Button
    }
}

open class MediaActionsViewHolder : RecyclerView.ViewHolder {

    val media_area: ImageView
    val action1: ImageButton
    val action2: ImageButton
    val action3: ImageButton

    constructor(parent: ViewGroup, viewType: Int) : super(inflate(parent) {
        when (viewType) {
            0 -> R.layout.card_media_actions_alt1
            1 -> R.layout.card_media_actions_alt2
            else -> throw IllegalArgumentException("Unknown view type: " + viewType)
        }
    }) {
        media_area = itemView.findViewById(R.id.media_area) as ImageView
        action1 = itemView.findViewById(R.id.action1) as ImageButton
        action2 = itemView.findViewById(R.id.action2) as ImageButton
        action3 = itemView.findViewById(R.id.action3) as ImageButton
    }
}

open class MediaHeadlineActionsViewHolder : RecyclerView.ViewHolder {

    val media_area: ImageView
    val headline: TextView
    val action1: ImageButton
    val action2: ImageButton
    val action3: ImageButton

    constructor(parent: ViewGroup, viewType: Int) : super(inflate(parent, R.layout.card_media_headline_actions)) {
        media_area = itemView.findViewById(R.id.media_area) as ImageView
        headline = itemView.findViewById(R.id.headline) as TextView
        action1 = itemView.findViewById(R.id.action1) as ImageButton
        action2 = itemView.findViewById(R.id.action2) as ImageButton
        action3 = itemView.findViewById(R.id.action3) as ImageButton
    }
}

open class MediaHeadlineSubtextActionsViewHolder : RecyclerView.ViewHolder {

    val media_area: ImageView
    val title: TextView
    val subtitle: TextView
    val action1: Button
    val action2: Button

    constructor(parent: ViewGroup, viewType: Int) : super(inflate(parent) {
        when (viewType) {
            0 -> R.layout.card_media_headline_subtext_actions_alt1
            1 -> R.layout.card_media_headline_subtext_actions_alt2
            2 -> R.layout.card_media_headline_subtext_actions_alt3
            3 -> R.layout.card_media_headline_subtext_actions_alt4
            else -> throw IllegalArgumentException("Unknown view type: " + viewType)
        }
    }) {
        media_area = itemView.findViewById(R.id.media_area) as ImageView
        title = itemView.findViewById(R.id.headline) as TextView
        subtitle = itemView.findViewById(R.id.subtext) as TextView
        action1 = itemView.findViewById(R.id.action1) as Button
        action2 = itemView.findViewById(R.id.action2) as Button
    }
}

open class MediaHeadlineSubtextActionsExpandBody1ViewHolder : RecyclerView.ViewHolder {

    val media_area: ImageView
    val headline: TextView
    val subtext: TextView
    val body: TextView
    val action1: Button
    val action2: Button

    constructor(parent: ViewGroup, viewType: Int) : super(inflate(parent, R.layout.card_media_headline_subtext_actions_expand_body1)) {
        media_area = itemView.findViewById(R.id.media_area)as ImageView
        headline = itemView.findViewById(R.id.headline)as TextView
        subtext = itemView.findViewById(R.id.subtext)as TextView
        body = itemView.findViewById(R.id.body)as TextView
        action1 = itemView.findViewById(R.id.action1)as Button
        action2 = itemView.findViewById(R.id.action2)as Button
    }
}
