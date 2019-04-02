package id.eudeka.osg3kelompok14.data;

import id.eudeka.osg3kelompok14.model.UserLoginRespon;

public interface LoginDataSource {
    void doLogin(TestLogin callback, String email, String pass);

    interface TestLogin{
        void dataAvailable(UserLoginRespon hasil);
        void onDataNotAvailable(String errorMessage);
    }
}
