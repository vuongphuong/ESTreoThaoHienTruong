package com.es.estreothaohientruong.UserInterface.Home;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.es.estreothaohientruong.Data.Base.BaseResponse;
import com.es.estreothaohientruong.Data.Base.ResponseListener;
import com.es.estreothaohientruong.Data.Base.errors.AuthFailureError;
import com.es.estreothaohientruong.Data.Base.errors.ParserError;
import com.es.estreothaohientruong.Data.Base.errors.ServerError;
import com.es.estreothaohientruong.Data.Entities.ReportEntity;
import com.es.estreothaohientruong.Data.Entities.SubtationEntity;
import com.es.estreothaohientruong.Data.Request.ReportRequest;
import com.es.estreothaohientruong.Data.Request.SubtationRequest;
import com.es.estreothaohientruong.Data.Response.ReportResponse;
import com.es.estreothaohientruong.Data.Response.SubtationResponse;
import com.es.estreothaohientruong.Helper.AppAlertDialog;
import com.es.estreothaohientruong.Helper.AppLog;
import com.es.estreothaohientruong.Helper.Common;
import com.es.estreothaohientruong.Helper.Singleton;
import com.es.estreothaohientruong.R;
import com.es.estreothaohientruong.UserInterface.Base.BaseFragment;

import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by My_PC on 9/5/2017.
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener,ResponseListener {
    ViewPager vpMain;
    PagerTabStrip pTabMain;
    LinearLayout llDataManagement,llDataVerify;
    ArrayList<ReportEntity> reportEntities;
    ArrayList<SubtationEntity> subtationEntities;
    //region Activity Life Cycle
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reportEntities = new ArrayList<>();
        subtationEntities = new ArrayList<>();
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize(view);

    }

//endregion

    //region Init View
    public void initialize(View view){
        vpMain = (ViewPager) view.findViewById(R.id.f_main_vp);
        pTabMain = (PagerTabStrip) view.findViewById(R.id.f_main_tabs);
        llDataManagement = (LinearLayout) view.findViewById(R.id.f_main_llDataManagement);
        llDataVerify = (LinearLayout) view.findViewById(R.id.f_main_llDataVerify);
        showLoadingDialog("Đồng bộ dữ liệu...");
        ReportRequest reportRequest = new ReportRequest();
        reportRequest.setMA_DONVI(Singleton.getInstance().IdCompany);
        reportRequest.setMA_NHANVIEN(Singleton.getInstance().idCustomer);
        mApi.getReport(Common.REQUEST_REPORT,reportRequest,this);

        SubtationRequest subtationRequest = new SubtationRequest();
        subtationRequest.setMA_DONVI(Singleton.getInstance().IdCompany);
        mApi.getSubtation(Common.REQUEST_SUBTATION,subtationRequest,this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.f_main_llDataManagement){

        }else if (v.getId() == R.id.f_main_llDataVerify){

        }
    }

    @Override
    public BaseResponse parse(int requestId, Call call, Response response) throws Exception {
        return new ReportResponse(response);
    }

    @Override
    public void onResponse(int requestId, BaseResponse response) {
        if (requestId == Common.REQUEST_REPORT) {
            ReportResponse reportResponse = (ReportResponse) response;
            reportEntities.clear();
            reportEntities.addAll(reportResponse.getReportEntities());
        }else if (requestId == Common.REQUEST_SUBTATION){
            SubtationResponse subtationResponse = (SubtationResponse) response;
            subtationEntities.clear();
            subtationEntities.addAll(subtationResponse.getSubtationEntities());
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
