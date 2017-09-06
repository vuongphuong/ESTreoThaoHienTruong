package com.es.estreothaohientruong.UserInterface.Login;

/**
 * Created by My_PC on 9/5/2017.
 */

public interface ILoginView {
    void showLoginFail(String message);

    void showTextUserPass(String userName, String pass);

    void showTickCheckbox(boolean isSaveLogin);
}
