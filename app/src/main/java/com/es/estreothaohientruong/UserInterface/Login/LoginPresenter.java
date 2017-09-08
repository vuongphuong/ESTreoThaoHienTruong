package com.es.estreothaohientruong.UserInterface.Login;

import com.es.estreothaohientruong.Data.Base.BaseResponse;
import com.es.estreothaohientruong.Data.Base.ResponseListener;
import com.es.estreothaohientruong.Data.Request.LoginRequest;
import com.es.estreothaohientruong.Data.Response.LoginResponse;
import com.es.estreothaohientruong.Helper.Common;
import com.es.estreothaohientruong.Helper.CurrentPrefers;
import com.es.estreothaohientruong.Helper.Singleton;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by My_PC on 9/5/2017.
 */

public class LoginPresenter implements ILoginPresenter,ResponseListener {
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
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserName(userName);
        loginRequest.setPassword(password);
        loginRequest.setIdCompany(Singleton.getInstance().IdCompany);
        loginRequest.setImei(Common.GetIMEI(iLoginView.getContextView()));
        iLoginView.getApi().login(Common.REQUEST_LOGIN, loginRequest, this);
    }

    @Override
    public BaseResponse parse(int requestId, Call call, Response response) throws Exception {
        return new LoginResponse(response);
    }

    @Override
    public void onResponse(int requestId, BaseResponse response) {
        if (requestId == Common.REQUEST_LOGIN){
            LoginResponse loginResponse = (LoginResponse) response;
            Singleton.getInstance().idCustomer = loginResponse.getId();
            iLoginView.loginSuccess();
        }
    }

    @Override
    public void onError(int requestId, Exception e) {
            iLoginView.showLoginErorService(requestId,e);
    }
}
