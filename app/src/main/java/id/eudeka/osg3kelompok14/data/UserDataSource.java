package id.eudeka.osg3kelompok14.data;

import id.eudeka.osg3kelompok14.model.UserDataRespon;

public interface UserDataSource {
    void getListUsers(GetUsersCallback callback);

    interface GetUsersCallback{
        void onUserLoaded(UserDataRespon data);
        void onDataNotAvailable(String errorMessage);
    }
}
