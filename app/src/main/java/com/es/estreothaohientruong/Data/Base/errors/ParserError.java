package com.es.estreothaohientruong.Data.Base.errors;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by My_PC on 9/5/2017.
 */

public class ParserError extends BaseError {
    public ParserError(Call call, Response response) {
        super(call, response);
    }
}
