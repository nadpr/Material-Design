package salatigacity.materialdesigndemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import salatigacity.materialdesigndemo.fragment.MainFragment;

/**
 * Created by ssh on 6/13/2017.
 */

public class HomePageAdapter extends FragmentPagerAdapter{

    public String[] title = {"Page Home", "Descriptions", "Promo", "Tickets", "Tour & Travel"};

    public HomePageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return MainFragment.newInstance(title[position]);
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
