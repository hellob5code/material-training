package fr.erictruong.android.lists;

import android.support.annotation.IntDef;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.List;

import fr.erictruong.android.lists.holder.AvatarCheckBoxViewHolder;
import fr.erictruong.android.lists.holder.AvatarIconViewHolder;
import fr.erictruong.android.lists.holder.AvatarReorderViewHolder;
import fr.erictruong.android.lists.holder.AvatarViewHolder;
import fr.erictruong.android.lists.holder.CheckBoxIconViewHolder;
import fr.erictruong.android.lists.holder.CheckBoxViewHolder;
import fr.erictruong.android.lists.holder.ExpandViewHolder;
import fr.erictruong.android.lists.holder.IconExpandViewHolder;
import fr.erictruong.android.lists.holder.IconSwitchViewHolder;
import fr.erictruong.android.lists.holder.IconViewHolder;
import fr.erictruong.android.lists.holder.TextViewHolder;
import fr.erictruong.android.lists.item.MaterialListItem;

public class MaterialListAdapter extends RecyclerView.Adapter {

    public static final int VIEW_TYPE_ONE_LINE = 0;
    public static final int VIEW_TYPE_TWO_LINE = 1;
    public static final int VIEW_TYPE_THREE_LINE = 2;

    public static final int VIEW_TYPE_ONE_LINE_ICON = 3;
    public static final int VIEW_TYPE_TWO_LINE_ICON = 4;
    public static final int VIEW_TYPE_THREE_LINE_ICON = 5;

    public static final int VIEW_TYPE_ONE_LINE_AVATAR = 6;
    public static final int VIEW_TYPE_TWO_LINE_AVATAR = 7;
    public static final int VIEW_TYPE_THREE_LINE_AVATAR = 8;

    public static final int VIEW_TYPE_ONE_LINE_AVATAR_ICON = 9;
    public static final int VIEW_TYPE_TWO_LINE_AVATAR_ICON = 10;
    public static final int VIEW_TYPE_THREE_LINE_AVATAR_ICON = 11;

    public static final int VIEW_TYPE_ONE_LINE_CHECKBOX = 12;

    public static final int VIEW_TYPE_ONE_LINE_SWITCH = 21;

    public static final int VIEW_TYPE_ONE_LINE_EXPAND = 31;

    public static final int VIEW_TYPE_ONE_LINE_CHECKBOX_ICON = 230;

    public static final int VIEW_TYPE_ONE_LINE_AVATAR_CHECKBOX = 245;

    public static final int VIEW_TYPE_ONE_LINE_ICON_SWITCH = 251;

    public static final int VIEW_TYPE_ONE_LINE_AVATAR_REORDER = 269;

    public static final int VIEW_TYPE_ONE_LINE_ICON_EXPAND = 300;

