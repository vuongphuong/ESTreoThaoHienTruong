package com.es.estreothaohientruong.UserInterface.Login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.es.estreothaohientruong.Helper.Singleton;
import com.es.estreothaohientruong.R;
import com.es.estreothaohientruong.UserInterface.Base.BaseFragment;

/**
 * Created by My_PC on 9/1/2017.
 */

public class PageLogin extends BaseFragment {
    private static EditText edUserName;
    private static EditText edPassword;
    //region Activity Life Cycle
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.page_login, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize(view);
    }

//endregion

    //region Init View
    public void initialize(View view){
        edUserName = (EditText) view.findViewById(R.id.page_login_et_username);
        edPassword = (EditText) view.findViewById(R.id.page_login_et_password);
    }


//endregion

    //region Navigation


//endregion

    //region Control Action
    public void getData(){
        Singleton.getInstance().userName = edUserName.getText().toString();
        Singleton.getInstance().password = edPassword.getText().toString();
    }

//endregion

    //region Control Delegate


//endregion

    //region API


//endregion

    //region Helper
//endregion
}
