package com.example.apicalling2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Myadaptercom extends RecyclerView.Adapter<Myadaptercom.mycom> {

    Comments_activity comments_activity;
    ArrayList<Commetmodel> list1;

    public Myadaptercom(Comments_activity comments_activity, ArrayList<Commetmodel> list1) {
        this.comments_activity = comments_activity;
        this.list1 = list1;
    }

    @NonNull
    @Override
    public Myadaptercom.mycom onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(comments_activity).inflate(R.layout.com_rec,parent,false);

        return new mycom(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myadaptercom.mycom holder, int position) {

        Commetmodel co= list1.get(position);

        holder.cpostid.setText(""+co.getPostId());
        holder.cid.setText("id"+co.getId());
        holder.cname.setText(co.getName());
        holder.cemail.setText(co.getEmail());
        holder.cbody.setText(co.getBody());

    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public class mycom extends RecyclerView.ViewHolder {

        TextView cpostid,cid,cname,cemail,cbody;

        public mycom(@NonNull View itemView) {
            super(itemView);

            cpostid=itemView.findViewById(R.id.cpostid);
            cid=itemView.findViewById(R.id.cid);
            cname=itemView.findViewById(R.id.cname);
            cemail=itemView.findViewById(R.id.cemail);
            cbody=itemView.findViewById(R.id.cbody);

        }
    }
}
