package com.tenchichrono.popularmovies;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dchi on 1/11/2016.
 */
public class ImageAdapter extends BaseAdapter
{
    private Context mContext;
    private List<Movies> mMovies;
    private String[] mThumbIds;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public ImageAdapter(Context c, List<Movies> movies)
    {
        mContext = c;
        mMovies = movies;
        setmThumbIds();
    }

    public int getCount() {
        return mMovies.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.movie_images_grid, null);//inflater.inflate(R.layout.movie_images_grid, parent, false);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        TextView textView = (TextView) convertView.findViewById(R.id.textView);
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            //imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            //imageView = (ImageView) convertView;
        }

        //imageView.setImageResource(mThumbIds[position]);
        String url = mThumbIds[position];//getItem(mThumbIds[position]);
        String movieTitle = mMovies.get(position).getTitle();
        textView.setText(movieTitle);
        Picasso.with(mContext)
                .load(url)
                .noFade().resize(300, 300)
                .centerCrop()
                .into(imageView);
        //textView.setText("ehllasdf");
        return convertView;
    }

    // references to our images
    private void setmThumbIds ()
    {
        mThumbIds = new String[mMovies.size()];
        int count = 0;
        for (Movies movies : mMovies)
        {
            mThumbIds[count] = movies.getPosterURL();
            Log.i("Movies",mThumbIds[count]);
            count++;
        }
    }
}
