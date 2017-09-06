package com.es.estreothaohientruong.Data.Request;

import com.es.estreothaohientruong.Data.Base.BaseRequest;
import com.es.estreothaohientruong.Helper.Common;
import com.es.estreothaohientruong.Helper.Singleton;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import okhttp3.Headers;
import okhttp3.RequestBody;

/**
 * Created by hungh on 4/22/2017.
 */

public class ManagementUnitRequest implements BaseRequest {
    String MA_DONVI;

    @Override
    public String getUrl() {
        return "http://" + Singleton.getInstance().IPAddress +  Common.URL + "Get_d_dviqly";
    }

    @Override
    public Headers getHeaders() {
        Headers.Builder builder = new Headers.Builder()
                .add("Content-Type", "application/json");
        return builder.build();
    }

    @Override
    public String getMethod() {
        return Common.GET;
    }

    @Override
    public String toJson() {
        return null;
    }

    @Override
    public RequestBody getBody() {
        return null;
    }
    public void setMnUnit(String MA_DONVI) {
        this.MA_DONVI = MA_DONVI;
    }

}
