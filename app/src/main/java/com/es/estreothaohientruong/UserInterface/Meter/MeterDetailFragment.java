package com.es.estreothaohientruong.UserInterface.Meter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.es.estreothaohientruong.Data.Base.BaseResponse;
import com.es.estreothaohientruong.Data.Base.ResponseListener;
import com.es.estreothaohientruong.Data.Base.errors.AuthFailureError;
import com.es.estreothaohientruong.Data.Base.errors.ParserError;
import com.es.estreothaohientruong.Data.Base.errors.ServerError;
import com.es.estreothaohientruong.Helper.AppAlertDialog;
import com.es.estreothaohientruong.Helper.AppLog;
import com.es.estreothaohientruong.Helper.Common;
import com.es.estreothaohientruong.R;
import com.es.estreothaohientruong.UserInterface.Base.BaseFragment;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by My_PC on 9/8/2017.
 */

public class MeterDetailFragment extends BaseFragment implements ResponseListener, View.OnClickListener {

LinearLayout llImage;
    //region Activity Life Cycle
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.meter_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize(view);
    }

//endregion

    //region Init View
    public void initialize(View view) {
        llImage = (LinearLayout) view.findViewById(R.id.f_meter_llImage);
        for (int i = 0; i < 5;i++){
            initImageViewImage();
        }
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

    }
    void initImageViewImage() {
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        final View custLayout = inflater.inflate(R.layout.item_image_meter, null, false);
        custLayout.setLayoutParams(new ActionBar.LayoutParams(Common.dpToPx(getContext(),400), Common.dpToPx(getContext(),400)));

        llImage.addView(custLayout);

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
