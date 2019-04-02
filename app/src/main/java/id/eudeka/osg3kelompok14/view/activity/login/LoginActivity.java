package id.eudeka.osg3kelompok14.view.activity.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pixplicity.easyprefs.library.Prefs;

import id.eudeka.osg3kelompok14.Injection;
import id.eudeka.osg3kelompok14.R;
import id.eudeka.osg3kelompok14.navigator.LoginNavigator;
import id.eudeka.osg3kelompok14.view.activity.main.MainActivity;
import id.eudeka.osg3kelompok14.viewmodel.LoginViewModel;
import id.eudeka.osg3kelompok14.widget.Common;

public class LoginActivity extends AppCompatActivity implements LoginNavigator {

    private LoginViewModel viewModel;

    EditText user, pass;
    Button submitBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setUI();

        viewModel= new LoginViewModel(this, Injection.provideLoginRepository(this));
        viewModel.setNavigator(this);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.cekUser(user.getText().toString(), pass.getText().toString());
            }
        });


    }

    private void setUI() {
        user= findViewById(R.id.inputUsername);
        pass= findViewById(R.id.inputPassword);
        submitBtn= findViewById(R.id.submit_user);
    }


    @Override
    public void loginSucces(String token) {
        Prefs.putString(Common.TOKEN, token);
        Intent main= new Intent(this, MainActivity.class);
        main.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(main);
        finish();
    }

    @Override
    public void loginFailed(String error) {
        Toast.makeText(this, ""+error, Toast.LENGTH_SHORT).show();
    }


}
