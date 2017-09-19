package com.es.estreothaohientruong;

import android.app.Application;

import com.es.estreothaohientruong.Data.Api;
import com.es.estreothaohientruong.Data.OkHttpApiImpl;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by hungh on 3/3/2017.
 */

public class App extends Application {

    public static App instance;
    Api mApi;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
        mApi = new OkHttpApiImpl(okHttpClient);
//        Configuration.Builder configurationBuilder = new Configuration.Builder(this);
//        configurationBuilder.setDatabaseName( "sdcard"+Common.PROGRAM_DB_PATH + "TTHT.s3db");
    }

    public static App get() {
        return instance;
    }

    public Api getApi() {
        return mApi;
    }
}
