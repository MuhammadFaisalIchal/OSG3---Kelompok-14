package id.eudeka.osg3kelompok14.data;

import id.eudeka.osg3kelompok14.data.local.UserLocalDataSource;
import id.eudeka.osg3kelompok14.data.remote.UserRemoteDataSource;
import id.eudeka.osg3kelompok14.model.UserDataRespon;

public class UserRepository implements UserDataSource {

    private UserLocalDataSource lokalUserSource;
    private UserRemoteDataSource remoteUserSource;

    public UserRepository(UserLocalDataSource lokalUserSource, UserRemoteDataSource remoteUserSource) {
        this.lokalUserSource = lokalUserSource;
        this.remoteUserSource = remoteUserSource;
    }

    @Override
    public void getListUsers(final GetUsersCallback callback) {
        remoteUserSource.getListUsers(new GetUsersCallback() {
            @Override
            public void onUserLoaded(UserDataRespon data) {
                callback.onUserLoaded(data);
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                callback.onDataNotAvailable(errorMessage);
            }
        });
    }

    private void getUsersfromRemoteDataSource(final GetUsersCallback callback) {

    }
}
