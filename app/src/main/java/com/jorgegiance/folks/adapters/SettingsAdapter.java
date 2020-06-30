package com.jorgegiance.folks.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jorgegiance.folks.R;
import com.jorgegiance.folks.models.googlecivicModels.Official;

import java.util.ArrayList;

public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.SettingsHolder> {

    private Context ctx;
    private ArrayList<Official> memberArrayList;

    public SettingsAdapter( Context ctx ) {
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public SettingsHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType ) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View peopleView = inflater.inflate(R.layout.item_settings, parent, false);
        SettingsHolder holder = new SettingsHolder(peopleView);
        return holder;
    }

    @Override
    public void onBindViewHolder( @NonNull SettingsAdapter.SettingsHolder holder, int position ) {


    }

    public void setMemberArrayList(ArrayList<Official> list){

        memberArrayList = list;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        //return memberArrayList == null? 0 : memberArrayList.size();
          return 1;
    }


    public class SettingsHolder extends RecyclerView.ViewHolder{


        public SettingsHolder( @NonNull View itemView ) {
            super(itemView);


        }
    }
}
