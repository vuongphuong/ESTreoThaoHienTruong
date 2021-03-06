package com.es.estreothaohientruong.UserInterface.Login;

import android.Manifest;
import android.app.Dialog;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.es.estreothaohientruong.Data.Base.BaseResponse;
import com.es.estreothaohientruong.Data.Base.ResponseListener;
import com.es.estreothaohientruong.Data.Base.errors.AuthFailureError;
import com.es.estreothaohientruong.Data.Base.errors.ParserError;
import com.es.estreothaohientruong.Data.Base.errors.ServerError;
import com.es.estreothaohientruong.Data.Entities.ManagementUnitEntity;
import com.es.estreothaohientruong.Data.Request.ManagementUnitRequest;
import com.es.estreothaohientruong.Data.Response.GetMnUnitResponse;
import com.es.estreothaohientruong.Data.SQLiteConnection.SQLiteConnection;
import com.es.estreothaohientruong.Helper.AppAlertDialog;
import com.es.estreothaohientruong.Helper.AppLog;
import com.es.estreothaohientruong.Helper.Common;
import com.es.estreothaohientruong.Helper.CurrentPrefers;
import com.es.estreothaohientruong.Helper.PermissionGrant;
import com.es.estreothaohientruong.Helper.Singleton;
import com.es.estreothaohientruong.R;
import com.es.estreothaohientruong.UserInterface.Base.BaseFragment;

import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by My_PC on 9/1/2017.
 */

public class PageSync extends BaseFragment implements View.OnClickListener, ResponseListener {
    private LinearLayout btnSync;
    private EditText edIP;

    //region Activity Life Cycle
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.page_sync, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize(view);
    }

//endregion

    //region Init View
    public void initialize(View view) {
        btnSync = (LinearLayout) view.findViewById(R.id.page_sync_btnSync);
        edIP = (EditText) view.findViewById(R.id.page_sync_et_ip);
        btnSync.setOnClickListener(this);
        edIP.setText(CurrentPrefers.getInstance().getIP());
    }

    private void GetDonviQuanLy() {
        ManagementUnitRequest managementUnitRequest = new ManagementUnitRequest();
        mApi.getManagementUnit(Common.REQUEST_GET_MN_UNIT, managementUnitRequest, this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.page_sync_btnSync) {
            if (!edIP.getText().toString().isEmpty()) {
                Singleton.getInstance().IPAddress = edIP.getText().toString();
                GetDonviQuanLy();
                showLoadingDialog("Đang lấy dữ liệu...");
            } else {
                AlertDialog alertDialog = AppAlertDialog.AlertDialogOk(getContext(), getString(R.string.app_name), "Bạn chưa nhập địa chỉ ip!", true, null);
                alertDialog.show();
            }
        }
    }

    @Override
    public BaseResponse parse(int requestId, Call call, Response response) throws Exception {
        return new GetMnUnitResponse(response);
    }

    @Override
    public void onResponse(int requestId, BaseResponse response) {
        if (requestId == Common.REQUEST_GET_MN_UNIT) {
            GetMnUnitResponse mnUnitResponse = (GetMnUnitResponse) response;
            CurrentPrefers.getInstance().saveIP(edIP.getText().toString());
            connection = SQLiteConnection.getInstance(getContext());
            connection.deleteAllDataDVIQLY();
            for (ManagementUnitEntity managementUnitEntity:mnUnitResponse.getManagementUnitEntities()){
                connection.insertDataDVIQLY(managementUnitEntity.getMA_DVIQLY(),managementUnitEntity.getTEN_DVIQLY());
            }
            LoginFragment loginFragment = new LoginFragment();
            mNativeManager.switchPage(loginFragment,"Login");
        }
        dismissLoadingDialog();
    }

    @Override
    public void onError(int requestId, Exception e) {
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
