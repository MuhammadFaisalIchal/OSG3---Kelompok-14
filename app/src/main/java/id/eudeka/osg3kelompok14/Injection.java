package id.eudeka.osg3kelompok14;

import android.content.Context;

import id.eudeka.osg3kelompok14.data.LoginRepository;
import id.eudeka.osg3kelompok14.data.UserRepository;
import id.eudeka.osg3kelompok14.data.local.UserLocalDataSource;
import id.eudeka.osg3kelompok14.data.remote.LoginRemoteDataSource;
import id.eudeka.osg3kelompok14.data.remote.UserRemoteDataSource;

public class Injection {
    public static UserRepository provideUserRepository(Context context) {
        return new UserRepository(new UserLocalDataSource(context), new UserRemoteDataSource());
    }

    public static LoginRepository provideLoginRepository(Context context){
        return new LoginRepository(new LoginRemoteDataSource());
    }
}
