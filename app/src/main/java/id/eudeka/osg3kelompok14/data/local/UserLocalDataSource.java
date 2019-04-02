package id.eudeka.osg3kelompok14.data.local;

import android.content.Context;

import java.util.List;

import id.eudeka.osg3kelompok14.data.UserDataSource;
import id.eudeka.osg3kelompok14.model.UserModel;

public class UserLocalDataSource implements UserDataSource {

    Context context;
    UserDAO userDao;

    public UserLocalDataSource(Context context) {
        this.context = context;
        userDao= UserDatabase.getInstance(context).userDao();
    }

    public void saveDataTeam(final List<UserModel> team){
        Runnable runnable= new Runnable() {
            @Override
            public void run() {
               //dao -> insert user
            }
        };
        new Thread(runnable).start();
    }

    @Override
    public void getListUsers(GetUsersCallback callback) {

    }
}
