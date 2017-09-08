package com.es.estreothaohientruong.Data.Response;


import com.es.estreothaohientruong.Data.Base.ResponseListener;
import com.es.estreothaohientruong.Data.Request.LoginRequest;
import com.es.estreothaohientruong.Data.Request.ManagementUnitRequest;
import com.es.estreothaohientruong.Data.Request.ReportRequest;
import com.es.estreothaohientruong.Data.Request.SubtationRequest;

/**
 * Created by My_PC on 9/5/2017.
 */
public interface Api {

//    void register(int requestId, RegisterRequest registerRequest, ResponseListener listener);
    void getManagementUnit(int requestId, ManagementUnitRequest managementUnitRequest, ResponseListener listener);
    void login(int requestId, LoginRequest loginRequest, ResponseListener listener);
    void getReport(int requestId, ReportRequest reportRequest, ResponseListener listener);
    void getSubtation(int requestId, SubtationRequest subtationRequest, ResponseListener listener);
}
