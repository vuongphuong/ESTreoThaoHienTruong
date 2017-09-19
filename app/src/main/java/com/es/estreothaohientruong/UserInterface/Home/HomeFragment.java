package com.es.estreothaohientruong.UserInterface.Home;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.es.estreothaohientruong.Data.Base.BaseResponse;
import com.es.estreothaohientruong.Data.Base.ResponseListener;
import com.es.estreothaohientruong.Data.Base.errors.AuthFailureError;
import com.es.estreothaohientruong.Data.Base.errors.ParserError;
import com.es.estreothaohientruong.Data.Base.errors.ServerError;
import com.es.estreothaohientruong.Helper.AppAlertDialog;
import com.es.estreothaohientruong.Helper.AppLog;
import com.es.estreothaohientruong.R;
import com.es.estreothaohientruong.UserInterface.Base.BaseFragment;

import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by My_PC on 9/5/2017.
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener, ResponseListener {
    ViewPager vpMain;
    TabLayout pTabMain;
    Button btnDataManagement, btnVerify;
    LinearLayout llDataManagement, llDataVerify;
    HomeVPAdapter homeVPAdapter;
    ArrayList<String> arrPageTitle;

    boolean isInspect;

    //region Activity Life Cycle
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isInspect = true;
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
    public void initialize(View view) {
        arrPageTitle = new ArrayList<>();
        vpMain = (ViewPager) view.findViewById(R.id.f_main_vp);
        pTabMain = (TabLayout) view.findViewById(R.id.f_main_tabs);
        llDataManagement = (LinearLayout) view.findViewById(R.id.f_main_llDataManagement);
        llDataVerify = (LinearLayout) view.findViewById(R.id.f_main_llDataVerify);
        btnDataManagement = (Button) view.findViewById(R.id.f_main_btnDataManagement);
        btnVerify = (Button) view.findViewById(R.id.f_main_btnDataVerify);

        llDataManagement.setOnClickListener(this);
        llDataVerify.setOnClickListener(this);

        arrPageTitle.add("Khách hàng");
        arrPageTitle.add("Công tơ treo");
        arrPageTitle.add("Công tơ tháo");
        homeVPAdapter = new HomeVPAdapter(getChildFragmentManager(), arrPageTitle, isInspect);
        vpMain.setAdapter(homeVPAdapter);
        btnVerify.setVisibility(View.GONE);
        pTabMain.setupWithViewPager(vpMain, true);
        pTabMain.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpMain.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.f_main_llDataManagement) {
            arrPageTitle.clear();
            isInspect = true;
            arrPageTitle.add("Khách hàng");
            arrPageTitle.add("Công tơ treo");
            arrPageTitle.add("Công tơ tháo");
            btnVerify.setVisibility(View.GONE);
            btnDataManagement.setVisibility(View.VISIBLE);
            homeVPAdapter.notifyDataSetChanged();

        } else if (v.getId() == R.id.f_main_llDataVerify) {
            arrPageTitle.clear();
            arrPageTitle.add("Nguyễn văn A");
            isInspect = false;
            vpMain.setNestedScrollingEnabled(false);
            btnVerify.setVisibility(View.VISIBLE);
            btnDataManagement.setVisibility(View.GONE);
            homeVPAdapter = new HomeVPAdapter(getChildFragmentManager(), arrPageTitle, false);
            vpMain.setAdapter(homeVPAdapter);
//            homeVPAdapter.getItem(0);
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
