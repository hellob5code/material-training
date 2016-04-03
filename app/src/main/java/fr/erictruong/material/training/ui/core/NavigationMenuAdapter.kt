package fr.erictruong.material.training.ui.core

import android.content.Context
import android.graphics.Color
import android.support.v7.view.SupportMenuInflater
import android.support.v7.view.menu.MenuBuilder
import android.support.v7.view.menu.MenuItemImpl
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import fr.erictruong.material.training.R
import fr.erictruong.material.training.supportLollipop
import fr.erictruong.material.training.ui.core.Bindable
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class NavigationMenuUI : AnkoComponent<BaseDrawerActivity> {

    override fun createView(ui: AnkoContext<BaseDrawerActivity>) = with(ui) {
        recyclerView {
            clipToPadding = false
            verticalPadding = dimen(R.dimen.padding_small)
            supportLollipop {
                topPadding += dimen(R.dimen.status_bar_size)
            }
        }
    }
}

class NavigationMenuAdapter(val context: Context, menuResId: Int, val onNavigationItemSelected: (item: MenuItem) -> Unit) : RecyclerView.Adapter<MenuItemViewHolder>(), AnkoLogger {

    val menuItems = mutableListOf<NavigationMenuItem>()
    val subMenuItems = mutableMapOf<Int, List<NavigationMenuItem>>()

    init {
        val menuBuilder = MenuBuilder(context)
        SupportMenuInflater(context).inflate(menuResId, menuBuilder)
        menuBuilder.visibleItems.forEach { item ->
            if (item.hasSubMenu() && item.subMenu.hasVisibleItems()) {
                menuItems.add(NavigationMenuItem(item) { onItemClicked(it) })
                val items = mutableListOf<NavigationMenuItem>()
                for (i in 0..item.subMenu.size() - 1) {
                    val subItem = item.subMenu.getItem(i)
                    items.add(NavigationMenuItem(subItem as MenuItemImpl) { onSubItemClicked(it) })
                }
                subMenuItems.put(item.itemId, items)
            }
        }
    }

    private fun onItemClicked(item: NavigationMenuItem) {
        debug("Clicked item $item id=${item.menuItem.itemId} index=${menuItems.indexOf(item)} isChecked=${item.menuItem.isChecked}")

        val positionStart = menuItems.indexOf(item)

        val subItems = subMenuItems[item.menuItem.itemId]
        if (subItems != null) {
            if (item.menuItem.isChecked) {
                menuItems.removeAll(subItems)
                notifyItemRangeRemoved(positionStart + 1, subItems.size)
            } else {
                menuItems.addAll(positionStart + 1, subItems)
                notifyItemRangeInserted(positionStart + 1, subItems.size)
            }
        }
        item.menuItem.isChecked = !item.menuItem.isChecked
    }

    private fun onSubItemClicked(item: NavigationMenuItem) {
        debug("Clicked subItem $item id=${item.menuItem.itemId} index=${menuItems.indexOf(item)} isChecked=${item.menuItem.isChecked}")
        onNavigationItemSelected(item.menuItem)
        item.menuItem.isChecked = true
        notifyItemChanged(menuItems.indexOf(item))
    }

    override fun getItemViewType(position: Int): Int = if (menuItems[position].menuItem.hasSubMenu()) 0 else 1

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MenuItemViewHolder? {
        var layoutResId = 0
        when (viewType) {
            0 -> layoutResId = R.layout.nav_tile_item
            1 -> layoutResId = R.layout.nav_tile_subitem
            else -> throw IllegalStateException("Unknown view type")
        }
        return MenuItemViewHolder(LayoutInflater.from(parent?.context).inflate(layoutResId, parent, false))
    }

    override fun onBindViewHolder(holder: MenuItemViewHolder?, position: Int) {
        holder?.bind(menuItems[position])
    }

    override fun getItemCount(): Int = menuItems.size
}

class NavigationMenuItem(val menuItem: MenuItemImpl, val onClick: (item: NavigationMenuItem) -> Unit) {
    override fun toString(): String = menuItem.title as String
}

class MenuItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), Bindable<NavigationMenuItem> {

    val text1 by lazy { itemView.findViewById(R.id.text1) as TextView }

    override fun bind(item: NavigationMenuItem) {
        text1.text = item.menuItem.title
        if (item.menuItem.isChecked) {
            text1.textColor = Color.RED
        } else {
            text1.textColor = itemView.getResources().getColor(R.color.material_text)
        }
        itemView.setOnClickListener { item.onClick(item) }
    }

    override fun unbind() {
    }
}
