package com.es.estreothaohientruong.Data.Base.errors;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by My_PC on 9/5/2017.
 */
public class AuthFailureError extends BaseError {
    private Error error;
    public AuthFailureError(Call call, Response response) {
        super(call, response);
        parseError();
    }
    private void parseError() {
        try {
            Gson gson = new Gson();
            error = gson.fromJson(response.body().string(), Error.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Error getError() {
        return error;
    }
}
