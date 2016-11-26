package com.twoplugs.mobile;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


import adapter.MyAdapter;
import model.Service;
import model.ServiceBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import services.ServiceService;
import services.UserService;

public class MainActivity extends AppCompatActivity implements Callback<ServiceBean> {

        private MyAdapter adapter ;
        private  RecyclerView recycler;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

             Retrofit  retrofit = new Retrofit.Builder().baseUrl("http://qatest.twoplugs.com:3721/apk/v1/").addConverterFactory(GsonConverterFactory.create()).build();

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

   public void onBackPressed() {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
        builder.setTitle("Notice");
        builder.setMessage("Are you sure you want to exit?");
        builder.setNegativeButton("cancel", null);
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
               // App.getInstance().exitApp();
                finish();
            }
        });
        builder.show();
    }
}
