package com.es.estreothaohientruong.Data.Response;

import com.es.estreothaohientruong.Data.Base.BaseResponse;
import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Response;

/**
 * Created by hungh on 5/1/2017.
 */

public class LoginResponse extends BaseResponse {
    @SerializedName("MA_NHAN_VIEN")
    private String MA_NHAN_VIEN;

    public LoginResponse(Response response) throws IOException, JSONException {
        super(response);
    }

    @Override
    protected void parseData(Response data) throws JSONException, IOException {
        String json = data.body().string();
        JSONObject jsonObject = new JSONObject(json);
        if (jsonObject.has("MA_NHAN_VIEN")) {
            MA_NHAN_VIEN = jsonObject.getString("MA_NHAN_VIEN");
        }
    }

    public String getId() {
        return MA_NHAN_VIEN;
    }
}
