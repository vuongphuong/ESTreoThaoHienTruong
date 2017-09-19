package com.es.estreothaohientruong.UserInterface.ChangePassword;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;

import com.es.estreothaohientruong.Data.Base.BaseResponse;
import com.es.estreothaohientruong.Data.Base.ResponseListener;
import com.es.estreothaohientruong.Data.Base.errors.AuthFailureError;
import com.es.estreothaohientruong.Data.Base.errors.ParserError;
import com.es.estreothaohientruong.Data.Base.errors.ServerError;
import com.es.estreothaohientruong.Helper.AppAlertDialog;
import com.es.estreothaohientruong.Helper.AppLog;
import com.es.estreothaohientruong.Helper.CurrentPrefers;
import com.es.estreothaohientruong.R;
import com.es.estreothaohientruong.UserInterface.Base.AdapterDelegate;
import com.es.estreothaohientruong.UserInterface.Base.BaseFragment;
import com.es.estreothaohientruong.UserInterface.Customer.CustomerDetailFragment;
import com.es.estreothaohientruong.UserInterface.Home.AdapterPageCustomer;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by My_PC on 9/8/2017.
 */

public class ChangePassword extends BaseFragment implements ResponseListener, View.OnClickListener {
    EditText edNewPass, edCurrentPass, edConfirmPass;
    CheckBox cbShowPass;
    Button btnChangePass;

    //region Activity Life Cycle
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.change_pass_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize(view);

    }

//endregion

    //region Init View
    public void initialize(View view) {
        edNewPass = (EditText) view.findViewById(R.id.f_change_pass_edNewPass);
        edCurrentPass = (EditText) view.findViewById(R.id.f_change_pass_edCurrentPass);
        edConfirmPass = (EditText) view.findViewById(R.id.f_change_pass_edConfirmPass);
        cbShowPass = (CheckBox) view.findViewById(R.id.f_change_pass_cbShowPass);
        btnChangePass = (Button) view.findViewById(R.id.f_change_pass_btnChangePass);
        btnChangePass.setOnClickListener(this);

        cbShowPass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    edCurrentPass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    edNewPass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    edConfirmPass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    edCurrentPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    edNewPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    edConfirmPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });
    }

    @Override
    public BaseResponse parse(int requestId, Call call, Response response) throws Exception {
        return null;
    }

    @Override
    public void onResponse(int requestId, BaseResponse response) {

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

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.f_change_pass_btnChangePass) {
            if (!edConfirmPass.getText().toString().equals(edNewPass.getText().toString())) {
                AppAlertDialog.showAlertDialogGreen(getContext(), getString(R.string.error1), Color.RED, "Mật khẩu mới không đúng!", Color.WHITE, getString(R.string.common_ok), Color.RED);
            } else if (edCurrentPass.getText().toString().equals(edNewPass.getText().toString())) {
                AppAlertDialog.showAlertDialogGreen(getContext(), getString(R.string.error1), Color.RED, "Mật khẩu mới không được giống mật khẩu cũ!", Color.WHITE, getString(R.string.common_ok), Color.RED);
            } else if (edNewPass.getText().toString().length() <= 6) {
                AppAlertDialog.showAlertDialogGreen(getContext(), getString(R.string.error1), Color.RED, "Mật khẩu mới phải dài hơn 6 ký tự!", Color.WHITE, getString(R.string.common_ok), Color.RED);
            } else {
                if (CurrentPrefers.getInstance().getSavePass())
                    CurrentPrefers.getInstance().savePassword(edNewPass.getText().toString());
            }
        }
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
