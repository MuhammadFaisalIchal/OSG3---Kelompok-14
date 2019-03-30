package id.eudeka.osg3kelompok14.viewmodel;

import android.content.Context;

import id.eudeka.osg3kelompok14.data.UserRepository;
import id.eudeka.osg3kelompok14.navigator.UserNavigator;
import id.eudeka.osg3kelompok14.view.activity.MainActivity;

public class UserViewModel {

    private UserRepository userRepository;
    private Context context;
    private UserNavigator mNavigator;

    public UserViewModel(UserRepository userRepository, Context context) {
        this.userRepository = userRepository;
        this.context = context;
    }

    public void getListUser(){

    }

    public void setNavigator(UserNavigator mNavigator) {
        this.mNavigator = mNavigator;
    }
}
