package id.eudeka.osg3kelompok14.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.service.autofill.UserData;

import id.eudeka.osg3kelompok14.model.UserModel;

@Database(entities = {UserModel.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    private static UserDatabase INSTANCE;

    public abstract UserDAO userDao();

    private static final Object sLock= new Object();

    public static UserDatabase getInstance(Context context){
        synchronized (sLock){
            if (INSTANCE==null){
                INSTANCE= Room.databaseBuilder(context.getApplicationContext(),
                        UserDatabase.class, "User.db").build();
            }
            return INSTANCE;
        }
    }

}
