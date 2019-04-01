package id.eudeka.osg3kelompok14.data;

import id.eudeka.osg3kelompok14.data.remote.LoginRemoteDataSource;
import id.eudeka.osg3kelompok14.model.UserLoginRespon;

public class LoginRepository implements LoginDataSource {

    private LoginRemoteDataSource loginRemoteDataSource;

    public LoginRepository(LoginRemoteDataSource loginRemoteDataSource) {
        this.loginRemoteDataSource = loginRemoteDataSource;
    }


    @Override
    public void doLogin(final TestLogin callback, String email, String pass) {
        loginRemoteDataSource.doLogin(new TestLogin() {
            @Override
            public void dataAvailable(UserLoginRespon hasil) {
                callback.dataAvailable(hasil);
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                callback.onDataNotAvailable(errorMessage);
            }
        }, email, pass);
    }
}
