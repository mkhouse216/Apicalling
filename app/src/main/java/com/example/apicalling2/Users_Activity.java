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

public class Users_Activity extends AppCompatActivity {

    RecyclerView user;
    ArrayList<Usermodel> list6 =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        user=findViewById(R.id.user);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://jsonplaceholder.typicode.com/users";



        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.e("===res", "onResponse: "+response );

                        try {
                            JSONArray ja6=new JSONArray(response);


                            for(int i=0;i<ja6.length();i++){
                                JSONObject jb6=ja6.getJSONObject(i);
                                int id =jb6.getInt("id");
                                String name =jb6.getString("name");
                                String username =jb6.getString("username");
                                String email =jb6.getString("email");

                                JSONObject address =jb6.getJSONObject("address");
                                String street=address.getString("street");
                                String suite=address.getString("suite");
                                String city=address.getString("city");
                                String zipcode=address.getString("zipcode");

                                JSONObject geo =address.getJSONObject("geo");
                                String lat =geo.getString("lat");
                                String lng =geo.getString("lng");

                                String phone=jb6.getString("phone");
                                String website=jb6.getString("website");

                                JSONObject company =jb6.getJSONObject("company");
                                String cname=company.getString("name");
                                String catchPhrase=company.getString("catchPhrase");
                                String bs=company.getString("bs");


                                Usermodel usermodel =new Usermodel(id,name,username,email,street,suite,city,zipcode,lat,lng,phone,website,cname,catchPhrase,bs);
                                list6.add(usermodel);
                            }
                            Myadapter_User myadapter_user=new Myadapter_User(Users_Activity.this,list6);
                            user.setAdapter(myadapter_user);

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