package fr.erictruong.material.training.ui.components.subheaders

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import fr.erictruong.android.core.activity.RecyclerActivity
import fr.erictruong.android.lists.MaterialListAdapter
import fr.erictruong.android.lists.SectionedListAdapter
import fr.erictruong.android.lists.holder.AvatarViewHolder
import fr.erictruong.android.lists.holder.Holder
import fr.erictruong.android.lists.item.AvatarItem
import fr.erictruong.android.lists.item.MaterialListItem
import fr.erictruong.material.training.model.DummyModel
import java.util.*

class SampleListSubheaderActivity : RecyclerActivity() {

    val itemCount = 42
    val objectModel = DummyModel(0, "http://placehold.it/100/888/888/", "Primary text", "Secondary text", "Tertiary text")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adapter = MaterialListAdapter<AvatarViewHolder>()
        val sectionedAdapter = SectionedListAdapter(adapter)

        recyclerView.adapter = sectionedAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val items = ArrayList<MaterialListItem>(itemCount)
        for (i in 0..itemCount - 1) {
            val item = AvatarItem(
                    id = i.toLong(),
                    viewType = Holder.TWO_LINE,
                    avatarUrl = objectModel.avatarUrl,
                    text1 = objectModel.text1,
                    text2 = objectModel.text2,
                    action = { v, item -> Snackbar.make(recyclerView, "Action - " + item, Snackbar.LENGTH_SHORT).show() })
            items.add(item)
        }
        adapter.swapData(items)

        val sections = ArrayList<SectionedListAdapter.Section>()
        sections.add(SectionedListAdapter.Section(0, "Subheader"))
        sections.add(SectionedListAdapter.Section(5, "Subheader"))
        sections.add(SectionedListAdapter.Section(12, "Subheader"))
        sections.add(SectionedListAdapter.Section(14, "Subheader"))
        sections.add(SectionedListAdapter.Section(20, "Subheader"))
        sectionedAdapter.setSections(sections.toArray<SectionedListAdapter.Section>(arrayOfNulls<SectionedListAdapter.Section>(sections.size)))
    }
}
