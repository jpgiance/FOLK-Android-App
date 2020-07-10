package com.jorgegiance.folks.ui.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.jorgegiance.folks.R;

public class VoteDialog extends DialogFragment {

    public VoteDialog() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog( @Nullable Bundle savedInstanceState ) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        View mDialog = inflater.inflate(R.layout.dialog_vote, null);

        builder.setView(mDialog)
                .setTitle("Rate this article")
                .setPositiveButton("Rate", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick( DialogInterface dialog, int which ) {
                        VoteDialog.this.getDialog().cancel();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        VoteDialog.this.getDialog().cancel();

                    }
                });





        return builder.create();
    }
}
