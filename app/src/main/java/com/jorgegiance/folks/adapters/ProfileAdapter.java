package com.jorgegiance.folks.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jorgegiance.folks.R;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileHolder> {

    private Context ctx;
    private boolean fieldsState = false;


    public ProfileAdapter( Context ctx ) {
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ProfileHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType ) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.item_profile, parent, false);
        ProfileHolder holder = new ProfileHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder( @NonNull ProfileHolder holder, int position ) {

        holder.disableFields();
    }

    @Override
    public int getItemCount() {
        return 1;
    }







    public class ProfileHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //ui components
        private ImageButton editButton;
        private EditText name, email, dateOfBirth, address, city, state, country, zipCode;


        public ProfileHolder( @NonNull View itemView ) {
            super(itemView);

            editButton = itemView.findViewById(R.id.edit_button_personal_info);
            name = itemView.findViewById(R.id.profile_edit_name);
            email = itemView.findViewById(R.id.profile_edit_email);
            dateOfBirth = itemView.findViewById(R.id.profile_edit_age);
            city = itemView.findViewById(R.id.profile_edit_city);
            state = itemView.findViewById(R.id.profile_edit_state);
            country = itemView.findViewById(R.id.profile_edit_country);
            zipCode= itemView.findViewById(R.id.profile_edit_zipCode);
            address = itemView.findViewById(R.id.profile_edit_address);

            editButton.setOnClickListener(this);

        }

        private void disableFields(){
            name.setEnabled(false);
            name.setBackground(null);
            email.setEnabled(false);
            email.setBackground(null);
            dateOfBirth.setEnabled(false);
            dateOfBirth.setBackground(null);
            city.setEnabled(false);
            city.setBackground(null);
            state.setEnabled(false);
            state.setBackground(null);
            country.setEnabled(false);
            country.setBackground(null);
            zipCode.setEnabled(false);
            zipCode.setBackground(null);
            address.setEnabled(false);
            address.setBackground(null);

            editButton.setBackgroundColor(ctx.getResources().getColor(R.color.fui_transparent));
            fieldsState = false;
        }

        @Override
        public void onClick( View v ) {
            if (v.getId() == R.id.edit_button_personal_info){
                if (!fieldsState){
                    name.setEnabled(true);
                    email.setEnabled(true);
                    dateOfBirth.setEnabled(true);
                    city.setEnabled(true);
                    state.setEnabled(true);
                    country.setEnabled(true);
                    zipCode.setEnabled(true);
                    address.setEnabled(true);

                    editButton.setBackgroundColor(ctx.getResources().getColor(R.color.colorGrey));

                    fieldsState =true;
                }else {
                    disableFields();
                }
            }
        }
    }


}
