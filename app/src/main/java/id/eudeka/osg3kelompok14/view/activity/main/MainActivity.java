package id.eudeka.osg3kelompok14.view.activity.main;

import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.pixplicity.easyprefs.library.Prefs;

import java.util.ArrayList;
import java.util.List;

import id.eudeka.osg3kelompok14.Injection;
import id.eudeka.osg3kelompok14.R;
import id.eudeka.osg3kelompok14.model.UserModel;
import id.eudeka.osg3kelompok14.navigator.UserNavigator;
import id.eudeka.osg3kelompok14.view.activity.login.LoginActivity;
import id.eudeka.osg3kelompok14.viewmodel.UserViewModel;
import id.eudeka.osg3kelompok14.widget.Common;

public class MainActivity extends AppCompatActivity implements UserNavigator {

    private UserViewModel mUserViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cekToken();
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

    @Override
    public void cekToken() {
        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();

        if (Prefs.getString(Common.TOKEN, "").equals("")){
            Intent login= new Intent(this, LoginActivity.class);
            login.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(login);
            finish();
        }
        Toast.makeText(this, ""+Prefs.getString(Common.TOKEN, ""), Toast.LENGTH_SHORT).show();
    }
}
