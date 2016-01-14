package com.tenchichrono.popularmovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MovieInfoFragment extends Fragment {

    public MovieInfoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_movie_info, container, false);

        Intent intent = getActivity().getIntent();
        String movieTitle = intent.getStringExtra(MainActivity.MOVIE) + "";

        TextView textView = (TextView) view.findViewById(R.id.movie_title_text_view);
        textView.setText(movieTitle);
        return view;
    }
}
