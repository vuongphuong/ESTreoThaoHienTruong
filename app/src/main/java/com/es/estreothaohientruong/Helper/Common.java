package com.es.estreothaohientruong.Helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.telephony.TelephonyManager;

import java.io.File;
import java.lang.reflect.Method;

/**
 * Created by My_PC on 9/5/2017.
 */

public class Common {
    public static String POST = "POST";
    public static String GET = "GET";
    public static String URL = "/api/serviceMTB/";

    public static final int REQUEST_GET_MN_UNIT = 100;
    public static final int REQUEST_LOGIN = 101;
    public static final int REQUEST_REPORT = 102;
    public static final int REQUEST_SUBTATION = 103;

    public static final int REQUEST_PERMISSION_READ_PHONE = 110;
    public static final int REQUEST_PERMISSION_WRITE_EXTERNAL_STORAGE = 111;
    public static final int READ_EXTERNAL_STORAGE = 112;

    public static final String PROGRAM_PATH = "/TTHT/";
    public static final String PROGRAM_DB_PATH = "/TTHT/DB/";
    public static final String PROGRAM_DB_BACKUP_PATH = "/TTHT/DB/BACKUP/";

    @SuppressLint("HardwareIds")
    public static String GetIMEI(Context context) {
        try {
            TelephonyManager tManager = (TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);

            String IMEI = tManager.getDeviceId();
            if (IMEI == null) {
                Class<?> c = Class.forName("android.os.SystemProperties");
                Method get = c.getMethod("get", String.class);
                IMEI = (String) get.invoke(c, "ro.serialno");
            }

//            return Settings.Secure.getString(context.getContentResolver(),
//                    Settings.Secure.ANDROID_ID);
            return IMEI;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean isNetworkOnline(Context context) {
        boolean status = false;
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getNetworkInfo(0);
            if (netInfo != null
                    && netInfo.getState() == NetworkInfo.State.CONNECTED) {
                status = true;
            } else {
                netInfo = cm.getNetworkInfo(1);
                if (netInfo != null
                        && netInfo.getState() == NetworkInfo.State.CONNECTED)
                    status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return status;
    }
    public static void CreatForder() {
        try {
            File programDirectory = new File(Environment.getExternalStorageDirectory() + PROGRAM_PATH);
            if (!programDirectory.exists()) {
                programDirectory.mkdirs();
            }
            File programDbDirectory = new File(Environment.getExternalStorageDirectory() + PROGRAM_DB_PATH);
            if (!programDbDirectory.exists()) {
                programDbDirectory.mkdirs();
            }
            File programSampleDirectory = new File(Environment.getExternalStorageDirectory() + PROGRAM_DB_BACKUP_PATH);
            if (!programSampleDirectory.exists()) {
                programSampleDirectory.mkdirs();
            }
//            File programPhotoDirectory = new File(Environment.getExternalStorageDirectory() + TthtConstantVariables.PROGRAM_PHOTOS_PATH);
//            if (!programPhotoDirectory.exists()) {
//                programPhotoDirectory.mkdirs();
//            }
//            String filePath = Environment.getExternalStorageDirectory() + TthtConstantVariables.PROGRAM_PATH + TthtConstantVariables.CFG_FILENAME;
//            File cfgFile = new File(filePath);
//            if (cfgFile.exists()) {
//                TthtCommon.cfgInfo = TthtCommon.GetFileConfig();
//                if (TthtCommon.cfgInfo == null) {
//                    TthtCommon.cfgInfo = new TthtConfigInfo();
//                }
//            } else {
//                TthtCommon.cfgInfo = new TthtConfigInfo();
//                TthtCommon.CreateFileConfig(TthtCommon.cfgInfo, cfgFile, "");
//            }
        } catch (Exception ex) {
        }
    }

}
