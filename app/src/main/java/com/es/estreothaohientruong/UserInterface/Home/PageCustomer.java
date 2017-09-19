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
import android.widget.ListView;

import com.es.estreothaohientruong.Data.Base.BaseResponse;
import com.es.estreothaohientruong.Data.Base.ResponseListener;
import com.es.estreothaohientruong.Data.Base.errors.AuthFailureError;
import com.es.estreothaohientruong.Data.Base.errors.ParserError;
import com.es.estreothaohientruong.Data.Base.errors.ServerError;
import com.es.estreothaohientruong.Data.Entities.ManagementUnitEntity;
import com.es.estreothaohientruong.Data.Entities.ReportEntity;
import com.es.estreothaohientruong.Data.SQLiteConnection.SQLiteConnection;
import com.es.estreothaohientruong.Helper.AppAlertDialog;
import com.es.estreothaohientruong.Helper.AppLog;
import com.es.estreothaohientruong.MainActivity;
import com.es.estreothaohientruong.R;
import com.es.estreothaohientruong.UserInterface.Base.AdapterDelegate;
import com.es.estreothaohientruong.UserInterface.Base.BaseFragment;
import com.es.estreothaohientruong.UserInterface.Customer.CustomerDetailFragment;

import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by My_PC on 9/8/2017.
 */

public class PageCustomer extends BaseFragment implements ResponseListener, AdapterDelegate {
    private ListView lvCustomer;
    private AdapterPageCustomer adapterPageCustomer;
    private ArrayList<ReportEntity> reportEntities;

    //region Activity Life Cycle
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        connection = SQLiteConnection.getInstance(getContext());
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.customer_frangment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize(view);

    }

//endregion

    //region Init View
    public void initialize(View view) {
        reportEntities = new ArrayList<>();
        MainActivity.tvTitleToolbar.setText("Thông tin khách hàng");
        lvCustomer = (ListView) view.findViewById(R.id.f_customer_lvCustomer);
        adapterPageCustomer = new AdapterPageCustomer(getContext(),connection.getAllDataBBanTThao(), this);
        lvCustomer.setAdapter(adapterPageCustomer);
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
    public void onClickItemAdapter(View v) {
        if (v.getId() == R.id.i_customer_btnDetail) {
            ReportEntity reportEntity = (ReportEntity) v.getTag();
            CustomerDetailFragment customerDetailFragment = new CustomerDetailFragment();
            customerDetailFragment.setReportEntity(reportEntity);
            mNativeManager.addFragment(customerDetailFragment, "CustomerDetail");
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
