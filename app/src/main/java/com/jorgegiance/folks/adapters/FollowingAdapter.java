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

import com.bumptech.glide.Glide;
import com.jorgegiance.folks.R;
import com.jorgegiance.folks.models.googlecivicModels.Official;
import com.jorgegiance.folks.util.Utilities;

import java.util.ArrayList;

public class FollowingAdapter extends RecyclerView.Adapter<FollowingAdapter.FollowingHolder> {

    private Context ctx;
    private ArrayList<Official> memberArrayList;

    public FollowingAdapter( Context ctx ) {
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public FollowingHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType ) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View peopleView = inflater.inflate(R.layout.item_following, parent, false);
        FollowingHolder holder = new FollowingHolder(peopleView);
        return holder;
    }

    @Override
    public void onBindViewHolder( @NonNull FollowingAdapter.FollowingHolder holder, int position ) {

        holder.candidateName.setText(memberArrayList.get(position).getName());
        holder.candidateCurrentPosition.setText(memberArrayList.get(position).getUrls().get(0));
        holder.candidateStateParty.setText(memberArrayList.get(position).getParty());


        Glide.with(ctx)
                .load(memberArrayList.get(position).getPhotoUrl())
                .centerCrop()
                .placeholder(R.drawable.ic_person)
                .into(holder.candidateImage);
    }

    public void setMemberArrayList(ArrayList<Official> list){

        memberArrayList = list;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return memberArrayList == null? 0 : memberArrayList.size();
      //  return 20;
    }


    public class FollowingHolder extends RecyclerView.ViewHolder{

        ImageView candidateImage;
        ImageButton iconDelete;
        TextView candidateName, candidateStateParty, candidateCurrentPosition, positionRunningFor;

        public FollowingHolder( @NonNull View itemView ) {
            super(itemView);

            candidateImage = itemView.findViewById(R.id.image_following);
            iconDelete = itemView.findViewById(R.id.delete_icon);
            candidateName = itemView.findViewById(R.id.name_following);
            candidateStateParty = itemView.findViewById(R.id.state_party);
            candidateCurrentPosition = itemView.findViewById(R.id.current_position);
        }
    }
}
