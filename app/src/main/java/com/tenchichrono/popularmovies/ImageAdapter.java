package com.tenchichrono.popularmovies;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by dchi on 1/11/2016.
 */
public class ImageAdapter extends BaseAdapter
{
    private Context mContext;

    public ImageAdapter()
    {

    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ImageView imageView;

        if (convertView == null)
        {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType((ImageView.ScaleType.CENTER_CROP));
            imageView.setPadding(8, 8, 8, 8);
        } else
        {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbs[position]);
        return null;
    }

    public Integer[] mThumbs = {


            };
}
