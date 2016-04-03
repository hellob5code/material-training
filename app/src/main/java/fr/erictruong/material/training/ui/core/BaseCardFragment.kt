package fr.erictruong.material.training.ui.core

import android.graphics.Rect
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

import fr.erictruong.android.cards.MaterialCardAdapter
import fr.erictruong.android.core.fragment.RecyclerFragment
import fr.erictruong.android.core.util.BuildVersion
import fr.erictruong.material.training.R

abstract class BaseCardFragment : RecyclerFragment() {

    var adapter: MaterialCardAdapter = MaterialCardAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
                val margin: Int
                if (BuildVersion.isLollipop()) {
                    margin = resources.getDimensionPixelSize(R.dimen.margin_small)
                    outRect.set(0, margin, 0, 0)
                } else {
                    margin = resources.getDimensionPixelSize(R.dimen.margin_xxsmall)
                    outRect.set(-margin, margin, -margin, 0)
                }

                val position = parent.getChildAdapterPosition(view)

                if (position == 0) {
                    outRect.top = 0
                }
            }
        })
    }
}
