package fr.erictruong.training.material.ui.fragment;

import fr.erictruong.training.material.R;
import fr.erictruong.training.material.ui.card.Card;
import fr.erictruong.training.material.ui.card.DisplayBodyCard;
import fr.erictruong.training.material.ui.card.HeadlineBodyCard;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.RecyclerView.NO_ID;
import static fr.erictruong.training.material.ui.card.Card.TYPE_PRIMARY_DISPLAY_1_BODY_2;
import static fr.erictruong.training.material.ui.card.Card.TYPE_PRIMARY_HEADLINE_BODY_1;

public class DataFormatsFragment extends MaterialTrainingFragment {

    @Override
    protected List<Card> populateDataset() {
        List<Card> dataset = new ArrayList<>();
        dataset.add(new DisplayBodyCard(NO_ID, TYPE_PRIMARY_DISPLAY_1_BODY_2, getString(R.string.fragment_data_formats), getString(R.string.fragment_data_formats_txt)));
        dataset.add(new HeadlineBodyCard(NO_ID, TYPE_PRIMARY_HEADLINE_BODY_1, getString(R.string.fragment_data_formats_date_and_time), null));
        dataset.add(new HeadlineBodyCard(NO_ID, TYPE_PRIMARY_HEADLINE_BODY_1, getString(R.string.fragment_data_formats_data_redaction_and_truncation), null));
        return dataset;
    }

//    @InjectView(R.id.recycler)
//    RecyclerView mRecyclerView;
//
//    private RecyclerView.Adapter mAdapter;
//    private RecyclerView.LayoutManager mLayoutManager;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.recycler_view, container, false);
//        ButterKnife.inject(this, view);
//
//        mLayoutManager = new LinearLayoutManager(getActivity());
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
//            @Override
//            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//                if (parent.getChildPosition(view) < 1)
//                    return;
//                if (ApiUtils.isLollipop()) {
//                    outRect.top = getResources().getDimensionPixelSize(R.dimen.margin_small);
//                } else {
//                    outRect.top = getResources().getDimensionPixelSize(R.dimen.margin_xsmall);
//                }
//            }
//        });
//
//        List<Data> dataset = populateDataset();
//
//        mAdapter = new InternalAdapter(dataset);
//        mRecyclerView.setAdapter(mAdapter);
//        return view;
//    }
//
//    private List<Data> populateDataset() {
//        Context ctx = getActivity();
//        DateTime now = new DateTime();
//        List<Data> dataset = new ArrayList<Data>();
//        dataset.add(new Data(formatDateTime(ctx, now.getMillis(), FORMAT_SHOW_TIME), getString(R.string.fragment_patterns_basic_1)));
//        dataset.add(new Data(formatSameDayTime(now.getMillis(), now.getMillis(), 0, DateFormat.SHORT), getString(R.string.fragment_patterns_basic_2)));
//        dataset.add(new Data(formatDateTime(ctx, now.getMillis(), FORMAT_ABBREV_ALL), getString(R.string.fragment_patterns_basic_3)));
//        dataset.add(new Data(formatDateTime(ctx, now.plusYears(1).getMillis(), FORMAT_ABBREV_ALL), getString(R.string.fragment_patterns_basic_4)));
//        dataset.add(new Data(formatDateRange(ctx, now.getMillis(), now.plusHours(4).getMillis(), FORMAT_SHOW_TIME | FORMAT_ABBREV_ALL) + "\n" +
//                formatDateRange(ctx, now.getMillis(), now.plusWeeks(4).getMillis(), FORMAT_ABBREV_ALL | FORMAT_NO_YEAR),
//                getString(R.string.fragment_patterns_basic_5)
//        ));
//        dataset.add(new Data(formatDateRange(ctx, now.getMillis(), now.plusWeeks(1).getMillis(), FORMAT_ABBREV_ALL | FORMAT_NO_YEAR) + "\n" +
//                formatDateRange(ctx, now.getMillis(), now.plusYears(1).getMillis(), FORMAT_ABBREV_ALL | FORMAT_NO_YEAR),
//                getString(R.string.fragment_patterns_basic_6)
//        ));
//        dataset.add(new Data(formatDateRange(ctx, now.getMillis(), now.plusHours(1).getMillis(), FORMAT_SHOW_TIME | FORMAT_ABBREV_ALL), getString(R.string.fragment_patterns_basic_7)));
//        dataset.add(new Data(DateTimeFormat.forPattern("zZZ").print(now), getString(R.string.fragment_patterns_basic_8)));
//
//        dataset.add(new Data(getRelativeTimeSpanString(now.minusDays(1).getMillis(), now.getMillis(), DAY_IN_MILLIS) + ", " +
//                getRelativeTimeSpanString(now.plusDays(1).getMillis(), now.getMillis(), DAY_IN_MILLIS),
//                getString(R.string.fragment_patterns_human_1)
//        ));
//        dataset.add(new Data(DateTimeFormat.forPattern("EEEE").print(now.plusDays(2)), getString(R.string.fragment_patterns_human_2)));
////        dataset.add(new Data(formatDateTime(ctx, now.getMillis(), 0), getString(R.string.fragment_patterns_human_3)));
//        dataset.add(new Data(getRelativeTimeSpanString(now.plusMinutes(5).getMillis(), now.getMillis(), MINUTE_IN_MILLIS, 0) + "\n" +
//                new PeriodFormatterBuilder().appendHours().appendSuffix(" hours from now").toFormatter().print(new Period(now, now.plusHours(8))) + "\n" +
//                getRelativeTimeSpanString(now.minusDays(3).getMillis(), now.getMillis(), DAY_IN_MILLIS, 0),
//                getString(R.string.fragment_patterns_human_4)
//        ));
//        dataset.add(new Data(DateTimeFormat.forPattern("E, MMM d").print(now) + "\n" +
//                getRelativeTimeSpanString(now.plusSeconds(1).getMillis(), now.getMillis(), DAY_IN_MILLIS) + ", " + DateTimeFormat.forPattern("h:mm a").print(now), getString(R.string.fragment_patterns_human_5)
//        ));
//
//        dataset.add(new Data(DateTimeFormat.forPattern("MMM d, h:mm a").print(now.plusDays(8)), getString(R.string.fragment_patterns_modular_1)));
//        dataset.add(new Data(DateTimeFormat.forPattern("'Reminded' MMM d, h:mm a").print(now.minusDays(8)), getString(R.string.fragment_patterns_modular_2)));
//        dataset.add(new Data(DateTimeFormat.forPattern("E, MMM d, h:mm a").print(now), getString(R.string.fragment_patterns_modular_3)));
//        dataset.add(new Data(DateTimeFormat.forPattern("MMM d").print(now.minusDays(5)), getString(R.string.fragment_patterns_modular_4)));
//        dataset.add(new Data(formatElapsedTime(30) + "\n" +
//                formatElapsedTime(134) + "\n" +
//                formatElapsedTime(3665),
//                getString(R.string.fragment_patterns_modular_5)));
//
//        DateTime date = new DateTime(2014, 1, 6, 8, 0, 0);
//        dataset.add(new Data(DateTimeFormat.forPattern("MMM d").print(date) + ", " +
//                DateTimeFormat.forPattern("MMM d").print(date.plusMonths(1).plusDays(1)) + ", " +
//                DateTimeFormat.forPattern("MMM d").print(date.plusMonths(2).plusDays(2)) + ", " +
//                DateTimeFormat.forPattern("MMM d").print(date.plusMonths(3).plusDays(3)) + ", " +
//                DateTimeFormat.forPattern("MMM d").print(date.plusMonths(4).plusDays(4)) + ", " +
//                DateTimeFormat.forPattern("MMM d").print(date.plusMonths(5).plusDays(5)) + ", " +
//                DateTimeFormat.forPattern("MMM d").print(date.plusMonths(6).plusDays(6)) + ", " +
//                DateTimeFormat.forPattern("MMM d").print(date.plusMonths(7).plusDays(7)) + ", " +
//                DateTimeFormat.forPattern("MMM d").print(date.plusMonths(8).plusDays(8)) + ", " +
//                DateTimeFormat.forPattern("MMM d").print(date.plusMonths(9).plusDays(9)) + ", " +
//                DateTimeFormat.forPattern("MMM d").print(date.plusMonths(10).plusDays(10)) + ", " +
//                DateTimeFormat.forPattern("MMM d").print(date.plusMonths(11).plusDays(11)),
//                getString(R.string.fragment_patterns_brief_1)));
//        dataset.add(new Data(DateTimeFormat.forPattern("E, h:mm a").print(date) + "\n" +
//                DateTimeFormat.forPattern("E, h:mm a").print(date.plusDays(1).plusHours(1)) + "\n" +
//                DateTimeFormat.forPattern("E, h:mm a").print(date.plusDays(2).plusHours(2)) + "\n" +
//                DateTimeFormat.forPattern("E, h:mm a").print(date.plusDays(3).plusHours(3)) + "\n" +
//                DateTimeFormat.forPattern("E, h:mm a").print(date.plusDays(4).plusHours(4)) + "\n" +
//                DateTimeFormat.forPattern("E, h:mm a").print(date.plusDays(5).plusHours(5)) + "\n" +
//                DateTimeFormat.forPattern("E, h:mm a").print(date.plusDays(6).plusHours(6)),
//                getString(R.string.fragment_patterns_brief_2)));
//        dataset.add(new Data(DateTimeFormat.forPattern("h a").print(now.getMillis()) + "\n" +
//                new PeriodFormatterBuilder().appendHours().appendSuffix(" hr ").appendMinutes().appendSuffix(" min ago").toFormatter().print(new Period(now.minusHours(2).minusMinutes(32), now)) + "\n" +
//                formatDateTime(ctx, now.getMillis(), FORMAT_SHOW_YEAR | FORMAT_NUMERIC_DATE),
//                getString(R.string.fragment_patterns_brief_3)));
//        dataset.add(new Data(DateTimeFormat.forPattern("MMM d").print(now.plusDays(1)), getString(R.string.fragment_patterns_brief_4)));
//        return dataset;
//    }
//
//    private String formatDateRange(Context context, long startMillis, long endMillis, int flags) {
//        return DateUtils.formatDateRange(context, startMillis, endMillis, flags).replace(" – ", "–"); // en-dash
//    }
//
//    public class InternalAdapter extends RecyclerView.Adapter<InternalAdapter.ViewHolder> {
//        private List<Data> mDataset;
//
//        public InternalAdapter(List<Data> dataset) {
//            mDataset = dataset;
//        }
//
//        @Override
//        public InternalAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_data_formats, parent, false);
//            return new ViewHolder(v);
//        }
//
//        @Override
//        public void onBindViewHolder(ViewHolder holder, int position) {
//            Data row = mDataset.get(position);
//            holder.textView1.setText(row.datetime);
//            holder.textView2.setText(row.text);
//        }
//
//        @Override
//        public int getItemCount() {
//            return mDataset.size();
//        }
//
//        public class ViewHolder extends RecyclerView.ViewHolder {
//            public TextView textView1;
//            public TextView textView2;
//
//            public ViewHolder(View v) {
//                super(v);
//                textView1 = (TextView) v.findViewById(R.id.text1);
//                textView2 = (TextView) v.findViewById(R.id.text2);
//            }
//        }
//    }
//
//    private class Data {
//        CharSequence datetime;
//        String text;
//
//        public Data(String text) {
//            this.text = text;
//        }
//
//        public Data(CharSequence datetime, String text) {
//            this.datetime = datetime;
//            this.text = text;
//        }
//
//        public CharSequence getDatetime() {
//            return datetime;
//        }
//
//        public String getText() {
//            return text;
//        }
//    }
}
