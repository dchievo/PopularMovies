package com.tenchichrono.popularmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String MOVIE = "";
    private ImageAdapter mImageAdapter;
    private String[] movies;
    GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mGridView = (GridView) findViewById(R.id.gridview);

        mGridView.setAdapter(createArr);



    }

    private ArrayAdapter<String> createArrayAdapter(List<String> fakeData)
    {
        adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_forecast, R.id.listview_forecast_textview, new ArrayList<String>());

        return adapter;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private TheMovieDB grabMovieInfo()
    {
        TheMovieDB theMovieDB = new TheMovieDB();

        theMovieDB.execute();
        try {
            movies = theMovieDB.get();
            Log.i("Movies:", movies.length + "");
        } catch (Exception e) {
            Log.i("grabMovieException:", e + "");
        }

        return theMovieDB;
    }

    @Override
    public void onStart()
    {
        super.onStart();
        grabMovieInfo();
    }


}
