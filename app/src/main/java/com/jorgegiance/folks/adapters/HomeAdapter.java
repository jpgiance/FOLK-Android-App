package com.jorgegiance.folks.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jorgegiance.folks.R;
import com.jorgegiance.folks.models.firebaseModels.Item;
import com.jorgegiance.folks.models.firebaseModels.News;
import com.jorgegiance.folks.util.Utilities;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private HomeAdapterOnClickHandler handler;
    private OnBottomReachedListener mOnBottomReachedListener;
    private Context ctx;
    private ArrayList<Item> homeItemsList;
    private static int TYPE_INFO = 1;
    private static int TYPE_TOP = 2;
    private static int TYPE_SINGLE = 3;
    private static int TYPE_DUO = 4;
    private static int TYPE_LIST = 5;
    private static int TYPE_LOADING = 6;

    public HomeAdapter( Context ctx, HomeAdapterOnClickHandler handler ) {
        this.ctx = ctx;
        this.handler = handler;
    }


    public void setHomeItemsList( ArrayList<Item> homeItemsList ) {
        this.homeItemsList = homeItemsList;
        notifyDataSetChanged();
    }

    public void addToHomeItemList(ArrayList<Item> homeItemsList ){
        this.homeItemsList.addAll(homeItemsList);
        notifyDataSetChanged();
    }

    public void addItemToHomeItemList(Item item ){
        this.homeItemsList.add(item);
        notifyDataSetChanged();
    }

    public void addOnBottomReachedListener(OnBottomReachedListener onBottomReachedListener){
        this.mOnBottomReachedListener = onBottomReachedListener;
    }




    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType ) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(ctx);



        if (viewType == TYPE_INFO) {
                view = inflater.inflate(R.layout.item_info_home, parent, false);
                return new InfoHolder(view);
            }
        if (viewType == TYPE_TOP) {
            view = inflater.inflate(R.layout.item_top_home, parent, false);
            return new TopHolder(view);
        }
        if (viewType == TYPE_SINGLE) {
            view = inflater.inflate(R.layout.item_single_home, parent, false);
            return new SingleHolder(view);
        }
        if (viewType == TYPE_DUO) {
            view = inflater.inflate(R.layout.item_duo_home, parent, false);
            return new DuoHolder(view);
        }
        if (viewType == TYPE_LIST) {
            view = inflater.inflate(R.layout.item_list_home, parent, false);
            return new ListHolder(view);
        }
        else
            return null;


    }

    @Override
    public int getItemViewType( int position ) {

        if (homeItemsList.get(position) == null)
            return TYPE_LOADING;
        else if (homeItemsList.get(position).hasInformation())
            return TYPE_INFO;
        else if (homeItemsList.get(position).hasSectionTitle())
            return TYPE_TOP;
        else if (homeItemsList.get(position).itemSize() == 1)
            return TYPE_SINGLE;
        else if (homeItemsList.get(position).itemSize() == 2)
            return TYPE_DUO;
        else if (homeItemsList.get(position).itemSize() > 2)
            return TYPE_LIST;
        else
            return 0;

    }

    @Override
    public void onBindViewHolder( @NonNull RecyclerView.ViewHolder holder, int position ) {

        if (getItemViewType(position) == TYPE_INFO){
            ((InfoHolder) holder).populateView(homeItemsList.get(position));
        }
        if (getItemViewType(position) == TYPE_TOP){
            ((TopHolder) holder).populateView(homeItemsList.get(position));
        }
        if (getItemViewType(position) == TYPE_SINGLE){
            ((SingleHolder) holder).populateView(homeItemsList.get(position));
        }
        if (getItemViewType(position) == TYPE_DUO){
            ((DuoHolder) holder).populateView(homeItemsList.get(position));
        }
        if (getItemViewType(position) == TYPE_LIST){
            ((ListHolder) holder).populateView(homeItemsList.get(position));
        }
        if (getItemViewType(position) == TYPE_LOADING){
            ((LoadingHolder) holder).populateView(homeItemsList.get(position));
        }

//        if (position == homeItemsList.size()-1){
//            mOnBottomReachedListener.onBottomReached(position);
//
//
//        }

    }

    @Override
    public int getItemCount() {
        return homeItemsList == null ? 0 : homeItemsList.size();
    }



    public class InfoHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView informationText;

        public InfoHolder( @NonNull View itemView ) {
            super(itemView);

            informationText = itemView.findViewById(R.id.info_text);
            informationText.setOnClickListener(this);

        }

        public void populateView( Item homeItem ) {
            informationText.setText(homeItem.getInformation());
        }

        @Override
        public void onClick( View v ) {
            // TODO implement onClick for info item
        }
    }

    public class TopHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView sectionTitle, itemTitle, itemTime;
        ImageView itemImage;


        public TopHolder( @NonNull View itemView ) {
            super(itemView);

            sectionTitle = itemView.findViewById(R.id.section_title);
            itemTitle = itemView.findViewById(R.id.item_title);
            itemTime = itemView.findViewById(R.id.item_time);
            itemImage = itemView.findViewById(R.id.item_image);

        }

        @SuppressLint("SetTextI18n")
        public void populateView( Item homeItem ) {
            sectionTitle.setText(homeItem.getTitle());
            itemTitle.setText(homeItem.getNews().get(0).getTitle());
            itemTime.setText(Utilities.time2String(homeItem.getNews().get(0).getTime()));

            Glide.with(ctx)
                    .load(homeItem.getNews().get(0).getPhotoUrl())
                    .centerCrop()
                    .into(itemImage);

            itemTime.setOnClickListener(this);
            itemTitle.setOnClickListener(this);
            itemImage.setOnClickListener(this);
        }

        @Override
        public void onClick( View v ) {
            handler.onItemClicked(homeItemsList.get(getAdapterPosition()).getNews().get(0));
        }
    }

    public class SingleHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView itemTitle, itemTime;
        ImageView itemImage;

        public SingleHolder( @NonNull View itemView ) {
            super(itemView);

            itemTitle = itemView.findViewById(R.id.item_title);
            itemTime = itemView.findViewById(R.id.item_time);
            itemImage = itemView.findViewById(R.id.item_image);

        }

        @SuppressLint("SetTextI18n")
        public void populateView( Item homeItem ) {

            itemTitle.setText(homeItem.getNews().get(0).getTitle());
            itemTime.setText(Utilities.time2String(homeItem.getNews().get(0).getTime()));

            Glide.with(ctx)
                    .load(homeItem.getNews().get(0).getPhotoUrl())
                    .centerCrop()
                    .into(itemImage);

            itemTime.setOnClickListener(this);
            itemTitle.setOnClickListener(this);
            itemImage.setOnClickListener(this);
        }

        @Override
        public void onClick( View v ) {
            handler.onItemClicked(homeItemsList.get(getAdapterPosition()).getNews().get(0));
        }
    }

    public class DuoHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView itemTitle, itemTime, itemTitle2, itemTime2;
        ImageView itemImage, itemImage2;

        public DuoHolder( @NonNull View itemView ) {
            super(itemView);

            itemTitle = itemView.findViewById(R.id.item_title);
            itemTime = itemView.findViewById(R.id.item_time);
            itemImage = itemView.findViewById(R.id.item_image);

            itemTitle2 = itemView.findViewById(R.id.item_title_2);
            itemTime2 = itemView.findViewById(R.id.item_time_2);
            itemImage2 = itemView.findViewById(R.id.item_image_2);

        }

        @SuppressLint("SetTextI18n")
        public void populateView( Item homeItem ) {
            itemTitle.setText(homeItem.getNews().get(0).getTitle());
            itemTime.setText(Utilities.time2String(homeItem.getNews().get(0).getTime()));

            itemTitle2.setText(homeItem.getNews().get(1).getTitle());
            itemTime2.setText(Utilities.time2String(homeItem.getNews().get(1).getTime()));

            Glide.with(ctx)
                    .load(homeItem.getNews().get(0).getPhotoUrl())
                    .centerCrop()
                    .into(itemImage);

            Glide.with(ctx)
                    .load(homeItem.getNews().get(1).getPhotoUrl())
                    .centerCrop()
                    .into(itemImage2);

            itemTime.setOnClickListener(this);
            itemTitle.setOnClickListener(this);
            itemImage.setOnClickListener(this);

            itemTime2.setOnClickListener(this);
            itemTitle2.setOnClickListener(this);
            itemImage2.setOnClickListener(this);

        }

        @Override
        public void onClick( View v ) {
            switch (v.getId()){
                case R.id.item_image:
                case R.id.item_time:
                case R.id.item_title:
                    firstItemClicked();
                    break;
                case R.id.item_image_2:
                case R.id.item_time_2:
                case R.id.item_title_2:
                    SecondItemClicked();
                    break;
            }
        }

        private void SecondItemClicked() {
            handler.onItemClicked(homeItemsList.get(getAdapterPosition()).getNews().get(1));
        }

        private void firstItemClicked() {
            handler.onItemClicked(homeItemsList.get(getAdapterPosition()).getNews().get(0));
        }
    }

    public class ListHolder extends RecyclerView.ViewHolder {

        /* TODO Implement Holder for horizontal recycler view
        *
        * */

        public ListHolder( @NonNull View itemView ) {
            super(itemView);
        }

        public void populateView( Item homeItem ) {
        }
    }

    public class LoadingHolder extends RecyclerView.ViewHolder {

        ProgressBar progressBar;


        public LoadingHolder( @NonNull View itemView ) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progressBar);
        }

        public void populateView( Item homeItem ) {
        }
    }



    public interface HomeAdapterOnClickHandler {
        void onItemClicked( News news );
    }

    public interface OnBottomReachedListener{
        void onBottomReached(int position);
    }
}
