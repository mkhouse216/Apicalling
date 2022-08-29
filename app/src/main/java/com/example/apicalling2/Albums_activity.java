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

public class Albums_activity extends AppCompatActivity {

    RecyclerView alb;
    ArrayList<Albummodel> list2 =new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        alb=findViewById(R.id.alb);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://jsonplaceholder.typicode.com/posts";



        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.e("===res", "onResponse: "+response );

                        try {
                            JSONArray ja2=new JSONArray(response);


                            for(int i=0;i<ja2.length();i++){
                                JSONObject jb2=ja2.getJSONObject(i);
                                int userId =jb2.getInt("userId");
                                int id =jb2.getInt("id");
                                String title =jb2.getString("title");


                                Albummodel albummodel =new Albummodel(userId,id,title);
                                list2.add(albummodel);
                            }
                            Myadapter_alb myadapter_alb=new Myadapter_alb(Albums_activity.this,list2);
                            alb.setAdapter(myadapter_alb);

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