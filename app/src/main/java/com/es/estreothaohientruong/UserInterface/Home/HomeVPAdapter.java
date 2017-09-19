package com.es.estreothaohientruong.UserInterface.Home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.es.estreothaohientruong.UserInterface.Inspect.InspectFragment;

import java.util.ArrayList;

/**
 * Created by My_PC on 9/1/2017.
 */

public class HomeVPAdapter extends FragmentPagerAdapter {
    private ArrayList<String> arrPageTitle;
    private boolean isInspect;

    public HomeVPAdapter(FragmentManager fm, ArrayList<String> arrPageTitle, boolean isInspect) {
        super(fm);
        this.arrPageTitle = arrPageTitle;
        this.isInspect = isInspect;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                if (isInspect) {
                    return new PageCustomer();
                } else {
                    return new InspectFragment();
                }
            case 1:
                return new PageMeter();
            case 2:
                return new PageMeter();
            default:
                return null;
        }
    }


    @Override
    public int getCount() {
        return arrPageTitle.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return arrPageTitle.get(position);
    }
}
