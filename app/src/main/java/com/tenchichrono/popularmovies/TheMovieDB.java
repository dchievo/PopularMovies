package com.tenchichrono.popularmovies;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by dchi on 1/20/2016.
 */
public class TheMovieDB extends AsyncTask<String, Void, String[]>
{
    private final String LOG_TAG = TheMovieDB.class.getSimpleName();

    @Override
    protected String[] doInBackground(String... params) {
/*        if (params.length == 0)
        {
            Log.i("Length","Equals 0");
            return null;
        }*/
        String[] movies = new String[100];
        try {
            movies = getMovieDataFromJSON(getMovieInfo());
        } catch (JSONException e)
        {
            Log.i("JSONException", e.toString());
        }
        return movies;
    }


    private String[] getMovieDataFromJSON(String movieJSONStr) throws JSONException
    {
        final String TMDB_results = "results";
        final String TMDB_title = "title";
        final String TMDB_release_date = "release_date";
        final String TMDB_poster_path = "poster_path";
        final String IMAGE_PATH = "https://image.tmdb.org/t/p/w185";

        JSONObject popularMoviesJSON = new JSONObject(movieJSONStr);
        JSONArray popularMoviesJSONArray = popularMoviesJSON.getJSONArray(TMDB_results);


        String[] results = new String[100];//popularMoviesJSONArray.length()];
        for (int i = 0; i < popularMoviesJSONArray.length(); i++)
        {
            String title;
            String releaseDate;
            String poster;

            JSONObject movie = popularMoviesJSONArray.getJSONObject(i);
            title = movie.getString(TMDB_title);
            releaseDate = movie.getString(TMDB_release_date);
            poster = IMAGE_PATH + movie.getString(TMDB_poster_path);
            results[i] = title + " " + releaseDate + " " + poster;
            Log.i(LOG_TAG, results[i]);
        }
        return results;
    }

    private String getMovieInfo()
    {
        // Used can be closed gracefully in finally block
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        // House JSON String
        String movieJSONStr = "";

        try {
            Uri.Builder builder = new Uri.Builder();
            final String DOMAIN = "api.themoviedb.org";
            final String PATH1 = "3";
            final String PATH2 = "movie";
            final String PATH3 = "popular";
            final String API = "api_key";
            final String APIKEY = "907b1de05a7f5cf65158d5171b54d431";

            builder.scheme("https")
                    .authority(DOMAIN)
                    .appendPath(PATH1)
                    .appendPath(PATH2)
                    .appendPath(PATH3)
                    .appendQueryParameter(API, APIKEY);

            URL url = new URL(builder.build().toString());
            Log.i("URL", url.toString());

            // Create request to TheMovieDB then open connection
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // Read the output from urlConnection then assign into a String variable to hold value
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null)
            {
                //do not a damned thing
                return null;
            }

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null)
            {
                buffer.append(line + "\n");
            }

            if (buffer.length() == 0)
            {
                return null;
            }
            movieJSONStr = buffer.toString();
            Log.i(LOG_TAG, movieJSONStr);

        } catch(IOException e)
        {
            Log.e(LOG_TAG, "Error", e);

        } finally {
            if (urlConnection != null)
            {
                urlConnection.disconnect();
            }
            if (reader != null)
            {
                try {
                    reader.close();
                } catch (final IOException e)
                {
                    Log.e(LOG_TAG, "Error closing streams", e);
                }
            }


        }
        return movieJSONStr;
    }
}
