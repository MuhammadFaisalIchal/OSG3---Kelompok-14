package id.eudeka.osg3kelompok14.data;

import android.support.annotation.Nullable;

import id.eudeka.osg3kelompok14.data.local.UserLocalDataSource;
import id.eudeka.osg3kelompok14.data.remote.UserRemoteDataSource;

public class UserRepository implements UserDataSource {

    private UserLocalDataSource lokalUserSource;
    private UserRemoteDataSource remoteUserSource;

    public UserRepository(UserLocalDataSource lokalUserSource, UserRemoteDataSource remoteUserSource) {
        this.lokalUserSource = lokalUserSource;
        this.remoteUserSource = remoteUserSource;
    }

    @Override
    public void getListUsers(GetUsersCallback callack) {

    }

    private void getUsersfromRemoteDataSource(final GetUsersCallback callback) {

    }
}
