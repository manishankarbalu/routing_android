package com.commonman.manishankar.saferout;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;


import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    ArrayList<Dbinfo> arrayList=new ArrayList<>();
    public RecyclerAdapter(ArrayList<Dbinfo> arrayList){
        this.arrayList=arrayList;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        Dbinfo movie=arrayList.get(position);
        holder.user.setText(movie.getUsername());
        holder.lat.setText(movie.getLatti().toString());
        holder.lng.setText(movie.getLongi().toString());
        holder.crat.setText(Integer.toString(movie.getCrimerate()));
    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.dblister,parent,false);
        RecyclerViewHolder recyclerViewHolder=new RecyclerViewHolder(view);
        return recyclerViewHolder;



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{

        private TextView user;
        private TextView lat;
        private TextView lng;
        private TextView crat;
        public RecyclerViewHolder(View view){
            super(view);

            user=(TextView)view.findViewById(R.id.user);
            lat=(TextView)view.findViewById(R.id.llat);
            lng=(TextView)view.findViewById(R.id.llon);
            crat=(TextView)view.findViewById(R.id.ccra);
        }
    }
}
