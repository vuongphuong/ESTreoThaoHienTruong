package com.es.estreothaohientruong.UserInterface.Login;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.es.estreothaohientruong.Data.Base.errors.AuthFailureError;
import com.es.estreothaohientruong.Data.Base.errors.ParserError;
import com.es.estreothaohientruong.Data.Base.errors.ServerError;
import com.es.estreothaohientruong.Data.Entities.ManagementUnitEntity;
import com.es.estreothaohientruong.Data.Api;
import com.es.estreothaohientruong.Data.SQLiteConnection.SQLiteConnection;
import com.es.estreothaohientruong.Helper.AppAlertDialog;
import com.es.estreothaohientruong.Helper.AppLog;
import com.es.estreothaohientruong.Helper.Common;
import com.es.estreothaohientruong.Helper.CurrentPrefers;
import com.es.estreothaohientruong.Helper.PermissionGrant;
import com.es.estreothaohientruong.Helper.Singleton;
import com.es.estreothaohientruong.MainActivity;
import com.es.estreothaohientruong.R;
import com.es.estreothaohientruong.UserInterface.Base.BaseFragment;

import java.util.ArrayList;


/**
 * Created by My_PC on 9/1/2017.
 */

public class LoginFragment extends BaseFragment implements View.OnClickListener, ILoginView {
    CheckBox cbSave;
    Button btnLogin;
    EditText edUserName, edPassword;
    private TextView tvIP;
    private Spinner spMnUnit;
    LoginPresenter loginPresenter;
    ArrayAdapter<ManagementUnitEntity> adapterDvi;
    private ArrayList<ManagementUnitEntity> managementUnitEntities;

    //region Activity Life Cycle
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginPresenter = new LoginPresenter(this);
        hideKeyboard();
        if (!PermissionGrant.checkSelfPermission(getContext(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE})) {
            PermissionGrant.verify(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, Common.READ_EXTERNAL_STORAGE);
        }
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
        managementUnitEntities = new ArrayList<>();
        cbSave = (CheckBox) view.findViewById(R.id.f_login_cbSavePass);
        tvIP = (TextView) view.findViewById(R.id.f_login_tvIP);
        btnLogin = (Button) view.findViewById(R.id.f_login_btnLogin);
        edUserName = (EditText) view.findViewById(R.id.page_login_et_username);
        edPassword = (EditText) view.findViewById(R.id.page_login_et_password);
        spMnUnit = (Spinner) view.findViewById(R.id.page_sync_spSync);
        btnLogin.setOnClickListener(this);
        spMnUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Singleton.getInstance().IdCompany = managementUnitEntities.get(position).getMA_DVIQLY();
                CurrentPrefers.getInstance().saveIDCompany(managementUnitEntities.get(position).getMA_DVIQLY());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        tvIP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PageSync pageSync = new PageSync();
                mNativeManager.switchPage(pageSync, "page sync");
            }
        });
        loginPresenter.showInfoSharePrefLogin();
        connection = SQLiteConnection.getInstance(getContext());
        managementUnitEntities.addAll(connection.getDataDVIQLY());
        adapterDvi = new ArrayAdapter<ManagementUnitEntity>(getContext(), R.layout.simple_item_list, managementUnitEntities);
        spMnUnit.setAdapter(adapterDvi);
        for (int i = 0; i < managementUnitEntities.size(); i++) {
            if (managementUnitEntities.get(i).getMA_DVIQLY().equals(CurrentPrefers.getInstance().getidCompany())) {
                spMnUnit.setSelection(i);
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.f_login_btnLogin) {
            if (cbSave.isChecked()) {
                loginPresenter.writeSharedPrefLogin(edUserName.getText().toString(), edPassword.getText().toString());
            } else {
                loginPresenter.clearSharedPrefLogin();
            }
            CurrentPrefers.getInstance().savePass(cbSave.isChecked());
            if (PermissionGrant.verify(this, new String[]{Manifest.permission.READ_PHONE_STATE}, Common.REQUEST_PERMISSION_READ_PHONE)) {
                showLoadingDialog("Đăng nhập");
                loginPresenter.validateInput(edUserName.getText().toString(), edPassword.getText().toString());
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
        edUserName.setText(userName);
        edPassword.setText(pass);
    }

    @Override
    public void showTickCheckbox(boolean isSaveLogin) {
        cbSave.setChecked(isSaveLogin);
    }

    @Override
    public void showIP(String ip) {
        tvIP.setText("Địa chỉ IP: " + ip);
    }

    @Override
    public void loginSuccess() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        getActivity().finish();
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
