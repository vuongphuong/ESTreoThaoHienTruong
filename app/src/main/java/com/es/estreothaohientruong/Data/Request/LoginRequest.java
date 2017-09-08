package com.es.estreothaohientruong.Data.Request;

import com.es.estreothaohientruong.Data.Base.BaseRequest;
import com.es.estreothaohientruong.Helper.Common;
import com.es.estreothaohientruong.Helper.Singleton;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.RequestBody;

/**
 * Created by hungh on 4/22/2017.
 */

public class LoginRequest implements BaseRequest {
    String UserName;
    String Password;
    String IdCompany;
    String imei;

    @Override
    public String getUrl() {
        return "http://" + Singleton.getInstance().IPAddress +  Common.URL + "Get_LoginMTB" + sumString();
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

    private String sumString(){
        String sum;
        sum = "?madonvi=" + IdCompany + "&username=" + UserName + "&password=" + Password + "&imei="
                +imei;
        return sum;
    }
    public void setUserName(String userName) {
        this.UserName = userName;
    }
    public void setPassword(String password) {
        this.Password = password;
    }
    public void setIdCompany(String idCompany) {
        this.IdCompany = idCompany;
    }
    public void setImei(String imei) {
        this.imei = imei;
    }

}
