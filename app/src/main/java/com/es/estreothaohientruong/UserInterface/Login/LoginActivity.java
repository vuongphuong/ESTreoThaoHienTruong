package com.es.estreothaohientruong.UserInterface.Login;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.es.estreothaohientruong.Data.SQLiteConnection.SQLiteConnection;
import com.es.estreothaohientruong.Helper.Common;
import com.es.estreothaohientruong.Helper.CurrentPrefers;
import com.es.estreothaohientruong.Helper.PermissionGrant;
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
        if (PermissionGrant.verify(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, Common.REQUEST_PERMISSION_WRITE_EXTERNAL_STORAGE)) {
            Common.CheckForder();
        }
        hideKeyboard();
        if (getActivePage() == null) {
            if (CurrentPrefers.getInstance().getIP().isEmpty()) {
                PageSync pageSync = new PageSync();
                switchPage(pageSync, "page sync");
            } else {
                LoginFragment loginFragment = new LoginFragment();
                switchPage(loginFragment, "login");
            }
        }
    }

    @Override
    public int getPageHolder() {
        return R.id.act_login_main;
    }

    @Override
    public void syncActionBar() {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == Common.REQUEST_PERMISSION_WRITE_EXTERNAL_STORAGE) {
            boolean grant = true;
            for (int grantResult : grantResults) {
                if (grantResult != PackageManager.PERMISSION_GRANTED) {
                    grant = false;
                }
            }
            if (grant) {
                Common.CheckForder();
            }
        }
    }
}
