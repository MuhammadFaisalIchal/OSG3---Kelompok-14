package id.eudeka.osg3kelompok14.data.remote;

import id.eudeka.osg3kelompok14.data.UserDataSource;

public class UserRemoteDataSource implements UserDataSource {

    private ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);


    @Override
    public void getListUsers(GetUsersCallback callack) {

    }
}
