package id.eudeka.osg3kelompok14.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserDataRespon {

    @SerializedName("data")
    private List<UserDataRespon> data;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("id")
    private int id;

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("first_name")
    private String firstName;

    public UserDataRespon(List<UserDataRespon> data, String lastName, int id, String avatar, String firstName) {
        this.data = data;
        this.lastName = lastName;
        this.id = id;
        this.avatar = avatar;
        this.firstName = firstName;
    }

    public List<UserDataRespon> getData() {
        return data;
    }

    public String getLastName() {
        return lastName;
    }


    public int getId() {
        return id;
    }


    public String getAvatar() {
        return avatar;
    }


    public String getFirstName() {
        return firstName;
    }

}