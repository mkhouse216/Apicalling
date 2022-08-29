package com.example.apicalling2.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;

public interface GithubService {


    @GET("posts")
    Call<List<Example>> Postslist(@Field(String name),@);

}
