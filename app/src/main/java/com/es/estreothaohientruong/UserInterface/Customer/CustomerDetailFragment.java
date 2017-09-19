package com.es.estreothaohientruong.UserInterface.Customer;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.es.estreothaohientruong.Data.Base.BaseResponse;
import com.es.estreothaohientruong.Data.Base.ResponseListener;
import com.es.estreothaohientruong.Data.Base.errors.AuthFailureError;
import com.es.estreothaohientruong.Data.Base.errors.ParserError;
import com.es.estreothaohientruong.Data.Base.errors.ServerError;
import com.es.estreothaohientruong.Data.Entities.ReportEntity;
import com.es.estreothaohientruong.Helper.AppAlertDialog;
import com.es.estreothaohientruong.Helper.AppLog;
import com.es.estreothaohientruong.R;
import com.es.estreothaohientruong.UserInterface.Base.BaseFragment;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by My_PC on 9/8/2017.
 */

public class CustomerDetailFragment extends BaseFragment implements ResponseListener {
    private ListView lvReport;
    private TextView tvName,tvPhone,tvAddress,tvIdCustomer,tvIdGCS;
    private ReportEntity reportEntity;
    private AdapterCustomerDetail adapterCustomerDetail;
    //region Activity Life Cycle
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.customer_detail_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize(view);

    }

//endregion

    //region Init View
    public void initialize(View view){
        lvReport = (ListView) view.findViewById(R.id.f_customer_detail_lvReport);
        tvName = (TextView) view.findViewById(R.id.f_customer_detail_tvName);
        tvPhone = (TextView) view.findViewById(R.id.f_customer_detail_tvPhone);
        tvAddress = (TextView) view.findViewById(R.id.f_customer_detail_tvAddress);
        tvIdCustomer = (TextView) view.findViewById(R.id.f_customer_detail_tvIdCustomer);
        tvIdGCS = (TextView) view.findViewById(R.id.f_customer_detail_tvIdGCS);
        fillData();
        adapterCustomerDetail = new AdapterCustomerDetail(getContext());
        lvReport.setAdapter(adapterCustomerDetail);
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


//endregion

    //region Navigation


//endregion

    //region Control Action
    private void fillData(){
        tvName.setText(reportEntity.getTEN_KHANG());
        tvPhone.setText(reportEntity.getDTHOAI());
        tvAddress.setText(reportEntity.getDCHI_HDON());
        tvIdCustomer.setText(reportEntity.getMA_TRAM());
        tvIdGCS.setText(reportEntity.getMA_GCS_CTO());
    }

//endregion

    //region Control Delegate
public void setReportEntity(ReportEntity reportEntity){
    this.reportEntity = reportEntity;
}

//endregion

    //region API


//endregion

    //region Helper
//endregion
}
