package com.jorgegiance.folk.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jorgegiance.folk.R;
import com.jorgegiance.folk.adapters.PeopleAdapter;
import com.jorgegiance.folk.models.Person;

import java.util.ArrayList;

public class ExecutiveFragment extends Fragment implements View.OnClickListener{

    //ui components
    Button button;

    public ExecutiveFragment() {
    }

    @Nullable
    @Override
    public View onCreateView( @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {

        final View rootView = inflater.inflate(R.layout.fragment_executive, container, false);

        button = rootView.findViewById(R.id.button);
        RecyclerView recycler = rootView.findViewById(R.id.person_recycler);
        
        setListener();
        
        PeopleAdapter adapter = new PeopleAdapter(getContext());
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recycler.setHasFixedSize(true);

        adapter.setPersonList(createPeopleList());




        return rootView;
    }

    private void setListener() {

        button.setOnClickListener(this);
    }


    public ArrayList<Person> createPeopleList(){

       ArrayList<Person> list = new ArrayList<>();

       for (int i = 0; i < 50 ; i++) {

           Person person =  new Person();
           person.setPositionTitle("Sec. of Agriculture");
           person.setName("Alexander, Lamar");
           person.setPhotoLink("https://www.alexander.senate.gov/public/_cache/files/e6fc1af2-9158-414a-b2ad-bbd4c111ec90/alexander-lamar-rgb-2400-3600.jpg");

           list.add(person);

       }

       return list;
   }

    @Override
    public void onClick( View v ) {
        switch (v.getId()){
            case R.id.button:
                showFilterDialog();
                break;
            default:
                break;
        }
    }

    private void showFilterDialog() {
        FragmentManager fm = getFragmentManager();
        StateFilterDialog nameDialog = new StateFilterDialog();
        nameDialog.show(fm, "lolo");//getResources().getString(R.string.dialog_tag));
    }
}
