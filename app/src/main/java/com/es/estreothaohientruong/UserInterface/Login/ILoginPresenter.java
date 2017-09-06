package com.es.estreothaohientruong.UserInterface.Login;

public interface ILoginPresenter {
    void validateInput(String userName, String pass);

    void writeSharedPrefLogin(String userName, String pass);

    void clearSharedPrefLogin();

    void showInfoSharePrefLogin();
}