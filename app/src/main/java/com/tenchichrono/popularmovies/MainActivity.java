package com.tenchichrono.popularmovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String MOVIE = "";
    private ImageAdapter mImageAdapter;
    private List<Movies> movies;
    GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView topTextView = (TextView) findViewById(R.id.topTextView);

        movies = grabMovieInfo();
        topTextView.setText("Top " + movies.size() + " Popular Movies");
        Log.i("Movies", movies.get(0).getPosterURL());
        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(this, movies));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                //intent.putParcelableArrayListExtra("Movies", (ArrayList<? extends Parcelable>) movies);
                intent.putSeri("Movies",movies);
                intent.setClass(MainActivity.this, MovieInfo.class);
                startActivity(intent);
            }
        });



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

    private List<Movies> grabMovieInfo()
    {
        TheMovieDB theMovieDB = new TheMovieDB();

        theMovieDB.execute();
        try {
            movies = theMovieDB.get();
            Log.i("Movies:", movies.size() + "");
        } catch (Exception e) {
            Log.i("grabMovieException:", e + "");
        }

        return movies;
    }

    @Override
    public void onStart()
    {
        super.onStart();
        grabMovieInfo();
    }

}
