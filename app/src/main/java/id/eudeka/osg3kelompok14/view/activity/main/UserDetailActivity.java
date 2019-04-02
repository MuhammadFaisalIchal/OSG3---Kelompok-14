package id.eudeka.osg3kelompok14.view.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import id.eudeka.osg3kelompok14.R;

public class UserDetailActivity extends MainActivity {

    String strImgUser, strFName, strLName;
    TextView txtFname, txtLname;
    ImageView avaUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdetail);

        Intent intent = getIntent();
        strImgUser = intent.getStringExtra(EXTRA_IMG);
        strFName = intent.getStringExtra(EXTRA_FNAME);
        strLName = intent.getStringExtra(EXTRA_LNAME);

        avaUser = findViewById(R.id.ava_user);
        txtFname = findViewById(R.id.txt_detailfname);
        txtLname = findViewById(R.id.txt_detaillname);

        Picasso.get().load(strImgUser).into(avaUser);
        txtFname.setText(strFName);
        txtLname.setText(strLName);
    }
}