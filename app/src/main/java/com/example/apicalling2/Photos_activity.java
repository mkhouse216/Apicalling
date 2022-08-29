package com.example.apicalling2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Photos_activity extends AppCompatActivity {

    RecyclerView photo;
    ArrayList<Photomodel> list3 =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        photo=findViewById(R.id.photo);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://jsonplaceholder.typicode.com/photos";



        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.e("===res", "onResponse: "+response );

                        try {
                            JSONArray ja3=new JSONArray(response);


                            for(int i=0;i<ja3.length();i++){
                                JSONObject jb3=ja3.getJSONObject(i);
                                int albumId =jb3.getInt("albumId");
                                int id =jb3.getInt("id");
                                String title =jb3.getString("title");
                                String url =jb3.getString("url");
                                String thumbnailUrl =jb3.getString("thumbnailUrl");


                                Photomodel photomodel =new Photomodel(albumId,id,title,url,thumbnailUrl);
                                list3.add(photomodel);
                            }
                            Myadapter_photo myadapter_photo=new Myadapter_photo(Photos_activity.this,list3);
                            photo.setAdapter(myadapter_photo);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e("====error", "onErrorResponse: "+error.getLocalizedMessage() );

            }
        });
        queue.add(stringRequest);


    }
}