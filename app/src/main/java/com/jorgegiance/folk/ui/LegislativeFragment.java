package com.jorgegiance.folk.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jorgegiance.folk.R;
import com.jorgegiance.folk.adapters.PeopleAdapter;
import com.jorgegiance.folk.models.Person;

import java.util.ArrayList;

public class LegislativeFragment extends Fragment {

    public LegislativeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView( @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {

        final View rootView = inflater.inflate(R.layout.fragment_legislative, container, false);

        RecyclerView recyclerSenate = rootView.findViewById(R.id.person_recycler_0);
        PeopleAdapter adapterSenate = new PeopleAdapter(getContext());
        recyclerSenate.setAdapter(adapterSenate);
        recyclerSenate.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerSenate.setHasFixedSize(true);

        RecyclerView recyclerCongress = rootView.findViewById(R.id.person_recycler_1);
        PeopleAdapter adapterCongress = new PeopleAdapter(getContext());
        recyclerCongress.setAdapter(adapterCongress);
        recyclerCongress.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerCongress.setHasFixedSize(true);

        adapterSenate.setPersonList(createPeopleList());
        adapterCongress.setPersonList(createPeopleList());


        return rootView;
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
}
