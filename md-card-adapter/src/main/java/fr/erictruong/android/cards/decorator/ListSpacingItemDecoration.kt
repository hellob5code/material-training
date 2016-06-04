package fr.erictruong.android.cards.decorator

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 *
 */
class ListSpacingItemDecoration(val spacing: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        outRect.set(spacing, spacing, spacing, 0)

        val position = parent.getChildAdapterPosition(view)
        if (position == 0) {
            outRect.top = 0
        }
    }
}
