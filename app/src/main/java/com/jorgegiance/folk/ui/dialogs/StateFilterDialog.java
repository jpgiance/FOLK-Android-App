package com.jorgegiance.folk.ui.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jorgegiance.folk.R;
import com.jorgegiance.folk.adapters.FilterAdapter;
import com.jorgegiance.folk.viewmodels.PeopleActivityViewModel;

public class StateFilterDialog extends DialogFragment implements FilterAdapter.FilterAdapterOnClickHandler {

    private FilterAdapter adapter;
    private RecyclerView recycler;

    private PeopleActivityViewModel peopleActivityViewModel;
    private Context ctx;




    public StateFilterDialog(Context ctx) {
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog( @Nullable Bundle savedInstanceState ) {


        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        View mDialog = inflater.inflate(R.layout.dialog_filter_item, null);

        builder.setView(mDialog)
                .setTitle(R.string.filter_dialog_title)
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        StateFilterDialog.this.getDialog().cancel();

                    }
                });

        peopleActivityViewModel = new ViewModelProvider(getActivity()).get(PeopleActivityViewModel.class);

        adapter = new FilterAdapter(ctx, this);
        recycler = mDialog.findViewById(R.id.filter_recycler);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setHasFixedSize(true);

        return builder.create();
    }

    @Override
    public void onFilterClicked( String state ) {
        peopleActivityViewModel.setFilterState(state);
        peopleActivityViewModel.setStateFilterSelected(true);
        StateFilterDialog.this.getDialog().cancel();

    }
}