    @IntDef({VIEW_TYPE_ONE_LINE, VIEW_TYPE_TWO_LINE, VIEW_TYPE_THREE_LINE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TextViewType {
    }

    @IntDef({VIEW_TYPE_ONE_LINE_ICON, VIEW_TYPE_TWO_LINE_ICON, VIEW_TYPE_THREE_LINE_ICON})
    @Retention(RetentionPolicy.SOURCE)
    public @interface IconViewType {
    }

    @IntDef({VIEW_TYPE_ONE_LINE_AVATAR, VIEW_TYPE_TWO_LINE_AVATAR, VIEW_TYPE_THREE_LINE_AVATAR})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AvatarViewType {
    }

    @IntDef({VIEW_TYPE_ONE_LINE_AVATAR_ICON, VIEW_TYPE_TWO_LINE_AVATAR_ICON, VIEW_TYPE_THREE_LINE_AVATAR_ICON})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AvatarIconViewType {
    }

    private List<MaterialListItem> dataset = Collections.emptyList();

    public MaterialListAdapter() {
    }

    public void swapData(List<MaterialListItem> items) {
        this.dataset = items;
        notifyDataSetChanged();
    }

    public MaterialListItem getItem(int position) {
        return dataset.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getViewType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case VIEW_TYPE_ONE_LINE:
                return new TextViewHolder(inflater.inflate(R.layout.list_tile_one_line, parent, false));
            case VIEW_TYPE_TWO_LINE:
                return new TextViewHolder(inflater.inflate(R.layout.list_tile_two_line, parent, false));
            case VIEW_TYPE_THREE_LINE:
                return new TextViewHolder(inflater.inflate(R.layout.list_tile_three_line, parent, false));

            case VIEW_TYPE_ONE_LINE_ICON:
                return new IconViewHolder(inflater.inflate(R.layout.list_tile_one_line_icon, parent, false));
            case VIEW_TYPE_TWO_LINE_ICON:
                return new IconViewHolder(inflater.inflate(R.layout.list_tile_two_line_icon, parent, false));
            case VIEW_TYPE_THREE_LINE_ICON:
                return new IconViewHolder(inflater.inflate(R.layout.list_tile_three_line_icon, parent, false));

            case VIEW_TYPE_ONE_LINE_AVATAR:
                return new AvatarViewHolder(inflater.inflate(R.layout.list_tile_one_line_avatar, parent, false));
            case VIEW_TYPE_TWO_LINE_AVATAR:
                return new AvatarViewHolder(inflater.inflate(R.layout.list_tile_two_line_avatar, parent, false));
            case VIEW_TYPE_THREE_LINE_AVATAR:
                return new AvatarViewHolder(inflater.inflate(R.layout.list_tile_three_line_avatar, parent, false));

            case VIEW_TYPE_ONE_LINE_AVATAR_ICON:
                return new AvatarIconViewHolder(inflater.inflate(R.layout.list_tile_one_line_avatar_icon, parent, false));
            case VIEW_TYPE_TWO_LINE_AVATAR_ICON:
                return new AvatarIconViewHolder(inflater.inflate(R.layout.list_tile_two_line_avatar_icon, parent, false));
            case VIEW_TYPE_THREE_LINE_AVATAR_ICON:
                return new AvatarIconViewHolder(inflater.inflate(R.layout.list_tile_three_line_avatar_icon, parent, false));

            case VIEW_TYPE_ONE_LINE_CHECKBOX:
                return new CheckBoxViewHolder(inflater.inflate(R.layout.list_tile_one_line_checkbox_end, parent, false));

            case VIEW_TYPE_ONE_LINE_EXPAND:
                return new ExpandViewHolder(inflater.inflate(R.layout.list_tile_one_line_checkbox_end, parent, false));

            case VIEW_TYPE_ONE_LINE_CHECKBOX_ICON:
                return new CheckBoxIconViewHolder(inflater.inflate(R.layout.list_tile_one_line_checkbox_icon, parent, false));

            case VIEW_TYPE_ONE_LINE_AVATAR_CHECKBOX:
                return new AvatarCheckBoxViewHolder(inflater.inflate(R.layout.list_tile_one_line_avatar_checkbox, parent, false));

            case VIEW_TYPE_ONE_LINE_ICON_SWITCH:
                return new IconSwitchViewHolder(inflater.inflate(R.layout.list_tile_one_line_icon_switch, parent, false));

            case VIEW_TYPE_ONE_LINE_AVATAR_REORDER:
                return new AvatarReorderViewHolder(inflater.inflate(R.layout.list_tile_one_line_avatar_icon, parent, false));

            case VIEW_TYPE_ONE_LINE_ICON_EXPAND:
                return new IconExpandViewHolder(inflater.inflate(R.layout.list_tile_one_line_icon_expand, parent, false));

            default:
                throw new IllegalArgumentException("Unknown view type: " + viewType);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((Bindable) holder).bind(getItem(position));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    @Override
    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        ((Bindable) holder).unbind();
    }
}
