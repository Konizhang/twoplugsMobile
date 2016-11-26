package services;

import model.ServiceBean;

import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/11/1.
 */

public interface ServiceService {

    //services?page=0&size=20
    @GET("services/")
    Call<ServiceBean> getService(@Query("page")int page, @Query("size")int size);

}
