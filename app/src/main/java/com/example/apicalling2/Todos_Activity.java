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

public class Todos_Activity extends AppCompatActivity {

    RecyclerView todo;
    ArrayList<Todomodel> list4 =new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos);

        todo=findViewById(R.id.todo);


        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://jsonplaceholder.typicode.com/todos";



        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.e("===res", "onResponse: "+response );

                        try {
                            JSONArray ja4=new JSONArray(response);


                            for(int i=0;i<ja4.length();i++){
                                JSONObject jb4=ja4.getJSONObject(i);
                                int userId =jb4.getInt("userId");
                                int id =jb4.getInt("id");
                                String title =jb4.getString("title");
                                String completed =jb4.getString("completed");


                                Todomodel todomodel =new Todomodel(userId,id,title,completed);
                                list4.add(todomodel);
                            }
                            Myadapter_todo myadapter_todo=new Myadapter_todo(Todos_Activity.this,list4);
                            todo.setAdapter(myadapter_todo);

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