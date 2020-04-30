package com.jorgegiance.folk.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jorgegiance.folk.R;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context ctx;

    public HomeAdapter( Context ctx ) {
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public NewsListHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType ) {

        LayoutInflater inflater = LayoutInflater.from(ctx);
        View settingView = inflater.inflate(R.layout.information_item, parent, false);

        return new NewsListHolder(settingView);
    }

    @Override
    public int getItemViewType( int position ) {
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder( @NonNull RecyclerView.ViewHolder holder, int position ) {

    }

//    @Override
//    public void onBindViewHolder( @NonNull NewsListHolder holder, int position ) {
//        holder.informationText.setText("HELLO");
//    }

    @Override
    public int getItemCount() {
        return 550;
    }



    public class NewsListHolder extends RecyclerView.ViewHolder {

        TextView informationText;

        public NewsListHolder( @NonNull View itemView ) {
            super(itemView);

            informationText = itemView.findViewById(R.id.information_text);

        }
    }
}
