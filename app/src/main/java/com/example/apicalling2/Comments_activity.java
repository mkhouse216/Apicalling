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

public class Comments_activity extends AppCompatActivity {

    RecyclerView com;
    ArrayList<Commetmodel> list1 =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        com=findViewById(R.id.com);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://jsonplaceholder.typicode.com/comments";



        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.e("===res", "onResponse: "+response );

                        try {
                            JSONArray ja1=new JSONArray(response);


                            for(int i=0;i<ja1.length();i++){
                                JSONObject jb1=ja1.getJSONObject(i);
                                int postId =jb1.getInt("postId");
                                int id =jb1.getInt("id");
                                String name =jb1.getString("name");
                                String email =jb1.getString("email");
                                String body =jb1.getString("body");


                                Commetmodel commetmodel =new Commetmodel(postId,id,name,email,body);

                                list1.add(commetmodel);
                            }
                            Myadaptercom myadaptercom=new Myadaptercom(Comments_activity.this,list1);
                            com.setAdapter(myadaptercom);

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