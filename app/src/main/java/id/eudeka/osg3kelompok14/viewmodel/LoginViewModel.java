package id.eudeka.osg3kelompok14.viewmodel;

import android.content.Context;

import id.eudeka.osg3kelompok14.data.LoginDataSource;
import id.eudeka.osg3kelompok14.data.LoginRepository;
import id.eudeka.osg3kelompok14.model.UserLoginRespon;
import id.eudeka.osg3kelompok14.navigator.LoginNavigator;

public class LoginViewModel {

    private Context context;
    private LoginNavigator mNavigator;
    private LoginRepository loginRepository;

    public LoginViewModel(Context context, LoginRepository loginRepository) {
        this.context = context;
        this.loginRepository = loginRepository;
    }

    public void setNavigator(LoginNavigator mNavigator){
        this.mNavigator= mNavigator;
    }

    public void cekUser(final String email, final String password){
        if (email.equals("") || password.equals("")){
            mNavigator.loginFailed("Kolom email dan password harus diisi");
        }else{
            loginRepository.doLogin(new LoginDataSource.TestLogin() {
                @Override
                public void dataAvailable(UserLoginRespon hasil) {
                    mNavigator.loginSucces(hasil.getToken());
                }

                @Override
                public void onDataNotAvailable(String errorMessage) {
                    mNavigator.loginFailed(errorMessage);
                }
            }, email, password);
        }
    }
}
