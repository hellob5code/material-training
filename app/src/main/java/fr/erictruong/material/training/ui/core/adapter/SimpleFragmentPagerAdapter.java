package fr.erictruong.material.training.ui.core.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<String> titles;
    private ArrayList<Fragment> fragments;

    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        titles = new ArrayList<>(3);
        fragments = new ArrayList<>(3);
    }

    public void addFragment(String title, Fragment fragment) {
        titles.add(title);
        fragments.add(fragment);
    }

    public void addFragment(Fragment fragment) {
        titles.add(null);
        fragments.add(fragment);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
//        Drawable drawable = icons.get(position);
//        if (drawable != null) {
//            Drawable mutated = drawable.mutate();
//            mutated.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
//
//            SpannableStringBuilder builder = new SpannableStringBuilder(" ");
//            String title = titles.get(position);
//            if (title != null && title.length() > 0) {
//                builder.append("\n").append(titles.get(position));
//            }
//            builder.setSpan(new ImageSpan(mutated), 0, 1, 0);
//            return builder;
//        } else {
            return titles.get(position);
//        }
    }
}
