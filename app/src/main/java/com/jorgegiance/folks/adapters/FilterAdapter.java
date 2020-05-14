package com.jorgegiance.folks.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jorgegiance.folks.R;

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.StatesListHolder> {

    private Context ctx;
    private FilterAdapterOnClickHandler handler;
    private String[] states;


    public FilterAdapter( Context ctx, FilterAdapterOnClickHandler handler ) {
        this.ctx = ctx;
        this.handler = handler;
        Resources res = ctx.getResources();
        states = res.getStringArray(R.array.states_list);
    }

    @NonNull
    @Override
    public FilterAdapter.StatesListHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType ) {

        LayoutInflater inflater = LayoutInflater.from(ctx);
        View settingView = inflater.inflate(R.layout.recycler_filter_item, parent, false);

        return new StatesListHolder(settingView);
    }

    @Override
    public void onBindViewHolder( @NonNull FilterAdapter.StatesListHolder holder, int position ) {
        holder.state.setText(states[position]);
    }

    @Override
    public int getItemCount() {
        return states.length;
    }

    public class StatesListHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView state;

        public StatesListHolder( @NonNull View itemView ) {
            super(itemView);

            state = itemView.findViewById(R.id.state_name);

            state.setOnClickListener(this);
        }

        @Override
        public void onClick( View v ) {
            handler.onFilterClicked(states[getAdapterPosition()]);
        }
    }

    public interface FilterAdapterOnClickHandler {
        void onFilterClicked( String state );
    }

}
