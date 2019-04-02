package id.eudeka.osg3kelompok14.data.remote;

import id.eudeka.osg3kelompok14.data.LoginDataSource;
import id.eudeka.osg3kelompok14.model.UserLoginRespon;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRemoteDataSource implements LoginDataSource {

    private ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);

    @Override
    public void doLogin(final TestLogin callback, String email, String pass) {
        Call<UserLoginRespon> call= apiInterface.login(email, pass);
        call.enqueue(new Callback<UserLoginRespon>() {
            @Override
            public void onResponse(Call<UserLoginRespon> call, Response<UserLoginRespon> response) {
                callback.dataAvailable(response.body());
            }

            @Override
            public void onFailure(Call<UserLoginRespon> call, Throwable t) {
                callback.onDataNotAvailable(t.getMessage());
            }
        });
    }
}
