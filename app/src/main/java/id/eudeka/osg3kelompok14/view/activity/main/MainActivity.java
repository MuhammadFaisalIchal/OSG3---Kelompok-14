package id.eudeka.osg3kelompok14.view.activity.main;

import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.pixplicity.easyprefs.library.Prefs;

import java.util.ArrayList;
import java.util.List;

import id.eudeka.osg3kelompok14.Injection;
import id.eudeka.osg3kelompok14.R;
import id.eudeka.osg3kelompok14.adapter.UserAdapter;
import id.eudeka.osg3kelompok14.model.UserDataRespon;
import id.eudeka.osg3kelompok14.navigator.UserNavigator;
import id.eudeka.osg3kelompok14.view.activity.login.LoginActivity;
import id.eudeka.osg3kelompok14.viewmodel.UserViewModel;
import id.eudeka.osg3kelompok14.widget.Common;

public class MainActivity extends AppCompatActivity implements UserNavigator {

    private UserViewModel mUserViewModel;
    private RecyclerView recUser;

    private UserAdapter adapter;
    private List<UserDataRespon> dataListUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recUser = (RecyclerView) findViewById(R.id.recyclerUser);
        mUserViewModel = new UserViewModel(Injection.provideUserRepository(this), this);
        dataListUser = new ArrayList<>();
        mUserViewModel.setNavigator(this);
        mUserViewModel.getListUser();

        initAdapter();
        cekToken();
    }

    private void initAdapter() {
        adapter = new UserAdapter(dataListUser);
        recUser.setLayoutManager(new LinearLayoutManager(this));
        recUser.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recUser.setAdapter(adapter);
    }


    @Override
    public void loadListUser(List<UserDataRespon> listUser) {
        dataListUser.addAll(listUser);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void errorLoadListUser(String message) {
        Toast.makeText(this, "Error to load user!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void cekToken() {
        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();

        if (Prefs.getString(Common.TOKEN, "").equals("")) {
            Intent login = new Intent(this, LoginActivity.class);
            login.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(login);
            finish();
        }
        Toast.makeText(this, "" + Prefs.getString(Common.TOKEN, ""), Toast.LENGTH_SHORT).show();
    }
}
