package fr.erictruong.android.lists;

import android.support.annotation.IntDef;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.List;

public class MaterialListAdapter<T> extends RecyclerView.Adapter {

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

    public static final int VIEW_TYPE_ONE_LINE_CHECKBOX_ICON = 230;
    public static final int VIEW_TYPE_ONE_LINE_CHECKBOX_AVATAR = 245;
    public static final int VIEW_TYPE_ONE_LINE_ICON_SWITCH = 251;
    public static final int VIEW_TYPE_ONE_LINE_AVATAR_REORDER = 269;

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

    private final MaterialListItemMapper<T> mapper;

    private List<T> dataset = Collections.emptyList();

    public MaterialListAdapter(MaterialListItemMapper<T> mapper) {
        this.mapper = mapper;
    }

    public void swapData(List<T> items) {
        this.dataset = items;
        notifyDataSetChanged();
    }

    public T getData(int position) {
        return dataset.get(position);
    }

    public MaterialListItem getItem(int position) {
        return mapper.map(dataset.get(position));
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).id;
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).viewType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        switch (viewType) {
            case VIEW_TYPE_ONE_LINE:
                view = inflater.inflate(R.layout.list_tile_one_line, parent, false);
                return new TextViewHolder(view);
            case VIEW_TYPE_TWO_LINE:
                view = inflater.inflate(R.layout.list_tile_two_line, parent, false);
                return new TextViewHolder(view);
            case VIEW_TYPE_THREE_LINE:
                view = inflater.inflate(R.layout.list_tile_three_line, parent, false);
                return new TextViewHolder(view);
            case VIEW_TYPE_ONE_LINE_ICON:
                view = inflater.inflate(R.layout.list_tile_one_line_icon, parent, false);
                return new IconViewHolder(view);
            case VIEW_TYPE_TWO_LINE_ICON:
                view = inflater.inflate(R.layout.list_tile_two_line_icon, parent, false);
                return new IconViewHolder(view);
            case VIEW_TYPE_THREE_LINE_ICON:
                view = inflater.inflate(R.layout.list_tile_three_line_icon, parent, false);
                return new IconViewHolder(view);
            case VIEW_TYPE_ONE_LINE_AVATAR:
                view = inflater.inflate(R.layout.list_tile_one_line_avatar, parent, false);
                return new AvatarViewHolder(view);
            case VIEW_TYPE_TWO_LINE_AVATAR:
                view = inflater.inflate(R.layout.list_tile_two_line_avatar, parent, false);
                return new AvatarViewHolder(view);
            case VIEW_TYPE_THREE_LINE_AVATAR:
                view = inflater.inflate(R.layout.list_tile_three_line_avatar, parent, false);
                return new AvatarViewHolder(view);
            case VIEW_TYPE_ONE_LINE_AVATAR_ICON:
                view = inflater.inflate(R.layout.list_tile_one_line_avatar_icon, parent, false);
                return new AvatarIconViewHolder(view);
            case VIEW_TYPE_TWO_LINE_AVATAR_ICON:
                view = inflater.inflate(R.layout.list_tile_two_line_avatar_icon, parent, false);
                return new AvatarIconViewHolder(view);
            case VIEW_TYPE_THREE_LINE_AVATAR_ICON:
                view = inflater.inflate(R.layout.list_tile_three_line_avatar_icon, parent, false);
                return new AvatarIconViewHolder(view);
            case VIEW_TYPE_ONE_LINE_CHECKBOX_ICON:
                view = inflater.inflate(R.layout.list_tile_one_line_checkbox_icon, parent, false);
                return new CheckBoxIconViewHolder(view);
            default:
                throw new IllegalArgumentException("Unknown view type: " + viewType);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MaterialListTileViewHolder) holder).bind(getItem(position), getData(position));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    @Override
    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        ((MaterialListTileViewHolder) holder).unbind();
    }
}
