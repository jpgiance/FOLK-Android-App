package com.jorgegiance.folk.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jorgegiance.folk.R;
import com.jorgegiance.folk.models.Person;

import java.util.ArrayList;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleHolder> {

    private Context ctx;
    private ArrayList<Person> personList;

    public PeopleAdapter( Context ctx ) {
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public PeopleHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType ) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View peopleView = inflater.inflate(R.layout.people_item, parent, false);
        PeopleHolder holder = new PeopleHolder(peopleView);
        return holder;
    }

    @Override
    public void onBindViewHolder( @NonNull PeopleHolder holder, int position ) {

        holder.personTitle.setText(personList.get(position).getPositionTitle());
        holder.personName.setText(personList.get(position).getName());

        Glide.with(ctx)
             .load(personList.get(position).getPhotoLink())
             .centerCrop()
             .into(holder.personImage);

    }

    @Override
    public int getItemCount() {
        return personList.size();
    }


    public void setPersonList(ArrayList<Person> list){
        personList = list;
        notifyDataSetChanged();
    }




    public class PeopleHolder extends RecyclerView.ViewHolder {

        ImageView personImage;
        TextView personTitle;
        TextView personName;

        public PeopleHolder( @NonNull View itemView ) {
            super(itemView);

            personImage = itemView.findViewById(R.id.image_person);
            personName = itemView.findViewById(R.id.person_name);
            personTitle = itemView.findViewById(R.id.person_title);
        }
    }
}
