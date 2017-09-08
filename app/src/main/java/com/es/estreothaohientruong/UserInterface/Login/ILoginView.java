package com.es.estreothaohientruong.UserInterface.Login;

import com.es.estreothaohientruong.UserInterface.Base.ICommonView;

/**
 * Created by My_PC on 9/5/2017.
 */

public interface ILoginView extends ICommonView{
    void showLoginFail(String message);

    void showLoginErorService(int requestId, Exception e);

    void showTextUserPass(String userName, String pass);

    void showTickCheckbox(boolean isSaveLogin);

    void loginSuccess();
}
