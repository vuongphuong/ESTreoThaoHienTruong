package com.es.estreothaohientruong.UserInterface.Login;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.es.estreothaohientruong.R;
import com.es.estreothaohientruong.UserInterface.Base.BaseActivity;

/**
 * Created by My_PC on 9/1/2017.
 */

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_login);
        if (getActivePage() == null) {
            LoginFragment loginFragment = new LoginFragment();
            switchPage(loginFragment, "login");
        }
    }

    @Override
    public int getPageHolder() {
        return R.id.act_login_main;
    }

    @Override
    public void syncActionBar() {

    }
}
