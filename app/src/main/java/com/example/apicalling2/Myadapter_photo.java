package com.example.apicalling2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Myadapter_photo extends RecyclerView.Adapter<Myadapter_photo.myphoto> {

    Photos_activity photos_activit;
    ArrayList<Photomodel> list3;

    public Myadapter_photo(Photos_activity photos_activit, ArrayList<Photomodel> list3) {
        this.photos_activit = photos_activit;
        this.list3 = list3;
    }

    @NonNull
    @Override
    public Myadapter_photo.myphoto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(photos_activit).inflate(R.layout.phto_layout,parent,false);

        return new myphoto(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myadapter_photo.myphoto holder, int position) {

        Photomodel pm=list3.get(position);

        holder.palbumId.setText("albumId"+pm.getAlbumId());
        holder.pid.setText("id"+pm.getId());
        holder.ptitle.setText(pm.getTitle());
        holder.purl.setText(pm.getUrl());
        holder.pthumbnailUrl.setText(pm.getThumbnailUrl());


    }

    @Override
    public int getItemCount() {
        return list3.size();
    }

    public class myphoto extends RecyclerView.ViewHolder {

        TextView palbumId,pid,ptitle,purl,pthumbnailUrl;

        public myphoto(@NonNull View itemView) {
            super(itemView);

            palbumId=itemView.findViewById(R.id.palbumId);
            pid=itemView.findViewById(R.id.pid);
            ptitle=itemView.findViewById(R.id.ptitle);
            purl=itemView.findViewById(R.id.purl);
            pthumbnailUrl=itemView.findViewById(R.id.pthumbnailUrl);


        }
    }
}
