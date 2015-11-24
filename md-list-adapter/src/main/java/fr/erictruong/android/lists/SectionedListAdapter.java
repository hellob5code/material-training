package fr.erictruong.android.lists;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Comparator;

/**
 * See <a href="https://gist.github.com/gabrielemariotti/4c189fb1124df4556058">https://gist.github.com/gabrielemariotti/4c189fb1124df4556058</a>
 */
public class SectionedListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_SUBHEADER = 0;

    private boolean mValid = true;
    private int mSectionResourceId;
    private int mTextResourceId;
    private RecyclerView.Adapter mBaseAdapter;
    private SparseArray<Section> mSections = new SparseArray<>();

    private RecyclerView.AdapterDataObserver observer = new RecyclerView.AdapterDataObserver() {
        @Override
        public void onChanged() {
            mValid = mBaseAdapter.getItemCount() > 0;
            notifyDataSetChanged();
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount) {
            mValid = mBaseAdapter.getItemCount() > 0;
            notifyItemRangeChanged(positionStart, itemCount);
        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
            mValid = mBaseAdapter.getItemCount() > 0;
            notifyItemRangeInserted(positionStart, itemCount);
        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            mValid = mBaseAdapter.getItemCount() > 0;
            notifyItemRangeRemoved(positionStart, itemCount);
        }
    };

    public SectionedListAdapter(RecyclerView.Adapter baseAdapter) {
        mSectionResourceId = R.layout.list_tile_subheader;
        mTextResourceId = R.id.text1;
        mBaseAdapter = baseAdapter;
        mBaseAdapter.registerAdapterDataObserver(observer);
    }

    public SectionedListAdapter(int sectionResourceId, int textResourceId, RecyclerView.Adapter baseAdapter) {
        mSectionResourceId = sectionResourceId;
        mTextResourceId = textResourceId;
        mBaseAdapter = baseAdapter;
        mBaseAdapter.registerAdapterDataObserver(observer);
    }

    @Override
    public long getItemId(int position) {
        return isSectionHeaderPosition(position)
                ? Integer.MAX_VALUE - mSections.indexOfKey(position)
                : mBaseAdapter.getItemId(sectionedPositionToPosition(position));
    }

    @Override
    public int getItemViewType(int position) {
        return isSectionHeaderPosition(position)
                ? VIEW_TYPE_SUBHEADER
                : mBaseAdapter.getItemViewType(sectionedPositionToPosition(position)) + 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_SUBHEADER) {
            final View view = LayoutInflater.from(parent.getContext()).inflate(mSectionResourceId, parent, false);
            return new SectionViewHolder(view, mTextResourceId);
        } else {
            return mBaseAdapter.onCreateViewHolder(parent, viewType - 1);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder sectionViewHolder, int position) {
        if (isSectionHeaderPosition(position)) {
            if (position == 0) {
                ((SectionViewHolder) sectionViewHolder).divider.setVisibility(View.GONE);
            } else {
                ((SectionViewHolder) sectionViewHolder).divider.setVisibility(View.VISIBLE);
            }
            ((SectionViewHolder) sectionViewHolder).title.setText(mSections.get(position).title);
        } else {
            mBaseAdapter.onBindViewHolder(sectionViewHolder, sectionedPositionToPosition(position));
        }
    }

    @Override
    public int getItemCount() {
        return (mValid ? mBaseAdapter.getItemCount() + mSections.size() : 0);
    }

    public void setSections(Section[] sections) {
        mSections.clear();

        Arrays.sort(sections, new Comparator<Section>() {
            @Override
            public int compare(Section o, Section o1) {
                return (o.firstPosition == o1.firstPosition)
                        ? 0
                        : ((o.firstPosition < o1.firstPosition) ? -1 : 1);
            }
        });

        int offset = 0; // offset positions for the headers we're adding
        for (Section section : sections) {
            section.sectionedPosition = section.firstPosition + offset;
            mSections.append(section.sectionedPosition, section);
            ++offset;
        }

        notifyDataSetChanged();
    }

    public int positionToSectionedPosition(int position) {
        int offset = 0;
        for (int i = 0; i < mSections.size(); i++) {
            if (mSections.valueAt(i).firstPosition > position) {
                break;
            }
            ++offset;
        }
        return position + offset;
    }

    public int sectionedPositionToPosition(int sectionedPosition) {
        if (isSectionHeaderPosition(sectionedPosition)) {
            return RecyclerView.NO_POSITION;
        }

        int offset = 0;
        for (int i = 0; i < mSections.size(); i++) {
            if (mSections.valueAt(i).sectionedPosition > sectionedPosition) {
                break;
            }
            --offset;
        }
        return sectionedPosition + offset;
    }

    public boolean isSectionHeaderPosition(int position) {
        return mSections.get(position) != null;
    }

    public static class SectionViewHolder extends RecyclerView.ViewHolder {

        public View divider;
        public TextView title;

        public SectionViewHolder(View view, int mTextResourceid) {
            super(view);
            divider = view.findViewById(R.id.divider);
            title = (TextView) view.findViewById(mTextResourceid);
        }
    }

    public static class Section {

        int firstPosition;
        int sectionedPosition;
        CharSequence title;

        public Section(int firstPosition, CharSequence title) {
            this.firstPosition = firstPosition;
            this.title = title;
        }

        public CharSequence getTitle() {
            return title;
        }
    }
}