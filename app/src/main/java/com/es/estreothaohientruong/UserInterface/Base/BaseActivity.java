package com.es.estreothaohientruong.UserInterface.Base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;

import com.es.estreothaohientruong.Helper.AppLog;

/**
 * Created by My_PC on 8/30/2017.
 */

public abstract class BaseActivity extends AppCompatActivity implements NativeManager {

    protected FragmentManager mFragmentManager;
    InputMethodManager imm;
    public static Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentManager = getSupportFragmentManager();
        context = this;
    }

    @Override
    public void addFragment(Fragment fragment, String name) {
        if (fragment == null) {
            return;
        }
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        ft.replace(getPageHolder(), fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void switchPage(Fragment fragment, String name) {
        try {
            if (fragment == null) {
                return;
            }
            for (int i = 0; i < mFragmentManager.getBackStackEntryCount(); i++) {
                mFragmentManager.popBackStack();
                AppLog.e("stack",mFragmentManager.toString());
            }
            AppLog.e("stack",mFragmentManager.toString());
            FragmentTransaction ft = mFragmentManager.beginTransaction();
            ft.replace(getPageHolder(), fragment);
            ft.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Fragment getActivePage() {
        return mFragmentManager.findFragmentById(getPageHolder());
    }

    @Override
    public void goBack() {
        if (mFragmentManager.popBackStackImmediate()) {
            mFragmentManager.popBackStack();
        } else {
            onBackPressed();
        }
    }
    public InputMethodManager getIMM() {
        if (imm == null) {
            imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        }
        return imm;
    }
    public void hideKeyboard() {
        if (getCurrentFocus() != null) {
            getIMM().hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }
}
