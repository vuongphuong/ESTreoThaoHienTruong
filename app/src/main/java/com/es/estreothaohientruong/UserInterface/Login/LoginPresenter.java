package com.es.estreothaohientruong.UserInterface.Login;


import com.es.estreothaohientruong.Helper.CurrentPrefers;

/**
 * Created by My_PC on 9/5/2017.
 */

public class LoginPresenter implements ILoginPresenter {
    private CurrentPrefers currentPrefers;
    private ILoginView iLoginView;

    public LoginPresenter(ILoginView mILoginView) {
        if (mILoginView == null)
            return;
        this.iLoginView = mILoginView;
        currentPrefers = CurrentPrefers.getInstance();
    }

    @Override
    public void validateInput(String userName, String pass) {
        if (userName == null || userName.isEmpty() || pass == null || pass.isEmpty()) {
            iLoginView.showLoginFail("Kiểm tra lại Tên đăng nhập hoặc Mật khẩu!");
        } else {
            getDataLogin(userName, pass);
        }
    }

    @Override
    public void writeSharedPrefLogin(String userName, String pass) {
        if (userName == null || userName.isEmpty()) {
            return;
        }
        if (pass == null || pass.isEmpty()) {
            return;
        }
        currentPrefers.saveUserName(userName);
        currentPrefers.savePassword(pass);
    }

    @Override
    public void clearSharedPrefLogin() {
        currentPrefers.clearAll();
    }

    @Override
    public void showInfoSharePrefLogin() {
        if (currentPrefers != null) {
            iLoginView.showTickCheckbox(currentPrefers.getSavePass());
            iLoginView.showTextUserPass(currentPrefers.getUserName(), currentPrefers.getPassword());
        }
    }

    private void getDataLogin(String userName, String password) {

    }
}
