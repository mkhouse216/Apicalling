package com.example.apicalling2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Myadapter_todo extends RecyclerView.Adapter<Myadapter_todo.Mytodo> {

    Todos_Activity todos_activity;
    ArrayList<Todomodel> list4;

    public Myadapter_todo(Todos_Activity todos_activity, ArrayList<Todomodel> list4) {
        this.todos_activity = todos_activity;
        this.list4 = list4;
    }

    @NonNull
    @Override
    public Mytodo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(todos_activity).inflate(R.layout.todo_lay,parent,false);

        return new Mytodo(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Mytodo holder, int position) {
        Todomodel to=list4.get(position);

        holder.tuserId.setText("userId"+to.getUserId());
        holder.tid.setText("id"+to.getUserId());
        holder.ttitle.setText(to.getTitle());
        holder.tcompleted.setText(to.getCompleted());

    }

    @Override
    public int getItemCount() {
        return list4.size();
    }

    public class Mytodo extends RecyclerView.ViewHolder {

        TextView tuserId,tid,ttitle,tcompleted;

        public Mytodo(@NonNull View itemView) {
            super(itemView);

            tuserId=itemView.findViewById(R.id.tuserId);
            tid=itemView.findViewById(R.id.tid);
            ttitle=itemView.findViewById(R.id.ttitle);
            tcompleted=itemView.findViewById(R.id.tcompleted);


        }
    }
}
