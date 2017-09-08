package com.es.estreothaohientruong.UserInterface.Login;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.es.estreothaohientruong.Data.Base.errors.AuthFailureError;
import com.es.estreothaohientruong.Data.Base.errors.ParserError;
import com.es.estreothaohientruong.Data.Base.errors.ServerError;
import com.es.estreothaohientruong.Data.Response.Api;
import com.es.estreothaohientruong.Helper.AppAlertDialog;
import com.es.estreothaohientruong.Helper.AppLog;
import com.es.estreothaohientruong.Helper.Common;
import com.es.estreothaohientruong.Helper.PermissionGrant;
import com.es.estreothaohientruong.Helper.Singleton;
import com.es.estreothaohientruong.MainActivity;
import com.es.estreothaohientruong.R;
import com.es.estreothaohientruong.UserInterface.Base.BaseFragment;


/**
 * Created by My_PC on 9/1/2017.
 */

public class LoginFragment extends BaseFragment implements View.OnClickListener, ILoginView {
    ViewPager vpLogin;
    CheckBox cbSave;
    Button btnLogin;
    LoginVPAdapter loginVPAdapter;
    LoginPresenter loginPresenter;

    //region Activity Life Cycle
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginPresenter = new LoginPresenter(this);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize(view);

    }

//endregion

    //region Init View
    public void initialize(View view) {
        vpLogin = (ViewPager) view.findViewById(R.id.f_login_vp);
        cbSave = (CheckBox) view.findViewById(R.id.f_login_cbSavePass);
        btnLogin = (Button) view.findViewById(R.id.f_login_btnLogin);
        loginVPAdapter = new LoginVPAdapter(getChildFragmentManager());
        vpLogin.setAdapter(loginVPAdapter);
        btnLogin.setOnClickListener(this);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.f_login_TabLayout);
        tabLayout.setupWithViewPager(vpLogin, true);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.f_login_btnLogin) {
//            if (cbSave.isChecked()) {
//                loginPresenter.writeSharedPrefLogin(userName, pass);
//            } else
//                loginPresenter.clearSharedPrefLogin();
            int count = loginVPAdapter.getCount();
            for(int i=0;i<count;i++){
                Fragment fragment = loginVPAdapter .getItem(i);
                if(fragment instanceof PageLogin){
                    ((PageLogin)fragment).getData();
                    break;
                }
                else if(fragment instanceof PageSync){

                    break;
                }
            }
            if (PermissionGrant.verify(this, new String[]{Manifest.permission.READ_PHONE_STATE}, Common.REQUEST_PERMISSION_READ_PHONE)) {
                showLoadingDialog("Đăng nhập");
                loginPresenter.validateInput(Singleton.getInstance().userName, Singleton.getInstance().password);
            }
        }
    }

    @Override
    public void showLoginFail(String message) {
        AppAlertDialog.showAlertDialogGreen(getContext(), getString(R.string.error1), Color.RED, message, Color.WHITE, getString(R.string.common_ok), Color.RED);
        dismissLoadingDialog();
    }

    @Override
    public void showLoginErorService(int requestId, Exception e) {
        if (e instanceof ServerError) {
            ServerError serverError = (ServerError) e;
            AppLog.d(getString(R.string.app_name), serverError.getError().getErrorDescription());
            AppAlertDialog.showAlertDialogGreen(getContext(), getString(R.string.error1), Color.RED, getString(R.string.error), Color.WHITE, getString(R.string.common_ok), Color.RED);
        } else if (e instanceof ParserError) {
            AppLog.d(getString(R.string.app_name), "parser data error request: " + requestId);
        } else if (e instanceof AuthFailureError) {
            AppLog.d(getString(R.string.app_name), "AuthFailure error request: " + requestId);
        } else {
            AppLog.d(getString(R.string.app_name), "unKnown error request: " + requestId);
            AppAlertDialog.showAlertDialogGreen(getContext(), getString(R.string.error1), Color.RED, getString(R.string.error2), Color.WHITE, getString(R.string.common_ok), Color.RED);
        }
        dismissLoadingDialog();
    }

    @Override
    public void showTextUserPass(String userName, String pass) {

    }

    @Override
    public void showTickCheckbox(boolean isSaveLogin) {
        cbSave.setClickable(isSaveLogin);
    }

    @Override
    public void loginSuccess() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        dismissLoadingDialog();
    }

    @Override
    public Context getContextView() {
        return getContext();
    }

    @Override
    public Api getApi() {
        return mApi;
    }


//endregion

    //region Navigation


//endregion

    //region Control Action

//endregion

    //region Control Delegate


//endregion

    //region API


//endregion

    //region Helper
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == Common.REQUEST_PERMISSION_READ_PHONE) {
            boolean grant = true;
            for (int grantResult : grantResults) {
                if (grantResult != PackageManager.PERMISSION_GRANTED) {
                    grant = false;
                }
            }

            if (grant) {
                showLoadingDialog("Đăng nhập");
                loginPresenter.validateInput(Singleton.getInstance().userName, Singleton.getInstance().password);
            }
        }
    }
//endregion
}
