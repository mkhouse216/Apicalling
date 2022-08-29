package com.example.apicalling2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Myadapter_User extends RecyclerView.Adapter<Myadapter_User.myuser> {

    Users_Activity users_activity;
    ArrayList<Usermodel> list6;

    public Myadapter_User(Users_Activity users_activity, ArrayList<Usermodel> list6) {
        this.users_activity = users_activity;
        this.list6 = list6;
    }

    @NonNull
    @Override
    public Myadapter_User.myuser onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(users_activity).inflate(R.layout.user_layout,parent,false);

        return new myuser(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myadapter_User.myuser holder, int position) {

        Usermodel to=list6.get(position);

        holder.uid.setText("id"+to.getId());
        holder.uname.setText("name"+to.getName());
        holder.uusername.setText(to.getUsername());
        holder.uemail.setText(to.getEmail());
        holder.uaddress.setText("address"+to.getStreet()+","+to.getSuite()+","+to.getCity()+","+to.getZipcode());
        holder.ugeo.setText("geo"+to.getLat()+","+to.getLng());
        holder.uphone.setText(to.getPhone());
        holder.uwebsite.setText(to.getWebsite());
        holder.ucompany.setText("company"+to.getName()+","+to.getCatchPhrase()+","+to.getBs());

    }

    @Override
    public int getItemCount() {
        return list6.size();
    }

    public class myuser extends RecyclerView.ViewHolder {

        TextView uid,uname,uusername,uemail,uaddress,ugeo,uphone,uwebsite,ucompany;

        public myuser(@NonNull View itemView) {
            super(itemView);

            uid=itemView.findViewById(R.id.uid);
            uname=itemView.findViewById(R.id.uname);
            uusername=itemView.findViewById(R.id.uusername);
            uemail=itemView.findViewById(R.id.uemail);
            uaddress=itemView.findViewById(R.id.uaddress);
            ugeo=itemView.findViewById(R.id.ugeo);
            uphone=itemView.findViewById(R.id.uphone);
            uwebsite=itemView.findViewById(R.id.uwebsite);
            ucompany=itemView.findViewById(R.id.ucompany);


        }
    }
}
