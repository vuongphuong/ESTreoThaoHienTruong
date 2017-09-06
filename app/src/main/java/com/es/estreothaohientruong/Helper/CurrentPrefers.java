package com.es.estreothaohientruong.Helper;

import com.es.estreothaohientruong.UserInterface.Base.BasePrefers;

/**
 * Created by My_PC on 9/5/2017.
 */
public class CurrentPrefers extends BasePrefers {

    private static String TAG = "StaffPreferences";
    private static CurrentPrefers mStaffPrefers;
    private static final String FILE_PREFERENCES = "Budsz.preference";
    //
    private static final String KEY_USER_NAME = "user_name";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_SAVE_PASS = "key_save_password";
    private static final String KEY_RESULT = "key_result";

    // Employee
    private static final String KEY_EMP_INFO = "key_employee_info";

    // Manager

    public CurrentPrefers() {
        super();
    }

    public static CurrentPrefers getInstance() {
        if (mStaffPrefers == null) {
            mStaffPrefers = new CurrentPrefers();
        }
        return mStaffPrefers;
    }

    @Override
    protected String getFileNamePrefers() {
        return FILE_PREFERENCES;
    }

    //----------------User Name--------------------------
    public void saveUserName(String userName) {
        getEditor().putString(KEY_USER_NAME, userName).commit();
    }

    public String getUserName() {
        return getPreferences().getString(KEY_USER_NAME, "");
    }

    //----------------Token------------------------
    public void savePassword(String password) {
        getEditor().putString(KEY_PASSWORD, password).commit();
    }

    public String getPassword() {
        return getPreferences().getString(KEY_PASSWORD, "");
    }

    //----------------Save Password------------------------
    public void savePass(boolean isSaveLogin) {
        getEditor().putBoolean(KEY_SAVE_PASS, isSaveLogin).commit();
    }

    public boolean getSavePass() {
        return getPreferences().getBoolean(KEY_SAVE_PASS, true);
    }

    //----------------code employees----------------
    public void saveCode(String code) {
        getEditor().putString(KEY_RESULT, code).commit();
    }

    public String getCode() {
        return getPreferences().getString(KEY_RESULT, "");
    }


    // Employee login info - use for get user info of employee or manager
    public void saveUserInfo(String info) {
        getEditor().putString(KEY_EMP_INFO, info).commit();
    }

    public String getUserInfo() {
        return getPreferences().getString(KEY_EMP_INFO, "");
    }


    public void clearAll() {
        getEditor().clear().commit();
    }
}
