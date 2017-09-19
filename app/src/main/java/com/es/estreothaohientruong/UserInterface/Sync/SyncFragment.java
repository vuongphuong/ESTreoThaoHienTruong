package com.es.estreothaohientruong.UserInterface.Sync;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.es.estreothaohientruong.Data.Base.BaseResponse;
import com.es.estreothaohientruong.Data.Base.ResponseListener;
import com.es.estreothaohientruong.Data.Base.errors.AuthFailureError;
import com.es.estreothaohientruong.Data.Base.errors.ParserError;
import com.es.estreothaohientruong.Data.Base.errors.ServerError;
import com.es.estreothaohientruong.Data.Entities.ReportEntity;
import com.es.estreothaohientruong.Data.Entities.SubstationEntity;
import com.es.estreothaohientruong.Data.Request.ReportRequest;
import com.es.estreothaohientruong.Data.Request.SubstationRequest;
import com.es.estreothaohientruong.Data.Response.ReportResponse;
import com.es.estreothaohientruong.Data.Response.SubstationResponse;
import com.es.estreothaohientruong.Data.SQLiteConnection.SQLiteConnection;
import com.es.estreothaohientruong.Helper.AppAlertDialog;
import com.es.estreothaohientruong.Helper.AppLog;
import com.es.estreothaohientruong.Helper.Common;
import com.es.estreothaohientruong.Helper.DateHelper;
import com.es.estreothaohientruong.Helper.Singleton;
import com.es.estreothaohientruong.R;
import com.es.estreothaohientruong.UserInterface.Base.BaseFragment;

import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by My_PC on 9/8/2017.
 */

public class SyncFragment extends BaseFragment implements ResponseListener, View.OnClickListener {
    ProgressBar pgReportMeter, pgSubstation;
    TextView tvReportMeter, tvSubstation, tvDate;
    Button btnSync;
    ListView lvRequestData;
    int count = 0;
    private int progressBarStatus = 0;
    Handler progressBarHandler = new Handler();

    ArrayList<ReportEntity> reportEntities;
    ArrayList<SubstationEntity> substationEntities;


    //region Activity Life Cycle
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        connection = SQLiteConnection.getInstance(getContext());
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sync_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize(view);
    }

//endregion

    //region Init View
    @SuppressLint("SetTextI18n")
    public void initialize(View view) {
        reportEntities = new ArrayList<>();
        substationEntities = new ArrayList<>();
        pgReportMeter = (ProgressBar) view.findViewById(R.id.f_sync_pgReportMeter);
        pgSubstation = (ProgressBar) view.findViewById(R.id.f_sync_pgSubstation);
        tvReportMeter = (TextView) view.findViewById(R.id.f_sync_tvReportMeter);
        tvSubstation = (TextView) view.findViewById(R.id.f_sync_tvSubstation);
        tvDate = (TextView) view.findViewById(R.id.f_sync_tvDate);
        btnSync = (Button) view.findViewById(R.id.f_sync_btnSync);
        lvRequestData = (ListView) view.findViewById(R.id.f_sync_lvRequestData);
        btnSync.setOnClickListener(this);
        tvDate.setText(DateHelper.stringFromDate(Common.currentDate(), "dd/MM/yyyy HH:mm"));
        tvReportMeter.setText(pgReportMeter.getProgress() + "%");
        tvSubstation.setText(pgSubstation.getProgress() + "%");
//        connection.insertDataBBanCto()

    }

    @Override
    public BaseResponse parse(int requestId, Call call, Response response) throws Exception {
        if (requestId == Common.REQUEST_REPORT)
            return new ReportResponse(response);
        if (requestId == Common.REQUEST_SUBTATION)
            return new SubstationResponse(response);
        else
            return null;
    }

    @Override
    public void onResponse(int requestId, BaseResponse response) {
        if (requestId == Common.REQUEST_REPORT) {
            ReportResponse reportResponse = (ReportResponse) response;
            reportEntities.clear();
            reportEntities.addAll(reportResponse.getReportEntities());
            count = 0;
            setSeekBar(pgReportMeter, reportEntities.size(), tvReportMeter);
        }
        if (requestId == Common.REQUEST_SUBTATION) {
            connection.deleteAllDataTRAM();
            SubstationResponse substationResponse = (SubstationResponse) response;
            substationEntities.clear();
            substationEntities.addAll(substationResponse.getSubstationEntities());
            for (SubstationEntity substationEntity : substationEntities) {
                connection.insertDataTRAM(substationEntity);
            }
            count = 0;
            setSeekBar(pgSubstation, substationEntities.size(), tvSubstation);
        }
//        dismissLoadingDialog();
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
//        dismissLoadingDialog();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.f_sync_btnSync) {
//            showLoadingDialog("Đồng bộ dữ liệu...");
            ReportRequest reportRequest = new ReportRequest();
            reportRequest.setMA_DONVI(Singleton.getInstance().IdCompany);
            reportRequest.setMA_NHANVIEN(Singleton.getInstance().idCustomer);
            mApi.getReport(Common.REQUEST_REPORT, reportRequest, this);

            SubstationRequest substationRequest = new SubstationRequest();
            substationRequest.setMA_DONVI(Singleton.getInstance().IdCompany);
            mApi.getSubtation(Common.REQUEST_SUBTATION, substationRequest, this);
        }

    }


//endregion

    //region Navigation


//endregion

    //region Control Action

//endregion

    //region Control Delegate
    public void setSeekBar(final ProgressBar progressBar, final int setMax, final TextView tvProgress) {
        final float snap = (float) setMax / 100f;
//        progressBar.setSecondaryProgress(setMax);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                    for (int i = 0; i < setMax; i++) {
                        progressBarStatus = (int) (count / snap);
                        progressBarHandler.post(new Runnable() {
                            public void run() {
                                progressBar.setProgress(progressBarStatus);
                                tvProgress.setText(progressBarStatus + "%");
                            }
                        });
                        count++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        progressBar.setMax(100);
        }


//endregion

                //region API


//endregion

                //region Helper
//endregion
    }
