package id.eudeka.osg3kelompok14.navigator;

import java.util.List;

import id.eudeka.osg3kelompok14.model.UserDataRespon;

public interface UserNavigator {
    void loadListUser(List<UserDataRespon> listUser);
    void errorLoadListUser(String message);
    void cekToken();
}
