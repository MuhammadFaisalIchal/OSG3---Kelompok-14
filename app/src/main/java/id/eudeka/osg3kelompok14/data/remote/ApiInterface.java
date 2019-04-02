package id.eudeka.osg3kelompok14.data.remote;

import id.eudeka.osg3kelompok14.model.UserDataRespon;
import id.eudeka.osg3kelompok14.model.UserLoginRespon;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("login")
    Call<UserLoginRespon> login(@Field("email") String email,
                                @Field("password") String password);

    @GET("users?page=2")
    Call<UserDataRespon> getUserList();


}
