package com.example.apicalling2.Retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.apicalling2.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Retro_Activity2 extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retro2);

        Retro_instace.CallMyapi().Postslist().enqueue(new Callback<List<Example>>() {
            @Override
            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {

                Log.e("==", "onResponse: "+response.body() );
            }

            @Override
            public void onFailure(Call<List<Example>> call, Throwable t) {

            }
        });

    }
}