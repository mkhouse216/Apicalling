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

public class MainActivity extends AppCompatActivity {

    RecyclerView rec;
    ArrayList<Postmodel> list =new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rec=findViewById(R.id.rec);

        //todo change 1.Dependency add
        // 2.Internet permission
        // 3.send simple Request
        // 4.Check Uri
        // 5.Check Method(post/get)
        // 6.Compulsory put loge

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://jsonplaceholder.typicode.com/posts";



        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.e("===res", "onResponse: "+response );

                        try {
                            JSONArray ja=new JSONArray(response);


                            for(int i=0;i<ja.length();i++){
                                JSONObject jb=ja.getJSONObject(i);
                                int userId =jb.getInt("userId");
                                int id =jb.getInt("id");
                                String title =jb.getString("title");
                                String body =jb.getString("body");


                                Postmodel Postmodel =new Postmodel(userId,id,title,body);
                                list.add(Postmodel);
                            }
                            Myadapter myadapter=new Myadapter(MainActivity.this,list);
                            rec.setAdapter(myadapter);

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