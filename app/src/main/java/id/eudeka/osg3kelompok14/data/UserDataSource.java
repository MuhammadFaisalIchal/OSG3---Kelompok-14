package id.eudeka.osg3kelompok14.data;

import id.eudeka.osg3kelompok14.model.UserModelRespon;

public interface UserDataSource {
    void getListUsers(GetUsersCallback callack);

    interface GetUsersCallback{
        void onUserLoaded(UserModelRespon data);
        void onDataNotAvailable(String errorMessage);
    }
}
