package com.es.estreothaohientruong.Data;


import com.es.estreothaohientruong.Data.Base.BaseRequest;
import com.es.estreothaohientruong.Data.Base.CallBackWrapper;
import com.es.estreothaohientruong.Data.Base.ResponseListener;
import com.es.estreothaohientruong.Data.Request.LoginRequest;
import com.es.estreothaohientruong.Data.Request.ManagementUnitRequest;
import com.es.estreothaohientruong.Data.Request.ReportRequest;
import com.es.estreothaohientruong.Data.Request.SubstationRequest;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;


public class OkHttpApiImpl implements Api {

    private OkHttpClient mOkHttpClient;

    public OkHttpApiImpl(OkHttpClient okHttpClient) {
        mOkHttpClient = okHttpClient;
    }

    private void callApi(int requestId, BaseRequest baseRequest, ResponseListener listener) {
        Request.Builder request = new Request.Builder()
                .url(baseRequest.getUrl())
                .method(baseRequest.getMethod(), baseRequest.getBody());
        Headers headers = baseRequest.getHeaders();
        if (headers != null) {
            request.headers(headers);
        }
        mOkHttpClient.newCall(request.build()).enqueue(new CallBackWrapper(requestId, listener));
    }

    @Override
    public void getManagementUnit(int requestId, ManagementUnitRequest managementUnitRequest, ResponseListener listener) {
        callApi(requestId, managementUnitRequest, listener);
    }

    @Override
    public void login(int requestId, LoginRequest loginRequest, ResponseListener listener) {
        callApi(requestId,loginRequest,listener);
    }

    @Override
    public void getReport(int requestId, ReportRequest reportRequest, ResponseListener listener) {
        callApi(requestId,reportRequest,listener);
    }

    @Override
    public void getSubtation(int requestId, SubstationRequest substationRequest, ResponseListener listener) {
        callApi(requestId, substationRequest,listener);
    }
}
