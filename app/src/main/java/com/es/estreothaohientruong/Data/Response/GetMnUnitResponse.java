package com.es.estreothaohientruong.Data.Response;

import com.es.estreothaohientruong.Data.Base.BaseResponse;
import com.es.estreothaohientruong.Data.Entities.ManagementUnitEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import okhttp3.Response;

/**
 * Created by hungh on 5/1/2017.
 */

public class GetMnUnitResponse extends BaseResponse {

    private ArrayList<ManagementUnitEntity> managementUnitEntities;

    public GetMnUnitResponse(Response data) throws IOException, JSONException {
        super(data);
    }

    @Override
    protected void parseData(Response data) throws IOException {
        Gson gson = new Gson();
//        ManagementUnitEntity managementUnitEntity = gson.fromJson(data.body().string(),ManagementUnitEntity.class);
//        managementUnitEntities = new ArrayList<>();
//        managementUnitEntities.add(managementUnitEntity);
         Type type= new TypeToken<ArrayList<ManagementUnitEntity>>(){}.getType();
         managementUnitEntities = gson.fromJson(data.body().string(),type);
    }

    public ArrayList<ManagementUnitEntity> getManagementUnitEntities() {
        return managementUnitEntities;
    }
}
