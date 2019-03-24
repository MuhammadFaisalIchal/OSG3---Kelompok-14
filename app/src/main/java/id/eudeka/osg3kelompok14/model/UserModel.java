package id.eudeka.osg3kelompok14.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "user")
public class UserModel {

    //code late

    @PrimaryKey(autoGenerate = true)
    public int id_tim;

    @ColumnInfo(name = "nama_user")
    @SerializedName("strUser")
    public String nama_user;
}
