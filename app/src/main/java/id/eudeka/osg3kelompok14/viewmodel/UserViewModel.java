package id.eudeka.osg3kelompok14.viewmodel;

import android.content.Context;

import id.eudeka.osg3kelompok14.data.UserDataSource;
import id.eudeka.osg3kelompok14.data.UserRepository;
import id.eudeka.osg3kelompok14.model.UserDataRespon;
import id.eudeka.osg3kelompok14.navigator.UserNavigator;

public class UserViewModel {

    private Context context;
    private UserRepository userRepository;
    private UserNavigator mNavigator;

    public UserViewModel(UserRepository userRepository, Context context) {
        this.userRepository = userRepository;
        this.context = context;
    }

    public void getListUser() {
        userRepository.getListUsers(new UserDataSource.GetUsersCallback() {
            @Override
            public void onUserLoaded(UserDataRespon data) {
                mNavigator.loadListUser(data.getData());
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                mNavigator.errorLoadListUser(errorMessage);
            }
        });
    }

    public void setNavigator(UserNavigator mNavigator) {
        this.mNavigator = mNavigator;
    }
}
