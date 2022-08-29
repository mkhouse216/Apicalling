package com.example.apicalling2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;

import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myadapter.myclss> {

    MainActivity mainActivity;
    ArrayList<Postmodel> list;

    public Myadapter(MainActivity mainActivity, ArrayList<Postmodel> list) {
        this.mainActivity = mainActivity;
        this.list = list;
    }

    @NonNull
    @Override
    public myclss onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(mainActivity).inflate(R.layout.rce_layout,parent,false);

        return new myclss(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myclss holder, int position) {

        Postmodel ll=list.get(position);

        holder.uid.setText("userId"+ll.getUserId());
        holder.tid.setText("id"+ll.getUserId());
        holder.title.setText(ll.title);
        holder.body.setText(ll.body);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myclss extends RecyclerView.ViewHolder {

        TextView uid,tid,title,body;

        public myclss(@NonNull View itemView) {
            super(itemView);

            uid=itemView.findViewById(R.id.uid);
            tid=itemView.findViewById(R.id.tid);
            title=itemView.findViewById(R.id.title);
            body=itemView.findViewById(R.id.body);
        }
    }
}
