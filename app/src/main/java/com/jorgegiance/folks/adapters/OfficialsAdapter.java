package com.jorgegiance.folks.adapters;

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
import com.jorgegiance.folks.models.googlecivicModels.StateCabinet;

public class OfficialsAdapter extends RecyclerView.Adapter<OfficialsAdapter.OfficialsHolder> {

    private Context ctx;
    private StateCabinet stateCabinet;

    public OfficialsAdapter( Context ctx ) {
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public OfficialsAdapter.OfficialsHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType ) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View peopleView = inflater.inflate(R.layout.item_people, parent, false);
        OfficialsHolder holder = new OfficialsHolder(peopleView);
        return holder;
    }

    @Override
    public void onBindViewHolder( @NonNull OfficialsAdapter.OfficialsHolder holder, int position ) {



            int count = 0;
            for (int i = 0; i < stateCabinet.getOffices().size(); i++) {

                count += stateCabinet.getOffices().get(i).getOfficialIndices().size();
                if (position < count){
                    holder.personTitle.setText(stateCabinet.getOffices().get(i).getName());
                    break;
                }


            }


            holder.personName.setText(stateCabinet.getOfficials().get(position).getName());

            Glide.with(ctx)
                    .load(stateCabinet.getOfficials().get(position).getPhotoUrl())
                    .centerCrop()
                    .placeholder(R.drawable.ic_person)
                    .into(holder.personImage);

//        }
    }

    @Override
    public int getItemCount() {

        if (stateCabinet == null){
            return 0;
        }else if (stateCabinet.getOfficials() == null){
            return 0;
        }else {
            return stateCabinet.getOfficials().size();
        }
    }

    public void setStateCabinet( StateCabinet stateCabinet ) {
        this.stateCabinet = stateCabinet;
        notifyDataSetChanged();
    }

    public class OfficialsHolder extends RecyclerView.ViewHolder {

        ImageView personImage;
        TextView personTitle;
        TextView personName;

        public OfficialsHolder( @NonNull View itemView ) {
            super(itemView);

            personImage = itemView.findViewById(R.id.image_person);
            personName = itemView.findViewById(R.id.person_name);
            personTitle = itemView.findViewById(R.id.person_title);
        }
    }
}
