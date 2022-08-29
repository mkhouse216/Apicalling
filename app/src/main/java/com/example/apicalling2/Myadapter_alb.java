package com.example.apicalling2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Myadapter_alb extends RecyclerView.Adapter<Myadapter_alb.myalb> {

    Albums_activity albums_activity;
    ArrayList<Albummodel> list2;

    public Myadapter_alb(Albums_activity albums_activity, ArrayList<Albummodel> list2) {
        this.albums_activity = albums_activity;
        this.list2 = list2;
    }

    @NonNull
    @Override
    public Myadapter_alb.myalb onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(albums_activity).inflate(R.layout.alb,parent,false);

        return new myalb(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myadapter_alb.myalb holder, int position) {

        Albummodel alb=list2.get(position);

        holder.auserid.setText("userId"+alb.getUserId());
        holder.aid.setText("id"+alb.getId());
        holder.atitle.setText(alb.getTitle());

    }

    @Override
    public int getItemCount() {
        return list2.size();
    }

    public class myalb extends RecyclerView.ViewHolder {

        TextView auserid,aid,atitle;

        public myalb(@NonNull View itemView) {
            super(itemView);

            auserid=itemView.findViewById(R.id.auserid);
            aid=itemView.findViewById(R.id.aid);
            atitle=itemView.findViewById(R.id.atitle);
        }
    }
}
