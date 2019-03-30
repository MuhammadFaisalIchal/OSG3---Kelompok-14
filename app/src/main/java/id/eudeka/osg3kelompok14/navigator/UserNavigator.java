package id.eudeka.osg3kelompok14.navigator;

import java.util.List;
import id.eudeka.osg3kelompok14.model.UserModel;

public interface UserNavigator {
    void loadListUser(List<UserModel> listUser);
    void errorLoadListUser(String message);
}
