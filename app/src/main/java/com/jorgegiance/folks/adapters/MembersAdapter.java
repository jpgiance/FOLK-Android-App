package com.jorgegiance.folks.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jorgegiance.folks.R;
import com.jorgegiance.folks.models.propublicaModels.Member;
import com.jorgegiance.folks.util.Utilities;

import java.util.List;

public class MembersAdapter extends RecyclerView.Adapter<MembersAdapter.MembersHolder> {

    private Context ctx;
    private List<Member> membersList;

    public MembersAdapter( Context ctx ) {
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public MembersHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType ) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View peopleView = inflater.inflate(R.layout.people_item, parent, false);
        MembersHolder holder = new MembersHolder(peopleView);
        return holder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder( @NonNull MembersHolder holder, int position ) {

        holder.personTitle.setText(membersList.get(position).getState() + " - " + Utilities.parseParty(membersList.get(position).getParty()));
        holder.personName.setText(Utilities.parseName(membersList.get(position).getLastName(), membersList.get(position).getFirstName()));

        Glide.with(ctx)
             .load(Utilities.congressPhotoId(membersList.get(position).getId()))
             .centerCrop()
             .placeholder(R.drawable.ic_person)
             .into(holder.personImage);

    }

    @Override
    public int getItemCount() {
        return membersList == null ? 0 : membersList.size();
    }


    public void setMembersList( List<Member> list){
        membersList = list;
        notifyDataSetChanged();
    }




    public class MembersHolder extends RecyclerView.ViewHolder {

        ImageView personImage;
        TextView personTitle;
        TextView personName;

        public MembersHolder( @NonNull View itemView ) {
            super(itemView);

            personImage = itemView.findViewById(R.id.image_person);
            personName = itemView.findViewById(R.id.person_name);
            personTitle = itemView.findViewById(R.id.person_title);
        }
    }
}
