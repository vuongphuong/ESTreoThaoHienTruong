package com.es.estreothaohientruong.Data.Response;

import com.es.estreothaohientruong.Data.Base.BaseResponse;
import com.es.estreothaohientruong.Data.Entities.ReportEntity;
import com.es.estreothaohientruong.Data.Entities.SubtationEntity;
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

public class SubtationResponse extends BaseResponse {

    private ArrayList<SubtationEntity> subtationEntities;

    public SubtationResponse(Response data) throws IOException, JSONException {
        super(data);
    }

    @Override
    protected void parseData(Response data) throws IOException {
        Gson gson = new Gson();
//        ManagementUnitEntity managementUnitEntity = gson.fromJson(data.body().string(),ManagementUnitEntity.class);
//        managementUnitEntities = new ArrayList<>();
//        managementUnitEntities.add(managementUnitEntity);
         Type type= new TypeToken<ArrayList<SubtationResponse>>(){}.getType();
         subtationEntities = gson.fromJson(data.body().string(),type);
    }

    public ArrayList<SubtationEntity> getSubtationEntities() {
        return subtationEntities;
    }
}
