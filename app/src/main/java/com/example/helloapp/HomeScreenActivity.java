package com.example.helloapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeScreenActivity extends AppCompatActivity {

    ImageView image;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    Adapter adapter;
    List<InformationModelClass> users=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_sceen);


        recyclerView=findViewById(R.id.recyclerview);
        image=findViewById(R.id.image);

        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new Adapter(this,users);
        recyclerView.setAdapter(adapter);

        fetchData();


    }

    private void fetchData() {

        RetrofitClient.getRetrofitClient().getUsers().enqueue(new Callback<List<InformationModelClass>>() {
            @Override
            public void onResponse(Call<List<InformationModelClass>> call, Response<List<InformationModelClass>> response) {
              if(response.isSuccessful() && response.body()!=null){
                  users.addAll(response.body());
                  adapter.notifyDataSetChanged();
              }
            }

            @Override
            public void onFailure(Call<List<InformationModelClass>> call, Throwable t) {
                Toast.makeText(HomeScreenActivity.this, "Error: ", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
