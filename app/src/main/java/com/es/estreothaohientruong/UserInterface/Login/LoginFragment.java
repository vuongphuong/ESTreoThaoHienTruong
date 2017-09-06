package com.es.estreothaohientruong.UserInterface.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.es.estreothaohientruong.MainActivity;
import com.es.estreothaohientruong.R;
import com.es.estreothaohientruong.UserInterface.Base.BaseFragment;
import com.viewpagerindicator.CirclePageIndicator;

/**
 * Created by My_PC on 9/1/2017.
 */

public class LoginFragment extends BaseFragment implements View.OnClickListener, ILoginView {
    ViewPager vpLogin;
    CheckBox cbSave;
    Button btnLogin;
    LoginVPAdapter loginVPAdapter;

    //region Activity Life Cycle
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void showLoginFail(String message) {
    }

    @Override
    public void showTextUserPass(String userName, String pass) {

    }

    @Override
    public void showTickCheckbox(boolean isSaveLogin) {
        cbSave.setClickable(isSaveLogin);
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
//endregion
}
