package com.es.estreothaohientruong;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.es.estreothaohientruong.UserInterface.Base.BaseActivity;
import com.es.estreothaohientruong.UserInterface.Home.HomeFragment;
import com.es.estreothaohientruong.UserInterface.Login.LoginFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private DrawerLayout navDrawerLayout;
    private Toolbar toolbar;
    private ImageView ivMenu;
    private TextView tvTitleToolbar;

    //region Activity Life Cycle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        ivMenu = (ImageView) toolbar.findViewById(R.id.toolbar_btnMenu);
        tvTitleToolbar = (TextView) toolbar.findViewById(R.id.toolbar_title_center);

        ivMenu.setOnClickListener(this);
        if (getActivePage() == null) {
            HomeFragment homeFragment = new HomeFragment();
            switchPage(homeFragment, "home");
        }
    }

    @Override
    public int getPageHolder() {
        return R.id.act_login_main;
    }

    @Override
    public void syncActionBar() {

    }



//endregion

    //region Init View


//endregion

    //region Navigation


//endregion

    //region Control Action
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.toolbar_btnMenu ){
            if (navDrawerLayout.isDrawerOpen(Gravity.START)) {
                navDrawerLayout.closeDrawer(Gravity.START);
            } else {
                navDrawerLayout.openDrawer(Gravity.START);
            }
            hideKeyboard();
        }

    }

//endregion

    //region Control Delegate


//endregion

    //region API


//endregion

    //region Helper
//endregion
}
