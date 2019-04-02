package id.eudeka.osg3kelompok14.navigator;

public interface LoginNavigator {
    void loginSucces(String token);
    void loginFailed(String error);
}
