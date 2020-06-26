package com.jorgegiance.folks.ui.fragments;

import android.graphics.Paint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jorgegiance.folks.R;
import com.jorgegiance.folks.viewmodels.DetailActivityViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends Fragment {

    // UI components
    private TextView newsBody, contentLink;

    private DetailActivityViewModel mDetailActivityViewModel;
    private String sourceName = "ABC";
    private boolean articleHasContent = false;

    public ContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState ) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_content, container, false);

        mDetailActivityViewModel = new ViewModelProvider(getActivity()).get(DetailActivityViewModel.class);

        newsBody = rootView.findViewById(R.id.news_body);
        contentLink = rootView.findViewById(R.id.content_link);


        newsBody.setText(mDetailActivityViewModel.getSelectedNews().getBody().replaceAll("\n", "\n\n"));

        if(articleHasContent){
            contentLink.setVisibility(View.GONE);
            newsBody.setVisibility(View.VISIBLE);
            newsBody.setText(mDetailActivityViewModel.getSelectedNews().getBody().replaceAll("\n", "\n\n"));
        }else {
            contentLink.setVisibility(View.VISIBLE);
            newsBody.setVisibility(View.GONE);
            contentLink.setText(getResources().getString(R.string.article_content_link) + sourceName);
            contentLink.setPaintFlags(contentLink.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        }


        return rootView;
    }


}
