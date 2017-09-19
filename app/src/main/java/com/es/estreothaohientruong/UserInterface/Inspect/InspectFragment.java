package com.es.estreothaohientruong.UserInterface.Inspect;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.es.estreothaohientruong.R;
import com.es.estreothaohientruong.UserInterface.Base.BaseFragment;


/**
 * Created by My_PC on 9/5/2017.
 */

public class InspectFragment extends BaseFragment implements View.OnClickListener {
    TextView tvNameCustomer,tvIdCustomer,tvIdContract;
    //region Activity Life Cycle
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.inspect_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize(view);

    }

//endregion

    //region Init View
    public void initialize(View view){

    }

    @Override
    public void onClick(View v) {

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
