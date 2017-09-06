package com.es.estreothaohientruong.Data.Response;


import com.es.estreothaohientruong.Data.Base.ResponseListener;
import com.es.estreothaohientruong.Data.Request.ManagementUnitRequest;

/**
 * Created by My_PC on 9/5/2017.
 */
public interface Api {

//    void register(int requestId, RegisterRequest registerRequest, ResponseListener listener);
    void getManagementUnit(int requestId, ManagementUnitRequest managementUnitRequest, ResponseListener listener);
}
