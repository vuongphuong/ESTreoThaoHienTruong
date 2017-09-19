package com.es.estreothaohientruong.Data.Response;

import com.es.estreothaohientruong.Data.Base.BaseResponse;
import com.es.estreothaohientruong.Data.Entities.SubstationEntity;
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

public class SubstationResponse extends BaseResponse {

    private ArrayList<SubstationEntity> substationEntities;

    public SubstationResponse(Response data) throws IOException, JSONException {
        super(data);
    }

    @Override
    protected void parseData(Response data) throws IOException {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<SubstationEntity>>() {
        }.getType();
        substationEntities = gson.fromJson(data.body().string(), type);
    }

    public ArrayList<SubstationEntity> getSubstationEntities() {
        return substationEntities;
    }
}
