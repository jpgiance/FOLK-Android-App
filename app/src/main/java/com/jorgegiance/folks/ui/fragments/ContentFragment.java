package com.jorgegiance.folks.ui.fragments;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jorgegiance.folks.R;
import com.jorgegiance.folks.viewmodels.DetailActivityViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends Fragment implements View.OnClickListener{

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

        contentLink.setOnClickListener(this);


        newsBody.setText(mDetailActivityViewModel.getSelectedNews().getBody().replaceAll("\n", "\n\n"));

        if(articleHasContent){
            contentLink.setVisibility(View.GONE);
            newsBody.setVisibility(View.VISIBLE);
            newsBody.setText(mDetailActivityViewModel.getSelectedNews().getBody().replaceAll("\n", "\n\n"));
        }else {
            contentLink.setVisibility(View.VISIBLE);
            newsBody.setVisibility(View.GONE);
            contentLink.setText(getResources().getString(R.string.article_content_link) + " " + sourceName);
            contentLink.setPaintFlags(contentLink.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        }


        return rootView;
    }



    @Override
    public void onClick( View v ) {
        switch (v.getId()){
            case R.id.content_link:
                String url = "https://www.cnn.com/2020/07/07/politics/florida-texas-governors-coronavirus/index.html";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                if (true && i.resolveActivity(getContext().getPackageManager()) != null) {
                    this.startActivity(i);
                } else {

                    Toast.makeText(getContext(),
                            "no URL found",
                            Toast.LENGTH_LONG)
                            .show();

                }
        }
    }
}
