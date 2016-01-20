package com.tenchichrono.popularmovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.Map;

/**
 * A placeholder fragment containing a simple view.
 */
public class MovieInfoFragment extends Fragment {

    private Map<String,String> mMovies;

    public MovieInfoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_movie_info, container, false);

        Intent intent = getActivity().getIntent();
        ImageView imageView = (ImageView) view.findViewById(R.id.movie_title_image_view);

        return view;
    }


    public void setMovies()
    {
        mMovies = new HashMap<>();
        mMovies.put("movies_01", "Inspired by true events, THE REVENANT is an immersive and visceral cinematic experience capturing one man's epic adventure of survival and the extraordinary power of the human spirit. In an expedition of the uncharted American wilderness, legendary explorer Hugh Glass (Leonardo DiCaprio) is brutally attacked by a bear and left for dead by members of his own hunting team. In a quest to survive, Glass endures unimaginable grief as well as the betrayal of his confidant John Fitzgerald (Tom Hardy). Guided by sheer will and the love of his family, Glass must navigate a vicious winter in a relentless pursuit to live and find redemption. THE REVENANT is directed and co-written by renowned filmmaker, Academy Award (R) winner Alejandro G. Iñárritu (Birdman, Babel).");
    }
}
