package com.es.estreothaohientruong;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.es.estreothaohientruong.UserInterface.Base.AdapterDelegate;
import com.es.estreothaohientruong.UserInterface.Base.BaseActivity;
import com.es.estreothaohientruong.UserInterface.ChangePassword.ChangePassword;
import com.es.estreothaohientruong.UserInterface.Home.HomeFragment;
import com.es.estreothaohientruong.UserInterface.Home.PageCustomer;
import com.es.estreothaohientruong.UserInterface.Login.LoginActivity;
import com.es.estreothaohientruong.UserInterface.SlideMenu.DrawerItem;
import com.es.estreothaohientruong.UserInterface.SlideMenu.NavigationAdapter;
import com.es.estreothaohientruong.UserInterface.Sync.SyncFragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener,AdapterDelegate {
    private DrawerLayout navDrawerLayout;
    private Toolbar toolbar;
    private ImageView ivMenu,ivSearch;
    private ListView NavList;
    public static TextView tvTitleToolbar;

    //region Activity Life Cycle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        ivMenu = (ImageView) toolbar.findViewById(R.id.toolbar_btnMenu);
        ivSearch = (ImageView) toolbar.findViewById(R.id.toolbar_btnSearch);
        tvTitleToolbar = (TextView) toolbar.findViewById(R.id.toolbar_title_center);
        NavList = (ListView) findViewById(R.id.list_nav);
        /**Custom slide menu*/
        View header = getLayoutInflater().inflate(R.layout.nav_header_main, null);
        String[] title;
        DrawerItem drawerItem;
        ArrayList<DrawerItem> arrDrawerItems;
        TypedArray image;
        image = getResources().obtainTypedArray(R.array.iconEmployee);
        title = getResources().getStringArray(R.array.SlideMenuEmployees);

        arrDrawerItems = new ArrayList<DrawerItem>();
        for (int i = 0; i < title.length; i++) {
            Drawable icon = image.getDrawable(i);
            String navName = title[i];
            drawerItem = new DrawerItem(navName, icon);
            arrDrawerItems.add(drawerItem);
        }

        NavList.addHeaderView(header);
        NavigationAdapter navigationAdapter = new NavigationAdapter(this, arrDrawerItems,this);
        NavList.setAdapter(navigationAdapter);
        NavList.setOnItemClickListener(this);

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
        Fragment fragment = getActivePage();
        if (fragment instanceof PageCustomer){
            tvTitleToolbar.setText(getString(R.string.list_customer));
        }else if (fragment instanceof ChangePassword){
            tvTitleToolbar.setText(getString(R.string.change_pass));
            ivSearch.setVisibility(View.GONE);
        }
    }


//endregion

    //region Init View


//endregion

    //region Navigation


//endregion

    //region Control Action
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.toolbar_btnMenu) {
            if (navDrawerLayout.isDrawerOpen(Gravity.START)) {
                navDrawerLayout.closeDrawer(Gravity.START);
            } else {
                navDrawerLayout.openDrawer(Gravity.START);
            }
            hideKeyboard();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        if (view.getId() == R.id.list_nav) {
            switch (position){
                case 1:
                    SyncFragment syncFragment = new SyncFragment();
                    addFragment(syncFragment,"Sync");
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                    ChangePassword changePassword = new ChangePassword();
                    addFragment(changePassword,"ChangePass");
                    break;
                default:
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                    break;
            }
        navDrawerLayout.closeDrawer(Gravity.START);
//        }
    }

    @Override
    public void onClickItemAdapter(View v) {
        switch (v.getId()){
            case R.id.it_list_nav_ivPrint:

            case R.id.it_list_nav_ivBluetooth:
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
