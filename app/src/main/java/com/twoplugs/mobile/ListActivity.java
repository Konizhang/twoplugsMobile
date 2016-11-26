package com.twoplugs.mobile;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import adapter.MyAdapter;
import model.Service;
import model.ServiceBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import services.ServiceService;
import utils.Constants;

public class ListActivity extends AppCompatActivity  implements Callback<ServiceBean> {

    private MyAdapter adapter ;
    private  RecyclerView recycler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        ServiceService ss  = retrofit.create(ServiceService.class);

        Call<ServiceBean> call = ss.getService(0,20);


        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<ServiceBean> call, Response<ServiceBean> response) {

        ServiceBean s  = response.body();
        List<Service> services = s.get_embedded().getServices();

        adapter = new MyAdapter(this,services);
        recycler = (RecyclerView)findViewById(R.id.recycler);
        recycler.setAdapter(adapter);

        System.out.println(s.get_embedded().getServices().size());
    }


    @Override
    public void onFailure(Call<ServiceBean> call, Throwable t) {
        t.printStackTrace();
    }



}
