package id.eudeka.osg3kelompok14.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import id.eudeka.osg3kelompok14.Injection;
import id.eudeka.osg3kelompok14.R;
import id.eudeka.osg3kelompok14.model.UserModel;
import id.eudeka.osg3kelompok14.navigator.UserNavigator;
import id.eudeka.osg3kelompok14.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity implements UserNavigator {

    private UserViewModel mUserViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserViewModel = new UserViewModel(Injection.provideUserRepository(this), this);
        mUserViewModel.setNavigator(this);
        initAdapter();
    }

    private void initAdapter() {
        //init
    }


    @Override
    public void loadListUser(List<UserModel> listUser) {

    }

    @Override
    public void errorLoadListUser(String message) {

    }
}
