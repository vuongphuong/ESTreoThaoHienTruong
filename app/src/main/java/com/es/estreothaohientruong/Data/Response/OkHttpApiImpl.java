package com.es.estreothaohientruong.Data.Response;


import com.es.estreothaohientruong.Data.Base.BaseRequest;
import com.es.estreothaohientruong.Data.Base.CallBackWrapper;
import com.es.estreothaohientruong.Data.Base.ResponseListener;
import com.es.estreothaohientruong.Data.Request.ManagementUnitRequest;

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
}
