package com.es.estreothaohientruong.UserInterface.Login;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by My_PC on 9/1/2017.
 */

public class LoginVPAdapter extends FragmentPagerAdapter {

    public LoginVPAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
       switch (position) {
           case 0:
               return new PageLogin();
           default:
               return new PageSync();
       }
    }


    @Override
    public int getCount() {
        return 2;
    }
}
