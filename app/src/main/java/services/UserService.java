package services;

import java.util.List;

import model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by Administrator on 2016/10/30.
 */

public interface UserService {

    @GET("users/{id}")
    Call<User> getUser(@Path("id")int id);



}
