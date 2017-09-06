package com.es.estreothaohientruong.UserInterface.Home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.es.estreothaohientruong.R;
import com.es.estreothaohientruong.UserInterface.Base.BaseFragment;

/**
 * Created by My_PC on 9/5/2017.
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener{
    ViewPager vpMain;
    PagerTabStrip pTabMain;
    LinearLayout llDataManagement,llDataVerify;
    //region Activity Life Cycle
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.f_main_llDataManagement){

        }else if (v.getId() == R.id.f_main_llDataVerify){

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
