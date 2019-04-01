package id.eudeka.osg3kelompok14.model;

import com.google.gson.annotations.SerializedName;

public class UserLoginRespon {
    @SerializedName("token")
    String token;

    public UserLoginRespon(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
