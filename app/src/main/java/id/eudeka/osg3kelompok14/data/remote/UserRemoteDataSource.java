package id.eudeka.osg3kelompok14.data.remote;

import id.eudeka.osg3kelompok14.data.UserDataSource;
import id.eudeka.osg3kelompok14.model.UserDataRespon;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRemoteDataSource implements UserDataSource {

    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    @Override
    public void getListUsers(final GetUsersCallback callback) {

        Call<UserDataRespon> call = apiInterface.getUserList();
        call.enqueue(new Callback<UserDataRespon>() {
            @Override
            public void onResponse(Call<UserDataRespon> call, Response<UserDataRespon> response) {
                callback.onUserLoaded(response.body());
            }

            @Override
            public void onFailure(Call<UserDataRespon> call, Throwable t) {
                callback.onDataNotAvailable(t.getMessage());
            }
        });
    }
}